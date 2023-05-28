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
                    String tagValue = line.substring(line.indexOf('"') + 1, line.lastIndexOf('"'));
                    switch (line.substring(0)) {
                        case "[Date":
                            game.setDate(tagValue);
                            break;
                        case "[Автор":
                            game.setAuthor(tagValue);
                            break;
                        case "[Event":
                            game.setEvent(tagValue);
                            break;
                        case "[Result":
                            game.setResult(tagValue);
                            break;
                        case "[Задание":
                            game.setTask(tagValue);
                            break;
                        case "[Annotator":
                            game.setAnnotator(tagValue);
                            break;
                        case "[Remark":
                            game.setRemark(tagValue);
                            break;
                        case "[FEN":
                            game.setFen(tagValue);
                            analyzeFen(game, tagValue);
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
        final byte[] position = fen.substring(0, fen.indexOf(' ')).getBytes();
        calculatePieces(game, position);
    }

    private static void calculatePieces(Game game, byte[] position) {
        byte white = 0;
        byte black = 0;
        for (byte b : position) {
            if (b > 65 && b < 83) {
                white++;
            } else if (b > 97 && b < 115) {
                black++;
            }
        }
        game.setWhiteNumber(white);
        game.setBlackNumber(black);
        game.setTotalNumber((byte) (white + black));
    }


}
