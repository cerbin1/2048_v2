package bartek;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class RowTest {
    @Test
    public void shouldMoveField1() {
        // given
        Row row = new Row(2, 0, 0, 0);

        // when
        int[] after = row.joinAndMove();

        // then
        System.out.println(Arrays.toString(after));
        assertArrayEquals(new int[]{2, 0, 0, 0},
                after);
    }

    @Test
    public void shouldMoveField2() {
        // given
        Row row = new Row(0, 2, 0, 0);

        // when
        int[] after = row.joinAndMove();

        // then
        System.out.println(Arrays.toString(after));
        assertArrayEquals(new int[]{2, 0, 0, 0},
                after);
    }

    @Test
    public void shouldMoveField3() {
        // given
        Row row = new Row(0, 0, 2, 0);

        // when
        int[] after = row.joinAndMove();

        // then
        System.out.println(Arrays.toString(after));
        assertArrayEquals(new int[]{2, 0, 0, 0},
                after);
    }

    @Test
    public void shouldMoveField4() {
        // given
        Row row = new Row(0, 0, 0, 2);

        // when
        int[] after = row.joinAndMove();

        // then
        System.out.println(Arrays.toString(after));
        assertArrayEquals(new int[]{2, 0, 0, 0},
                after);
    }

    @Test
    public void shouldJoinTwoFields1() {
        // given
        Row row = new Row(2, 0, 0, 2);

        // when
        int[] after = row.joinAndMove();

        // then
        System.out.println(Arrays.toString(after));
        assertArrayEquals(new int[]{4, 0, 0, 0},
                after);
    }

    @Test
    public void shouldJoinTwoFields2() {
        // given
        Row row = new Row(2, 0, 2, 0);

        // when
        int[] after = row.joinAndMove();

        // then
        System.out.println(Arrays.toString(after));
        assertArrayEquals(new int[]{4, 0, 0, 0},
                after);
    }

    @Test
    public void shouldJoinTwoFields3() {
        // given
        Row row = new Row(2, 2, 0, 0);

        // when
        int[] after = row.joinAndMove();

        // then
        System.out.println(Arrays.toString(after));
        assertArrayEquals(new int[]{4, 0, 0, 0},
                after);
    }

    @Test
    public void shouldJoinTwoFields4() {
        // given
        Row row = new Row(0, 2, 2, 0);

        // when
        int[] after = row.joinAndMove();

        // then
        System.out.println(Arrays.toString(after));
        assertArrayEquals(new int[]{4, 0, 0, 0},
                after);
    }

    @Test
    public void shouldJoinTwoFields5() {
        // given
        Row row = new Row(0, 2, 0, 2);

        // when
        int[] after = row.joinAndMove();

        // then
        System.out.println(Arrays.toString(after));
        assertArrayEquals(new int[]{4, 0, 0, 0},
                after);
    }

    @Test
    public void shouldJoinTwoFields6() {
        // given
        Row row = new Row(0, 0, 2, 2);

        // when
        int[] after = row.joinAndMove();

        // then
        System.out.println(Arrays.toString(after));
        assertArrayEquals(new int[]{4, 0, 0, 0},
                after);
    }

    @Test
    public void shouldJoinFourFields() {
        // given
        Row row = new Row(2, 2, 8, 8);

        // when
        int[] after = row.joinAndMove();

        // then
        System.out.println(Arrays.toString(after));
        assertArrayEquals(new int[]{4, 16, 0, 0},
                after);
    }

    @Test
    public void shouldJoinAndStopOnField() {
        // given
        Row row = new Row(0, 4, 2, 2);

        // when
        int[] after = row.joinAndMove();

        // then
        System.out.println(Arrays.toString(after));
        assertArrayEquals(new int[]{4, 4, 0, 0},
                after);
    }

    @Test
    public void shouldMoveFields() {
        // given
        Row row = new Row(0, 2, 0, 4);

        // when
        int[] after = row.joinAndMove();

        // then
        System.out.println(Arrays.toString(after));
        assertArrayEquals(new int[]{2, 4, 0, 0},
                after);
    }

    @Test
    public void shouldNotMoveAndJoin() {
        // given
        Row row = new Row(2, 4, 8, 32);

        // when
        int[] after = row.joinAndMove();

        // then
        System.out.println(Arrays.toString(after));
        assertArrayEquals(new int[]{2, 4, 8, 32},
                after);
    }

    @Test
    public void shouldJoinOnlyTwoFields() {
        // given
        Row row = new Row(2, 2, 4, 0);

        // when
        int[] after = row.joinAndMove();

        // then
        System.out.println(Arrays.toString(after));
        assertArrayEquals(new int[]{4, 4, 0, 0},
                after);
    }

    @Test
    public void shouldPreferJoinFieldsOnLeft1() {
        // given
        Row row = new Row(2, 2, 2, 0);

        // when
        int[] after = row.joinAndMove();

        // then
        System.out.println(Arrays.toString(after));
        assertArrayEquals(new int[]{4, 2, 0, 0},
                after);
    }

    @Test
    public void shouldPreferJoinFieldsOnLeft2() {
        // given
        Row row = new Row(2, 2, 0, 2);

        // when
        int[] after = row.joinAndMove();

        // then
        System.out.println(Arrays.toString(after));
        assertArrayEquals(new int[]{4, 2, 0, 0},
                after);
    }

    @Test
    public void shouldPreferJoinFieldsOnLeft3() {
        // given
        Row row = new Row(0, 2, 2, 2);

        // when
        int[] after = row.joinAndMove();

        // then
        System.out.println(Arrays.toString(after));
        assertArrayEquals(new int[]{4, 2, 0, 0},
                after);
    }

    @Test
    public void shouldPreferJoinFieldsOnLeft4() {
        // given
        Row row = new Row(2, 0, 2, 2);

        // when
        int[] after = row.joinAndMove();

        // then
        System.out.println(Arrays.toString(after));
        assertArrayEquals(new int[]{4, 2, 0, 0},
                after);
    }

    @Test
    public void shouldDoNothingOnEmptyFields() {
        // given
        Row row = new Row(0, 0, 0, 0);

        // when
        int[] after = row.joinAndMove();

        // then
        System.out.println(Arrays.toString(after));
        assertArrayEquals(new int[]{0, 0, 0, 0},
                after);
    }

    @Test
    public void shouldJoinFourFieldsAndNotJoinMore() {
        // given
        Row row = new Row(2, 2, 2, 2);

        // when
        int[] after = row.joinAndMove();

        // then
        System.out.println(Arrays.toString(after));
        assertArrayEquals(new int[]{4, 4, 0, 0},
                after);
    }

    @Test
    public void shouldMoveLastField() {
        // given
        Row row = new Row(2, 4, 0, 8);

        // when
        int[] after = row.joinAndMove();

        // then
        System.out.println(Arrays.toString(after));
        assertArrayEquals(new int[]{2, 4, 8, 0},
                after);
    }

    @Test
    public void shouldMoveLastFieldWhenTwoCentralAreEmpty() {
        // given
        Row row = new Row(4, 0, 0, 8);

        // when
        int[] after = row.joinAndMove();

        // then
        System.out.println(Arrays.toString(after));
        assertArrayEquals(new int[]{4, 8, 0, 0},
                after);
    }

    @Test
    public void shouldAddPoints() {
        // given
        Row row = new Row(2, 2, 0, 0);

        // when
        row.joinAndMove();

        // then
        assertEquals(4, row.getPoints());
    }

    @Test
    public void shouldAddPointsFromDoubleJoining() {
        // given
        Row row = new Row(4, 4, 32, 32);

        // when
        row.joinAndMove();

        // then
        assertEquals(72, row.getPoints());
    }

    @Test
    public void shouldNotAddPoints() {
        // given
        Row row = new Row(2, 4, 8, 16);

        // when
        row.joinAndMove();

        // then
        assertEquals(0, row.getPoints());
    }
}
