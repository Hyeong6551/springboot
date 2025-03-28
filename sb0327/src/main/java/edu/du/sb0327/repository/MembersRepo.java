package edu.du.sb0327.repository;

import edu.du.sb0327.entity.Members;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MembersRepo extends JpaRepository<Members, Long> {
    Optional<Members> findById(long id);
}
