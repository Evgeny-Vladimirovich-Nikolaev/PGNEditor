package dao;

import model.Game;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class PGNReader {

    private static LinkedList<String> lines;
    private static List<List<String>> games;


    public static List<Game> getPGNList(String path) {
        lines = new LinkedList<>();
        games = new LinkedList<>();
        readByLines(path);
        writeGames();

        for (List<String> list: games
             ) {
            System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------\n-----------------------------------------------------------------------------------------------------------");
            System.out.println(list);
        }

        return null;
    }

    private static void readByLines(String path) {
        File file = new File(path);

        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            reader.lines().forEach(s -> lines.add(s.trim()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void writeGames() {

        ListIterator<String> itr = lines.listIterator(0);
        while(itr.hasNext()) {
            String line = itr.next();
            List<String> game = new ArrayList<>();
            while(itr.hasNext() && line.startsWith("[") ) {
                game.add(line);
                line = itr.next();
            }
            while(itr.hasNext() && !itr.next().startsWith("[")) {
                game.add(itr.next());
            }
            games.add(game);
        }



//        ListIterator<String> itr = lines.listIterator(0);
//        List<String> game = new ArrayList<>();
//        boolean tagsComplete = false;
//        boolean isAdded = false;
//
//        while (itr.hasNext()) {
//            String line = itr.next();
//            if (line.length() > 0) {
//                if (line.charAt(0) == '[') {
//                    if(tagsComplete) {
//                        if(!isAdded) {
//                            games.add(game);
//                        }
//                        game = new ArrayList<>();
//                    }
//                    game.add(line);
//                } else {
//                    tagsComplete = true;
//                    if(line.length() > 1) {
//                        game.add(line);
//                        isAdded = true;
//                    }
//                }
//            }
//        }
    }

}
