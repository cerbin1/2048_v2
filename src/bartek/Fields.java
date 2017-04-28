package bartek;

public class Fields {
    int[][] fields;

    public Fields() {
        fields = new int[4][4];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j <4; j++) {
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
}
