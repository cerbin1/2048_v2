package bartek;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertArrayEquals;

public class BoardTest {

    private static Board setFields(int[][] fields) {
        for (int i = 0; i < 4; i++) {
            System.out.println(Arrays.toString(fields[i]));
        }
        Board board = new Board();
        for (int y = 0; y < 4; y++) {
            for (int x = 0; x < 4; x++) {
                board.setValue(x, y, fields[y][x]);
                System.out.print(fields[y][x]);
            }
            System.out.println();
        }
        return board;
    }

    private int[][] fixArray(int[][] array) {
        int[][] fixedArray = new int[4][4];
        for (int y = 0; y < 4; y++) {
            for (int x = 0; x < 4; x++) {
                fixedArray[x][y] = array[y][x];
            }
        }
        return fixedArray;
    }

    @Test
    public void shouldMoveFieldsDown() {
        // given

        Board board = setFields(new int[][]{
                {2, 2, 2, 2},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0}});

        // when
        for (int x = 0; x < 4; x++) {
            board.down(x);
        }

        // then
        assertArrayEquals(new int[][]{
                        {0, 0, 0, 0},
                        {0, 0, 0, 0},
                        {0, 0, 0, 0},
                        {2, 2, 2, 2}},
                fixArray(board.getFields())
        );
    }

    @Test
    public void shouldJoinTwoFieldsDown() {
        // given


        Board board = setFields(new int[][]{
                {2, 0, 0, 0},
                {0, 0, 0, 0},
                {2, 0, 0, 0},
                {0, 0, 0, 0}});

        // when
        for (int x = 0; x < 4; x++) {
            board.down(x);
        }

        System.out.println(Arrays.deepToString(fixArray(board.getFields())));
        // then
        assertArrayEquals(new int[][]{
                        {0, 0, 0, 0},
                        {0, 0, 0, 0},
                        {0, 0, 0, 0},
                        {4, 0, 0, 0}},
                fixArray(board.getFields())
        );
    }


    @Test
    public void shouldPreferFieldsOnBottomDown() {
        // given


        Board board = setFields(new int[][]{
                {2, 0, 16, 0},
                {2, 0, 0, 0},
                {2, 0, 16, 0},
                {0, 0, 16, 0}});

        // when
        for (int x = 0; x < 4; x++) {
            board.down(x);
        }

        // then
        assertArrayEquals(new int[][]{
                        {0, 0, 0, 0},
                        {0, 0, 0, 0},
                        {2, 0, 16, 0},
                        {4, 0, 32, 0}},
                fixArray(board.getFields())
        );
    }

    @Test
    public void shouldJoinFourFieldsInAColumnDown() {


        Board board = setFields(new int[][]{
                {2, 0, 0, 16},
                {2, 0, 0, 16},
                {4, 0, 0, 64},
                {4, 0, 0, 64}});

        // when
        for (int x = 0; x < 4; x++) {
            board.down(x);
        }

        // then
        assertArrayEquals(new int[][]{
                        {0, 0, 0, 0},
                        {0, 0, 0, 0},
                        {4, 0, 0, 32},
                        {8, 0, 0, 128}},
                fixArray(board.getFields())
        );
    }


    @Test
    public void shouldJoinFieldsAndStopOnFieldDown() {


        Board board = setFields(new int[][]{
                {2, 4, 0, 0},
                {2, 0, 0, 0},
                {4, 4, 0, 0},
                {0, 16, 0, 0}});

        // when
        for (int x = 0; x < 4; x++) {
            board.down(x);
        }

        // then
        assertArrayEquals(new int[][]{
                        {0, 0, 0, 0},
                        {0, 0, 0, 0},
                        {4, 8, 0, 0},
                        {4, 16, 0, 0}},
                fixArray(board.getFields())
        );
    }

    @Test
    public void shouldNotJoinDifferentFieldsDown() {


        Board board = setFields(new int[][]{
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {2, 16, 0, 0},
                {4, 32, 0, 0}});
        // when
        for (int x = 0; x < 4; x++) {
            board.down(x);
        }

        // then
        assertArrayEquals(new int[][]{
                        {0, 0, 0, 0},
                        {0, 0, 0, 0},
                        {2, 16, 0, 0},
                        {4, 32, 0, 0}},
                fixArray(board.getFields())
        );
    }

    @Test
    public void shouldMoveFieldsButNotJoinDown() {
        // given

        Board board = setFields(new int[][]{
                {2, 0, 0, 0},
                {0, 0, 0, 4},
                {4, 0, 0, 0},
                {0, 0, 0, 8}});

        // when
        for (int x = 0; x < 4; x++) {
            board.down(x);
        }

        // then
        assertArrayEquals(new int[][]{
                        {0, 0, 0, 0},
                        {0, 0, 0, 0},
                        {2, 0, 0, 4},
                        {4, 0, 0, 8}},
                fixArray(board.getFields()));
    }

    @Test
    public void shouldNotMoveWhenNoSpaceAndFieldsToJoinDown() {

        Board board = setFields(new int[][]{
                {2, 0, 0, 0},
                {4, 0, 0, 0},
                {8, 2, 0, 0},
                {16, 4, 2, 2}});

        // when
        for (int x = 0; x < 4; x++) {
            board.down(x);
        }

        // then
        assertArrayEquals(new int[][]{
                        {2, 0, 0, 0},
                        {4, 0, 0, 0},
                        {8, 2, 0, 0},
                        {16, 4, 2, 2}},
                fixArray(board.getFields())
        );
    }

    @Test
    public void shouldMoveFieldsUp() {
        // given


        Board board = setFields(new int[][]{
                {0, 0, 0, 0},
                {0, 0, 2, 0},
                {0, 2, 0, 0},
                {2, 0, 0, 2}});

        // when
        for (int x = 0; x < 4; x++) {
            board.up(x);
        }

        // then
        assertArrayEquals(new int[][]{
                        {2, 2, 2, 2},
                        {0, 0, 0, 0},
                        {0, 0, 0, 0},
                        {0, 0, 0, 0}},
                fixArray(board.getFields())
        );
    }

    @Test
    public void shouldJoinTwoFieldsUp() {
        // given
        Board board = setFields(new int[][]{
                {0, 0, 8, 0},
                {2, 0, 0, 32},
                {0, 4, 0, 0},
                {2, 4, 8, 32}});

        // when
        for (int x = 0; x < 4; x++) {
            board.up(x);
        }

        // then
        System.out.println(Arrays.deepToString(fixArray(board.getFields())));
        assertArrayEquals(new int[][]{
                        {4, 8, 16, 64},
                        {0, 0, 0, 0},
                        {0, 0, 0, 0},
                        {0, 0, 0, 0}},
                fixArray(board.getFields())
        );
    }

    @Test
    public void shouldPreferFieldsOnTopUp() {
        // given


        Board board = setFields(new int[][]{
                {0, 0, 16, 0},
                {2, 0, 16, 0},
                {2, 0, 0, 0},
                {2, 0, 16, 0}});

        // when
        for (int x = 0; x < 4; x++) {
            board.up(x);
        }

        // then
        assertArrayEquals(new int[][]{
                        {4, 0, 32, 0},
                        {2, 0, 16, 0},
                        {0, 0, 0, 0},
                        {0, 0, 0, 0}},
                fixArray(board.getFields())
        );
    }

    @Test
    public void shouldJoinFourFieldsInAColumnUp() {


        Board board = setFields(new int[][]{
                {2, 0, 16, 0},
                {2, 0, 16, 0},
                {4, 0, 128, 0},
                {4, 0, 128, 0}});

        // when
        for (int x = 0; x < 4; x++) {
            board.up(x);
        }

        // then
        assertArrayEquals(new int[][]{
                        {4, 0, 32, 0},
                        {8, 0, 256, 0},
                        {0, 0, 0, 0},
                        {0, 0, 0, 0}},
                fixArray(board.getFields())
        );
    }


    @Test
    public void shouldJoinFieldsAndStopOnFieldUp() {


        Board board = setFields(new int[][]{
                {0, 0, 0, 16},
                {32, 0, 0, 8},
                {2, 0, 0, 0},
                {2, 0, 0, 8}});

        // when
        for (int x = 0; x < 4; x++) {
            board.up(x);
        }

        // then
        assertArrayEquals(new int[][]{
                        {32, 0, 0, 16},
                        {4, 0, 0, 16},
                        {0, 0, 0, 0},
                        {0, 0, 0, 0}},
                fixArray(board.getFields())
        );
    }

    @Test
    public void shouldNotJoinDifferentFieldsUp() {


        Board board = setFields(new int[][]{
                {2, 16, 0, 0},
                {4, 32, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0}});

        // when
        for (int x = 0; x < 4; x++) {
            board.up(x);
        }

        // then
        assertArrayEquals(new int[][]{
                        {2, 16, 0, 0},
                        {4, 32, 0, 0},
                        {0, 0, 0, 0},
                        {0, 0, 0, 0}},
                fixArray(board.getFields())
        );
    }

    @Test
    public void shouldMoveFieldsButNotJoinUp() {
        // given


        Board board = setFields(new int[][]{
                {0, 0, 0, 0},
                {2, 0, 0, 0},
                {0, 0, 0, 4},
                {4, 0, 0, 8}});

        // when
        for (int x = 0; x < 4; x++) {
            board.up(x);
        }

        // then
        assertArrayEquals(new int[][]{
                        {2, 0, 0, 4},
                        {4, 0, 0, 8},
                        {0, 0, 0, 0},
                        {0, 0, 0, 0}},
                fixArray(board.getFields()));
    }

    @Test
    public void shouldNotMoveWhenNoSpaceAndFieldsToJoinUp() {


        Board board = setFields(new int[][]{
                {2, 2, 2, 2},
                {4, 4, 0, 0},
                {8, 0, 0, 0},
                {16, 0, 0, 0}});

        // when
        for (int x = 0; x < 4; x++) {
            board.up(x);
        }

        // then
        assertArrayEquals(new int[][]{
                        {2, 2, 2, 2},
                        {4, 4, 0, 0},
                        {8, 0, 0, 0},
                        {16, 0, 0, 0}},
                fixArray(board.getFields())
        );
    }


}