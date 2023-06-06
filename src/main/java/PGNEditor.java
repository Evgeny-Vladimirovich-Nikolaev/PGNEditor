import dao.PGNParser;
import dao.PGNReader;
import model.Game;

import java.util.ArrayList;
import java.util.List;

public class PGNEditor {

    private static final String  PATH = "C:\\Users\\Nobilis\\YandexDisk-Nobilis13\\JAVA\\ЭТЮД ГЛАЗАМИ ГРОССМЕЙСТЕРОВ.pgn";

    public static void main(String[] args) {
        List<Game> gamesList = PGNReader.getPGNList(PATH);
        //PGNParser.parsePGN()



    }


}

