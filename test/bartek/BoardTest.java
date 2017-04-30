package bartek;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class BoardTest {
    private static Application Application(Board board) {
        return new Application(board);
    }

    private static void setFields(int[][] fields, Board board) {
        for (int y = 0; y < 4; y++) {
            for (int x = 0; x < 4; x++) {
                board.setValue(x, y, fields[x][y]);
            }
        }
    }

    @Test
    public void shouldMoveFieldsDown() {
        // given

        Board board = new Board();
        Application application = Application(board);

        setFields(new int[][]{
                {2, 2, 2, 2},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0}}, board);

        // when
        application.move(40);

        // then
        assertArrayEquals(new int[][]{
                        {0, 0, 0, 0},
                        {0, 0, 0, 0},
                        {0, 0, 0, 0},
                        {2, 2, 2, 2}},
                board.getFields()
        );
    }

    @Test
    public void shouldJoinTwoFieldsDown() {
        // given
        Board board = new Board();
        Application application = Application(board);

        setFields(new int[][]{
                {2, 0, 16, 128},
                {2, 4, 0, 0},
                {0, 4, 0, 128},
                {0, 0, 16, 0}}, board);

        // when
        application.move(40);

        // then
        assertArrayEquals(new int[][]{
                        {0, 0, 0, 0},
                        {0, 0, 0, 0},
                        {0, 0, 0, 0},
                        {4, 8, 32, 256}},
                board.getFields()
        );
    }


    @Test
    public void shouldPreferFieldsOnBottomDown() {
        // given
        Board board = new Board();
        Application application = Application(board);

        setFields(new int[][]{
                {2, 0, 16, 0},
                {2, 0, 0, 0},
                {2, 0, 16, 0},
                {0, 0, 16, 0}}, board);

        // when
        application.move(40);

        // then
        assertArrayEquals(new int[][]{
                        {0, 0, 0, 0},
                        {0, 0, 0, 0},
                        {2, 0, 16, 0},
                        {4, 0, 32, 0}},
                board.getFields()
        );
    }

    @Test
    public void shouldJoinFourFieldsInAColumnDown() {
        Board board = new Board();
        Application application = Application(board);

        setFields(new int[][]{
                {2, 0, 0, 16},
                {2, 0, 0, 16},
                {4, 0, 0, 64},
                {4, 0, 0, 64}}, board);

        // when
        application.move(40);

        // then
        assertArrayEquals(new int[][]{
                        {0, 0, 0, 0},
                        {0, 0, 0, 0},
                        {4, 0, 0, 32},
                        {8, 0, 0, 128}},
                board.getFields()
        );
    }


    @Test
    public void shouldJoinFieldsAndStopOnFieldDown() {
        Board board = new Board();
        Application application = Application(board);

        setFields(new int[][]{
                {2, 4, 0, 0},
                {2, 0, 0, 0},
                {4, 4, 0, 0},
                {0, 16, 0, 0}}, board);

        // when
        application.move(40);

        // then
        assertArrayEquals(new int[][]{
                        {0, 0, 0, 0},
                        {0, 0, 0, 0},
                        {4, 8, 0, 0},
                        {4, 16, 0, 0}},
                board.getFields()
        );
    }

    @Test
    public void shouldNotJoinDifferentFieldsDown() {
        Board board = new Board();
        Application application = Application(board);

        setFields(new int[][]{
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {2, 16, 0, 0},
                {4, 32, 0, 0}}, board);
        // when
        application.move(40);

        // then
        assertArrayEquals(new int[][]{
                        {0, 0, 0, 0},
                        {0, 0, 0, 0},
                        {2, 16, 0, 0},
                        {4, 32, 0, 0}},
                board.getFields()
        );
    }

    @Test
    public void shouldMoveFieldsButNotJoinDown() {
        // given
        Board board = new Board();
        Application application = Application(board);
        setFields(new int[][]{
                {2, 0, 0, 0},
                {0, 0, 0, 4},
                {4, 0, 0, 0},
                {0, 0, 0, 8}}, board);

        // when
        application.move(40);

        // then
        assertArrayEquals(new int[][]{
                        {0, 0, 0, 0},
                        {0, 0, 0, 0},
                        {2, 0, 0, 4},
                        {4, 0, 0, 8}},
                board.getFields());
    }

    @Test
    public void shouldNotMoveWhenNoSpaceAndFieldsToJoinDown() {
        Board board = new Board();
        Application application = Application(board);
        setFields(new int[][]{
                {2, 0, 0, 0},
                {4, 0, 0, 0},
                {8, 2, 0, 0},
                {16, 4, 2, 2}}, board);

        // when
        application.move(40);

        // then
        assertArrayEquals(new int[][]{
                        {2, 0, 0, 0},
                        {4, 0, 0, 0},
                        {8, 2, 0, 0},
                        {16, 4, 2, 2}},
                board.getFields()
        );
    }

    @Test
    public void shouldMoveFieldsUp() {
        // given

        Board board = new Board();
        Application application = Application(board);

        setFields(new int[][]{
                {0, 0, 0, 0},
                {0, 0, 2, 0},
                {0, 2, 0, 0},
                {2, 0, 0, 2}}, board);

        // when
        application.move(38);

        // then
        assertArrayEquals(new int[][]{
                        {2, 2, 2, 2},
                        {0, 0, 0, 0},
                        {0, 0, 0, 0},
                        {0, 0, 0, 0}},
                board.getFields()
        );
    }

    @Test
    public void shouldJoinTwoFieldsUp() {
        // given
        Board board = new Board();
        Application application = Application(board);

        setFields(new int[][]{
                {0, 0, 8, 0},
                {2, 0, 0, 32},
                {0, 4, 0, 0},
                {2, 4, 8, 32}}, board);

        // when
        application.move(38);

        // then
        assertArrayEquals(new int[][]{
                        {4, 8, 16, 64},
                        {0, 0, 0, 0},
                        {0, 0, 0, 0},
                        {0, 0, 0, 0}},
                board.getFields()
        );
    }

    @Test
    public void shouldPreferFieldsOnTopUp() {
        // given
        Board board = new Board();
        Application application = Application(board);

        setFields(new int[][]{
                {0, 0, 16, 0},
                {2, 0, 16, 0},
                {2, 0, 0, 0},
                {2, 0, 16, 0}}, board);

        // when
        application.move(38);

        // then
        assertArrayEquals(new int[][]{
                        {4, 0, 32, 0},
                        {2, 0, 16, 0},
                        {0, 0, 0, 0},
                        {0, 0, 0, 0}},
                board.getFields()
        );
    }

    @Test
    public void shouldJoinFourFieldsInAColumnUp() {
        Board board = new Board();
        Application application = Application(board);

        setFields(new int[][]{
                {2, 0, 16, 0},
                {2, 0, 16, 0},
                {4, 0, 128, 0},
                {4, 0, 128, 0}}, board);

        // when
        application.move(38);

        // then
        assertArrayEquals(new int[][]{
                        {4, 0, 32, 0},
                        {8, 0, 256, 0},
                        {0, 0, 0, 0},
                        {0, 0, 0, 0}},
                board.getFields()
        );
    }


    @Test
    public void shouldJoinFieldsAndStopOnFieldUp() {
        Board board = new Board();
        Application application = Application(board);

        setFields(new int[][]{
                {0, 0, 0, 16},
                {32, 0, 0, 8},
                {2, 0, 0, 0},
                {2, 0, 0, 8}}, board);

        // when
        application.move(38);

        // then
        assertArrayEquals(new int[][]{
                        {32, 0, 0, 16},
                        {4, 0, 0, 16},
                        {0, 0, 0, 0},
                        {0, 0, 0, 0}},
                board.getFields()
        );
    }

    @Test
    public void shouldNotJoinDifferentFieldsUp() {
        Board board = new Board();
        Application application = Application(board);

        setFields(new int[][]{
                {2, 16, 0, 0},
                {4, 32, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0}}, board);

        // when
        application.move(38);

        // then
        assertArrayEquals(new int[][]{
                        {2, 16, 0, 0},
                        {4, 32, 0, 0},
                        {0, 0, 0, 0},
                        {0, 0, 0, 0}},
                board.getFields()
        );
    }

    @Test
    public void shouldMoveFieldsButNotJoinUp() {
        // given
        Board board = new Board();
        Application application = Application(board);

        setFields(new int[][]{
                {0, 0, 0, 0},
                {2, 0, 0, 0},
                {0, 0, 0, 4},
                {4, 0, 0, 8}}, board);

        // when
        application.move(38);

        // then
        assertArrayEquals(new int[][]{
                        {2, 0, 0, 4},
                        {4, 0, 0, 8},
                        {0, 0, 0, 0},
                        {0, 0, 0, 0}},
                board.getFields());
    }

    @Test
    public void shouldNotMoveWhenNoSpaceAndFieldsToJoinUp() {
        Board board = new Board();
        Application application = Application(board);

        setFields(new int[][]{
                {2, 2, 2, 2},
                {4, 4, 0, 0},
                {8, 0, 0, 0},
                {16, 0, 0, 0}}, board);

        // when
        application.move(38);

        // then
        assertArrayEquals(new int[][]{
                        {2, 2, 2, 2},
                        {4, 4, 0, 0},
                        {8, 0, 0, 0},
                        {16, 0, 0, 0}},
                board.getFields()
        );
    }
}
