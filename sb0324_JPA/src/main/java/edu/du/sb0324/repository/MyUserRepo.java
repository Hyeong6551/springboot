package edu.du.sb0324.repository;

import edu.du.sb0324.entity.MyUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface MyUserRepo extends JpaRepository<MyUser, Long> {

    List<MyUser> findByName(String name);

    @Query("select m from MyUser m where m.name = :name")
    List<MyUser> findUrName(@Param("name") String name);

    @Query(value = "select * from my_user where name = :name", nativeQuery = true)
    List<MyUser> findUrName2(@Param("name") String name);
}
