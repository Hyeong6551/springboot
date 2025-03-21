package edu.du.sb20250319.service;

import edu.du.sb20250319.entity.UserTb;
import edu.du.sb20250319.repository.UserTbRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ListService {

    private final UserTbRepo userTbRepo;

    public ListService(UserTbRepo userTbRepo) {
        this.userTbRepo = userTbRepo;
    }

    public List<UserTb> findAll() {
        return userTbRepo.findAll();
    }

    public int deleteByNo(int no) {
        return userTbRepo.deleteByNo(no);
    }
}
