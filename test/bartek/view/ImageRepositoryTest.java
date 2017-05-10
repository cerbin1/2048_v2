package bartek.view;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertTrue;

public class ImageRepositoryTest {
    public @Rule
    ExpectedException expectedException = ExpectedException.none();

    @Test
    public void shouldNotThrowWhenGettingProperIconImage() {
        // given
        boolean testPassed;

        // when
        ImageRepository.get("2");
        testPassed = true;

        // then
        assertTrue(testPassed);
    }

    @Test
    public void shouldThrow() {
        // given
        expectedException.expect(RuntimeException.class);

        // when
        ImageRepository.get("3");
    }
}