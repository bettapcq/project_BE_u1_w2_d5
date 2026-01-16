package bettapcq;

import bettapcq.entities.BoardGame;
import bettapcq.entities.Game;
import bettapcq.entities.VideoGame;
import bettapcq.entities.VideogameGenre;
import bettapcq.exceptions.IdExistException;
import bettapcq.exceptions.InvalidNumberOfPlayersException;
import bettapcq.exceptions.NotFoundException;

import java.util.*;

public class GamesCollection {

    private List<Game> gamesColl;

    public GamesCollection() {
        this.gamesColl = new ArrayList<>();
    }


    //metodi:

    public List<Game> getGamesColl() {
        return gamesColl;
    }

    public void setGamesColl(List<Game> gamesColl) {
        this.gamesColl = gamesColl;
    }

    @Override
    public String toString() {
        return "GamesCollection{" +
                "gamesColl=" + gamesColl +
                '}';
    }

    public void addGame(Game newGame) {
        Boolean isPresent = gamesColl.stream().anyMatch(game -> game.getId().equals(newGame.getId()));
        if (isPresent) {
            throw new IdExistException("L'id che hai inserito esiste già!");
        } else {
            gamesColl.add(newGame);
        }
    }


    public Game searchById(String id) {
        Boolean isPresent = gamesColl.stream().anyMatch(game -> game.getId().equals(id));
        if (isPresent) {
            Game result = (Game) gamesColl.stream().filter(game -> game.getId().equals(id)).toList();
            return result;
        } else {
            throw new NotFoundException("L'Id che hai inserito non esiste!");
        }

    }

    public List<Game> searchByMaxPrice(Integer maxPrice) {
        Boolean isPresent = gamesColl.stream().anyMatch(game -> game.getPrice() < maxPrice);
        if (isPresent) {
            List<Game> results = gamesColl.stream().filter(game -> game.getPrice() < maxPrice).toList();
            return results;
        } else {
            throw new NotFoundException("Non ci sono giochi con un prezzo minore di " + maxPrice);
        }
    }

    public List<BoardGame> searchByNumberOfPlayers(int number) {
        if (number >= 2 && number <= 10) {
            List<BoardGame> boardGamesList = gamesColl.stream().filter(game -> game instanceof BoardGame)
                    .map(game -> (BoardGame) game).toList();
            if (boardGamesList.isEmpty()) {
                throw new NotFoundException("Non ci sono giochi per " + number + "giocatori");
            } else {
                List<BoardGame> results = boardGamesList.stream()
                        .filter(boardGame -> (boardGame.getNumberOfPlayers()) == number)
                        .toList();
                ;
                return results;
            }
        } else {
            throw new InvalidNumberOfPlayersException("Il numero dev'essere compreso tra 2 e 10!");
        }
    }

    public void removeGameById(String id) {
        Boolean isPresent = gamesColl.stream().anyMatch(game -> game.getId().equals(id));

        if (isPresent) {
            gamesColl.removeIf(game -> (game.getId()).equals(id));
        } else {
            throw new NotFoundException("L'id che hai inserito non esiste!");
        }
    }

    public void editGame(String id) {

        Boolean isPresent = gamesColl.stream().anyMatch(game -> game.getId().equals(id));

        if (isPresent) {
            Game gameToEdit = gamesColl.stream().filter(game -> game.getId().equals(id)).findFirst().get();
            if (gameToEdit instanceof VideoGame) {
                VideoGame videoGToEdit = (VideoGame) gameToEdit;
                editAVG(videoGToEdit);
            } else {
                BoardGame boardGToEdit = (BoardGame) gameToEdit;
                editABG(boardGToEdit);
            }
        } else {
            throw new NotFoundException("L'id che hai inserito non esiste!");
        }
    }

    public void editAVG(VideoGame vG, String nT, Double nP, int nH, VideogameGenre nG) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Inizio modifiche:");

        System.out.print("Nuovo titolo: ");
        vG.setTitle(scanner.nextLine());

        System.out.print("Nuovo prezzo: ");
        vG.setPrice(scanner.nextDouble());


        System.out.print("Nuove ore di gioco: ");
        vG.getPlayHours(scanner.nextInt());


        System.out.print("Nuovo genere: ");
        vG.setGenre(VideogameGenre.valueOf(scanner.nextLine().toUpperCase()));

        System.out.println("Gioco modificato!");
    }

    public void editABG(BoardGame bG, String nT, Double nP, int nG, Double nM) {
        bG.setTitle(nT);
        bG.setPrice(nP);
        bG.setNumberOfPlayers(nG);
        bG.setDurationAverage(nM);
    }

    public void collectionStatistics(GamesCollection collection) {
        System.out.println("------STATISTICHE------");
        //tot giochi
        int gamesTotNumber = gamesColl.size();
        System.out.println("- Il totale dei giochi presenti è: " + gamesTotNumber);

        //gioco più caro
        Optional<Game> mostExpensiveGame = gamesColl.stream().sorted(Comparator.comparing(Game::getAge).reversed()).findFirst();
        if (mostExpensiveGame.isPresent()) {
            System.out.println("- Il gioco più costoso è : " + mostExpensiveGame);
        } else {
            throw new NotFoundException("La lista è vuota, non è stato possibile individuare il gioco più costoso");
        }

        //media prezzo giochi
        OptionalDouble priceAverage = gamesColl.stream().mapToDouble(game -> game.getPrice()).average();
        if (priceAverage.isPresent()) {
            System.out.println("- La media dei prezzi dei giochi è : " + priceAverage + "euro");
        } else {
            throw new NotFoundException("La lista è vuota, non è stato possibile calcolare la media dei prezzi");
        }
    }
}
