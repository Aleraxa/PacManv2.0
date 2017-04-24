package pacman;

import Nazwy.Nazwy;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alison on 2017-04-23.
 */

/**
 * Okienko z wpisywaniem nazwy przez gracza
 */
public class OknoNick extends JFrame{
    /**
     * Panel okienka
     */
    private JPanel OknoNcikPanel;
    /**
     * Pole instruujące do wpisania nazwy
     */
    private JTextArea wpiszSwójNickTextArea;
    /**
     * Pole do wpisywania nazwy
     */
    private JFormattedTextField nickFormattedTextField;
    /**
     * Przycisk "Wstecz"
     */
    private JButton wsteczButton;
    /**
     *  Przycisk zapisujący nazwę i przechodzący do gry
     */
    private JButton zapiszIGrajButton;
    /**
     * Lista składająca się z nazw graczy
     */
    private final List<Nazwy> nazwyGraczy = new ArrayList<Nazwy>();


    public OknoNick() {

        /**
         * Nadpisywanie parametru klasy nadrzędnej JFrame
         */
        super("Nick");

        setContentPane(OknoNcikPanel);

        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

/**
 * Ustawienie widoczności okienka
 */
        setVisible(true);


        nickFormattedTextField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        nickFormattedTextField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);
            }
        });
        zapiszIGrajButton.addActionListener(new ActionListener() {
            @Override
            /**
             * Ustawienie funkcji przycisku
             */
            public void actionPerformed(ActionEvent e) {
                nazwyGraczy.add(new Nazwy(nickFormattedTextField.getText()));

                /**
                 * Wyświetlenie komunikatu
                 */
                JOptionPane.showMessageDialog(null,"Podana nazwa: "+ nazwyGraczy.get(0).pobierzNazwy(), "Nazwa #1", JOptionPane.PLAIN_MESSAGE);

                /*Plansza nextWindowGamew = new Plansza();
                nextWindowGamew.setVisible(true);
                Odczytplanszy con = new Odczytplanszy();*/


            }
        });
        /**
         * Ustawienie funckji prycisku
         */
        wsteczButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });
    }
}
