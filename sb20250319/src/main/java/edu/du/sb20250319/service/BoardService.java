package edu.du.sb20250319.service;

import edu.du.sb20250319.dto.BoardDto;
import edu.du.sb20250319.entity.BoardTb;
import edu.du.sb20250319.repository.BoardTbRepo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BoardService {

    private final BoardTbRepo boardTbRepo;

    public BoardService(BoardTbRepo boardTbRepo) {
        this.boardTbRepo = boardTbRepo;
    }

    public List<BoardTb> findAll() {
        return boardTbRepo.findAll();
    }

    public BoardTb findAllByNo(int no) {
        return boardTbRepo.findAllByNo(no);
    }

    @Transactional
    public void deleteAllByNo(int no) {
        boardTbRepo.deleteAllByNo(no);
    }

    @Transactional
    public void updateBoard(int no, BoardDto boardDto) {
        BoardTb board = boardTbRepo.findAllByNo(no);

        board.setTitle(boardDto.getTitle());
        board.setContent(boardDto.getContent());

        boardTbRepo.save(board);
    }

    public void save(BoardTb boardTb) {
        boardTbRepo.save(boardTb);
    }
}
