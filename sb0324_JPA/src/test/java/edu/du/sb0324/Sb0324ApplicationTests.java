package edu.du.sb0324;

import edu.du.sb0324.entity.MyUser;
import edu.du.sb0324.repository.MyUserRepo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.PersistenceUnit;
import jakarta.persistence.TypedQuery;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.List;

@SpringBootTest
class Sb0324ApplicationTests {

    @Autowired
    private MyUserRepo myUserRepo;

    @PersistenceUnit
    private EntityManagerFactory emf;

    @Test
    void insertUser() {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        MyUser user = MyUser.builder().createdAt(LocalDateTime.now()).name("Jack").emali("Jack@gmail.com").build();

        em.persist(user);
        user.setName("Jackson");

        em.getTransaction().commit();
        em.close();
    }

    @Test
    void findUser() {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        MyUser user = em.find(MyUser.class, 1);
        System.out.println(user);
        user.setName("Jimmy");

        em.getTransaction().commit();
        em.close();
    }

    @Test
    void mergeUser() {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        MyUser user = em.find(MyUser.class, 2);
        user.setId(2L);
        user.setEmali("James@gmail.com");
        user.setName("Jack");
        user.setCreatedAt(LocalDateTime.now());
        em.merge(user);

        em.getTransaction().commit();
        em.close();
    }

    @Test
    void createQueryUser() {
        EntityManager em = emf.createEntityManager();
        
        // JPQL 작성
        TypedQuery<MyUser> query = em.createQuery("SELECT u FROM MyUser u", MyUser.class);
        List<MyUser> users = query.getResultList();
        for(MyUser user : users) {
            System.out.println(user);
        }

        em.close();
    }

    @Test
    void createQueryUser2() {
        EntityManager em = emf.createEntityManager();

        // JPQL 작성
        TypedQuery<MyUser> query = em.createQuery("SELECT u FROM MyUser u WHERE u.name = :name", MyUser.class);
        
        // name에서 Jimmy라는 값을 바인딩. :name은 name이다. 
        query.setParameter("name","Jack");
        
        // 결과 가져오기
        List<MyUser> users = query.getResultList();
        for(MyUser user : users) {
            System.out.println(user);
        }

        em.close();
    }

    @Test
    void findByName() {
        System.out.println(myUserRepo.findUrName("Jimmy"));
        System.out.println(myUserRepo.findUrName2("Jimmy"));
    }
}
