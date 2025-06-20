package Utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

     static Properties prop = new Properties();

    static{


        try {
            FileInputStream file = new FileInputStream("src/main/java/Utils/config.properties");
            prop.load(file);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }


    public static String get(String key){

        return prop.getProperty(key);
    }

}
