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

    private static List<String> lines;
    private static List<List<String>> processedList;


    public static List<Game> getPGNList(String path) {
        lines = new ArrayList<>();
        processedList = new LinkedList<>();
        readByLines(path);
        writeGames();


        System.out.println(processedList.size());

        return PGNParser.parseGamesList(processedList);
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
        long start = System.currentTimeMillis();
        ListIterator<String> itr = lines.listIterator(0);
        List<String> separateList = new ArrayList<>();
        List<String> newSeparateList = null;
        String line;
        while (itr.hasNext()) {
            while (itr.hasNext()) {
                line = itr.next();
                separateList.add(line);
                if (!line.startsWith("[")) {
                    break;
                }
            }
            while (itr.hasNext()) {
                line = itr.next();
                if (!line.startsWith("[")) {
                    separateList.add(line);
                } else {
                    newSeparateList = new ArrayList<>();
                    newSeparateList.add(line);
                    break;
                }
            }
            processedList.add(separateList);
            separateList = newSeparateList;
        }
        long end = System.currentTimeMillis();
        long total = end - start;
        System.out.println("time: " + total);
    }

}
