package com.companydu.sb0313.service;

import com.companydu.sb0313.entity.Users;
import com.companydu.sb0313.repository.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserDao userDao;

    @Autowired
    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }

    public int countUsers() {
        return userDao.countUser();
    }

    public int addUser(Users user) {
        return userDao.addUser(user);
    }

    public Users getUserById(Long id) {
        return userDao.getUserById(id);
    }

    public List<Users> getAllUsers() {
        return userDao.getAllUsers();
    }

    public int updateUser(Users user) {
        return userDao.updateUser(user);
    }
}
