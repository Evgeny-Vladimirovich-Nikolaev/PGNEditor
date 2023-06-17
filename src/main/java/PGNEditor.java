import dao.MaterialClassifications;
import dao.PGNReader;
import model.Game;
import processing.DiagramCreator;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class PGNEditor {

    private final static String PATH = "C:\\D\\Dev\\IDEA\\PGNEditor\\src\\main\\resources\\одноцветные";

    public static void main(String[] args) {
        List<Game> gamesList = PGNReader.getPGNList(PATH);
        String diagram = DiagramCreator.getDiagramFromFen(gamesList.get(0).getFen());
        System.out.println(diagram);

    }

}

