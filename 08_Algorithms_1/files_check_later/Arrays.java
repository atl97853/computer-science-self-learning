public class Arrays {
    public static void main (String[] args) {

        // One-dimensional array
        // Initializing declaration 
        String[] names = {"Tohru", "Ragnar", "Atl"};

        // Printing array
        for (String name: names) {
            // System.out.println(name); // testing
        }

        // Two-dimensional array
        int M = 2;
        int N = 2;
        // Declaring and creating array
        int[][] twoArrayA = new int[M][N];
        int[][] twoArrayB = new int[M][N];
        // Initialization and printing 
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                twoArrayA[i][j] = j;
                twoArrayB[i][j] = j;
                // System.out.println(twoArrayA[i][j]); // testing
            }
        }

        /**
         * matrix-matrix multiplication 
         * (square matrices)
         * a[][]*b[][] = c[][]
         */
        int arrayLength = twoArrayA.length; 
        double[][] c = new double[arrayLength][arrayLength];
        for (int row = 0; row < arrayLength; row++) {
            for (int column = 0; column < arrayLength; column++) {
                // Compute dot product of row i and column j
                c[row][column] = twoArrayA[row][column]*twoArrayB[row][column];
                System.out.println(c[row][column]);
            }
        }
    }
}