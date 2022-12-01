
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

        // 1.  Repository initialisieren
        SchoolSubjectRepository repository = new SchoolSubjectRepository();

        // 2a. Spaltenliste erstellen
        DefaultListModel<String> liste = new DefaultListModel<>();
        // 2b. Spalten definieren
        liste.addElement("id");
        liste.addElement("label");
        liste.addElement("abbr");
        // 2c. Spaltenliste zur Abfrage hinzufügen
        repository.setFields(liste);

        // 3.  Sortierung hinzufügen
        repository.addOrderStatement("label","asc");

        // 4. SQL-Abfrage starten
        repository.findAll();   // Alle Datensätze
        // repository.find(1);  // Ein Datensatz mit id = 1


        JLabel label = new JLabel("Medienübersicht");
        JList<String> list = new JList<>(repository.getResults());

        f.add(list);

        f.setVisible(true);
    }

}
