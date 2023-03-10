package Entities;

import jdk.jfr.Enabled;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table( name = "department" )
public class Department implements Serializable {
    @Id
    @Column ( name = "code_department" )
    private int code_department;
    @Column ( name = "name" )
    private String name;
    @Column ( name = "phone" )
    private String phone;


    public Department(int code_department, String name, String phone) {
        super();
        this.code_department = code_department;
        this.name = name;
        this.phone = phone;
    }

    public Department() {
    }

    public int getCode_department() {
        return code_department;
    }

    public void setCode_department(int code_department) {
        this.code_department = code_department;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }


    @Override
    public String toString() {
        return "Department{" +
                "code_department=" + code_department +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}

