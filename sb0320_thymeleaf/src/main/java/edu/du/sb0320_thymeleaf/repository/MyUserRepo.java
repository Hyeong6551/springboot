package edu.du.sb0320_thymeleaf.repository;

import edu.du.sb0320_thymeleaf.entity.MyUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MyUserRepo extends JpaRepository<MyUser, Integer> {
    MyUser findByName(String name);
    List<MyUser> findMyuserByOrderByNameAsc();
}
