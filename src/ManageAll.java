import java.io.IOException;
import java.nio.channels.SeekableByteChannel;
import java.util.List;
import java.util.Iterator;
import java.util.Scanner;

import Entities.*;
import org.hibernate.HibernateException;
import org.hibernate.Transaction;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class ManageAll {

    private static SessionFactory factory;

    private static EntityManagerFactory emf;

    public static Scanner scanner;


    public static void main(String[] args) throws IOException {
        try {
            factory = new Configuration().configure().buildSessionFactory();
            emf = new Configuration().configure().buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Failed to create sessionFactory object." + ex);
            throw new ExceptionInInitializerError(ex);
        }

        ManageAll MA = new ManageAll();
        FileAccessor fa;
        fa = new FileAccessor();
        fa.readDepartmentFile("department.txt");
        fa.readTeacherFile("teacher.txt");
        fa.readSubjectFile("subject.txt");
        fa.readGroupsFile("groups.txt");
        fa.readSessionFile("session.txt");

        // Deletes
        for (Session session: fa.llistaSession) {
            MA.deleteSession(new SessionPK(session.getTeacher(), session.getSubject(), session.getGroups(), session.getWeek_day()));
        }

        for (Teacher teacher : fa.llistaTeacher) {
            MA.deleteTeacher(teacher);
        }

        for (Department department : fa.llistaDepartment) {
            MA.deleteDepartment(department);
        }

        for (Subject subject : fa.llistaSubject) {
            MA.deleteSubject(subject);
        }

        for (Groups groups : fa.llistaGroup) {
            MA.deleteGroups(groups);
        }

        // Adds

        for (Department department: fa.llistaDepartment) {
            MA.addDepartment(department);
        }
        for (Teacher teacher: fa.llistaTeacher) {
            MA.addTeacher(teacher);
        }
        for (Groups groups: fa.llistaGroup) {
            MA.addGroups(groups);
        }
        for (Subject subject: fa.llistaSubject) {
            MA.addSubject(subject);
        }
        for (Session session: fa.llistaSession) {
            MA.addSession(session);
        }

        // Lists

        MA.listDepartment();

        MA.listTeacher();

        MA.listSubject();

        MA.listGroup();

        MA.listSession();


    }

    // Deletes

    public void deleteSession(SessionPK sessionPK) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Session session = (Session) em.find(Session.class, sessionPK);
        em.remove(session);
        em.getTransaction().commit();
        em.close();
    }

    public void deleteTeacher(Teacher teacher) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.remove(teacher);
        em.getTransaction().commit();
        em.close();
    }

    public void deleteDepartment(Department department) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.remove(department);
        em.getTransaction().commit();
        em.close();
    }

    public void deleteSubject(Subject subject) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.remove(subject);
        em.getTransaction().commit();
        em.close();
    }

    public void deleteGroups(Groups groups) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.remove(groups);
        em.getTransaction().commit();
        em.close();
    }

    // Adds

    public void addDepartment(Department department) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(department);
        em.getTransaction().commit();
        em.close();
    }

    public void addTeacher(Teacher teacher) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(teacher);
        em.getTransaction().commit();
        em.close();
    }

    public void addSubject(Subject subject) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(subject);
        em.getTransaction().commit();
        em.close();
    }

    public void addGroups(Groups groups) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(groups);
        em.getTransaction().commit();
        em.close();
    }

    public void addSession(Session session) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(session);
        em.getTransaction().commit();
        em.close();
    }

    // Lists

    public void listDepartment() {
        org.hibernate.Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            List departments = session.createQuery("FROM Department").list();

            for (Iterator iterator = departments.iterator(); iterator.hasNext();) {
                Department department = (Department) iterator.next();
                System.out.println(department.toString());
            }

            tx.commit();
        } catch (HibernateException e) {
            if (tx != null)
                tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public void listTeacher() {
        org.hibernate.Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            List teachers = session.createQuery("FROM Teacher").list();

            for (Iterator iterator = teachers.iterator(); iterator.hasNext();) {
                Teacher teacher = (Teacher) iterator.next();
                System.out.println(teacher.toString());
            }

            tx.commit();
        } catch (HibernateException e) {
            if (tx != null)
                tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public void listSubject() {
        org.hibernate.Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            List subjects = session.createQuery("FROM Subject").list();

            for (Iterator iterator = subjects.iterator(); iterator.hasNext();) {
                Subject subject = (Subject) iterator.next();
                System.out.println(subject.toString());
            }

            tx.commit();
        } catch (HibernateException e) {
            if (tx != null)
                tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public void listGroup() {
        org.hibernate.Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            List groups = session.createQuery("FROM Groups").list();

            for (Iterator iterator = groups.iterator(); iterator.hasNext();) {
                Groups groups1 = (Groups) iterator.next();
                System.out.println(groups1.toString());
            }

            tx.commit();
        } catch (HibernateException e) {
            if (tx != null)
                tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public void listSession() {
        org.hibernate.Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            List sessions = session.createQuery("FROM Session").list();

            for (Iterator iterator = sessions.iterator(); iterator.hasNext();) {
                Session session1 = (Session) iterator.next();
                System.out.println(session1.toString());
            }

            tx.commit();
        } catch (HibernateException e) {
            if (tx != null)
                tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

}
