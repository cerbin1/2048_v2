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

    public void up(int x) {
        Row row = new Row(fields[x][0], fields[x][1], fields[x][2], fields[x][3]);
        int[] array = row.joinAndMove();
        for (int i = 0; i < 4; i++) {
            fields[x][i] = array[i];
        }
    }

    public void down(int x) {
        Row row = new Row(fields[x][3], fields[x][2], fields[x][1], fields[x][0]);
        int[] array = row.joinAndMove();
        fields[x][3] = array[0];
        fields[x][2] = array[1];
        fields[x][1] = array[2];
        fields[x][0] = array[3];
    }
}
