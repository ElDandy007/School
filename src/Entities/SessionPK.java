package Entities;
import java.io.Serializable;

public class SessionPK implements Serializable {
    private int id_teacher;
    private String code_subject;
    private String code_group;
    private String week_day;
    public SessionPK(int id_teacher, String code_subject, String code_group, String week_day) {
        this.id_teacher = id_teacher;
        this.code_subject = code_subject;
        this.code_group = code_group;
        this.week_day = week_day;
    }
    public SessionPK() {
    }
    public boolean equals(Object object) {
        if (object instanceof SessionPK) {
            SessionPK pk = (SessionPK)object;
            return id_teacher == pk.id_teacher && code_subject == pk.code_subject && code_group == pk.code_group && week_day == pk.week_day;
        } else {
            return false;
        }
    }
    public int hashCode() {
        return (int)((id_teacher + code_subject + code_group + week_day).hashCode());
    }
}