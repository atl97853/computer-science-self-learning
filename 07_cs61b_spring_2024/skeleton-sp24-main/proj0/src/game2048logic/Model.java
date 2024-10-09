package game2048logic;

import game2048rendering.Board;
import game2048rendering.Side;
import game2048rendering.Tile;

import java.util.Formatter;


/** The state of a game of 2048.
 *  @author P. N. Hilfinger + Josh Hug
 */
public class Model {
    /** Current contents of the board. */
    private final Board board;
    /** Current score. */
    private int score;

    /* Coordinate System: column x, row y of the board (where x = 0,
     * y = 0 is the lower-left corner of the board) will correspond
     * to board.tile(x, y).  Be careful!
     */

    /** Largest piece value. */
    public static final int MAX_PIECE = 2048;

    /** A new 2048 game on a board of size SIZE with no pieces
     *  and score 0. */
    public Model(int size) {
        board = new Board(size);
        score = 0;
    }

    /** A new 2048 game where RAWVALUES contain the values of the tiles
     * (0 if null). VALUES is indexed by (x, y) with (0, 0) corresponding
     * to the bottom-left corner. Used for testing purposes. */
    public Model(int[][] rawValues, int score) {
        board = new Board(rawValues);
        this.score = score;
    }

    /** Return the current Tile at (x, y), where 0 <= x < size(),
     *  0 <= y < size(). Returns null if there is no tile there.
     *  Used for testing. */
    public Tile tile(int x, int y) {
        return board.tile(x, y);
    }

    /** Return the number of squares on one side of the board. */
    public int size() {
        return board.size();
    }

    /** Return the current score. */
    public int score() {
        return score;
    }


    /** Clear the board to empty and reset the score. */
    public void clear() {
        score = 0;
        board.clear();
    }

    /** Add TILE to the board. There must be no Tile currently at the
     *  same position. */
    public void addTile(Tile tile) {
        board.addTile(tile);
    }

    /** Return true iff the game is over (there are no moves, or
     *  there is a tile with value 2048 on the board). */
    public boolean gameOver() {
        return maxTileExists() || !atLeastOneMoveExists();
    }

    /** Returns this Model's board. */
    public Board getBoard() {
        return board;
    }

    /** Returns true if at least one space on the Board is empty.
     *  Empty spaces are stored as null.
     * */
    public boolean emptySpaceExists() {
        // TODO: Task 2. Fill in this function.
        // It loops a two-dimensional object of size 4.
        for (int i = 0; i < board.size(); i++) {
            for (int j = 0; j < board.size(); j++) {
                // It checks if tile(i, j) returns null.
                if (tile(i, j) == null) return true;
            }
        }
        return false;
    }

    /**
     * Returns true if any tile is equal to the maximum valid value.
     * Maximum valid value is given by this.MAX_PIECE. Note that
     * given a Tile object t, we get its value with t.value().
     */
    public boolean maxTileExists() {
        // TODO: Task 3. Fill in this function.
        int size = getBoard().size();
        // It loops two-dimensional object of size 4.
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {

                Tile tile = tile(i, j);
                // "Special case" to avoid NullPointerException before calling value().
                if (tile(i, j) == null) continue;
                // It converts tile object into an int using value() from Tile class.
                if (tile.value() == MAX_PIECE) return true;
            }
        }
        return false;
    }

    /**
     * Returns true if there are any valid moves on the board.
     * There are two ways that there can be valid moves:
     * 1. There is at least one empty space on the board.
     * 2. There are two adjacent tiles with the same value.
     */
    public boolean atLeastOneMoveExists() {
        // TODO: Fill in this function.
        // There is at least one empty space on the board.
        if (emptySpaceExists()) return true;
        // Size - 1, because we are iterating over each array except the last, to avoid ArrayIndexOutOfBoundsExceptions.
        int size = getBoard().size();
        for (int i = 0; i < size - 1; i++) {
            for (int j = 0; j < size - 1; j++) {

                // In each row and column, we compare each tile with the tile that comes after it,
                // if their values are equal, then it returns true. We don't have to worry about the zeros,
                // the condition above catches them all.

                // Row 0,0.
                if (tile(i, 0).value() == tile(i + 1, 0).value()) return true;
                // Row 0,1.
                if (tile(i, 1).value() == tile(i + 1, 1).value()) return true;
                // Row 0,2.
                if (tile(i, 2).value() == tile(i + 1, 2).value()) return true;
                // Row 0,3.
                if (tile(i, 3).value() == tile(i + 1, 3).value()) return true;

                // Colum 0,0.
                if (tile(0, i).value() == tile(0, i + 1).value()) return true;
                // Colum 1,0.
                if (tile(1, i).value() == tile(1, i + 1).value()) return true;
                // Colum 2,0.
                if (tile(2, i).value() == tile(2, i + 1).value()) return true;
                // Colum 3,0.
                if (tile(3, i).value() == tile(3, i + 1).value()) return true;
            }
        }
        return false;
    }

    /**
     * Moves the tile at position (x, y) as far up as possible.
     *
     * Rules for Tilt:
     * 1. If two Tiles are adjacent in the direction of motion and have
     *    the same value, they are merged into one Tile of twice the original
     *    value and that new value is added to the score instance variable
     * 2. A tile that is the result of a merge will not merge again on that
     *    tilt. So each move, every tile will only ever be part of at most one
     *    merge (perhaps zero).
     * 3. When three adjacent tiles in the direction of motion have the same
     *    value, then the leading two tiles in the direction of motion merge,
     *    and the trailing tile does not.
     */
    public void moveTileUpAsFarAsPossible(int x, int y) {
        // TODO: Tasks 5, 6, and 10. Fill in this function.
        Tile currTile = board.tile(x, y);
        // Gatekeeper for loop
        if (y + 1 < board.size() && atLeastOneMoveExists()) { // top row and at least one move exists.
            if (tile(x, y) != null) { // is not null
                // checks for the next square to be empty or don't be not equal to the current tile value.
                if (tile(x, y + 1) == null || tile(x, y + 1).value() == currTile.value()) {
                    // encapsulated loop, all of this to call board.move() just when it is necessary and avoid bugs
                    int myValue = currTile.value();
                    int targetY = y;
                    for (int i = targetY + 1; i < board.size(); i++) {
                        if (tile(x, i) == null || tile(x, i).value() == myValue && !tile(x, i).wasMerged()) {
                            targetY = i;
                        }
                    }
                    board.move(x, targetY, currTile);
                }
            }
        }
    }

    /**public void test(int x, int y) {
        Tile currTile = board.tile(x, y);
        int myValue = currTile.value();
        int targetY = y;
        // TODO: Tasks 5, 6, and 10. Fill in this function.
        while (true) {
        if (targetY + 1 < board.size() && atLeastOneMoveExists()) {
            if (tile(x, targetY + 1) == null) {
                targetY += 1;
            } else if (tile(x, targetY + 1).value() == myValue
                    && !tile(x, targetY + 1 ).wasMerged()) {
                targetY += 1;
            } else {
                board.move(x, targetY, currTile);
            }
        }
    } */

    /** Handles the movements of the tilt in column x of the board
     * by moving every tile in the column as far up as possible.
     * The viewing perspective has already been set,
     * so we are tilting the tiles in this column up.
     * */
    public void tiltColumn(int x) {
        // TODO: Task 7. Fill in this function.
        // Iterates the loop from top to bottom, starting with (x, 3), in this way it moves the
        // tiles to avoid them colliding with each other using the helper method.
        for (int i = board.size() - 1; i >= 0; i--) {
            moveTileUpAsFarAsPossible(x,i);
        }
    }

    public void tilt(Side side) {
        // TODO: Tasks 8 and 9. Fill in this function.
        // Tilt the entire board up, move all the tiles in all columns into their rightful place.
        // Merge any tiles that need to be merged.
        for (int i = board.size() - 1; i >= 0; i--) {
            for (int j = board.size() - 1; j >= 0; j--) {
                moveTileUpAsFarAsPossible(i,j);
            }
        }
    }

    /** Tilts every column of the board toward SIDE.
     */
    public void tiltWrapper(Side side) {
        board.resetMerged();
        tilt(side);
    }


    @Override
    public String toString() {
        Formatter out = new Formatter();
        out.format("%n[%n");
        for (int y = size() - 1; y >= 0; y -= 1) {
            for (int x = 0; x < size(); x += 1) {
                if (tile(x, y) == null) {
                    out.format("|    ");
                } else {
                    out.format("|%4d", tile(x, y).value());
                }
            }
            out.format("|%n");
        }
        String over = gameOver() ? "over" : "not over";
        out.format("] %d (game is %s) %n", score(), over);
        return out.toString();
    }

    @Override
    public boolean equals(Object o) {
        return (o instanceof Model m) && this.toString().equals(m.toString());
    }

    @Override
    public int hashCode() {
        return toString().hashCode();
    }
}
