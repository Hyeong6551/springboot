package edu.du.boardservice.controller;


import edu.du.boardservice.entity.BoardEntity;
import edu.du.boardservice.repository.BoardRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/board")
public class BoardController {
    @Autowired
    private BoardRepo boardRepo;

    @GetMapping
    public List<BoardEntity> findAll() {
        return boardRepo.findAll();
    }
}
