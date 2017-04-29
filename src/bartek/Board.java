package bartek;

public class Board {
    int[][] fields;

    public Board() {
        fields = new int[4][4];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                fields[i][j] = 0;
            }
        }
    }

    public void setValue(int x, int y, int value) {
        fields[x][y] = value;
    }

    public int[][] getFields() {
        return fields;
    }

    public void joinFieldsIfPossible(int y) {
        if (canJoinFourFields(y)) {
            fields[1][y] += fields[0][y];
            fields[0][y] = 0;
            fields[3][y] += fields[2][y];
            fields[2][y] = 0;
        }
        for (int i = 3; i > 0; i--) {
            if (canJoinTwoFields(i, y)) {
                fields[i][y] += fields[i - 1][y];
                fields[i - 1][y] = 0;
                return;
            }
        }
    }

    private boolean canJoinFourFields(int y) {
        return fields[0][y] == fields[1][y] && fields[2][y] == fields[3][y];
    }

    private boolean canJoinTwoFields(int x, int y) {
        return fields[x][y] != 0 && fields[x][y] == fields[x - 1][y];
    }

    public void moveIfPossible(int j, int k) {
        if (canMove(j, k)) {
            fields[j + 1][k] = fields[j][k];
            fields[j][k] = 0;
        }
    }

    private boolean canMove(int x, int y) {
        return x <= 2 && fields[x + 1][y] == 0;
    }
}
