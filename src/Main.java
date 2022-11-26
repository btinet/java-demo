import product.BookProduct;
import product.CdProduct;

import javax.swing.*;
import java.awt.*;

public class Main {

    public static void main(String[] args)
    {
        BookProduct book1 = new BookProduct(
                "Weired Sisters",
                "Terry",
                "Prattchet",
                1989,
                995,
                495
        );

        CdProduct cd1 = new CdProduct(
                "Christmas Time",
                "Monkey",
                "Man",
                2017,
                1695,
                59
        );

        cd1.setAuthorName("Pentatonix");

        JFrame f = new JFrame("Medienbibliothek");
        JPanel p = new JPanel();
        p.setLayout( new java.awt.GridLayout( 3, 3 ) );
        // Das JLabel beschriften…
        JLabel jLabel1 = new javax.swing.JLabel();
        jLabel1.setText ( "1. ein JLabel" );
        // …und dem JPanel zuweisen
        p.add ( jLabel1 );
        f.add(p);
        String[] data = {book1.getSummaryLine(),cd1.getSummaryLine()};
        p.add(new JList<>(data));
        f.pack();
        f.setSize(800,600);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        JMenuBar menubar = new JMenuBar();
        JMenu menu = new JMenu("Menu");
        JMenuItem settings = new JMenuItem("Settings");
        settings.addActionListener(e -> System.out.println("Open Settings"));
        menu.add(settings);
        menubar.add(menu);
        f.setJMenuBar(menubar);
        f.setVisible(true);
    }

}
