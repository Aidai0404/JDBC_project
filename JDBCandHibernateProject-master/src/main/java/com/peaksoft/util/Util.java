package com.peaksoft.util;

import com.peaksoft.model.User;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static java.lang.System.setProperty;

public class Util {
    // реализуйте настройку соеденения с БД
    private static String URL="jdbc:postgresql://localhost:5432/postgres";
    private static String USERNAME="postgres";
    private static String PASSWORD="aidai2004";
    public static Connection connection(){
        Connection conn=null;
        try{
            conn= DriverManager.getConnection(URL,USERNAME,PASSWORD);
            System.out.println("Successfully connected ");
        }catch (SQLException e){
            e.printStackTrace();
        }
        return conn;
    }

    private final static SessionFactory sessionFactory=buildSessionFactory();

 public static SessionFactory buildSessionFactory() {
        try {
            return new Configuration()
                    .addAnnotatedClass(User.class)
                    .setProperty("hibernate.connection.driver_class", "org.postgresql.Driver")
                    .setProperty("hibernate.connection.url", "jdbc:postgresql://localhost:5432/postgres")
                    .setProperty("hibernate.connection.username", "postgres")
                    .setProperty("hibernate.connection.password", "aidai2004")
                    .setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect")
                    .setProperty("hibernate.hbm2ddl.auto", "update")
                    .setProperty("hibernate.show_sql", "true")
                    .buildSessionFactory();
        }catch (Throwable e){
            throw e;
        }
    }
        public static SessionFactory getSessionFactory() {
            return sessionFactory;
        }
    }

