package edu.du.sb0320_thymeleaf.controller;

import edu.du.sb0320_thymeleaf.dto.SampleDto;
import edu.du.sb0320_thymeleaf.entity.MyUser;
import edu.du.sb0320_thymeleaf.repository.MyUserRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.time.LocalDateTime.now;

@Controller
@RequestMapping("/test")
@Slf4j
public class SampleController {

    private final MyUserRepo myUserRepo;

    public SampleController(MyUserRepo myUserRepo) {
        this.myUserRepo = myUserRepo;
    }

    @GetMapping("/s1")
    public String s1(Model model) {
//        MyUser myUser = myUserRepo.findById(1).get();
        MyUser myUser = myUserRepo.findByName("hyeong");
        log.info("사용자 정보 : {}", myUser); //시스템 로그에 기록
        model.addAttribute("message", myUser);
        return "sample/samplePage1";
    }

    @GetMapping("/s2")
    public String samplePage2(Model model) {
        log.info("samplePage2 called");
        List<SampleDto> list = new ArrayList<>();
        for(int i=1;i<=10;i++) {
            SampleDto dto = new SampleDto(i,"이름"+i,25+i,"aaa@naver.com"+i,now());
            list.add(dto);
        }
        model.addAttribute("list", list.toString());
        return "sample/samplePage2";
    }

    @GetMapping("/s3")
    public String samplePage3(Model model) {
//        List<MyUser> mlist = myUserRepo.findAll();
        List<MyUser> users = myUserRepo.findMyuserByOrderByNameAsc();
        model.addAttribute("user", users);

        List<SampleDto> list = IntStream.rangeClosed(1, 10)
                .mapToObj(i -> {
                    SampleDto dto = SampleDto.builder()
                            .id(i) // int형 유지
                            .name("테스트" + i)
                            .age(25 + i)
                            .email("aaa@naver.com" + i)
                            .build();
                    return dto;
                }).collect(Collectors.toList());
        model.addAttribute("list", list);
        return "sample/samplePage3";
    }
}
