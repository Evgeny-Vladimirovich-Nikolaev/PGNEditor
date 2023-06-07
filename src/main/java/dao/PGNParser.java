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
            for (int i = 10; i < 14; i++) {
                material[i] = material[i - 9] + material[i - 4];
            }
            material[14] = material[10] + material[11] + material[12] + material[13];      // total number of knights, bishops, rooks and queens
            game.setWhiteNumber(white);
            game.setBlackNumber(black);
            game.setTotalNumber((byte) (white + black));
        }
        String status = MaterialClassifier.startAnalyze(position, material);
        System.out.println(status);
    }
}

class MaterialClassifier {

    static String startAnalyze(byte[] position, int[] material) {
        if (material[13] > 0) {
            return countWithQueens(material);
        } else if (material[12] > 0) {
            return countWithRooks(material);
        } else if (material[11] > 0) {
            return countWithBishops(position, material);
        } else if (material[10] > 0) {
            return countWithKnights(material);
        } else if (material[0] != 0 && material[5] != 0) {
            return MaterialClassifications.P.getCategory();
        }
        throw new RuntimeException();
    }

    private static String countWithQueens(int[] material) {
        if (material[12] > 0) {
            return countWithQueensAndRooks(material);
        } else if (material[11] > 0) {
            return countWithQueensAndBishops(material);
        } else if (material[10] > 0) {
            return MaterialClassifications.QN_VARIATIONS.getCategory();
        } else if (material[4] == 1 && material[9] == 1) {
            return MaterialClassifications.Q_VS_Q.getCategory();
        } else if ((material[4] == 1 && material[9] == 0 && material[5] > 0) || (material[9] == 1 && material[4] == 0 && material[0] > 0)) {
            return MaterialClassifications.Q_VS_P.getCategory();
        }
        return null;
    }

    private static String countWithQueensAndRooks(int[] material) {
        if (material[10] == 0) {
            if (material[11] == 0) {
                return MaterialClassifications.QR_VARIATIONS.getCategory();
            }
            return MaterialClassifications.QRB_VARIATIONS.getCategory();
        }
        if (material[11] == 0) {
            return MaterialClassifications.QRN_VARIATIONS.getCategory();
        }
        if (material[14] == 4) {
            return MaterialClassifications.QRBN_VARIATIONS_4.getCategory();
        }
        if (material[14] == 5) {
            return MaterialClassifications.QRBN_VARIATIONS_5.getCategory();
        }
        return MaterialClassifications.QRBN_VARIATIONS_6_0R_M0RE.getCategory();
    }

    private static String countWithQueensAndBishops(int[] material) {
        if (material[10] == 0) {
            return MaterialClassifications.QB_VARIATIONS.getCategory();
        }
        if (material[14] == 3) {
            return MaterialClassifications.QBN_VARIATIONS_3.getCategory();
        }
        if (material[14] == 4) {
            return MaterialClassifications.QBN_VARIATIONS_4.getCategory();
        }
        return MaterialClassifications.QBN_VARIATIONS_5_OR_MORE_PIECES.getCategory();
    }

    private static String countWithRooks(int[] material) {
        if (material[14] == 1) {
            return MaterialClassifications.ONE_R.getCategory();
        }
        if (material[10] == 0 && material[11] == 0) {
            if (material[3] == 1 && material[8] == 1) {
                return MaterialClassifications.R_VS_R.getCategory();
            }
            return MaterialClassifications.SEVERAL_R.getCategory();
        }
        if (material[11] == 0) {
            if ((material[3] == 1 && material[6] == 1) || (material[1] == 1 && material[8] == 1)) {
                return MaterialClassifications.R_VS_N.getCategory();
            }
            if ((material[1] == 1 && material[3] == 1 && material[5] > 0) || (material[6] == 1 && material[8] == 1 && material[0] > 0)) {
                return MaterialClassifications.RN_VS_P.getCategory();
            }
            return MaterialClassifications.RN_VARIATIONS.getCategory();
        }
        if (material[10] == 0) {
            if ((material[3] == 1 && material[7] == 1) || (material[2] == 1 && material[8] == 1)) {
                return MaterialClassifications.R_VS_B.getCategory();
            }
            if ((material[2] == 1 && material[3] == 1 && material[5] > 0) || (material[7] == 1 && material[8] == 1 && material[0] > 0)) {
                return MaterialClassifications.RB_VS_P.getCategory();
            }
            return MaterialClassifications.RB_VARIATIONS.getCategory();
        }
        if (material[14] == 3) {
            return MaterialClassifications.RBN_VARIATIONS_3.getCategory();
        }
        if (material[14] == 4) {
            return MaterialClassifications.RBN_VARIATIONS_4.getCategory();
        }
        return MaterialClassifications.RBN_VARIATIONS_5_OR_MORE.getCategory();
    }

    private static String countWithBishops(byte[] position, int[] material) {
        if (material[14] == 1) {
            return MaterialClassifications.ONE_B.getCategory();
        }
        if (material[14] == 2) {
            if (material[2] == 1 && material[7] == 1) {
                if (isSameColored(position)) {
                    return MaterialClassifications.B_VS_B_SAME_COLORED.getCategory();
                }
                return MaterialClassifications.B_VS_B_OPPOSITE_COLORED.getCategory();
            }
        }
        return null;
    }

    private static boolean isSameColored(byte[] position) {
        int sum = 0;
        for (int sym = 0, row = 0, count = 0; sym < position.length && count < 2; sym++, row++) {
            int column = 0;
            while (position[sym] != 47) {
                if (position[sym] > 48 && position[sym] < 57) {
                    column += position[sym];
                } else if (position[sym] == 66 || position[sym] == 98) {
                    sum = sum + row + column;
                    count++;
                }
                sym++;
                column++;
            }
        }
        return sum % 2 == 0;
    }

    private static String countWithKnights(int[] material) {
        return null;
    }
}
