package pacman;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * Klasa zawierająca wszystkie stałe parametry
 */
public class Config {

    static Properties testData;
    static String dataFile;
    static String propDirectory;


    /**
     * Katalog z plikiem properties
     */
    static {
        propDirectory = System.getProperty("user.dir") + "/src/pacman/";
        try {
            /**
             * Odczyt danych z pliku
             */
            loadTestData();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Ladowanie danych z pliku
     * @throws FileNotFoundException Obsługiwany wyjątek
     * @throws IOException Obsługiwany wyjątek
     */
    private static void loadTestData() throws FileNotFoundException, IOException {
        testData = new Properties();
        dataFile = "/config.properties";
        testData.load(new FileInputStream(propDirectory + dataFile));
    }

    /**
     * Metoda używana do ładowania konkretnej wartości z pliku properties
     * @param key Parametr za pomocą którego możliwe jest określenie jakie dane chcemy pobrać
     * @return Zwraca konkretne dane
     */
    protected static String getData(String key) {
        return testData.getProperty(key);
    }

}

















