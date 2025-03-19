package com.companydu.sb0313;

import com.companydu.sb0313.entity.Users;
import com.companydu.sb0313.repository.UserDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Sb0313ApplicationTests {

	@Autowired
	private UserDao userDao;

	@Test
	void contextLoads() {
		System.out.println("사용자 수 : "+userDao.countUser());
	}

	@Test
	void selectAllUser() {
		for(Users user : userDao.getAllUsers()){
			System.out.println(user);
		}
	}

	@Test
	void insertUser() {
		Users users = new Users();
		users.setUsername("일순신");
		users.setEmail("zhangsan@qq.com");
		users.setPassword("990099");
		userDao.addUser(users);
	}
}
