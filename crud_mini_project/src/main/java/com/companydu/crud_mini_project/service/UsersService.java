package com.companydu.crud_mini_project.service;

import com.companydu.crud_mini_project.entity.UsersDto;
import com.companydu.crud_mini_project.repository.UsersDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsersService {

    private final UsersDao usersDao;

    public UsersService(UsersDao usersDao) {
        this.usersDao = usersDao;
    }

    // 회원 가입
    public int insertUser(UsersDto users) {
        return usersDao.insertUser(users);
    }

    // 개별 회원 조회
    public UsersDto selectUser(String user_id) {
        return usersDao.selectUser(user_id);
    }

    // 정보 수정
    public int updateUser(UsersDto users) {
        return usersDao.updateUser(users);
    }
}
