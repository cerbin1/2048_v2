package bartek;

public class LineMerger {
    private final int[] line;
    private int points;

    public LineMerger(int one, int two, int three, int four) {
        this.line = new int[]{one, two, three, four};
    }

    public int[] mergeAndMove() {
        for (int i = 0; i < 3; i++) {
            if (line[i] == 0) {
                moveEmptyFieldsToEndFrom(i);
            }
            if (line[i + 1] == 0) {
                moveEmptyFieldsToEndFrom(i + 1);
            }
            if (canMergeFields(i)) {
                joinWithNext(i);
            }
        }
        return line;
    }

    private void moveEmptyFieldsToEndFrom(int startingField) {
        int fieldsLeft = startingField;
        while (fieldsLeft < 3 && line[startingField] == 0) {
            collapseFrom(startingField);
            fieldsLeft++;
        }
    }

    private boolean canMergeFields(int i) {
        return line[i] == line[i + 1];
    }

    private void collapseFrom(int startingPosition) {
        for (int j = startingPosition; j < 3; j++) {
            line[j] = line[j + 1];
        }
        line[3] = 0;
    }

    private void joinWithNext(int i) {
        line[i] += line[i + 1];
        line[i + 1] = 0;
        points += line[i];
    }

    public void revertValues() {
        ArrayHelper.revertValues(line);
    }

    int getPoints() {
        return points;
    }
}
