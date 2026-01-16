package bettapcq;

import bettapcq.entities.BoardGame;
import bettapcq.entities.Game;
import bettapcq.entities.VideoGame;
import bettapcq.entities.VideogameGenre;

import java.util.List;

public class Application {

    public static void main(String[] args) {

        VideoGame vg1 = new VideoGame("VG001", "Elden Ring", 2022, 69.99, "PC", 150, VideogameGenre.RPG);
        VideoGame vg2 = new VideoGame("VG002", "Pac-Man Championship Edition", 2010, 19.99, "PS5", 40, VideogameGenre.ARCADE);
        VideoGame vg3 = new VideoGame("VG003", "Civilization VI", 2016, 59.99, "PC", 120, VideogameGenre.STRATEGY);
        VideoGame vg4 = new VideoGame("VG004", "Forza Horizon 5", 2021, 59.99, "XBOX", 80, VideogameGenre.RACING);
        VideoGame vg5 = new VideoGame("VG005", "Starfield", 2023, 79.99, "PC", 200, VideogameGenre.RPG);

        BoardGame bg1 = new BoardGame("BG001", "Catan", 1995, 34.99, 3, 90.0);
        BoardGame bg2 = new BoardGame("BG002", "Ticket to Ride", 2004, 39.99, 5, 60.0);
        BoardGame bg3 = new BoardGame("BG003", "Dixit", 2008, 29.99, 4, 45.0);

        GamesCollection collection = new GamesCollection();


        collection.addGame(vg1);
        collection.addGame(vg2);
        collection.addGame(vg3);
        collection.addGame(vg4);
        collection.addGame(vg5);

        collection.addGame(bg1);
        collection.addGame(bg2);
        collection.addGame(bg3);
        System.out.println(collection);


        Game provaSearchId = collection.searchById("VG002");
        System.out.println(provaSearchId);

        List<Game> provaSearchByPrice = collection.searchByMaxPrice(50);
        System.out.println(provaSearchByPrice);

        List<BoardGame> provasearchByPlayers = collection.searchByNumberOfPlayers(3);
        System.out.println(provasearchByPlayers);

        collection.removeGameById("BG002");
        System.out.println("Dopo remove, collezione: " + collection);

        System.out.println("\n--- TEST collectionStatistics ---");
        collection.collectionStatistics(collection);
    }

}

