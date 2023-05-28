package dao;

import com.sun.tools.javac.util.StringUtils;
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
                    case "[Автор":
                        addAuthor(game, line);
                        break;
                    case "[Event:" :
                        addEvent(game, line);
                        break;
                    case "[Задание":
                        addTask(game, line);
                        break;
                }
            }
        }
        return null;
    }

    private static void addDate(Game game, String line) {
        game.setDate(line.substring(line.indexOf('"'), line.lastIndexOf('"')));
    }

    private static void addAuthor(Game game, String line) {
        game.setAuthor(line.substring(line.indexOf('"'), line.lastIndexOf('"')));
    }

    private static void addEvent(Game game, String line) {
        game.setEvent(line.substring(line.indexOf('"'), line.lastIndexOf('"')));
    }

    private static void addTask(Game game, String line) {
        game.setTask(line.substring(line.indexOf('"'), line.lastIndexOf('"')));
    }

}
