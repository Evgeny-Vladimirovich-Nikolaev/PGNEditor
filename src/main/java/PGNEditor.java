import dao.PGNReader;
import model.Game;

import java.util.ArrayList;
import java.util.List;

public class PGNEditor {

    private static final String  PATH = "C:\\Users\\Nobilis\\YandexDisk\\JAVA\\ЭТЮД ГЛАЗАМИ ГРОССМЕЙСТЕРОВ.pgn";

    public static void main(String[] args) {
        List<Game> gamesList = PGNReader.getPGNList(PATH);
        //PGNParser.parsePGN()

        System.out.println(gamesList.get(0));
        System.out.println(gamesList.get(9));
        System.out.println(gamesList.get(gamesList.size() - 1));

    }


}

