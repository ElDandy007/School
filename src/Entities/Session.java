package Entities;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Time;

@Entity
@IdClass(SessionPK.class)
@Table( name = "session" )
public class Session implements Serializable {
    @Id
    @Column ( name = "id_teacher" )
    private int id_teacher;
    @Id
    @Column ( name = "code_subject" )
    private String code_subject;
    @Id
    @Column ( name = "code_group" )
    private String code_group;
    @Id
    @Column ( name = "week_day" )
    private String week_day;
    @Column ( name = "starts" )
    private Time starts;
    @Column ( name = "finishes" )
    private Time finishes;

    public Session(int id_teacher, String code_subject, String code_group, String week_day, Time starts, Time finishes) {
        this.id_teacher = id_teacher;
        this.code_subject = code_subject;
        this.code_group = code_group;
        this.week_day = week_day;
        this.starts = starts;
        this.finishes = finishes;
    }

    public Session(){
    }

    public int getTeacher() {
        return id_teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.id_teacher = id_teacher;
    }

    public String getSubject() {
        return code_subject;
    }

    public void setSubject(Subject subject) {
        this.code_subject = code_subject;
    }

    public String getGroups() {
        return code_group;
    }

    public void setGroups(Groups groups) {
        this.code_group = code_group;
    }

    public String getWeek_day() {
        return week_day;
    }

    public void setWeek_day(String week_day) {
        this.week_day = week_day;
    }

    public Time getStarts() {
        return starts;
    }

    public void setStarts(Time starts) {
        this.starts = starts;
    }

    public Time getFinishes() {
        return finishes;
    }

    public void setFinishes(Time finishes) {
        this.finishes = finishes;
    }

    @Override
    public String toString() {
        return "Session{" +
                "id_teacher=" + id_teacher +
                ", code_subject='" + code_subject + '\'' +
                ", code_group='" + code_group + '\'' +
                ", week_day='" + week_day + '\'' +
                ", starts=" + starts +
                ", finishes=" + finishes +
                '}';
    }

}

