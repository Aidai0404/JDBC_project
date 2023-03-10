package com.peaksoft.dao;


import com.peaksoft.model.User;

import java.util.List;

public interface UserDao {

    void createUsersTable();

    void dropUsersTable();

    void saveUser(String name, String lastName, Byte age);

    void removeUserById(long id);

    List<User> getAllUsers();

    void cleanUsersTable();
}
