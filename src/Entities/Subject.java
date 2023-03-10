package Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table( name = "subject" )
public class Subject implements Serializable {
    @Id
    @Column( name = "code_subject" )
    private String code_subject;
    @Column( name = "description" )
    private String description;

    public Subject(String code_subject, String description) {
        this.code_subject = code_subject;
        this.description = description;
    }

    public Subject(){
    }

    public String getCode_subject() {
        return code_subject;
    }

    public void setCode_subject(String code_subject) {
        this.code_subject = code_subject;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Subject{" +
                "code_subject='" + code_subject + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}

