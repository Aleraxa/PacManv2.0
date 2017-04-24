package pacman;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;

import static pacman.Config.getData;

@SuppressWarnings("serial")
/**
 * Klasa głownego okienka gry
 */
public class Plansza extends JFrame {


	/**
	 * Wczytywanie obrazku
	 * @param img Obrazek
	 * @return Wczytany obrazek
	 */
	public static BufferedImage toBufferedImage(Image img)
	{
		if (img instanceof BufferedImage)
		{
			return (BufferedImage) img;
		}

		/**
		 * Tworzy zbuforowany obrazek
		 */
		BufferedImage bimage = new BufferedImage(img.getWidth(null), img.getHeight(null), BufferedImage.TYPE_INT_ARGB);

		/**
		 * Rysuje obrazek na zbufrowanym obrazku
		 */
		Graphics2D bGr = bimage.createGraphics();
		bGr.drawImage(img, 0, 0, null);
		bGr.dispose();

		/**
		 * Zwraca obrazek
		 */
		return bimage;
	}


	/**
	 * Rysuje planszę
	 * @param wysokosc	Wysokość planszy
	 * @param szerokosc	Szerokość planszy
	 * @param punkty Zdobyte punkty
	 * @throws InterruptedException
	 */
	public void launchFrame(int wysokosc, int szerokosc,char[][] punkty) throws InterruptedException{
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we) {
				System.exit(1);
			}
		});

		/**
		 * Tworzenie panelu
		 */
		JPanel mainpanel = new JPanel(new BorderLayout());


		/**
		 * Tworzenie komponentu o nazwie wynik
		 */
		JTextField wynik = new JTextField("Wynik");
		/**
		 * Ustawia preferowany rozmiar pola
		 */
		wynik.setPreferredSize(new Dimension(100,35));
		/**
		 * Ustawienie braku możliwośc edycji
		 */
		wynik.setEditable(false);
		/**
		 * Tworzenie komponentu o nazwie wynik
		 */
		JTextField zycia = new JTextField("Życia " + getData("zycia"));
		/**
		 * Ustawienie braku możliwośc edycji
		 */
		zycia.setEditable(false);
		/**
		 * Ustawienie miejsca wyświetlania pola
		 */
		zycia.setHorizontalAlignment(JTextField.CENTER);
		/**
		 *  Tworzenie komponentu o nazwie pauza
		 */
		JButton button = new JButton(getData("pauza"));
		/**
		 * Ustawia preferowany rozmiar pola
		 */
		button.setPreferredSize(new Dimension(100,40));

		//Obrazgra gra = new Obrazgra(wysokosc,szerokosc,punkty);
		/**
		 * Nowa gra
		 */
		final Obrazgra gra = new Obrazgra(wysokosc,szerokosc,punkty);

		/**
		 * Dodawanie komponentu wynik do panelu
		 */
		mainpanel.add(wynik,BorderLayout.WEST);
		/**
		 * Dodawanie komponentu zycia do panelu
		 */
		mainpanel.add(zycia,BorderLayout.CENTER);
		/**
		 * Dodawanie komponentu button do panelu
		 */
		mainpanel.add(button,BorderLayout.EAST);
		/**
		 * Dodawanie komponentu gra do panelu
		 */
		mainpanel.add(gra,BorderLayout.SOUTH);
		/**
		 * Dodanie panelu do okienka
		 */
		add(mainpanel);
		//gra.zaladujplansze();

		this.addComponentListener(new ComponentAdapter() {
			public void componentResized(ComponentEvent ce) {
				//gra.updateOffscreenSize(ce.getComponent().getWidth(), ce.getComponent().getHeight());
			}
		});



		pack();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				setVisible(true);
			}
		});
		(gra.kicker = new Thread(gra)).start();


	}}