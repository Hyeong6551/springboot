package edu.du.sb0320.controller;

import edu.du.sb0320.dto.SampleDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
@RequestMapping("/sample")
@Slf4j
public class SampleController {

    @GetMapping("/ex1")
    public String ex1(Model model) {
        log.info("ex1 나옴!!");
//        System.out.println("나온다!!");
        model.addAttribute("name1", "홍길동");
        return "sample/ex1";
    }
    @GetMapping("/ex2")
    public String ex2(Model model) {
        List<SampleDTO> list = IntStream.rangeClosed(1,20)
                .asLongStream().mapToObj(i -> {
                    SampleDTO sampleDTO = SampleDTO.builder()
                            .id(i)
                            .name("테스트"+i)
                            .age(20+i)
                            .build();
                    return sampleDTO;
                }).collect(Collectors.toList());
//        List<SampleDTO> list = new ArrayList<>();
//        SampleDTO dto = new SampleDTO(1,"홍길동", 24);
//        list.add(dto);
//        dto = new SampleDTO(2,"홍길순", 23);
//        list.add(dto);
//        dto = new SampleDTO(3,"홍길철", 25);
//        list.add(dto);
        log.info(list.toString());
        model.addAttribute("list", list);
        return "sample/ex2";
    }
}
