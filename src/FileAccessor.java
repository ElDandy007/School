import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.StringTokenizer;

import Entities.*;

public class FileAccessor {

    ArrayList<Department> llistaDepartment = new ArrayList();
    ArrayList<Groups> llistaGroup = new ArrayList();
    ArrayList<Subject> llistaSubject = new ArrayList();
    ArrayList<Teacher> llistaTeacher = new ArrayList();
    ArrayList<Session> llistaSession = new ArrayList();


    public FileAccessor() {
    }

    public void readDepartmentFile(String filename) throws IOException {
        int code_department;
        String name, phone;

        BufferedReader br = new BufferedReader(new FileReader(filename));
        String linea = "";
        while ((linea = br.readLine()) != null) {
            StringTokenizer str = new StringTokenizer(linea, ",");
            code_department = Integer.parseInt(str.nextToken());
            name = str.nextToken();
            phone = str.nextToken();
            llistaDepartment.add(new Department(code_department, name, phone));

        }
        br.close();

    }

    public void readGroupsFile(String filename) throws IOException {
        String code_group, curriculum, course;

        BufferedReader br = new BufferedReader(new FileReader("groups.txt"));
        String linea = "";
        while ((linea = br.readLine()) != null) {
            StringTokenizer str = new StringTokenizer(linea, ",");
            code_group = str.nextToken();
            curriculum = str.nextToken();
            course = str.nextToken();
            llistaGroup.add(new Groups(code_group, curriculum, course));

        }
        br.close();

    }

    public void readSubjectFile(String filename) throws IOException {
        String code_subject, description;

        BufferedReader br = new BufferedReader(new FileReader("subject.txt"));
        String linea = "";
        while ((linea = br.readLine()) != null) {
            StringTokenizer str = new StringTokenizer(linea, ",");
            code_subject = str.nextToken();
            description = str.nextToken();
            llistaSubject.add(new Subject(code_subject, description));

        }
        br.close();


    }

    public void readTeacherFile(String filename) throws IOException {
        int id_teacher, department;
        String firstname, lastname, email;

        BufferedReader br = new BufferedReader(new FileReader("teacher.txt"));
        String linea = "";
        while ((linea = br.readLine()) != null) {
            StringTokenizer str = new StringTokenizer(linea, ",");
            id_teacher = Integer.parseInt(str.nextToken());
            firstname = str.nextToken();
            lastname = str.nextToken();
            email = str.nextToken();
            department = Integer.parseInt(str.nextToken());
            for (Department department1 : llistaDepartment) {
                if (department1.getCode_department() == department) {
                    llistaTeacher.add(new Teacher(id_teacher, firstname, lastname, email, department1.getCode_department()));
                }
            }

        }
        br.close();

    }

    public void readSessionFile(String filename) throws IOException {
        int teacher;
        String subject, groups, week_day;
        Time starts, finishes;

        BufferedReader br = new BufferedReader(new FileReader("session.txt"));
        String linea = "";
        while ((linea = br.readLine()) != null) {
            StringTokenizer str = new StringTokenizer(linea, ",");
            teacher = Integer.parseInt(str.nextToken());
            subject = str.nextToken();
            groups = str.nextToken();
            week_day = str.nextToken();
            starts = Time.valueOf(str.nextToken());
            finishes = Time.valueOf(str.nextToken());
            llistaSession.add(new Session(teacher, subject, groups, week_day, starts, finishes));
        }

        br.close();


    }
}
