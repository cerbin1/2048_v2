package bartek;

import java.util.Arrays;

import static bartek.ArrayHelper.revertValues;
import static java.util.Arrays.stream;

public class Board {
    private final int[][] fields;
    private PointsCounter pointsCounter;

    public Board(PointsCounter pointsCounter) {
        this.pointsCounter = pointsCounter;
        fields = new int[4][4];
    }

    public int[][] getFields() {
        return fields;
    }

    public void moveFieldsUp() {
        for (int x = 0; x < 4; x++) {
            LineMerger lineMerger = getRow(x);
            int[] merged = lineMerger.mergeAndMove();
            addPoints(lineMerger.getPoints());
            for (int y = 0; y < 4; y++) {
                fields[x][y] = merged[y];
            }
        }
    }

    public void moveFieldsDown() {
        for (int x = 0; x < 4; x++) {
            LineMerger lineMerger = getRow(x);
            lineMerger.revertValues();
            int[] merged = revertValues(lineMerger.mergeAndMove());
            addPoints(lineMerger.getPoints());
            for (int y = 0; y < 4; y++) {
                fields[x][y] = merged[y];
            }
        }
    }

    private LineMerger getRow(int x) {
        return new LineMerger(fields[x][0], fields[x][1], fields[x][2], fields[x][3]);
    }

    public void moveFieldsLeft() {
        for (int y = 0; y < 4; y++) {
            LineMerger lineMerger = getColumn(y);
            int[] merged = lineMerger.mergeAndMove();
            addPoints(lineMerger.getPoints());
            for (int x = 0; x < 4; x++) {
                fields[x][y] = merged[x];
            }
        }
    }

    public void moveFieldsRight() {
        for (int y = 0; y < 4; y++) {
            LineMerger lineMerger = getColumn(y);
            lineMerger.revertValues();
            int[] merged = revertValues(lineMerger.mergeAndMove());
            addPoints(lineMerger.getPoints());
            for (int x = 0; x < 4; x++) {
                fields[x][y] = merged[x];
            }
        }
    }

    private LineMerger getColumn(int y) {
        return new LineMerger(fields[0][y], fields[1][y], fields[2][y], fields[3][y]);
    }

    private void addPoints(int points) {
        pointsCounter.addPoints(points);
    }

    public boolean canMove() {
        if (isAnyFieldEmpty()) {
            return true;
        }
        for (int y = 0; y < 4; y++) {
            for (int x = 0; x < 3; x++) {
                if (canFieldsJoin(y, x)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean isAnyFieldEmpty() {
        return stream(fields)
                .flatMapToInt(Arrays::stream)
                .anyMatch(value -> value == 0);
    }

    private boolean canFieldsJoin(int y, int x) {
        return fields[y][x] == fields[y][x + 1] || fields[x][y] == fields[x + 1][y];
    }
}
