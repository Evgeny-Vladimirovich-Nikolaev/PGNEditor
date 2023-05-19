package dao;

import model.PGN;

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.time.Instant;
import java.util.List;

public class PGNReader {

    public static List<PGN> getPGNList(String path) {
        StringBuilder sb = new StringBuilder("");
        try(FileReader reader = new FileReader(path))
        {
            int c;
            while((c=reader.read())!=-1){
                sb.append((char)c);
            }
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
        return null;
    }

}
