package bettapcq.entities;


public class VideoGame extends Game {
    private String platform;
    private int playHours;
    private VideogameGenre genre;


    public VideoGame(String id, String title, int year, Double price, String platform, int playHours, VideogameGenre genre) {
        super(id, title, year, price);
        this.platform = platform;
        this.playHours = playHours;
        this.genre = genre;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public int getPlayHours(int i) {
        return playHours;
    }

    public void setPlayHours(int playHours) {
        this.playHours = playHours;
    }

    public VideogameGenre getGenre() {
        return genre;
    }

    public void setGenre(VideogameGenre genre) {
        this.genre = genre;
    }


    @Override
    public String toString() {
        return "VideoGame{" +
                "platform='" + platform + '\'' +
                ", playHours=" + playHours +
                ", genre=" + genre +
                '}';
    }


}

