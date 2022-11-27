package model;

import model.entity.AbstractEntity;

import javax.swing.*;
import java.lang.reflect.InvocationTargetException;
import java.sql.*;

public abstract class RepositoryManager {

    Connection connection;

    protected Statement statement;

    protected ResultSet result;

    protected String query;
    String url = "jdbc:mysql://localhost:3306/tk_ceberus";
    String user = "root";
    String pass = "";

    AbstractEntity entity;

    DefaultListModel<String> results;

    public RepositoryManager(AbstractEntity entity) throws SQLException {
        this.entity = entity;
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

    public void execute() throws SQLException {
        try {
            this.result =  this.statement.executeQuery(this.query);

            while(this.result.next()){
                this.results.addElement(this.result.getString(1));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public DefaultListModel<String> getResults()
    {
        return this.results;
    }

}
