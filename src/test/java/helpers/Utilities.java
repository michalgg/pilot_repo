package helpers;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by michał on 1/25/2018.
 */
public class Utilities {

    public static List<Object []> getTestDataFromFile(String sourceFile){

        String dataFile = "src/test/resources/test_data/" + sourceFile;
        BufferedReader br = null;
        String separator = ";";
        String line = "";

        List<Object []> testCases = new ArrayList<>();
        String[] data= null;

        try {
            br = new BufferedReader(new FileReader(dataFile));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            String headerLine = br.readLine();
            while ((line = br.readLine()) != null) {
                data =  line.split(separator);
                testCases.add(data);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return testCases;
    }
}
