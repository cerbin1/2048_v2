package bartek;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class BoardTest {

    private static Board setBoard(int[][] fields) {
        Board board = new Board();
        for (int y = 0; y < 4; y++) {
            for (int x = 0; x < 4; x++) {
                board.setValue(x, y, fields[y][x]);
            }
        }
        return board;
    }

    private int[][] rotate(int[][] array) {
        int[][] rotated = new int[4][4];
        for (int y = 0; y < 4; y++) {
            for (int x = 0; x < 4; x++) {
                rotated[x][y] = array[y][x];
            }
        }
        return rotated;
    }

    private void moveDown(Board board) {
        board.moveFieldsDown();
    }

    private void moveUp(Board board) {
        board.moveFieldsUp();
    }

    private void moveLeft(Board board) {
        board.moveFieldsLeft();
    }

    private void moveRight(Board board) {
        board.moveFieldsRight();
    }

    @Test
    public void shouldMoveFieldsDown() {
        // given
        Board board = setBoard(new int[][]{
                {2, 2, 2, 2},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0}});

        // when
        moveDown(board);

        // then
        assertArrayEquals(new int[][]{
                        {0, 0, 0, 0},
                        {0, 0, 0, 0},
                        {0, 0, 0, 0},
                        {2, 2, 2, 2}},
                rotate(board.getFields())
        );
    }

    @Test
    public void shouldJoinTwoFieldsDown() {
        // given
        Board board = setBoard(new int[][]{
                {2, 0, 0, 0},
                {0, 0, 0, 0},
                {2, 0, 0, 0},
                {0, 0, 0, 0}});

        // when
        moveDown(board);

        // then
        assertArrayEquals(new int[][]{
                        {0, 0, 0, 0},
                        {0, 0, 0, 0},
                        {0, 0, 0, 0},
                        {4, 0, 0, 0}},
                rotate(board.getFields())
        );
    }

    @Test
    public void shouldPreferFieldsOnBottomDown() {
        // given
        Board board = setBoard(new int[][]{
                {2, 0, 16, 0},
                {2, 0, 0, 0},
                {2, 0, 16, 0},
                {0, 0, 16, 0}});

        // when
        moveDown(board);

        // then
        assertArrayEquals(new int[][]{
                        {0, 0, 0, 0},
                        {0, 0, 0, 0},
                        {2, 0, 16, 0},
                        {4, 0, 32, 0}},
                rotate(board.getFields())
        );
    }

    @Test
    public void shouldJoinFourFieldsInAColumnDown() {
        Board board = setBoard(new int[][]{
                {2, 0, 0, 16},
                {2, 0, 0, 16},
                {4, 0, 0, 64},
                {4, 0, 0, 64}});

        // when
        moveDown(board);

        // then
        assertArrayEquals(new int[][]{
                        {0, 0, 0, 0},
                        {0, 0, 0, 0},
                        {4, 0, 0, 32},
                        {8, 0, 0, 128}},
                rotate(board.getFields())
        );
    }

    @Test
    public void shouldJoinFieldsAndStopOnFieldDown() {
        Board board = setBoard(new int[][]{
                {2, 4, 0, 0},
                {2, 0, 0, 0},
                {4, 4, 0, 0},
                {0, 16, 0, 0}});

        // when
        moveDown(board);

        // then
        assertArrayEquals(new int[][]{
                        {0, 0, 0, 0},
                        {0, 0, 0, 0},
                        {4, 8, 0, 0},
                        {4, 16, 0, 0}},
                rotate(board.getFields())
        );
    }

    @Test
    public void shouldNotJoinDifferentFieldsDown() {
        Board board = setBoard(new int[][]{
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {2, 16, 0, 0},
                {4, 32, 0, 0}});
        // when
        moveDown(board);

        // then
        assertArrayEquals(new int[][]{
                        {0, 0, 0, 0},
                        {0, 0, 0, 0},
                        {2, 16, 0, 0},
                        {4, 32, 0, 0}},
                rotate(board.getFields())
        );
    }

    @Test
    public void shouldMoveFieldsButNotJoinDown() {
        // given
        Board board = setBoard(new int[][]{
                {2, 0, 0, 0},
                {0, 0, 0, 4},
                {4, 0, 0, 0},
                {0, 0, 0, 8}});

        // when
        moveDown(board);

        // then
        assertArrayEquals(new int[][]{
                        {0, 0, 0, 0},
                        {0, 0, 0, 0},
                        {2, 0, 0, 4},
                        {4, 0, 0, 8}},
                rotate(board.getFields()));
    }

    @Test
    public void shouldNotMoveWhenNoSpaceAndFieldsToJoinDown() {
        Board board = setBoard(new int[][]{
                {2, 0, 0, 0},
                {4, 0, 0, 0},
                {8, 2, 0, 0},
                {16, 4, 2, 2}});

        // when
        moveDown(board);

        // then
        assertArrayEquals(new int[][]{
                        {2, 0, 0, 0},
                        {4, 0, 0, 0},
                        {8, 2, 0, 0},
                        {16, 4, 2, 2}},
                rotate(board.getFields())
        );
    }

    @Test
    public void shouldMoveFieldsUp() {
        // given
        Board board = setBoard(new int[][]{
                {0, 0, 0, 0},
                {0, 0, 2, 0},
                {0, 2, 0, 0},
                {2, 0, 0, 2}});

        // when
        moveUp(board);

        // then
        assertArrayEquals(new int[][]{
                        {2, 2, 2, 2},
                        {0, 0, 0, 0},
                        {0, 0, 0, 0},
                        {0, 0, 0, 0}},
                rotate(board.getFields())
        );
    }

    @Test
    public void shouldJoinTwoFieldsUp() {
        // given
        Board board = setBoard(new int[][]{
                {0, 0, 8, 0},
                {2, 0, 0, 32},
                {0, 4, 0, 0},
                {2, 4, 8, 32}});

        // when
        moveUp(board);

        // then
        assertArrayEquals(new int[][]{
                        {4, 8, 16, 64},
                        {0, 0, 0, 0},
                        {0, 0, 0, 0},
                        {0, 0, 0, 0}},
                rotate(board.getFields())
        );
    }

    @Test
    public void shouldPreferFieldsOnTopUp() {
        // given
        Board board = setBoard(new int[][]{
                {0, 0, 16, 0},
                {2, 0, 16, 0},
                {2, 0, 0, 0},
                {2, 0, 16, 0}});

        // when
        moveUp(board);

        // then
        assertArrayEquals(new int[][]{
                        {4, 0, 32, 0},
                        {2, 0, 16, 0},
                        {0, 0, 0, 0},
                        {0, 0, 0, 0}},
                rotate(board.getFields())
        );
    }

    @Test
    public void shouldJoinFourFieldsInAColumnUp() {
        Board board = setBoard(new int[][]{
                {2, 0, 16, 0},
                {2, 0, 16, 0},
                {4, 0, 128, 0},
                {4, 0, 128, 0}});

        // when
        moveUp(board);

        // then
        assertArrayEquals(new int[][]{
                        {4, 0, 32, 0},
                        {8, 0, 256, 0},
                        {0, 0, 0, 0},
                        {0, 0, 0, 0}},
                rotate(board.getFields())
        );
    }

    @Test
    public void shouldJoinFieldsAndStopOnFieldUp() {
        Board board = setBoard(new int[][]{
                {0, 0, 0, 16},
                {32, 0, 0, 8},
                {2, 0, 0, 0},
                {2, 0, 0, 8}});

        // when
        moveUp(board);

        // then
        assertArrayEquals(new int[][]{
                        {32, 0, 0, 16},
                        {4, 0, 0, 16},
                        {0, 0, 0, 0},
                        {0, 0, 0, 0}},
                rotate(board.getFields())
        );
    }

    @Test
    public void shouldNotJoinDifferentFieldsUp() {
        Board board = setBoard(new int[][]{
                {2, 16, 0, 0},
                {4, 32, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0}});

        // when
        moveUp(board);

        // then
        assertArrayEquals(new int[][]{
                        {2, 16, 0, 0},
                        {4, 32, 0, 0},
                        {0, 0, 0, 0},
                        {0, 0, 0, 0}},
                rotate(board.getFields())
        );
    }

    @Test
    public void shouldMoveFieldsButNotJoinUp() {
        // given
        Board board = setBoard(new int[][]{
                {0, 0, 0, 0},
                {2, 0, 0, 0},
                {0, 0, 0, 4},
                {4, 0, 0, 8}});

        // when
        moveUp(board);

        // then
        assertArrayEquals(new int[][]{
                        {2, 0, 0, 4},
                        {4, 0, 0, 8},
                        {0, 0, 0, 0},
                        {0, 0, 0, 0}},
                rotate(board.getFields()));
    }

    @Test
    public void shouldNotMoveWhenNoSpaceAndFieldsToJoinUp() {
        Board board = setBoard(new int[][]{
                {2, 2, 2, 2},
                {4, 4, 0, 0},
                {8, 0, 0, 0},
                {16, 0, 0, 0}});

        // when
        moveUp(board);

        // then
        assertArrayEquals(new int[][]{
                        {2, 2, 2, 2},
                        {4, 4, 0, 0},
                        {8, 0, 0, 0},
                        {16, 0, 0, 0}},
                rotate(board.getFields())
        );
    }

    @Test
    public void shouldMoveFieldsLeft() {
        // given
        Board board = setBoard(new int[][]{
                {0, 0, 0, 2},
                {0, 0, 2, 0},
                {0, 2, 0, 0},
                {2, 0, 0, 0}});

        // when
        moveLeft(board);

        // then
        assertArrayEquals(new int[][]{
                        {2, 0, 0, 0},
                        {2, 0, 0, 0},
                        {2, 0, 0, 0},
                        {2, 0, 0, 0}},
                rotate(board.getFields())
        );
    }

    @Test
    public void shouldJoinTwoFieldsLeft() {
        // given
        Board board = setBoard(new int[][]{
                {0, 2, 0, 2},
                {0, 4, 4, 0},
                {0, 0, 8, 0},
                {0, 32, 0, 32}});

        // when
        moveLeft(board);

        // then
        assertArrayEquals(new int[][]{
                        {4, 0, 0, 0},
                        {8, 0, 0, 0},
                        {8, 0, 0, 0},
                        {64, 0, 0, 0}},
                rotate(board.getFields())
        );
    }

    @Test
    public void shouldPreferFieldsOnLeft() {
        // given
        Board board = setBoard(new int[][]{
                {0, 2, 2, 2},
                {0, 0, 0, 0},
                {16, 16, 0, 16},
                {0, 0, 0, 0}});

        // when
        moveLeft(board);

        // then
        assertArrayEquals(new int[][]{
                        {4, 2, 0, 0},
                        {0, 0, 0, 0},
                        {32, 16, 0, 0},
                        {0, 0, 0, 0}},
                rotate(board.getFields())
        );
    }

    @Test
    public void shouldJoinFourFieldsInAColumnLeft() {
        Board board = setBoard(new int[][]{
                {2, 2, 4, 4},
                {0, 0, 0, 0},
                {16, 16, 128, 128},
                {0, 0, 0, 0}});

        // when
        moveLeft(board);

        // then
        assertArrayEquals(new int[][]{
                        {4, 8, 0, 0},
                        {0, 0, 0, 0},
                        {32, 256, 0, 0},
                        {0, 0, 0, 0}},
                rotate(board.getFields())
        );
    }

    @Test
    public void shouldJoinFieldsAndStopOnFieldLeft() {
        Board board = setBoard(new int[][]{
                {0, 32, 2, 2},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 16, 8, 8}});

        // when
        moveLeft(board);

        // then
        assertArrayEquals(new int[][]{
                        {32, 4, 0, 0},
                        {0, 0, 0, 0},
                        {0, 0, 0, 0},
                        {16, 16, 0, 0}},
                rotate(board.getFields())
        );
    }

    @Test
    public void shouldNotJoinDifferentFieldsLeft() {
        Board board = setBoard(new int[][]{
                {2, 16, 0, 0},
                {4, 32, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0}});

        // when
        moveLeft(board);

        // then
        assertArrayEquals(new int[][]{
                        {2, 16, 0, 0},
                        {4, 32, 0, 0},
                        {0, 0, 0, 0},
                        {0, 0, 0, 0}},
                rotate(board.getFields())
        );
    }

    @Test
    public void shouldMoveFieldsButNotJoinLeft() {
        // given
        Board board = setBoard(new int[][]{
                {0, 2, 0, 4},
                {0, 0, 0, 0},
                {0, 0, 4, 8},
                {0, 0, 0, 0}});

        // when
        moveLeft(board);

        // then
        assertArrayEquals(new int[][]{
                        {2, 4, 0, 0},
                        {0, 0, 0, 0},
                        {4, 8, 0, 0},
                        {0, 0, 0, 0}},
                rotate(board.getFields()));
    }

    @Test
    public void shouldNotMoveWhenNoSpaceAndFieldsToJoinLeft() {
        Board board = setBoard(new int[][]{
                {2, 4, 16, 0},
                {2, 8, 0, 0},
                {2, 0, 0, 0},
                {2, 0, 0, 0}});

        // when
        moveLeft(board);

        // then
        assertArrayEquals(new int[][]{
                        {2, 4, 16, 0},
                        {2, 8, 0, 0},
                        {2, 0, 0, 0},
                        {2, 0, 0, 0}},
                rotate(board.getFields())
        );
    }

    @Test
    public void shouldMoveFieldsRight() {
        // given
        Board board = setBoard(new int[][]{
                {0, 0, 0, 2},
                {0, 0, 2, 0},
                {0, 2, 0, 0},
                {2, 0, 0, 0}});

        // when
        moveRight(board);

        // then
        assertArrayEquals(new int[][]{
                        {0, 0, 0, 2},
                        {0, 0, 0, 2},
                        {0, 0, 0, 2},
                        {0, 0, 0, 2}},
                rotate(board.getFields())
        );
    }

    @Test
    public void shouldJoinTwoFieldsRight() {
        // given
        Board board = setBoard(new int[][]{
                {0, 2, 0, 2},
                {0, 4, 4, 0},
                {0, 0, 8, 0},
                {0, 32, 0, 32}});

        // when
        moveRight(board);

        // then
        assertArrayEquals(new int[][]{
                        {0, 0, 0, 4},
                        {0, 0, 0, 8},
                        {0, 0, 0, 8},
                        {0, 0, 0, 64}},
                rotate(board.getFields())
        );
    }

    @Test
    public void shouldPreferFieldsOnRight() {
        // given
        Board board = setBoard(new int[][]{
                {0, 2, 2, 2},
                {0, 0, 0, 0},
                {16, 16, 0, 16},
                {0, 0, 0, 0}});

        // when
        moveRight(board);

        // then
        assertArrayEquals(new int[][]{
                        {0, 0, 2, 4},
                        {0, 0, 0, 0},
                        {0, 0, 16, 32},
                        {0, 0, 0, 0}},
                rotate(board.getFields())
        );
    }

    @Test
    public void shouldJoinFourFieldsInAColumnRight() {
        Board board = setBoard(new int[][]{
                {2, 2, 4, 4},
                {0, 0, 0, 0},
                {16, 16, 128, 128},
                {0, 0, 0, 0}});

        // when
        moveRight(board);

        // then
        assertArrayEquals(new int[][]{
                        {0, 0, 4, 8},
                        {0, 0, 0, 0},
                        {0, 0, 32, 256},
                        {0, 0, 0, 0}},
                rotate(board.getFields())
        );
    }

    @Test
    public void shouldJoinFieldsAndStopOnFieldRight() {
        Board board = setBoard(new int[][]{
                {0, 2, 2, 32},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {8, 8, 16, 0}});

        // when
        moveRight(board);

        // then
        assertArrayEquals(new int[][]{
                        {0, 0, 4, 32},
                        {0, 0, 0, 0},
                        {0, 0, 0, 0},
                        {0, 0, 16, 16}},
                rotate(board.getFields())
        );
    }

    @Test
    public void shouldNotJoinDifferentFieldsRight() {
        Board board = setBoard(new int[][]{
                {0, 0, 2, 16},
                {0, 0, 4, 32},
                {0, 0, 0, 0},
                {0, 0, 0, 0}});

        // when
        moveRight(board);

        // then
        assertArrayEquals(new int[][]{
                        {0, 0, 2, 16},
                        {0, 0, 4, 32},
                        {0, 0, 0, 0},
                        {0, 0, 0, 0}},
                rotate(board.getFields())
        );
    }

    @Test
    public void shouldMoveFieldsButNotJoinRight() {
        // given
        Board board = setBoard(new int[][]{
                {0, 2, 4, 0},
                {0, 0, 0, 0},
                {8, 4, 0, 0},
                {0, 0, 0, 0}});

        // when
        moveRight(board);

        // then
        assertArrayEquals(new int[][]{
                        {0, 0, 2, 4},
                        {0, 0, 0, 0},
                        {0, 0, 8, 4},
                        {0, 0, 0, 0}},
                rotate(board.getFields()));
    }

    @Test
    public void shouldNotMoveWhenNoSpaceAndFieldsToJoinRight() {
        Board board = setBoard(new int[][]{
                {0, 16, 4, 2},
                {0, 0, 8, 2},
                {0, 0, 0, 2},
                {0, 0, 0, 2}});

        // when
        moveRight(board);

        // then
        assertArrayEquals(new int[][]{
                        {0, 16, 4, 2},
                        {0, 0, 8, 2},
                        {0, 0, 0, 2},
                        {0, 0, 0, 2}},
                rotate(board.getFields())
        );
    }
}