package model;

import javax.swing.*;
import java.lang.reflect.Field;
import java.sql.*;
import java.util.StringJoiner;

abstract public class AbstractModel {

    Connection connection;

    protected Statement statement;

    protected ResultSet result;

    DefaultListModel<String> results;

    protected String query;
    String url = "jdbc:mysql://it.treptowkolleg.de:3306/tk01";
    String user = "tk01";
    String pass = "tk01";

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

    /**
     * getModifiers() => 0 = protected; 1 = public; 2 = private
     */

    public void execute() throws SQLException
    {
        this.result =  this.statement.executeQuery(this.query);

        while(this.result.next()){

            StringBuilder str = new StringBuilder();
            for(Field field : this.getEntity().getDeclaredFields()){
                System.out.println("Feld: " + field.getName() + " ist " + field.getModifiers());
                str.append(this.result.getString(field.getName()));
            }
            this.getResults().addElement(str.toString());

        }
    }

    public DefaultListModel<String> getResults()
    {
        return this.results;
    }

    protected String generateSnakeTailString(String value)
    {
        String string = String.join("_", value.split("(?=\\p{Upper})")).toLowerCase();
        System.out.println(string);
        return string;
    }

    protected String generateStringFromDefaultList(DefaultListModel<String> list)
    {

        String string = String.join(", ", list.toString()).toLowerCase().replaceAll("\\[|\\]","");;
        System.out.println(string);
        return string;
    }

}
