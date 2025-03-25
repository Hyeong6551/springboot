package edu.du.sb20250319.service;

import edu.du.sb20250319.dto.UserDto;
import edu.du.sb20250319.entity.BoardTb;
import edu.du.sb20250319.entity.UserTb;
import edu.du.sb20250319.repository.UserTbRepo;
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

    @Transactional
    public void deleteByNo(int no) {
        userTbRepo.deleteByNo(no);
    }

    public UserTb findAllByNo(int no) {
        return userTbRepo.findAllByNo(no);
    }

    @Transactional
    public void updateUser(int no, UserDto userDto) {
        UserTb user = userTbRepo.findAllByNo(no);

        user.setName(userDto.getName());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());

        userTbRepo.save(user);
    }

    public void save(UserTb userTb) {
        userTbRepo.save(userTb);
    }

    public List<UserTb> findAllById(String id){
        return userTbRepo.findAllById(id);
    }
}
