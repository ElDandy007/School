package Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table( name = "teacher" )
public class Teacher implements Serializable {
    @Id
    @Column ( name = "id_teacher" )
    private int id_teacher;
    @Column ( name = "firstname" )
    private String firstname;
    @Column ( name = "lastname" )
    private String lastname;
    @Column ( name = "email" )
    private String email;
    @Column ( name = "code_department" )
    private int code_department;

    public Teacher(int id_teacher, String firstname, String lastname, String email, int code_department) {
        this.id_teacher = id_teacher;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.code_department = code_department;
    }

    public Teacher(){
    }
    public int getId_teacher() {
        return id_teacher;
    }

    public void setId_teacher(int id_teacher) {
        this.id_teacher = id_teacher;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getDepartment() {
        return code_department;
    }

    public void setDepartment(int department) {
        this.code_department = department;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "id_teacher=" + id_teacher +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", email='" + email + '\'' +
                ", department=" + code_department +
                '}';
    }
}

