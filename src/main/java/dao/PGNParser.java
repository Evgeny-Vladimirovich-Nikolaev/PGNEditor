package dao;

import model.Game;

import java.util.ArrayList;
import java.util.List;

public class PGNParser {

    private static List<Game> parsedGames;

    public static List<Game> parseGamesList(List<List<String>> processedList) {
        parsedGames = new ArrayList<>();
        for (List<String> list : processedList) {
            Game game = new Game();
            for (String line : list) {
                switch (line.substring(0)) {
                    case "[Date" :
                        addDate(game, line);
                        break;
                    case "[Автор" :
                        addAuthor(game, line);
                        break;
                    case "[Event" :
                        addEvent(game, line);
                        break;
                    case "[Result" :
                        addResult(game, line);
                        break;
                    case "[Задание" :
                        addTask(game, line);
                        break;
                    case "[Annotator" :
                        addAnnotator(game, line);
                        break;
                    case "[Remark" :
                        addRemark(game, line);
                        break;
                    case "[FEN" :
                        addFen(game, line);
                        analyzeFen(game, line);
                        break;
                }
            }
        }
        return null;
    }

    private static void addDate(Game game, String line) {
        game.setDate(line.substring(line.indexOf('"') +1, line.lastIndexOf('"')));
    }

    private static void addAuthor(Game game, String line) {
        game.setAuthor(line.substring(line.indexOf('"') +1, line.lastIndexOf('"')));
    }

    private static void addEvent(Game game, String line) {
        game.setEvent(line.substring(line.indexOf('"') + 1, line.lastIndexOf('"')));
    }

    private static void addResult(Game game, String line) {
        game.setResult(line.substring(line.indexOf('"') + 1, line.lastIndexOf('"')));
    }

    private static void addTask(Game game, String line) {
        game.setTask(line.substring(line.indexOf('"') + 1, line.lastIndexOf('"')));
    }

    private static void addAnnotator(Game game, String line) {
        game.setAnnotator(line.substring(line.indexOf('"') + 1, line.lastIndexOf('"')));
    }

    private static void addRemark(Game game, String line) {
        game.setRemark(line.substring(line.indexOf('"') + 1, line.lastIndexOf('"')));
    }

    private static void addFen(Game game, String line) {
        game.setFen(line.substring(line.indexOf('"') + 1, line.lastIndexOf('"')));
    }

    private static void analyzeFen(Game game, String fen) {
        final String position = getPositionFromFen(fen);
        calculateMaterial(game, position);
    }

    private static String getPositionFromFen(String fen) {
        return null;
    }

    private static void calculateMaterial(Game game, String line) {

    }
}
