package bartek;

import org.junit.Test;

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
        application.move(40, fields.getFields());

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
        application.move(40, fields.getFields());

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
        application.move(40, fields.getFields());

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
    public void shouldJoinFourFieldsInOneColumn() {
        Application application = Application();

        Fields fields = new Fields();
        fields.setValue(0, 0, 2);
        fields.setValue(1, 0, 2);
        fields.setValue(2, 0, 4);
        fields.setValue(3, 0, 4);

        // when
        application.move(40, fields.getFields());

        // then
        assertArrayEquals(new int[][]{
                        {0, 0, 0, 0},
                        {0, 0, 0, 0},
                        {4, 0, 0, 0},
                        {8, 0, 0, 0}},
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
        application.move(40, fields.getFields());

        // then
        assertArrayEquals(new int[][]{
                        {0, 0, 0, 0},
                        {0, 0, 0, 0},
                        {4, 0, 0, 0},
                        {4, 0, 0, 0}},
                fields.getFields()
        );
    }

    @Test
    public void shouldNotJoinDifferentFields() {
        Application application = Application();

        Fields fields = new Fields();
        fields.setValue(2, 0, 2);
        fields.setValue(3, 0, 4);

        // when
        application.move(40, fields.getFields());

        // then
        assertArrayEquals(new int[][]{
                        {0, 0, 0, 0},
                        {0, 0, 0, 0},
                        {2, 0, 0, 0},
                        {4, 0, 0, 0}},
                fields.getFields()
        );
    }

    @Test
    public void shouldMoveFieldsButNotJoin() {
        // given
        Application application = Application();

        Fields fields = new Fields();
        fields.setValue(0, 0, 2);
        fields.setValue(2, 0, 4);

        // when
        application.move(40, fields.getFields());

        // then
        assertArrayEquals(new int[][]{
                        {0, 0, 0, 0},
                        {0, 0, 0, 0},
                        {2, 0, 0, 0},
                        {4, 0, 0, 0}},
                fields.getFields());
    }

    @Test
    public void shouldNotMoveWhenNoSpaceAndFieldsToJoin() {
        Application application = Application();

        Fields fields = new Fields();
        fields.setValue(0, 0, 2);
        fields.setValue(1, 0, 4);
        fields.setValue(2, 0, 8);
        fields.setValue(3, 0, 16);
        fields.setValue(2, 1, 2);
        fields.setValue(3, 1, 4);
        fields.setValue(3, 2, 2);
        fields.setValue(3, 3, 2);

        // when
        application.move(40, fields.getFields());

        // then
        assertArrayEquals(new int[][]{
                        {2, 0, 0, 0},
                        {4, 0, 0, 0},
                        {8, 2, 0, 0},
                        {16, 4, 2, 2}},
                fields.getFields()
        );
    }
}
