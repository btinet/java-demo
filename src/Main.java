
import model.RepositoryManager;
import model.entity.SchoolSubject;
import model.repository.SchoolSubjectRepository;
import product.BookProduct;
import product.CdProduct;

import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;


public class Main {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        JFrame f = new JFrame("Medienbibliothek");
        f.setLayout(new GridLayout(1,1));
        f.add(Box.createRigidArea(new Dimension(0,5)));
        f.setSize(800,600);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        DefaultListModel<String> liste = new DefaultListModel<>();
        liste.addElement("id");
        liste.addElement("label");
        SchoolSubjectRepository repository = new SchoolSubjectRepository();
        repository.setFields(liste);
        repository.findAll();

        JLabel label = new JLabel("Medienübersicht");
        JList<String> list = new JList<>(repository.getResults());

        f.add(list);

        f.setVisible(true);
    }

}
