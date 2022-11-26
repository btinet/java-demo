import model.RepositoryManager;
import product.BookProduct;
import product.CdProduct;

import javax.smartcardio.CardChannel;
import javax.swing.*;
import javax.swing.plaf.ScrollPaneUI;
import java.awt.*;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws SQLException {
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

        RepositoryManager rm = new RepositoryManager();
        rm.createStatement();
        rm.createQuery("SELECT * FROM school_subject ORDER BY label");
        rm.execute();

        cd1.setAuthorName("Pentatonix");

        JFrame f = new JFrame("Medienbibliothek");
        JPanel p = new JPanel();
        JPanel top = new JPanel();
        JPanel main = new JPanel();
        JPanel bottom = new JPanel();

        JPanel card1 = new JPanel();
        JPanel card2 = new JPanel();
        card2.setLayout(new BoxLayout(card2, BoxLayout.PAGE_AXIS));
        card1.setLayout(new FlowLayout());
        card1.add(new JButton("Button 1"));
        card1.add(new JButton("Button 2"));
        card1.add(new JButton("Button 3"));

        JList<String> list = new JList<>(rm.getResults());
        list.setBackground(new Color(164,164,190));

        JScrollPane listScroller = new JScrollPane(list);
        JScrollPane listScroller2 = new JScrollPane(list);




        JLabel label = new JLabel("Medienübersicht");
        card2.add(label);
        card2.add(Box.createRigidArea(new Dimension(0,5)));
        card1.add(Box.createRigidArea(new Dimension(0,5)));
        card2.add(listScroller2);
        card2.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        card1.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));


        card2.setBackground(new Color(230,230,245));
        f.setLayout( new java.awt.GridLayout( 3, 0 ) );
        top.setLayout(new CardLayout(1,1));
        main.setLayout(new GridLayout(0,1));

        // Das JLabel beschriften…
        JLabel jLabel1 = new javax.swing.JLabel();
        jLabel1.setText ( "1. ein JLabel" );
        main.add(card1);
        top.add(card2);
        // …und dem JPanel zuweisen
        f.add(top);
        top.setSize(800,100);
        f.add(main);
        main.setSize(800,400);
        f.add(bottom);
        bottom.setSize(800,100);


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
