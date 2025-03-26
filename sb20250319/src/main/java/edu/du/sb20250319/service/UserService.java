package edu.du.sb20250319.service;

import edu.du.sb20250319.dto.UserDto;
import edu.du.sb20250319.entity.UserTb;
import edu.du.sb20250319.repository.UserTbRepo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;

import java.util.List;

@Service
public class UserService {

    private final UserTbRepo userTbRepo;

    public UserService(UserTbRepo userTbRepo) {
        this.userTbRepo = userTbRepo;
    }

    // 전체 회원 리스트
    public List<UserTb> findAll() {
        return userTbRepo.findAll();
    }

    // 회원 삭제
    @Transactional
    public void deleteByNo(int no) {
        userTbRepo.deleteByNo(no);
    }

    // 회원 정보 수정
    public UserTb findAllByNo(int no) {
        return userTbRepo.findAllByNo(no);
    }

    // 글 쓰기
    @Transactional
    public void updateUser(int no, UserDto userDto) {
        UserTb user = userTbRepo.findAllByNo(no);
        user.setName(userDto.getName());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        userTbRepo.save(user);
    }

    // 회원 가입
    public void save(UserTb userTb) {
        userTbRepo.save(userTb);
    }

    // 로그인
    public List<UserTb> findAllById(String id) {
        return userTbRepo.findAllById(id);
    }

    // 아이디 중복 검사
    public boolean existsById(UserDto user) {
        return userTbRepo.existsById(user.getId());
    }

    // 이메일 중복 검사
    public boolean existsByEmail(UserDto user) {
        return userTbRepo.existsByEmail(user.getEmail());
    }
}
