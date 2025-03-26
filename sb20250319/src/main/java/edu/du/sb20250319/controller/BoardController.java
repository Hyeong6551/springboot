package edu.du.sb20250319.controller;

import edu.du.sb20250319.dto.BoardDto;
import edu.du.sb20250319.entity.BoardTb;
import edu.du.sb20250319.service.BoardService;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;

@Controller
@RequestMapping("/board")
public class BoardController {

    private final BoardService boardService;

    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }

    @GetMapping
    public String board(Model model) {
        model.addAttribute("boards",boardService.findAll());
        return "board/board";
    }

    @GetMapping("/{no}")
    public String list(@PathVariable int no, Model model) {
        model.addAttribute("boards",boardService.findAllByNo(no));
        return "board/detail";
    }

    @GetMapping("/delete/{no}")
    public String delete(@PathVariable int no) {
        boardService.deleteAllByNo(no);
        return "redirect:/board";
    }

    @GetMapping("/edit/{no}")
    public String edit(@PathVariable int no, Model model) {
        BoardTb board = boardService.findAllByNo(no);
        model.addAttribute("boardDto",board);
        return  "board/edit";
    }

    @PostMapping("/edit/{no}")
    public String edit(@PathVariable int no, @ModelAttribute BoardDto boardDto) {
        boardService.updateBoard(no, boardDto);
        return "redirect:/board";
    }

    @GetMapping("/write")
    public String write(Model model) {
        model.addAttribute("boardDto", new BoardDto());
        return "board/write";
    }

    @PostMapping("/write")
    public String writeForm(@ModelAttribute("boardDto") @Valid BoardDto boardDto,
                               BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "board/write";
        }
        BoardTb boardTb = BoardTb.builder()
                .title(boardDto.getTitle())
                .content(boardDto.getContent())
                .build();
        boardService.save(boardTb);
        return "redirect:/";
    }
}
