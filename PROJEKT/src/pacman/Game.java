package pacman;//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

/**
 * Klasa odpowiadająca za odczyt planszy
 */
public class Game {
    /**
     * Metoda wczytująca wymiary planszy
     */
    private Odczytplanszy odczyt;
    /**
     * Szerokość planszy
     */
    public int width;
    /**
     * Wysokość planszy
     */
    public int height;

    /**
     * Wyświetla główną planszę gry
     * @param title Tytuł okna gry
     * @param width Szerokość okna gry
     * @param height Wysokość okna gry
     */
    public Game(String title, int width, int height) {
        this.width = width;
        this.height = height;
        this.odczyt = new Odczytplanszy();
    }
}
