package bartek.logic;

class PointsCounter {
    private int points;

    void addPoints(int points) {
        if (points < 0) throw new IllegalArgumentException();
        this.points += points;
    }

    int getPoints() {
        return points;
    }
}
