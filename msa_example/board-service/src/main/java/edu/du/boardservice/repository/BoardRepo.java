package edu.du.boardservice.repository;

import edu.du.boardservice.entity.BoardEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BoardRepo extends JpaRepository<BoardEntity, Long> {
}
