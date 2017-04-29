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
    public void shouldJoinTwoFields() {
        // given
        Board board = new Board();
        Application application = Application(board);

        board.setValue(2, 0, 2);
        board.setValue(3, 0, 2);

        // when
        application.move(40);

        // then
        assertArrayEquals(new int[][]{
                        {0, 0, 0, 0},
                        {0, 0, 0, 0},
                        {0, 0, 0, 0},
                        {4, 0, 0, 0}},
                board.getFields()
        );
    }

    @Test
    public void shouldJoinFourFields() {
        Board board = new Board();
        Application application = Application(board);

        board.setValue(2, 0, 2);
        board.setValue(3, 0, 2);
        board.setValue(2, 1, 2);
        board.setValue(3, 1, 2);

        // when
        application.move(40);

        // then
        assertArrayEquals(new int[][]{
                        {0, 0, 0, 0},
                        {0, 0, 0, 0},
                        {0, 0, 0, 0},
                        {4, 4, 0, 0}},
                board.getFields()
        );
    }

    @Test
    public void shouldJoinFourFieldsInOneColumn() {
        Board board = new Board();
        Application application = Application(board);

        board.setValue(0, 0, 2);
        board.setValue(1, 0, 2);
        board.setValue(2, 0, 4);
        board.setValue(3, 0, 4);

        // when
        application.move(40);

        // then
        assertArrayEquals(new int[][]{
                        {0, 0, 0, 0},
                        {0, 0, 0, 0},
                        {4, 0, 0, 0},
                        {8, 0, 0, 0}},
                board.getFields()
        );
    }


    @Test
    public void shouldJoinFieldsAndStopOnField() {
        Board board = new Board();
        Application application = Application(board);

        board.setValue(0, 0, 2);
        board.setValue(1, 0, 2);
        board.setValue(3, 0, 4);

        // when
        application.move(40);

        // then
        assertArrayEquals(new int[][]{
                        {0, 0, 0, 0},
                        {0, 0, 0, 0},
                        {4, 0, 0, 0},
                        {4, 0, 0, 0}},
                board.getFields()
        );
    }

    @Test
    public void shouldNotJoinDifferentFields() {
        Board board = new Board();
        Application application = Application(board);

        board.setValue(2, 0, 2);
        board.setValue(3, 0, 4);

        // when
        application.move(40);

        // then
        assertArrayEquals(new int[][]{
                        {0, 0, 0, 0},
                        {0, 0, 0, 0},
                        {2, 0, 0, 0},
                        {4, 0, 0, 0}},
                board.getFields()
        );
    }

    @Test
    public void shouldMoveFieldsButNotJoin() {
        // given
        Board board = new Board();
        Application application = Application(board);

        board.setValue(0, 0, 2);
        board.setValue(2, 0, 4);

        // when
        application.move(40);

        // then
        assertArrayEquals(new int[][]{
                        {0, 0, 0, 0},
                        {0, 0, 0, 0},
                        {2, 0, 0, 0},
                        {4, 0, 0, 0}},
                board.getFields());
    }

    @Test
    public void shouldNotMoveWhenNoSpaceAndFieldsToJoin() {
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
}
