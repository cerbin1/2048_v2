package bartek;

import static bartek.ArrayHelper.*;

public class Board {
    private final int[][] fields;

    public Board() {
        fields = new int[4][4];
    }

    public void setValue(int x, int y, int value) {
        fields[x][y] = value;
    }

    public int[][] getFields() {
        return fields;
    }

    public void moveFieldsUp() {
        for (int x = 0; x < 4; x++) {
            Row row = getVerticalRow(x);
            int[] array = row.joinAndMove();
            for (int y = 0; y < 4; y++) {
                fields[x][y] = array[y];
            }
        }
    }

    public void moveFieldsDown() {
        for (int x = 0; x < 4; x++) {
            Row row = getVerticalRow(x);
            row.revertValues();
            int[] array = revertValues(row.joinAndMove());
            for (int y = 0; y < 4; y++) {
                fields[x][y] = array[y];
            }
        }
    }

    private Row getVerticalRow(int x) {
        return new Row(fields[x][0], fields[x][1], fields[x][2], fields[x][3]);
    }

    public void moveFieldsLeft() {
        for (int y = 0; y < 4; y++) {
            Row row = getHorizontalRow(y);
            int[] array = row.joinAndMove();
            for (int x = 0; x < 4; x++) {
                fields[x][y] = array[x];
            }
        }
    }

    public void moveFieldsRight() {
        for (int y = 0; y < 4; y++) {
            Row row = getHorizontalRow(y);
            row.revertValues();
            int[] array = revertValues(row.joinAndMove());
            for (int x = 0; x < 4; x++) {
                fields[x][y] = array[x];
            }
        }
    }

    private Row getHorizontalRow(int y) {
        return new Row(fields[0][y], fields[1][y], fields[2][y], fields[3][y]);
    }

    public int getEmptyFieldsCount() {
        int emptyFields = 0;
        for (int y = 0; y < 4; y++) {
            for (int x = 0; x < 4; x++) {
                if(fields[x][y] == 0) {
                    emptyFields++;
                }
            }
        }
        return emptyFields;
    }
}
