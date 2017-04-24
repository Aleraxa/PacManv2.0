package pacman;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Okno główne gry
 */
public class Menu extends JFrame{
    private JPanel PacManPanel;
    private JTextArea pacManGameTextArea;
    private JButton Button1;
    private JButton Button2;
    private JButton Button3;
    private JButton Button4;


    /**
     * Konstruktor głównego menu
     */
    public Menu() {

        /**
         * Nadpisywanie parametru klasy nadrzędnej JFrame
         */
        super("PacMan");

        setContentPane(PacManPanel);

        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        setVisible(true);


        /**
         * Funkcja pierwszego przycisku
         */
        Button1.addActionListener(new ActionListener() {
            @Override
            /**
             * Metoda opisująca dzisałanie drugiego przycisku w menu
             * @param e2 Obiekt interakcji z użytkownikiem
             */
            public void actionPerformed(ActionEvent e2) {
                OknoNick nextWindowGame1 = new OknoNick();
                nextWindowGame1.setVisible(true);




               /* char[][] pkty = con.odczytplanszy();
                int[] param = con.odczytparametrow();
                nextWindowGame.launchFrame(param[1],param[0],pkty);*/
        }



        });

        /**
         * Funkcja drugiego przycisku
         */
        Button2.addActionListener(new ActionListener() {
            @Override
            /**
             * Metoda opisująca dzisałanie drugiego przycisku w menu
             * @param e Obiekt interakcji z użytkownikiem
             */
            public void actionPerformed(ActionEvent e) {
                OknoWyniki nextWindowScores = new OknoWyniki();
                nextWindowScores.setVisible(true);
               // LoadObjects loadObjects = new LoadObjects();


            }
        });

        /**
         * Funkcja trzeciego przycisku
         */
        Button3.addActionListener(new ActionListener() {
            @Override
            /** Metoda opisująca dzisałanie trzeciego przycisku w menu
             * @param e Obiekt interakcji z użytkownikiem
             */
            public void actionPerformed(ActionEvent e) {

            }
        });


        /**
         * Funkcja czwartego przycisku
         */
        Button4.addActionListener(new ActionListener() {
            @Override
            /**
             * Metoda opisująca dzisałanie czwartego przycisku w menu
             * @param e Obiekt interakcji z użytkownikiem
             */
            public void actionPerformed(ActionEvent e) {

                OknoZakoncz nextWindowEnd = new OknoZakoncz();
                nextWindowEnd.setVisible(true);
            }
        });

    }

}