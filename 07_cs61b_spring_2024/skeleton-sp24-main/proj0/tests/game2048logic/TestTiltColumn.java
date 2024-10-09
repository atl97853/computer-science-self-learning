package game2048logic;
import jh61b.grader.GradedTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import static com.google.common.truth.Truth.assertWithMessage;

/** Tests the tiltColumn() method of Model.
 *
 *
 * @author Erik Kizior
 */
@Timeout(value = 60, threadMode = Timeout.ThreadMode.SEPARATE_THREAD)
public class TestTiltColumn {

    /** No merging required. */
    @Test
    @Tag("tiltColumn")
    @DisplayName("No merge")
    @GradedTest(number = "11.1")
    public void testNoMergeColumn() {
        int[][] board = {
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {4, 0, 0, 0},
                {2, 0, 0, 0}
        };
        Model before = new Model(board, 0);
        before.tiltColumn(0);

        int[][] result = {
                {4, 0, 0, 0},
                {2, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0}
        };

        Model after = new Model(result, 0);
        assertWithMessage("Boards should match:").that(before.toString()).isEqualTo(after.toString());
    }

    /** One merge required. Not dependent on score being implemented. */
    @Test
    @Tag("tiltColumn")
    @DisplayName("Merge, no score")
    @GradedTest(number = "11.2")
    public void testMergingColumn() {
        int[][] board = {
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {4, 0, 0, 0},
                {4, 0, 0, 0}
        };
        Model before = new Model(board, 0);
        before.tiltColumn(0);

        int[][] result = {
                {8, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0}
        };

        Model after = new Model(result, before.score());
        assertWithMessage("Boards should match:").that(before.toString()).isEqualTo(after.toString());
    }

    /** One merge required. Requires that score is implemented. */
    @Test
    @Tag("tiltColumn")
    @DisplayName("Merge and score")
    @GradedTest(number = "11.3")
    public void testMergingColumnWithScore() {
        int[][] board = {
                {0, 0, 0, 0},
                {2, 0, 0, 0},
                {2, 0, 0, 0},
                {0, 0, 0, 0}
        };
        Model before = new Model(board, 0);
        before.tiltColumn(0);

        int[][] result = {
                {4, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0}
        };

        Model after = new Model(result, 4);
        assertWithMessage("Boards should match:").that(before.toString()).isEqualTo(after.toString());
    }

    /**
     * Test for bugs.
     * */
    @Test
    @Tag("tiltColumn")
    @DisplayName("Merge, no score")
    @GradedTest(number = "11.2")
    public void test01() {
        int[][] board = {
                {2, 0, 0, 0},
                {2, 0, 0, 0},
                {2, 0, 0, 0},
                {2, 0, 0, 0}
        };
        Model before = new Model(board, 0);
        before.tiltColumn(0);

        int[][] result = {
                {4, 0, 0, 0},
                {4, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0}
        };

        Model after = new Model(result, before.score());
        assertWithMessage("Boards should match:").that(before.toString()).isEqualTo(after.toString());
    }
    @Test
    @Tag("tiltColumn")
    @DisplayName("Merge, no score")
    @GradedTest(number = "11.2")
    public void test02() {
        int[][] board = {
                {0, 0, 0, 0},
                {2, 0, 0, 0},
                {2, 0, 0, 0},
                {2, 0, 0, 0}
        };
        Model before = new Model(board, 0);
        before.tiltColumn(0);

        int[][] result = {
                {4, 0, 0, 0},
                {2, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0}
        };

        Model after = new Model(result, before.score());
        assertWithMessage("Boards should match:").that(before.toString()).isEqualTo(after.toString());
    }
    @Test
    @Tag("tiltColumn")
    @DisplayName("Merge, no score")
    @GradedTest(number = "11.2")
    public void test03() {
        int[][] board = {
                {2, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {2, 0, 0, 0}
        };
        Model before = new Model(board, 0);
        before.tiltColumn(0);

        int[][] result = {
                {4, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0}
        };

        Model after = new Model(result, before.score());
        assertWithMessage("Boards should match:").that(before.toString()).isEqualTo(after.toString());
    }
    @Test
    @Tag("tiltColumn")
    @DisplayName("Merge, no score")
    @GradedTest(number = "11.2")
    public void test04() {
        int[][] board = {
                {2, 0, 0, 0},
                {2, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0}
        };
        Model before = new Model(board, 0);
        before.tiltColumn(0);

        int[][] result = {
                {4, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0}
        };

        Model after = new Model(result, before.score());
        assertWithMessage("Boards should match:").that(before.toString()).isEqualTo(after.toString());
    }
    @Test
    @Tag("tiltColumn")
    @DisplayName("Merge, no score")
    @GradedTest(number = "11.2")
    public void test05() {
        int[][] board = {
                {0, 0, 0, 0},
                {2, 0, 0, 0},
                {0, 0, 0, 0},
                {2, 0, 0, 0}
        };
        Model before = new Model(board, 0);
        before.tiltColumn(0);

        int[][] result = {
                {4, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0}
        };

        Model after = new Model(result, before.score());
        assertWithMessage("Boards should match:").that(before.toString()).isEqualTo(after.toString());
    }
    @Test
    @Tag("tiltColumn")
    @DisplayName("Merge, no score")
    @GradedTest(number = "11.2")
    public void test06() {
        int[][] board = {
                {4, 0, 0, 0},
                {4, 0, 0, 0},
                {2, 0, 0, 0},
                {2, 0, 0, 0}
        };
        Model before = new Model(board, 0);
        before.tiltColumn(0);

        int[][] result = {
                {8, 0, 0, 0},
                {4, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0}
        };

        Model after = new Model(result, before.score());
        assertWithMessage("Boards should match:").that(before.toString()).isEqualTo(after.toString());
    }
    @Test
    @Tag("tiltColumn")
    @DisplayName("Merge, no score")
    @GradedTest(number = "11.2")
    public void test07() {
        int[][] board = {
                {0, 0, 0, 0},
                {2, 0, 0, 0},
                {2, 0, 0, 0},
                {4, 0, 0, 0}
        };
        Model before = new Model(board, 0);
        before.tiltColumn(0);

        int[][] result = {
                {4, 0, 0, 0},
                {4, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0}
        };

        Model after = new Model(result, before.score());
        assertWithMessage("Boards should match:").that(before.toString()).isEqualTo(after.toString());
    }
    @Test
    @Tag("tiltColumn")
    @DisplayName("Merge, no score")
    @GradedTest(number = "11.2")
    public void test08() {
        int[][] board = {
                {0, 0, 0, 0},
                {2, 0, 0, 0},
                {2, 0, 0, 0},
                {2, 0, 0, 0}
        };
        Model before = new Model(board, 0);
        before.tiltColumn(0);

        int[][] result = {
                {4, 0, 0, 0},
                {2, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0}
        };

        Model after = new Model(result, before.score());
        assertWithMessage("Boards should match:").that(before.toString()).isEqualTo(after.toString());
    }
    @Test
    @Tag("tiltColumn")
    @DisplayName("Merge, no score")
    @GradedTest(number = "11.2")
    public void test09() {
        int[][] board = {
                {4, 0, 0, 0},
                {4, 0, 0, 0},
                {4, 0, 0, 0},
                {4, 0, 0, 0}
        };
        Model before = new Model(board, 0);
        before.tiltColumn(0);

        int[][] result = {
                {8, 0, 0, 0},
                {8, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0}
        };

        Model after = new Model(result, before.score());
        assertWithMessage("Boards should match:").that(before.toString()).isEqualTo(after.toString());
    }
    @Test
    @Tag("tiltColumn")
    @DisplayName("Merge, no score")
    @GradedTest(number = "11.2")
    public void test10() {
        int[][] board = {
                {2, 0, 0, 0},
                {4, 0, 0, 0},
                {2, 0, 0, 0},
                {4, 0, 0, 0}
        };
        Model before = new Model(board, 0);
        before.tiltColumn(0);

        int[][] result = {
                {2, 0, 0, 0},
                {4, 0, 0, 0},
                {2, 0, 0, 0},
                {4, 0, 0, 0}
        };

        Model after = new Model(result, before.score());
        assertWithMessage("Boards should match:").that(before.toString()).isEqualTo(after.toString());
    }
    @Test
    @Tag("tiltColumn")
    @DisplayName("Merge, no score")
    @GradedTest(number = "11.2")
    public void test11() {
        int[][] board = {
                {4, 0, 0, 0},
                {2, 0, 0, 0},
                {4, 0, 0, 0},
                {2, 0, 0, 0}
        };
        Model before = new Model(board, 0);
        before.tiltColumn(0);

        int[][] result = {
                {4, 0, 0, 0},
                {2, 0, 0, 0},
                {4, 0, 0, 0},
                {2, 0, 0, 0}
        };

        Model after = new Model(result, before.score());
        assertWithMessage("Boards should match:").that(before.toString()).isEqualTo(after.toString());
    }

}
