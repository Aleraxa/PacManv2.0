package pacman; /**
 * Created by Alison on 2017-04-01.
 */

/*import javax.swing.*;
import javax.swing.plaf.basic.DefaultMenuLayout;
import java.awt.*;


public class Display {

    private JFrame frame;//tworzymy okienko
    private Canvas canvas;

    private JPanel panel;//tworzymy kontener z kontrolkami
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button4;

    private String title;
    private int width, height;

    public Display(String title, int width, int height) {
        this.title = title;
        this.width = width;
        this.height = height;

        createDisplay();

    }

    private void createDisplay() {
        frame = new JFrame(title);

        /*panel = new JPanel();
        panel.setLayout(new FlowLayout());
        frame.add(panel);

        button = new JButton("Gra");
        panel.add(button);*/
       /* addPanel();

        frame.setSize(width, height);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false); // uzytkownik podczas powekszania okna nie powoduje dopasowania do nie go gry
        frame.setLocationRelativeTo(null); //na srodku sie pojawi
        frame.setVisible(true);


        canvas = new Canvas();
        canvas.setPreferredSize(new Dimension(width, height));
        canvas.setMaximumSize(new Dimension(width, height));
        canvas.setMinimumSize(new Dimension(width, height));

        frame.add(canvas);
        frame.pack();


    }

    private void addPanel() {

        panel = new JPanel();
        panel.setLayout(new BoxLayout(panel,BoxLayout.PAGE_AXIS));
        frame.add(panel);

        button1 = new JButton("Gra");
        panel.add(button1);
        button1.setBounds(0, 0, 200, 200);

        button2 = new JButton("Wyniki");
        button2.setBounds(0, 200, 200, 200);
        button3 = new JButton("Informacje");
        button3.setBounds(0, 400, 200, 200);
        button4 = new JButton("Zakończ");
        button4.setBounds(0, 600, 200, 200);
        panel.add(button2);
        panel.add(button3);
        panel.add(button4);


    }
}








/*public class Panel {

    public void DisplayPanel(){
        String tekst = JOptionPane.showInputDialog("Wpisz imię");

        int a = JOptionPane.showConfirmDialog(null,"Wpisałeś: " +tekst, "Moje okienko", JOptionPane.YES_NO_CANCEL_OPTION);

        System.out.println(a);

        JOptionPane.showMessageDialog(null, "Informacja w oknie");

         System.exit(0);

    }

}*/


//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

/*
public class Display {
    private JFrame frame;
    private Canvas canvas;
    private JPanel panel;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    private String title;
    private int width;
    private int height;

    public Display(String title, int width, int height) {
        this.title = title;
        this.width = width;
        this.height = height;
        this.createDisplay();
    }

    private void createDisplay() {
        this.frame = new JFrame(this.title);
        this.addPanel();
        this.frame.setSize(this.width, this.height);
        this.frame.setDefaultCloseOperation(3);
        this.frame.setResizable(false);
        this.frame.setLocationRelativeTo((Component)null);
        this.frame.setVisible(true);
        this.canvas = new Canvas();
        this.canvas.setPreferredSize(new Dimension(this.width, this.height));
        this.canvas.setMaximumSize(new Dimension(this.width, this.height));
        this.canvas.setMinimumSize(new Dimension(this.width, this.height));
        this.frame.add(this.canvas);
        this.frame.pack();
    }

    private void addPanel() {
        this.panel = new JPanel();
        this.panel.setLayout(new BoxLayout(this.panel, 3));
        this.frame.add(this.panel);
        this.button1 = new JButton("Gra");
        this.panel.add(this.button1);
        this.button1.setBounds(0, 0, 200, 200);
        this.button2 = new JButton("Wyniki");
        this.button2.setBounds(0, 200, 200, 200);
        this.button3 = new JButton("Informacje");
        this.button3.setBounds(0, 400, 200, 200);
        this.button4 = new JButton("Zakończ");
        this.button4.setBounds(0, 600, 200, 200);
        this.panel.add(this.button2);
        this.panel.add(this.button3);
        this.panel.add(this.button4);
    }
}
*/

