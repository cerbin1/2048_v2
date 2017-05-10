package bartek;

import bartek.logic.PointsCounter;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class PointsCounterTest {
    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void shouldThrowOnAddingNegativePoints() {
        // given
        PointsCounter pointsCounter = new PointsCounter();

        expectedException.expect(RuntimeException.class);

        // when
        pointsCounter.addPoints(-10);
    }

    @Test
    public void shouldAddPoints() {
        // given
        PointsCounter pointsCounter = new PointsCounter();

        // when
        pointsCounter.addPoints(15);

        // then
        Assert.assertEquals(15, pointsCounter.getPoints());
    }
}