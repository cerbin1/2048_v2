package bartek;

import org.junit.Test;

import static java.awt.event.KeyEvent.VK_S;
import static org.junit.Assert.assertArrayEquals;

public class FieldsTest {
    private static Application Application() {
        return new Application();
    }

    @Test
    public void shouldMoveFieldsDown() {
        // given
        Application application = Application();

        Fields fields = new Fields();
        fields.setValue(0, 0, 2);
        fields.setValue(0, 1, 2);
        fields.setValue(0, 2, 2);
        fields.setValue(0, 3, 2);

        // when
        application.move(VK_S);

        // then
        assertArrayEquals(new int[][]{
                        {0, 0, 0, 0},
                        {0, 0, 0, 0},
                        {0, 0, 0, 0},
                        {2, 2, 2, 2}},
                fields.getFields()
        );
    }

    @Test
    public void shouldJoinTwoFields() {
        // given
        Application application = Application();

        Fields fields = new Fields();
        fields.setValue(2, 0, 2);
        fields.setValue(3, 0, 2);

        // when
        application.move(VK_S);

        // then
        assertArrayEquals(new int[][]{
                        {0, 0, 0, 0},
                        {0, 0, 0, 0},
                        {0, 0, 0, 0},
                        {4, 0, 0, 0}},
                fields.getFields()
        );
    }

    @Test
    public void shouldJoinFourFields() {
        Application application = Application();

        Fields fields = new Fields();
        fields.setValue(2, 0, 2);
        fields.setValue(3, 0, 2);
        fields.setValue(2, 1, 2);
        fields.setValue(3, 1, 2);

        // when
        application.move(VK_S);

        // then
        assertArrayEquals(new int[][]{
                        {0, 0, 0, 0},
                        {0, 0, 0, 0},
                        {0, 0, 0, 0},
                        {4, 4, 0, 0}},
                fields.getFields()
        );
    }

    @Test
    public void shouldJoinFieldsAndStopOnField() {
        Application application = Application();

        Fields fields = new Fields();
        fields.setValue(0, 0, 2);
        fields.setValue(1, 0, 2);
        fields.setValue(3, 0, 4);

        // when
        application.move(VK_S);

        // then
        assertArrayEquals(new int[][]{
                        {0, 0, 0, 0},
                        {0, 0, 0, 0},
                        {4, 0, 0, 0},
                        {4, 0, 0, 0}},
                fields.getFields()
        );

    }
}
