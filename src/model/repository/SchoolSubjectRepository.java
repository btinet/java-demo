package model.repository;

import model.RepositoryManager;
import model.entity.SchoolSubject;

import java.lang.reflect.Field;
import java.sql.SQLException;

public class SchoolSubjectRepository extends RepositoryManager {

    public SchoolSubjectRepository() throws SQLException, ClassNotFoundException {
        super("model.entity.SchoolSubject");
    }



    public void execute() throws SQLException
    {
        this.result =  this.statement.executeQuery(this.query);

        while(this.result.next()){

            for(Field field : this.getEntity().getDeclaredFields()){
                System.out.println("Feld: " + field.getName() + " ist " + field.getModifiers());
                this.getResults().addElement(this.result.getString(field.getName()));
                System.out.println(this.result.getString(field.getName()));
            }

        }
    }

}
