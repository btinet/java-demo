package model;

import javax.swing.*;
import java.sql.*;

public abstract class RepositoryManager extends AbstractModel {

    protected String table;
    protected DefaultListModel<String> fields;

    public RepositoryManager(String entity) throws SQLException, ClassNotFoundException
    {
        super(entity);
        this.table = generateSnakeTailString(this.getEntity().getSimpleName());
    }

    public void setFields(DefaultListModel<String> fields){
        this.fields = fields;
    }

    public void addField(String field){
        this.fields.addElement(field);
    }

    public void find(int id) throws SQLException
    {
        this.createQuery("SELECT " + this.fields + " FROM " + this.table + " WHERE id =" + id + " LIMIT 1");
        this.execute();
    }

    public void findAll() throws SQLException
    {
        this.createQuery("SELECT * FROM " + this.table + "");
        this.execute();
    }

}
