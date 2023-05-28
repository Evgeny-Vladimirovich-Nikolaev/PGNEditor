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
                if (line.startsWith("[")) {
                    String tagValue = line.substring(line.indexOf('"') +1, line.lastIndexOf('"'));
                    switch (line.substring(0)) {
                        case "[Date" :
                            game.setDate(tagValue);
                            break;
                        case "[Автор" :
                            game.setAuthor(tagValue);
                            break;
                        case "[Event" :
                            game.setEvent(tagValue);
                            break;
                        case "[Result" :
                            game.setResult(tagValue);
                            break;
                        case "[Задание" :
                            game.setTask(line);
                            break;
                        case "[Annotator" :
                            game.setAnnotator(line);
                            break;
                        case "[Remark" :
                            game.setRemark(line);
                            break;
                        case "[FEN" :
                            game.setFen(line);
                            analyzeFen(game, line);
                            break;
                    }
                } else {
                    game.setBody(line);
                }
            }
        }
        return null;
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
