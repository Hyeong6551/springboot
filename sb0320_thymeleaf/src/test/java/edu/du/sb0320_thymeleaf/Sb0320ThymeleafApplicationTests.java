package edu.du.sb0320_thymeleaf;

import edu.du.sb0320_thymeleaf.entity.MyUser;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.PersistenceUnit;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

@SpringBootTest
class Sb0320ThymeleafApplicationTests {

    @PersistenceUnit
    private EntityManagerFactory emf;

//    @Test
//    void contextLoads() {
//        EntityManager em1 = emf.createEntityManager();
//        em1.getTransaction().begin();
//        MyUser myUser = MyUser.builder()
//                .name("John")
//                .age(50)
//                .email("john@example.com")
//                .build();
//        em1.persist(myUser);    // 영속성
//        em1.getTransaction().commit();
//        emf.close();
//    }

    @Test
    void test() {
        EntityManager em1 = emf.createEntityManager();
        em1.getTransaction().begin();

        MyUser myUser = MyUser.builder()
                .id(2)
                .name("Jason")
                .age(33)
                .createdAt(LocalDateTime.now())
                .email("Jason@example.com")
                .build();
        em1.merge(myUser);  // 업데이트

//        MyUser myUser = em1.find(MyUser.class, 3);
//        System.out.println(myUser);

        em1.getTransaction().commit();
        emf.close();
    }
}
