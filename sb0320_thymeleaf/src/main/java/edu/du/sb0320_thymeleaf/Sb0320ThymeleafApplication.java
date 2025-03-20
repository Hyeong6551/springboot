package edu.du.sb0320_thymeleaf;

import edu.du.sb0320_thymeleaf.entity.MyUser;
import edu.du.sb0320_thymeleaf.repository.MyUserRepo;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Sb0320ThymeleafApplication {

    @Autowired
    private MyUserRepo myUserRepo;

    public static void main(String[] args) {
        SpringApplication.run(Sb0320ThymeleafApplication.class, args);
    }

    @PostConstruct
    public void init() {
        MyUser myUser = MyUser.builder().email("abc@naver.com").age(22).name("hyeong").build();
        myUserRepo.save(myUser);
    }
}
