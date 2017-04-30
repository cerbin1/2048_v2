package bartek;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class BoardTest {
    private static Application Application(Board board) {
        return new Application(board);
    }

    @Test
    public void shouldMoveFieldsDown() {
        // given

        Board board = new Board();
        Application application = Application(board);

        board.setValue(0, 0, 2);
        board.setValue(0, 1, 2);
        board.setValue(0, 2, 2);
        board.setValue(0, 3, 2);

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

        board.setValue(2, 0, 2);
        board.setValue(3, 0, 2);
        board.setValue(1, 1, 4);
        board.setValue(0, 1, 4);
        board.setValue(1, 2, 16);
        board.setValue(2, 2, 16);
        board.setValue(2, 3, 128);
        board.setValue(3, 3, 128);

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

        board.setValue(1, 0, 2);
        board.setValue(2, 0, 2);
        board.setValue(3, 0, 2);
        board.setValue(0, 2, 16);
        board.setValue(2, 2, 16);
        board.setValue(3, 2, 16);

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

        board.setValue(0, 0, 2);
        board.setValue(1, 0, 2);
        board.setValue(2, 0, 4);
        board.setValue(3, 0, 4);
        board.setValue(0, 2, 16);
        board.setValue(1, 2, 16);
        board.setValue(2, 2, 128);
        board.setValue(3, 2, 128);

        // when
        application.move(40);

        // then
        assertArrayEquals(new int[][]{
                        {0, 0, 0, 0},
                        {0, 0, 0, 0},
                        {4, 0, 32, 0},
                        {8, 0, 256, 0}},
                board.getFields()
        );
    }


    @Test
    public void shouldJoinFieldsAndStopOnFieldDown() {
        Board board = new Board();
        Application application = Application(board);

        board.setValue(0, 0, 2);
        board.setValue(1, 0, 2);
        board.setValue(3, 0, 4);
        board.setValue(0, 3, 4);
        board.setValue(1, 3, 4);
        board.setValue(2, 3, 16);

        // when
        application.move(40);

        // then
        assertArrayEquals(new int[][]{
                        {0, 0, 0, 0},
                        {0, 0, 0, 0},
                        {4, 0, 0, 8},
                        {4, 0, 0, 16}},
                board.getFields()
        );
    }

    @Test
    public void shouldNotJoinDifferentFieldsDown() {
        Board board = new Board();
        Application application = Application(board);

        board.setValue(2, 0, 2);
        board.setValue(3, 0, 4);
        board.setValue(2, 1, 16);
        board.setValue(3, 1, 32);

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

        board.setValue(0, 0, 2);
        board.setValue(2, 0, 4);
        board.setValue(0, 3, 4);
        board.setValue(2, 3, 8);

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

        board.setValue(0, 0, 2);
        board.setValue(1, 0, 4);
        board.setValue(2, 0, 8);
        board.setValue(3, 0, 16);
        board.setValue(2, 1, 2);
        board.setValue(3, 1, 4);
        board.setValue(3, 2, 2);
        board.setValue(3, 3, 2);

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

        board.setValue(3, 0, 2);
        board.setValue(3, 1, 2);
        board.setValue(3, 2, 2);
        board.setValue(3, 3, 2);

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

        board.setValue(1, 0, 2);
        board.setValue(2, 0, 2);
        board.setValue(0, 1, 4);
        board.setValue(1, 1, 4);
        board.setValue(2, 2, 16);
        board.setValue(3, 2, 16);
        board.setValue(1, 3, 128);
        board.setValue(2, 3, 128);

        // when
        application.move(38);

        // then
        assertArrayEquals(new int[][]{
                        {4, 8, 32, 256},
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

        board.setValue(1, 0, 2);
        board.setValue(2, 0, 2);
        board.setValue(3, 0, 2);
        board.setValue(0, 2, 16);
        board.setValue(2, 2, 16);
        board.setValue(3, 2, 16);

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

        board.setValue(0, 0, 2);
        board.setValue(1, 0, 2);
        board.setValue(2, 0, 4);
        board.setValue(3, 0, 4);
        board.setValue(0, 2, 16);
        board.setValue(1, 2, 16);
        board.setValue(2, 2, 128);
        board.setValue(3, 2, 128);

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

        board.setValue(0, 0, 2);
        board.setValue(1, 0, 2);
        board.setValue(2, 0, 32);
        board.setValue(0, 3, 16);
        board.setValue(1, 3, 4);
        board.setValue(2, 3, 4);

        // when
        application.move(38);

        // then
        assertArrayEquals(new int[][]{
                        {4, 0, 0, 16},
                        {32, 0, 0, 8},
                        {0, 0, 0, 0},
                        {0, 0, 0, 0}},
                board.getFields()
        );
    }

    @Test
    public void shouldNotJoinDifferentFieldsUp() {
        Board board = new Board();
        Application application = Application(board);

        board.setValue(0, 0, 2);
        board.setValue(1, 0, 4);
        board.setValue(0, 1, 16);
        board.setValue(1, 1, 32);

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

        board.setValue(1, 0, 2);
        board.setValue(2, 0, 4);
        board.setValue(2, 3, 4);
        board.setValue(3, 3, 8);

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

        board.setValue(0, 0, 2);
        board.setValue(1, 0, 4);
        board.setValue(2, 0, 8);
        board.setValue(3, 0, 16);
        board.setValue(0, 1, 2);
        board.setValue(1, 1, 4);
        board.setValue(0, 2, 2);
        board.setValue(0, 3, 2);

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
