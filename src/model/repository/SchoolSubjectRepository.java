package model.repository;

import model.RepositoryManager;
import model.entity.SchoolSubject;

import java.sql.SQLException;

public class SchoolSubjectRepository extends RepositoryManager {

    public SchoolSubjectRepository() throws SQLException
    {
        super(new SchoolSubject());
        this.createStatement();
    }

    public void find(int id) throws SQLException
    {
        this.createQuery("SELECT * FROM school_subject WHERE id =" + id + " LIMIT 1");
        this.execute();
    }

    public void findAll() throws SQLException
    {
        this.createQuery("SELECT * FROM school_subject");
        this.execute();
    }

    public void execute() throws SQLException
    {
        this.result =  this.statement.executeQuery(this.query);

        while(this.result.next()){
            this.getResults().addElement(this.result.getString(2));
            System.out.println(this.result.getString(2));
        }
    }

}
