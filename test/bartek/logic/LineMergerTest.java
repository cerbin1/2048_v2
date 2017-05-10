package bartek.logic;

import bartek.logic.LineMerger;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class LineMergerTest {
    @Test
    public void shouldMoveField1() {
        // given
        LineMerger lineMerger = new LineMerger(2, 0, 0, 0);

        // when
        int[] after = lineMerger.mergeAndMove();

        // then
        System.out.println(Arrays.toString(after));
        assertArrayEquals(new int[]{2, 0, 0, 0},
                after);
    }

    @Test
    public void shouldMoveField2() {
        // given
        LineMerger lineMerger = new LineMerger(0, 2, 0, 0);

        // when
        int[] after = lineMerger.mergeAndMove();

        // then
        System.out.println(Arrays.toString(after));
        assertArrayEquals(new int[]{2, 0, 0, 0},
                after);
    }

    @Test
    public void shouldMoveField3() {
        // given
        LineMerger lineMerger = new LineMerger(0, 0, 2, 0);

        // when
        int[] after = lineMerger.mergeAndMove();

        // then
        System.out.println(Arrays.toString(after));
        assertArrayEquals(new int[]{2, 0, 0, 0},
                after);
    }

    @Test
    public void shouldMoveField4() {
        // given
        LineMerger lineMerger = new LineMerger(0, 0, 0, 2);

        // when
        int[] after = lineMerger.mergeAndMove();

        // then
        System.out.println(Arrays.toString(after));
        assertArrayEquals(new int[]{2, 0, 0, 0},
                after);
    }

    @Test
    public void shouldJoinTwoFields1() {
        // given
        LineMerger lineMerger = new LineMerger(2, 0, 0, 2);

        // when
        int[] after = lineMerger.mergeAndMove();

        // then
        System.out.println(Arrays.toString(after));
        assertArrayEquals(new int[]{4, 0, 0, 0},
                after);
    }

    @Test
    public void shouldJoinTwoFields2() {
        // given
        LineMerger lineMerger = new LineMerger(2, 0, 2, 0);

        // when
        int[] after = lineMerger.mergeAndMove();

        // then
        System.out.println(Arrays.toString(after));
        assertArrayEquals(new int[]{4, 0, 0, 0},
                after);
    }

    @Test
    public void shouldJoinTwoFields3() {
        // given
        LineMerger lineMerger = new LineMerger(2, 2, 0, 0);

        // when
        int[] after = lineMerger.mergeAndMove();

        // then
        System.out.println(Arrays.toString(after));
        assertArrayEquals(new int[]{4, 0, 0, 0},
                after);
    }

    @Test
    public void shouldJoinTwoFields4() {
        // given
        LineMerger lineMerger = new LineMerger(0, 2, 2, 0);

        // when
        int[] after = lineMerger.mergeAndMove();

        // then
        System.out.println(Arrays.toString(after));
        assertArrayEquals(new int[]{4, 0, 0, 0},
                after);
    }

    @Test
    public void shouldJoinTwoFields5() {
        // given
        LineMerger lineMerger = new LineMerger(0, 2, 0, 2);

        // when
        int[] after = lineMerger.mergeAndMove();

        // then
        System.out.println(Arrays.toString(after));
        assertArrayEquals(new int[]{4, 0, 0, 0},
                after);
    }

    @Test
    public void shouldJoinTwoFields6() {
        // given
        LineMerger lineMerger = new LineMerger(0, 0, 2, 2);

        // when
        int[] after = lineMerger.mergeAndMove();

        // then
        System.out.println(Arrays.toString(after));
        assertArrayEquals(new int[]{4, 0, 0, 0},
                after);
    }

    @Test
    public void shouldJoinFourFields() {
        // given
        LineMerger lineMerger = new LineMerger(2, 2, 8, 8);

        // when
        int[] after = lineMerger.mergeAndMove();

        // then
        System.out.println(Arrays.toString(after));
        assertArrayEquals(new int[]{4, 16, 0, 0},
                after);
    }

    @Test
    public void shouldJoinAndStopOnField() {
        // given
        LineMerger lineMerger = new LineMerger(0, 4, 2, 2);

        // when
        int[] after = lineMerger.mergeAndMove();

        // then
        System.out.println(Arrays.toString(after));
        assertArrayEquals(new int[]{4, 4, 0, 0},
                after);
    }

    @Test
    public void shouldMoveFields() {
        // given
        LineMerger lineMerger = new LineMerger(0, 2, 0, 4);

        // when
        int[] after = lineMerger.mergeAndMove();

        // then
        System.out.println(Arrays.toString(after));
        assertArrayEquals(new int[]{2, 4, 0, 0},
                after);
    }

    @Test
    public void shouldNotMoveAndJoin() {
        // given
        LineMerger lineMerger = new LineMerger(2, 4, 8, 32);

        // when
        int[] after = lineMerger.mergeAndMove();

        // then
        System.out.println(Arrays.toString(after));
        assertArrayEquals(new int[]{2, 4, 8, 32},
                after);
    }

    @Test
    public void shouldJoinOnlyTwoFields() {
        // given
        LineMerger lineMerger = new LineMerger(2, 2, 4, 0);

        // when
        int[] after = lineMerger.mergeAndMove();

        // then
        System.out.println(Arrays.toString(after));
        assertArrayEquals(new int[]{4, 4, 0, 0},
                after);
    }

    @Test
    public void shouldPreferJoinFieldsOnLeft1() {
        // given
        LineMerger lineMerger = new LineMerger(2, 2, 2, 0);

        // when
        int[] after = lineMerger.mergeAndMove();

        // then
        System.out.println(Arrays.toString(after));
        assertArrayEquals(new int[]{4, 2, 0, 0},
                after);
    }

    @Test
    public void shouldPreferJoinFieldsOnLeft2() {
        // given
        LineMerger lineMerger = new LineMerger(2, 2, 0, 2);

        // when
        int[] after = lineMerger.mergeAndMove();

        // then
        System.out.println(Arrays.toString(after));
        assertArrayEquals(new int[]{4, 2, 0, 0},
                after);
    }

    @Test
    public void shouldPreferJoinFieldsOnLeft3() {
        // given
        LineMerger lineMerger = new LineMerger(0, 2, 2, 2);

        // when
        int[] after = lineMerger.mergeAndMove();

        // then
        System.out.println(Arrays.toString(after));
        assertArrayEquals(new int[]{4, 2, 0, 0},
                after);
    }

    @Test
    public void shouldPreferJoinFieldsOnLeft4() {
        // given
        LineMerger lineMerger = new LineMerger(2, 0, 2, 2);

        // when
        int[] after = lineMerger.mergeAndMove();

        // then
        System.out.println(Arrays.toString(after));
        assertArrayEquals(new int[]{4, 2, 0, 0},
                after);
    }

    @Test
    public void shouldDoNothingOnEmptyFields() {
        // given
        LineMerger lineMerger = new LineMerger(0, 0, 0, 0);

        // when
        int[] after = lineMerger.mergeAndMove();

        // then
        System.out.println(Arrays.toString(after));
        assertArrayEquals(new int[]{0, 0, 0, 0},
                after);
    }

    @Test
    public void shouldJoinFourFieldsAndNotJoinMore() {
        // given
        LineMerger lineMerger = new LineMerger(2, 2, 2, 2);

        // when
        int[] after = lineMerger.mergeAndMove();

        // then
        System.out.println(Arrays.toString(after));
        assertArrayEquals(new int[]{4, 4, 0, 0},
                after);
    }

    @Test
    public void shouldMoveLastField() {
        // given
        LineMerger lineMerger = new LineMerger(2, 4, 0, 8);

        // when
        int[] after = lineMerger.mergeAndMove();

        // then
        System.out.println(Arrays.toString(after));
        assertArrayEquals(new int[]{2, 4, 8, 0},
                after);
    }

    @Test
    public void shouldMoveLastFieldWhenTwoCentralAreEmpty() {
        // given
        LineMerger lineMerger = new LineMerger(4, 0, 0, 8);

        // when
        int[] after = lineMerger.mergeAndMove();

        // then
        System.out.println(Arrays.toString(after));
        assertArrayEquals(new int[]{4, 8, 0, 0},
                after);
    }

    @Test
    public void shouldAddPoints() {
        // given
        LineMerger lineMerger = new LineMerger(2, 2, 0, 0);

        // when
        lineMerger.mergeAndMove();

        // then
        assertEquals(4, lineMerger.getPoints());
    }

    @Test
    public void shouldAddPointsFromDoubleJoining() {
        // given
        LineMerger lineMerger = new LineMerger(4, 4, 32, 32);

        // when
        lineMerger.mergeAndMove();

        // then
        assertEquals(72, lineMerger.getPoints());
    }

    @Test
    public void shouldNotAddPoints() {
        // given
        LineMerger lineMerger = new LineMerger(2, 4, 8, 16);

        // when
        lineMerger.mergeAndMove();

        // then
        assertEquals(0, lineMerger.getPoints());
    }
}
