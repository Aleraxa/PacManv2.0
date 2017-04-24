package pacman;

import javax.swing.*;


public class OknoWyniki extends JFrame {


    private JPanel panelWyniki;
    private JTextArea textArea1;

    public OknoWyniki() {

        super("Najlepsze wyniki");
        setContentPane(panelWyniki);


        pack();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        setVisible(true);

        LoadObjects loadObjects = new LoadObjects();




}}
