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
            StringBuilder sb = new StringBuilder();
            for (String line : list) {
                if (line.startsWith("[")) {
                    System.out.println(line);
                    String tagValue = line.substring(line.indexOf('"') + 1, line.lastIndexOf('"'));
                    switch (line.substring(0, line.indexOf(' '))) {
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
                    sb.append(line);
                    //sb.append('\n');
                }
            }
            game.setBody(sb.toString());
            parsedGames.add(game);
        }
        return parsedGames;
    }

    private static void analyzeFen(Game game, String fen) {
        final byte[] position = fen.substring(0, fen.indexOf(' ')).getBytes();
        calculatePieces(game, position);
    }

    private static void calculatePieces(Game game, byte[] position) {
        final int[] material = new int[15];
        byte white = 0;
        byte black = 0;
        for (byte b : position) {
//            if (b > 65 && b < 83) {
//                white++;
//            } else if (b > 97 && b < 115) {
//                black++;
//            }
            switch (b) {
                case 80 -> {            // P -> white pawn
                    material[0]++;
                    white++;
                }
                case 78 -> {            // N -> white knight
                    material[1]++;
                    white++;
                }
                case 66 -> {            // B -> white bishop
                    material[2]++;
                    white++;
                }
                case 82 -> {            // R -> white rook
                    material[3]++;
                    white++;
                }
                case 81 -> {            // Q -> white queen
                    material[4]++;
                    white++;
                }
                case 75 -> {            // K -> white king
                    white++;
                }
                case 112 -> {            // p -> black pawn
                    material[5]++;
                    black++;
                }
                case 110 -> {            // n -> black knight
                    material[6]++;
                    black++;
                }
                case 98 -> {            // b -> black bishop
                    material[7]++;
                    black++;
                }
                case 114 -> {            // r -> black rook
                    material[8]++;
                    black++;
                }
                case 113 -> {            // q -> black queen
                    material[9]++;
                    black++;
                }
                case 107 -> {            // k -> black king
                    black++;
                }
            }
            for(int i = 10; i < 14; i++) {
                material[i] = material[i - 9] + material[i - 4];
            }
            material[14] = material[10] + material[11] + material[12] + material[13];      // total number of knights, bishops, rooks and queens
            game.setWhiteNumber(white);
            game.setBlackNumber(black);
            game.setTotalNumber((byte) (white + black));
        }

    }
}

class MaterialClassifier {

    private static String startAnalyze(int[] material) {
        if(material[13] > 0) {
            return countWithQueens(material);
        } else if(material[12] > 0) {
            return countWithRooks(material);
        } else if(material[11] > 0) {
            return countWithBishops(material);
        } else if(material[10] > 0) {
            return countWithKnights(material);
        } else if(material[0] != 0 && material[5] != 0) {
            return MaterialClassifications.P.getCategory();
        }
        throw new RuntimeException();
    }

    private static String countWithQueens(int[] material) {
        return null;
    }

    private static String countWithRooks(int[] material) {
        return null;
    }

    private static String countWithBishops(int[] material) {
        return null;
    }

    private static String countWithKnights(int[] material) {
        return null;
    }
}
