package model;

import javax.swing.*;
import java.sql.*;
import java.util.StringJoiner;

abstract public class AbstractModel {

    Connection connection;

    protected Statement statement;

    protected ResultSet result;

    DefaultListModel<String> results;

    protected String query;
    String url = "jdbc:mysql://localhost:3306/tk_ceberus";
    String user = "root";
    String pass = "";

    protected Class<?> entity;

    public AbstractModel(String entity) throws ClassNotFoundException, SQLException {
        this.entity = Class.forName(entity);
        this.connection = DriverManager.getConnection(url, user, pass);
        System.out.println("Verbindung erfolgreich hergestellt");
        this.results = new DefaultListModel<>();
        this.createStatement();
    }

    public Class<?> getEntity() {
        return entity;
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

    protected String generateSnakeTailString(String value)
    {
        String[] array = value.split("(?=\\p{Upper})");
        String string = String.join("_", array).toLowerCase();
        System.out.println(string);
        return string;
    }

}
