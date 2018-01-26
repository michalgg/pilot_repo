package helpers;

import java.util.Properties;
import java.io.FileInputStream;

/**
 * Created by michał on 1/25/2018.
 */
public class ConfigReader {

    private static Properties properties = new Properties();

    static {
        try {
            FileInputStream in = new FileInputStream("./resources/config.properties");

            properties.load(in);
            in.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static String getProperty(String key) {
        return properties.getProperty(key);
    }

}
