import dao.MaterialClassifications;
import dao.PGNReader;
import model.Game;

import java.util.ArrayList;
import java.util.List;

public class PGNEditor {

    private final static String PATH = "D:\\Dev\\IDEA\\PGNEditor\\src\\main\\resources\\одноцветные";

    public static void main(String[] args) {
        List<Game> gamesList = PGNReader.getPGNList(PATH);

        int countSuccess = 0;
        int countError = 0;

        for (Game game : gamesList) {
            if(game.getMaterial().endsWith("(одноцветные)")) {
                countSuccess++;
            } else if (game.getMaterial().endsWith("(разноцветные)")) {
                countError++;
            }
        }
        System.out.println("Правильных ответов : " + countSuccess);
        System.out.println("Ошибок : " + countError);

        countSuccess = 0;
        countError = 0;
        gamesList = PGNReader.getPGNList("D:\\Dev\\IDEA\\PGNEditor\\src\\main\\resources\\разноцветные");
        for (Game game : gamesList) {
            if(game.getMaterial().endsWith("(разноцветные)")) {
                countSuccess++;
            } else if (game.getMaterial().endsWith("(одноцветные)")) {
                countError++;
            }
        }
        System.out.println("Правильных ответов : " + countSuccess);
        System.out.println("Ошибок : " + countError);

    }


}

