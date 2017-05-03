package bartek;

public class Board {
    int[][] fields;

    public Board() {
        fields = new int[4][4];
        for (int y = 0; y < 4; y++) {
            for (int x = 0; x < 4; x++) {
                fields[x][y] = 0;
            }
        }
    }

    public void setValue(int x, int y, int value) {
        fields[x][y] = value;
    }

    public int[][] getFields() {
        return fields;
    }

    public void moveFieldsUp() {
        for (int x = 0; x < 4; x++) {
            Row row = new Row(fields[x][0], fields[x][1], fields[x][2], fields[x][3]);
            int[] array = row.joinAndMove();
            for (int y = 0; y < 4; y++) {
                fields[x][y] = array[y];
            }
        }
    }

    public void moveFieldsDown() {
        for (int x = 0; x < 4; x++) {
            Row row = new Row(fields[x][3], fields[x][2], fields[x][1], fields[x][0]);
            int[] array = revertArray(row.joinAndMove());
            for (int y = 0; y < 4; y++) {
                fields[x][y] = array[y];
            }
        }
    }

    public void moveFieldsLeft() {
        for (int y = 0; y < 4; y++) {
            Row row = new Row(fields[0][y], fields[1][y], fields[2][y], fields[3][y]);
            int[] array = row.joinAndMove();
            for (int x = 0; x < 4; x++) {
                fields[x][y] = array[x];
            }
        }

    }

    public void moveFieldsRight() {
        for (int y = 0; y < 4; y++) {
            Row row = new Row(fields[3][y], fields[2][y], fields[1][y], fields[0][y]);
            int[] array = revertArray(row.joinAndMove());
            for (int x = 0; x < 4; x++) {
                fields[x][y] = array[x];
            }
        }
    }

    private int[] revertArray(int[] array) {
        for (int i = 0; i < array.length / 2; i++) {
            int temp = array[i];
            array[i] = array[array.length - i - 1];
            array[array.length - i - 1] = temp;
        }
        return array;
    }
}
