package dao;

import model.Game;

import java.util.ArrayList;
import java.util.List;

public class PGNParser {

    public static List<Game> parsePGN(StringBuilder sb) {
        List<Game> gamesList = new ArrayList();
        int index = 0;
        while(index < sb.length()) {
            Game game = new Game();
            StringBuilder tags = new StringBuilder();
            StringBuilder body = new StringBuilder();
            if(sb.charAt(index) == '[') {
                while(index < sb.length()) {
                    if(sb.charAt(index) == ']' && !checkTagsComplete(sb, index)) {
                        break;
                    }
                    tags.append(sb.charAt(index++));
                    System.out.println(tags);
                }
                System.out.println("-----------------------------------------------------------------");
                System.out.println(tags);
            }
            while(index < sb.length() && (sb.charAt(index) == ' ' || sb.charAt(index) == '\n')) {
                index++;
            }
            while(index < sb.length() && sb.charAt(index) != '[') {
                body.append(sb.charAt(index));
            }
        }
        return null;
    }

    public static void addFieldToGame(Game game) {

    }

    private static boolean checkTagsComplete(StringBuilder sb, int index) {
        if(index + 2 >=  sb.length()) {
            return true;
        }
        if(sb.charAt(index + 1) != '[' && sb.charAt(index + 2) != '[') {
            return true;
        }
        return false;
    }

}
