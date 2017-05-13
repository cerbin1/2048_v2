package bartek.logic;

class BoardTestHelper extends Board {
    BoardTestHelper(PointsCounter pointsCounter) {
        super(pointsCounter);
    }

    void setValue(int x, int y, int value) {
        getFields()[x][y] = value;
    }
}
