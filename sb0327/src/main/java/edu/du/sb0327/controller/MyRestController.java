package edu.du.sb0327.controller;


import edu.du.sb0327.entity.Members;
import edu.du.sb0327.repository.MembersRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MyRestController {

    @Autowired
    private MembersRepo membersRepo;

    @GetMapping("/data")
    public List<Members> data() {
        return membersRepo.findAll();
    }

    @GetMapping("/data/{id}")
    public Members data(@PathVariable Long id) {
        return membersRepo.findById(id).orElse(null);
    }
}
