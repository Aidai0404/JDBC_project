package com.peaksoft;


import com.peaksoft.dao.UserDaoHibernateImpl;
import com.peaksoft.service.UserServiceImpl;

public class App
{
    public static void main( String[] args )
    {
        // реализуйте алгоритм здесь
        UserServiceImpl userService = new UserServiceImpl();
//       userService.createUsersTable();
//        userService.dropUsersTable();
//          userService.saveUser("Dilnaz","Tolonbaeva", (byte) 16);
//        userService.removeUserById(2);
//       System.out.println(userService.getAllUsers());
//        userService.cleanUsersTable();
        UserDaoHibernateImpl userDaoHibernate = new UserDaoHibernateImpl();
       // userDaoHibernate.createUsersTable();
       // userDaoHibernate.dropUsersTable();
//        userDaoHibernate.saveUser("Aidai",
//                "Mamatbekova",
//                (byte)18);
        // userDaoHibernate.removeUserById(1);
        System.out.println( userDaoHibernate.getAllUsers());


    }
}
