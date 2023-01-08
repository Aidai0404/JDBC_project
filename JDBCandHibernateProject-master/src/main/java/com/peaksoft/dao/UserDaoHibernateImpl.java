package com.peaksoft.dao;



import com.peaksoft.model.User;
import com.peaksoft.util.Util;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

public class UserDaoHibernateImpl implements UserDao {

    public UserDaoHibernateImpl() {

    }

    @Override
    public void createUsersTable() {
      String SQL = "CREATE TABLE IF NOT EXISTS users(" +
              "id BIGSERIAL PRIMARY KEY," +
              "name VARCHAR(50)," +
              "last_name VARCHAR(50)," +
              "age INT2);";
        Session session = Util.buildSessionFactory().openSession();
      try{
          session.beginTransaction();
          session.createSQLQuery(SQL).executeUpdate();
          session.getTransaction().commit();
      }catch (HibernateException h){
          h.printStackTrace();
      }finally {
          session.close();
      }

    }

    @Override
    public void dropUsersTable() {
        String SQL = "DROP TABLE IF EXISTS users;";
        Session session = Util.buildSessionFactory().openSession();
        try{
            session.beginTransaction();
            session.createSQLQuery(SQL).executeUpdate();
            session.getTransaction().commit();
        }catch (HibernateException h){
            h.printStackTrace();
        }finally {
            session.close();
        }
    }

    @Override
    public void saveUser(String name, String lastName, Byte age) {
        Session session = Util.buildSessionFactory().openSession();
        User user=new User();
        user.setName(name);
        user.setLastName(lastName);
        user.setAge(age);
        try{
            session.beginTransaction();
            session.save(user);
            session.getTransaction().commit();
        }catch (HibernateException h){
            h.printStackTrace();
        }finally {
            session.close();
        }

    }

    @Override
    public void removeUserById(long id) {
        Session session = Util.buildSessionFactory().openSession();
        User user = new User();
        user.setId(id);
        try{
            session.beginTransaction();
            session.delete(user);
            session.getTransaction().commit();
        }catch (HibernateException h){
            h.printStackTrace();
        }finally {
            session.close();
        }

    }

    @Override
    public List<User> getAllUsers() {
        Session session = Util.getSessionFactory().openSession();
        session.beginTransaction();
        List<User> users = (List<User>) session.createQuery("FROM User ").getResultList();
        session.getTransaction().commit();
        session.close();
        System.out.println("Successfully sorted");
        return users;
    }


    @Override
    public void cleanUsersTable() {
        Session session = Util.getSessionFactory().openSession();
        session.beginTransaction();
        Query query = session.createQuery("DELETE FROM User ");
        query.executeUpdate();
        session.getTransaction().commit();
        session.close();
        System.out.println("Successfully deleted all datas in Employee");
    }
}

