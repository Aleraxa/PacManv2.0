package Nazwy;

/**
 * Created by Alison on 2017-04-23.
 */
public class Nazwy {
    private String wpisaneNazwy;

    public Nazwy(String wpisaneNazwy){

        this.wpisaneNazwy = wpisaneNazwy;
    }

    public String pobierzNazwy() {
        return wpisaneNazwy;
    }

    public void zapiszNazwy(String wpisaneNazwy) {
        this.wpisaneNazwy = wpisaneNazwy;
    }
}
