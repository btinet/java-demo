package model.repository;

import model.RepositoryManager;
import java.sql.SQLException;

public class SchoolSubjectRepository extends RepositoryManager {

    public SchoolSubjectRepository() throws SQLException, ClassNotFoundException {
        super("model.entity.SchoolSubject");
    }

    public void execute() throws SQLException
    {
        this.result =  this.statement.executeQuery(this.query);

        while(this.result.next()){

            StringBuilder str = new StringBuilder();
            int i = 1;
            int length = this.fields.toArray().length;
            for(Object field : this.fields.toArray()){

                str.append(this.result.getString(field.toString()));

                if(i < length)
                {
                    str.append(" ");
                }
                i++;
            }
            this.getResults().addElement(str.toString());
        }
    }

}
