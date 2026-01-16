package bettapcq.entities;

public class BoardGame extends Game {
    private int numberOfPlayers;
    private int durationAverage;

    public BoardGame(String id, String title, int year, Double price, int numberOfPlayers, int durationAverage) {
        super(id, title, year, price);
        if (numberOfPlayers < 2 || numberOfPlayers > 10) {
            throw new IllegalArgumentException("Il numero dev'essere min 2 e max 10");
        }
        this.numberOfPlayers = numberOfPlayers;
        this.durationAverage = durationAverage;
    }

    public int getNumberOfPlayers() {
        return numberOfPlayers;
    }

    public void setNumberOfPlayers(int numberOfPlayers) {
        this.numberOfPlayers = numberOfPlayers;
    }

    public int getDurationAverage() {
        return durationAverage;
    }

    public void setDurationAverage(int durationAverage) {
        this.durationAverage = durationAverage;
    }

    @Override
    public String toString() {
        return "BoardGame{" +
                "numberOfPlayers=" + numberOfPlayers +
                ", durationAverage=" + durationAverage +
                '}';
    }
}
