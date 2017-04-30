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

    public void performMoveOnColumn(int y, int direction) {
        if (canJoinFourFields(y)) {
            joinFourFields(y);
        } else {
            joinTwo(y);
        }
        move(y, direction);
    }

    private boolean canJoinFourFields(int y) {
        return fields[0][y] == fields[1][y] && fields[2][y] == fields[3][y];
    }

    private void joinFourFields(int y) {
        fields[1][y] += fields[0][y];
        fields[0][y] = 0;
        fields[3][y] += fields[2][y];
        fields[2][y] = 0;
    }

    private void joinTwo(int y) {
        for (int i = 0; i < 3; i++) {
            for (int j = 3; j > i; j--) {
                if (fields[j][y] != 0 && fields[j][y] == fields[j - 1][y]) {
                    fields[j][y] += fields[j - 1][y];
                    fields[j - 1][y] = 0;
                    return;
                }
            }
        }
    }

    private void move(int y, int direction) {
        if (direction == 1) {
            for (int i = 0; i < 3; i++) {
                for (int x = 0; x < 3 - i; x++) {
                    moveIfPossible(x, y, direction);
                }
            }
        }
        if (direction == -1) {
            for (int i = 0; i < 3; i++) {
                for (int x = 3; x > 0; x--) {
                    moveIfPossible(x, y, direction);
                }
            }
        }
    }

    public void moveIfPossible(int x, int y, int direction) {
        if (x + direction <= 3 && x + direction >= 0 && fields[x + direction][y] == 0) {
            fields[x + direction][y] = fields[x][y];
            fields[x][y] = 0;
        }
    }
}
