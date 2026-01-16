package bettapcq.entities;

public abstract class Game {
    private String id;
    private String title;
    private int year;
    private Double price;

    public Game(String id, String title, int year, Double price) {
        this.id = id;
        this.title = title;
        this.year = year;
        if (price < 0) {
            throw new IllegalArgumentException("Il prezzo dev'essere maggiore di zero");

        }
        ;
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Game{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", year=" + year +
                ", price=" + price +
                '}';
    }
}
