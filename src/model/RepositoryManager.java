package model;

import java.sql.*;

public abstract class RepositoryManager extends AbstractModel {

    protected String table;

    public RepositoryManager(String entity) throws SQLException, ClassNotFoundException
    {
        super(entity);
        this.table = generateSnakeTailString(this.getEntity().getSimpleName());
    }

    public void find(int id) throws SQLException
    {
        this.createQuery("SELECT * FROM " + this.table + " WHERE id =" + id + " LIMIT 1");
        this.execute();
    }

    public void findAll() throws SQLException
    {
        this.createQuery("SELECT * FROM school_subject");
        this.execute();
    }

}
