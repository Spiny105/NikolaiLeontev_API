package service;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class SpellerParams {

    private static final String PROPERTIES_FILE_PATH = ".\\src\\test\\recources\\properties\\speller.properties";

    public static final String CHECK_TEXT_URI = "checkText";
    public static final String CHECK_TEXTS_URI = "checkTexts";

    private static String spellerJsonInterfaceString;
    private static String spellerUrl;

    static {
        Properties prop = new Properties();

        try (InputStream input = new FileInputStream(PROPERTIES_FILE_PATH)) {
            if (input == null) {
                System.out.println("Sorry, unable to find config.properties");
            }
            prop.load(input);
        } catch (IOException e) {
            e.printStackTrace();
        }

        spellerJsonInterfaceString = prop.getProperty("json_interface");
        spellerUrl = prop.getProperty("url");
    }

    public static String getSpellerJsonInterfaceString() {
        return spellerJsonInterfaceString;
    }

    public static String getSpellerUrl() {
        return spellerUrl;
    }
}
