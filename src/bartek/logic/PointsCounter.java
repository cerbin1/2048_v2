package bartek.logic;

public class PointsCounter {
    private int points;

    public void addPoints(int points) {
        if (points < 0) throw new IllegalArgumentException();
        this.points += points;
    }

    public int getPoints() {
        return points;
    }
}
