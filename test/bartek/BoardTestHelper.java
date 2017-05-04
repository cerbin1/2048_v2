package bartek;

public class BoardTestHelper extends Board {
    public BoardTestHelper(PointsCounter pointsCounter) {
        super(pointsCounter);
    }

    public void setValue(int x, int y, int value) {
        getFields()[x][y] = value;
    }
}
