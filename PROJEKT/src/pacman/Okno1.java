package pacman;

import javax.swing.*;
import java.awt.*;

/**
 *
 */
public class Okno1 {

    private JFrame okno1; //Tworzymy okno
    private Canvas canvas;

    private JPanel panel; //Tworzymy kontener z konrolkami
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button4;

    private String tytul;
    private int szerokosc, wysokosc;

    public Okno1(String tytul, int szerokosc, int wysokosc) {
        this.tytul = tytul;
        this.szerokosc = szerokosc;
        this.wysokosc = wysokosc;

        this.createDisplay();
    }

    private void createDisplay() {
        this.okno1 = new JFrame(this.tytul);
        this.addPanel();
        this.okno1.setSize(this.szerokosc, this.wysokosc);
        this.okno1.setDefaultCloseOperation(3);
        this.okno1.setResizable(true);
        this.okno1.setLocationRelativeTo(null);
        this.okno1.setVisible(true);
        this.canvas = new Canvas();
        this.canvas.setPreferredSize(new Dimension(this.szerokosc, this.wysokosc));
        this.canvas.setMaximumSize(new Dimension(this.szerokosc, this.wysokosc));
        this.canvas.setMinimumSize(new Dimension(this.szerokosc, this.wysokosc));
        this.okno1.add(this.canvas);
        this.okno1.pack();

        this.addPanel();

    }

    private void addPanel() {
        this.panel = new JPanel();
        this.panel.setLayout(new BoxLayout(this.panel, 3));
        this.okno1.add(this.panel);
        this.button1 = new JButton("Gra");
        this.panel.add(this.button1);
        this.button1.setBounds(0, 0, 200, 200);
        this.button2 = new JButton("Wyniki");
        this.panel.add(this.button2);
        this.button2.setBounds(0, 200, 200, 200);
        this.button3 = new JButton("Informacje");
        this.panel.add(this.button3);
        this.button3.setBounds(0, 400, 200, 200);
        this.button4 = new JButton("Zakończ");
        this.panel.add(this.button4);
        this.button4.setBounds(0, 600, 200, 200);


    }
}