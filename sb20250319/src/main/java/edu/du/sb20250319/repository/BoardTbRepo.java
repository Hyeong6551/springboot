package edu.du.sb20250319.repository;

import edu.du.sb20250319.entity.BoardTb;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface BoardTbRepo extends JpaRepository<BoardTb, Integer> {
    BoardTb findAllByNo(int no);

    void deleteAllByNo(int no);
}
