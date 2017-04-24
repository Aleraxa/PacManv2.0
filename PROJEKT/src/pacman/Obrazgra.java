package pacman;


import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import static pacman.Config.getData;

/**
 * Główna makieta gry
 */
public class Obrazgra extends Canvas implements Runnable, KeyListener{

    /**
     * Obraz pionowej ściany
     */
    private Image pion = null;
    /**
     * Obraz pustego pola
     */
    private Image pusto = null;
    /**
     * Obraz poziomej ściany
     */
    private Image poziom = null;
    /**
     * Obraz pacmana skierowanego w prawo
     */
    private Image pacmanE = null;
    /**
     * Obraz pacmana skierowanego w lewo
     */
    private Image pacmanW = null;
    /**
     * Obraz pacmana skierowanego do dołu
     */
    private Image pacmanS = null;
    /**
     * Obraz pacmana skierowanego w dół
     */
    private Image pacmanN = null;
    /**
     * Obraz duszka
     */
    private Image duszek = null;
    /**
     * Obraz niebieskiego duszka
     */
    private Image nduszek = null;
    /**
     * Obraz Obraz do podwójnego buforowania
     */
    private Image offscreen = null;
    /**
     * Obraz pionowej ściany
     */
    private Graphics offscreeng = null;
    /**
     * Szerokosc planszy
     */
    private int szerokosc=0;
    /**
     * wysokosc planszy
     */
    private int wysokosc=0;
    /**
     * Zobrazowanie planszy wejsciowej w tablicy charow
     */
    private char[][] punkty;
    /**
     * Współrzędna X pacmana
     */
    private int pacX=-1;
    /**
     * Współrzędna Y pacmana
     */
    private int pacY=-1;
    /**
     * Kierunek ruch pacmana
     */
    private char kierunek='a';
    /**
     * zmienna dla kolumny
     */
    public int wiersz=0;
    /**
     * Zmienna długość wiersza
     */
    public int kolumna=0;

    /**
     * Konstruktor podczas którego między innymi ładowane są obrazki
     * @param wysokosc Wysokość
     * @param szerokosc Szerokość
     * @param punkty  Punkty służące do rysowania planszy za pomocą obrazków
     */
    Obrazgra(int wysokosc,int szerokosc,char[][] punkty) {


        /**
         * Odczyt obrazka odpowiadającego pustemu polu na planszy
         */
        Image obraz0 = new ImageIcon(getData("Pusto")).getImage();
        this.pusto = obraz0;
        /**
         * Odczyt obrazka odpowiadającego pionowej ściance na planszy
         */
        Image obraz02 = new ImageIcon(getData("Pion")).getImage();
        this.pion = obraz02;
        /**
         * Odczyt obrazka odpowiadającego poziomej ściance na planszy
         */
        Image obraz03 = new ImageIcon(getData("Poziom")).getImage();
        this.poziom = obraz03;
        /**
         * Odczyt obrazka odpowiadającego pacmanowi skierowanemu w prawo na planszy
         */
        Image obraz04 = new ImageIcon(getData("Pacman")).getImage();
        this.pacmanE = obraz04;
        /**
         * Odczyt obrazka odpowiadającego pacmanowi skierowanemu w lewo na planszy
         */
        Image obraz041 = new ImageIcon(getData("PacmanW")).getImage();
        this.pacmanW = obraz041;
        /**
         * Odczyt obrazka odpowiadającego pacmanowi skierowanemu w dół na planszy
         */
        Image obraz042 = new ImageIcon(getData("PacmanS")).getImage();
        this.pacmanS = obraz042;
        /**
         * Odczyt obrazka odpowiadającego pacmanowi skierowanemu w górę na planszy
         */
        Image obraz043 = new ImageIcon(getData("PacmanN")).getImage();
        this.pacmanN = obraz043;
        /**
         * Odczyt obrazka odpowiadającego duszkowi na planszy
         */
        Image obraz05 = new ImageIcon(getData("Duszek")).getImage();
        this.duszek = obraz05;
        /**
         * Odczyt obrazka odpowiadającego niebieskiemu duszkowi na planszy
         */
        Image obraz06 = new ImageIcon(getData("niebieskiDuszek")).getImage();
        this.nduszek = obraz06;

        this.szerokosc=szerokosc;
        this.wysokosc=wysokosc;
        this.punkty=punkty;

        addKeyListener(this);

    }

    /**
     * Ustawianie domyślnego wymiaru planszy
     * @return Domyślny wymiar
     */
    public Dimension getPreferredSize() {
        return new Dimension(szerokosc*32, wysokosc*32);
    }

    /**
     * Dodaje domyślny wymiar
     */
    public void addNotify() {
        super.addNotify();
        offscreen = createImage(getPreferredSize().width, getPreferredSize().height);
        offscreeng = offscreen.getGraphics();
    }

    /**
     * Odświeża wygląd planszy
     * @param g Chwilowa wyświetlona grafika
     */
    public void update(Graphics g) {
        paint(g);
    }

    /**
     * Rysuje obrazek
     * @param g Chwilowa wyświetlona grafika
     */
    public void paint(Graphics g) {
        g.drawImage(offscreen, 0, 0, this);

    }

    /**
     * Tworzenie obrazu bedacego plansza odczytana z pliku tekstowego
     */
    void zaladujplansze() {

        //SKALOWANIE
	    	/*
	    		Rectangle r = this.getBounds();
	    		int temp = r.width+r.height;
	    		Image pacman10=pacman.getScaledInstance((r.width)/szerokosc, (r.height)/wysokosc, Image.SCALE_DEFAULT);;
	    		Image pusto1=pusto.getScaledInstance((r.width)/szerokosc, (r.height)/wysokosc, Image.SCALE_DEFAULT);
	    		Image pion1=pion.getScaledInstance((r.width)/szerokosc, (r.height)/wysokosc, Image.SCALE_DEFAULT);
	    		Image poziom1=poziom.getScaledInstance((r.width)/szerokosc, (r.height)/wysokosc, Image.SCALE_DEFAULT);
	    		Image duszek1=duszek.getScaledInstance((r.width)/szerokosc, (r.height)/wysokosc, Image.SCALE_DEFAULT);
	    		Image nduszek1=nduszek.getScaledInstance((r.width)/szerokosc, (r.height)/wysokosc, Image.SCALE_DEFAULT);

				//Rectangle r = this.getBounds();

	    		while(pusto1.getHeight(null)==-1 || pion1.getHeight(null)==-1 || poziom1.getHeight(null)==-1 || pacman10.getHeight(null)==-1 || duszek1.getHeight(null)==-1 || nduszek1.getHeight(null)==-1)
	    		{

	    		}
	    		int h=(r.height)/wysokosc;
	    		int w=(r.width)/szerokosc;
	    		*/
        /**
         * Obrazek przedstawiający pacmana
         */
        Image pacman10=pacmanE;
        /**
         * Obrazek przedstawiający puste miejsce
         */
        Image pusto1=pusto;
        /**
         * Obrazek przedstawiający pionową ściankę
         */
        Image pion1=pion;
        /**
         * Obrazek przedstawiający poziomą ściankę
         */
        Image poziom1=poziom;
        /**
         * Obrazek przedstawiający duszka
         */
        Image duszek1=duszek;
        /**
         * Obrazek przedstawiający niebieskiego duszka
         */
        Image nduszek1=nduszek;
        while(pusto.getHeight(null)==-1 || pion.getHeight(null)==-1 || poziom.getHeight(null)==-1 || pacmanE.getHeight(null)==-1 || duszek.getHeight(null)==-1 || nduszek.getHeight(null)==-1)
        {

        }
        int w=32;
        int h =32;
        int i=0;
        int j=0;
        /**
         * Rysowanie planszy z tablicy odczytanej z pliku tekstowego
         */
        for(int k =0; k<szerokosc*wysokosc; ++k) {
            if(punkty[i][j]==' ')
            {
                offscreeng.drawImage(pusto1, w*i, h*j, null);
            }
            else if(punkty[i][j]=='|')
            {
                offscreeng.drawImage(pion1, w*i, h*j, null);

            }
            else if(punkty[i][j]=='-')
            {
                offscreeng.drawImage(poziom1, w*i, h*j, null);

            }
            else if(punkty[i][j]=='p')
            {
                offscreeng.drawImage(pacman10, w*i, h*j, null);
                pacX=i*32;
                pacY=j*32;

            }
            else if(punkty[i][j]=='d')
            {
                offscreeng.drawImage(duszek1, w*i, h*j, null);

            }
            else if(punkty[i][j]=='n')
            {
                offscreeng.drawImage(nduszek1, w*i, h*j, null);

            }
            i++;
            if(i==szerokosc)
            {
                i=0;
                j++;
            }
        }
    }


    /**
     * Uaktualnienie obrazu wyświetlaniego na ekranie
     */
    void updateOffscreen() {

            switch (kierunek) {
                case 'N':
                    pacY--;

                    offscreeng.drawImage(pacmanN, pacX, pacY, null);
                    break;
                case 'S':
                    kierunek = 'S';
                    offscreeng.drawImage(pacmanS, pacX, pacY, null);
                    pacY++;
                    break;
                case 'W':
                    pacX--;
                    offscreeng.drawImage(pacmanW, pacX, pacY, null);
                    break;
                case 'E':
                    pacX++;
                    offscreeng.drawImage(pacmanE, pacX, pacY, null);
                    break;
            }




    }

	    /*
	    void updateOffscreenSize(final int w, final int h) {
	    	if (kicker != null) {
	    		Thread k = kicker;
	    		kicker = null;
	    		k.interrupt();
	    	}
	    	offscreen = createImage(w, h);
	        offscreeng = offscreen.getGraphics();
	        (kicker = new Thread(this)).start();
	    }*/


    public Thread kicker = null;

    /**
     * Czekanie na ruch
     */
    void sleeep() {
        try {
            Thread.sleep(15);
        } catch (InterruptedException ie) {
        }
    }


    /**
     * Ruch pacmana
     */
    public void run() {
        while (kicker == Thread.currentThread()) {
            if(pacX==-1 && pacY==-1)
            {
                zaladujplansze();
            }
            else
            {
                updateOffscreen();
            }
            repaint();
            sleeep();
        }
    }

    /**
     * Nacisniecie przycisku na klawiaturze
     */
    @Override
    public void keyPressed(KeyEvent arg0) {
        displayInfo(arg0);
    }

    @Override
    public void keyReleased(KeyEvent arg0) {
        // TODO Auto-generated method stub

    }

    @Override
    public void keyTyped(KeyEvent arg0) {
        // TODO Auto-generated method stub

    }


    /**
     * Odczyt zdarzenia, przypisanie jego symbolicznej wartosci do zmiennej
     * @param e Zdarzenie
     */
    private void displayInfo(KeyEvent e){

        /**
         * Przypisanie wartości klucza
         */
        int keyCode = e.getKeyCode();


        switch( keyCode ) {
            case KeyEvent.VK_UP:
                wiersz--;
                if(wiersz <0){
                    wiersz=0;
                }
                kierunek='N';
                break;
            case KeyEvent.VK_DOWN:
                wiersz++;
                if(wiersz > 10){
                    wiersz=10;
                }
                kierunek='S';
                break;
            case KeyEvent.VK_LEFT:
                kolumna--;
                if(kolumna < 0){
                    kolumna = 0;
                }
                kierunek='W';
                break;
            case KeyEvent.VK_RIGHT :
                kolumna++;
                if(kolumna > 9){
                    kolumna = 9;
                }
                kierunek='E';
                break;
        }

    }

}