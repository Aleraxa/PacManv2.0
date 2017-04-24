package pacman;

import java.io.IOException;

/**
 * Authors: M.Bałut, A.Sowińska
 */
public class Main {
	/**
	 *
	 * @param args Argumenty
	 * @throws IOException Wyjątek systemowy
	 * @throws InterruptedException Wyjątek systemowy
	 */
	public static void main(String... args) throws IOException,InterruptedException{


		Menu menuGlowne = new Menu();

		Plansza okno2 = new Plansza();
		Odczytplanszy con = new Odczytplanszy();
		char[][] pkty = con.odczytplanszy();
		int[] param = con.odczytparametrow();
		okno2.launchFrame(param[1],param[0],pkty);



	}

}