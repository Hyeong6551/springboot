package com.companydu.sb_0319.repository;

import com.companydu.sb_0319.entity.Memo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemoRepository extends JpaRepository<Memo, Long> { // <entity 이름, type>

}
