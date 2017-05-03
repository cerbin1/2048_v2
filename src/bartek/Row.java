package bartek;

public class Row {
    private final int[] row;

    public Row(int one, int two, int three, int four) {
        this.row = new int[]{one, two, three, four};
    }

    public int[] joinAndMove() {
        for (int i = 0; i < 3; i++) {
            if (row[i] == 0) {
                moveEmptyFieldsOnEnd(i);
            }
            if (row[i + 1] == 0) {
                moveEmptyFieldsOnEnd(i + 1);
            }
            if (canJoinFields(i)) {
                joinWithNext(i);
            }
        }
        return row;
    }

    private void moveEmptyFieldsOnEnd(int startingField) {
        int fieldsLeft = startingField;
        while (fieldsLeft < 3 && row[startingField] == 0) {
            collapseFrom(startingField);
            fieldsLeft++;
        }
    }

    private boolean canJoinFields(int i) {
        return row[i] == row[i + 1];
    }

    private void collapseFrom(int startingPosition) {
        for (int j = startingPosition; j < 3; j++) {
            row[j] = row[j + 1];
        }
        row[3] = 0;
    }

    private void joinWithNext(int i) {
        row[i] += row[i + 1];
        row[i + 1] = 0;
    }

    public void revertValues() {
        ArrayHelper.revertValues(row);
    }
}
