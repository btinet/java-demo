package model;

import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RepositoryManager {

    Connection connection;

    Statement statement;

    ResultSet result;

    String query;
    String url = "jdbc:mysql://localhost:3306/tk_ceberus";
    String user = "root";
    String pass = "";

    DefaultListModel<String> results;

    public RepositoryManager() throws SQLException {

            this.connection = DriverManager.getConnection(url, user, pass);
            System.out.println("Verbindung erfolgreich hergestellt");
            this.results = new DefaultListModel<>();

    }

    public void createQuery(String query)
    {
        this.query = query;
    }

    public void prepareStatement(String statement)
    {
        try {
            this.statement = this.connection.prepareStatement(statement);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void createStatement()
    {
        try {
           this.statement = this.connection.createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void execute()
    {
        try {
            this.result =  this.statement.executeQuery(this.query);

            while(this.result.next()){
                this.results.addElement(this.result.getString(2));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public DefaultListModel<String> getResults()
    {
        return this.results;
    }

    public void fetch() throws SQLException {


    }

}
