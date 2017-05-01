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

    public void joinColumn(int col) {
        Row row = new Row(fields[col][0], fields[col][1], fields[col][2], fields[col][3]);
        int[] array = row.joinAndMove();
        for (int i = 0; i < array.length; i++) {
            fields[col][i] = array[i];
        }
    }
}
