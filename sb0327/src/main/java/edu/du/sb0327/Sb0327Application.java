package edu.du.sb0327;

import edu.du.sb0327.entity.Members;
import edu.du.sb0327.repository.MembersRepo;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Sb0327Application {

    @Autowired
    private MembersRepo mrepo;

    public static void main(String[] args) {
        SpringApplication.run(Sb0327Application.class, args);
    }

//    @PostConstruct
//    public void init() {
//        for (int i = 0; i < 10; i++) {
//            Members members = Members.builder()
//                    .name("hong" + i)
//                    .email("hong"+i+"@gmail.com")
//                    .build();
//            mrepo.save(members);
//        }
//    }

}
