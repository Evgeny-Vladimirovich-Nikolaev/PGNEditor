package processing;

import java.util.HashMap;

public class DiagramCreator {

    private static final HashMap<Character,Character> CHARACTER_ON_LIGHT_SQUARE;
    private static final HashMap<Character,Character> CHARACTER_ON_DARK_SQUARE;
    private static final char LIGHT_SQUARE = '*';
    private static final char DARK_SQUARE = '+';
    private static final String CLEAR_DIAGRAM;

    static {
        CLEAR_DIAGRAM = getClearDiagram();
        CHARACTER_ON_LIGHT_SQUARE = new HashMap<>();
        CHARACTER_ON_DARK_SQUARE = new HashMap<>();
        CHARACTER_ON_LIGHT_SQUARE.put('P', 'p');
        CHARACTER_ON_LIGHT_SQUARE.put('N', 'n');
        CHARACTER_ON_LIGHT_SQUARE.put('B', 'b');
        CHARACTER_ON_LIGHT_SQUARE.put('R', 'r');
        CHARACTER_ON_LIGHT_SQUARE.put('Q', 'q');
        CHARACTER_ON_LIGHT_SQUARE.put('K', 'k');
        CHARACTER_ON_LIGHT_SQUARE.put('p', 'o');
        CHARACTER_ON_LIGHT_SQUARE.put('n', 'm');
        CHARACTER_ON_LIGHT_SQUARE.put('b', 'v');
        CHARACTER_ON_LIGHT_SQUARE.put('r', 't');
        CHARACTER_ON_LIGHT_SQUARE.put('q', 'e');
        CHARACTER_ON_LIGHT_SQUARE.put('k', 'l');
        CHARACTER_ON_DARK_SQUARE.put('P', 'P');
        CHARACTER_ON_DARK_SQUARE.put('N', 'N');
        CHARACTER_ON_DARK_SQUARE.put('B', 'B');
        CHARACTER_ON_DARK_SQUARE.put('R', 'R');
        CHARACTER_ON_DARK_SQUARE.put('Q', 'Q');
        CHARACTER_ON_DARK_SQUARE.put('K', 'K');
        CHARACTER_ON_DARK_SQUARE.put('p', 'O');
        CHARACTER_ON_DARK_SQUARE.put('n', 'M');
        CHARACTER_ON_DARK_SQUARE.put('b', 'V');
        CHARACTER_ON_DARK_SQUARE.put('r', 'T');
        CHARACTER_ON_DARK_SQUARE.put('q', 'W');
        CHARACTER_ON_DARK_SQUARE.put('k', 'L');
    }

    public static String getDiagramFromFen(String fen) {
        //String diagram = CLEAR_DIAGRAM;
        StringBuilder diagram = new StringBuilder(CLEAR_DIAGRAM);
        for(int fenInd = 0, diaInd = 0; fen.charAt(fenInd) != 32; fenInd++) {
            if(fen.charAt(fenInd) > 48 && fen.charAt(fenInd) < 57) {
                String s= "" + fen.charAt(fenInd);
                int num = 0 + Integer.parseInt(s);
                diaInd += num;
            } else if(fen.charAt(fenInd) == '/') {
                diagram.deleteCharAt(diaInd);
                diagram.insert(diaInd, '\n');
                diaInd++;
            } else {
                Character ch = diagram.charAt(diaInd);
                diagram.deleteCharAt(diaInd);
                if(ch == LIGHT_SQUARE) {
                    diagram.insert(diaInd, CHARACTER_ON_LIGHT_SQUARE.get(fen.charAt(fenInd)));
                } else diagram.insert(diaInd, CHARACTER_ON_DARK_SQUARE.get((fen.charAt(fenInd))));
                diaInd++;
            }
        }
        return diagram.toString();
    }

    private static String getClearDiagram() {
        StringBuilder diagram = new StringBuilder();
        for(int row = 0; row < 8; row++) {
            for(int columnPair = 0; columnPair < 4; columnPair++) {
                if(row % 2 == 0) {
                    diagram.append(LIGHT_SQUARE);
                    diagram.append(DARK_SQUARE);
                } else {
                    diagram.append(DARK_SQUARE);
                    diagram.append(LIGHT_SQUARE);
                }
            }
            diagram.append('\n');
        }
        return diagram.toString();
    }
}
