package com.kh.totalEx.repository;

import com.kh.totalEx.entitiy.Board;
import com.kh.totalEx.entitiy.Member;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import java.time.LocalDateTime;
import java.util.List;

@SpringBootTest
@TestPropertySource(locations = "classpath:application-test.properties")
class BoardRepositoryTest {

    @Autowired
    BoardRepository boardRepository;

    @Test
    @DisplayName("게시글 만들자")
    public void createBoardTest() {
        for(int i = 1; i <=10; i++){
            Board board = new Board();
            board.setTitle("안녕하세요~"+i);
            board.setContent(i+"번째 글이에요");
            board.setImgPath("http//www."+i+"@naver.com");
            board.setRegDate(LocalDateTime.now());
            boardRepository.save(board);
        }
    }

    @Test
    @DisplayName("게시글 전체조회")
    public void findAll(){
        this.createBoardTest();
        List<Board> boardList = boardRepository.findAll();
        for (Board e : boardList){
            System.out.println("전체 게시글 출력 " + e.toString());
        }
    }

    @Test
    @DisplayName("게시물 제목 찾아 출력하는 것")
    public void findByTitleContaining(){
        this.createBoardTest();
        List<Board> boardList = boardRepository.findByTitleContaining("3");
        for (Board e : boardList){
            System.out.println("너가 찾는 제목의 글 "+ e.toString());
        }
    }
}
