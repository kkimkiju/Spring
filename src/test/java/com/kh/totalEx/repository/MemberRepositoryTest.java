package com.kh.totalEx.repository;

import com.kh.totalEx.entitiy.Member;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@SpringBootTest
@TestPropertySource(locations = "classpath:application-test.properties")
class MemberRepositoryTest {
    @Autowired
    MemberRepository memberRepository;

    @Test
    @DisplayName("멤버 생성")
    public void createMemberTest() {
        for(int i = 1; i <=10; i++){
            Member member = new Member();
            member.setName("user"+i);
            member.setPwd("1234"+i);
            member.setEmail("k199201"+i+"@naver.com");
            member.setImage("http:image."+i);
            member.setRegDate(LocalDateTime.now());
            memberRepository.save(member);

        }
    }

    @Test
    @DisplayName("전체 회원 조회 테스트")
    public void findAll(){
        this.createMemberTest();
        List<Member> memberList = memberRepository.findAll();
        for (Member e : memberList){
            System.out.println("전체 회원조회" + e.toString());
        }
    }
    @Test
    @DisplayName("이메일로 찾아볼게요")
    public void findByEmailTest() {
        this.createMemberTest();
        Optional<Member> memberList = memberRepository.findByEmail("k1992013@naver.com");
       if(memberList.isPresent()){
            Member mem = memberList.get();
            System.out.println("결과 : " + mem.getEmail());
        }
    }

    @Test
    @DisplayName("아이디 비번 입력 맞아?")
    public void findByEmailAndPwd() {
        this.createMemberTest();
        List<Member> memberList = memberRepository.findByEmailAndPwd("k1992013@naver.com","12343");
        if (!memberList.isEmpty()) {
            for (Member e : memberList) {
                System.out.println("로그인 성공");
            }
        } else {
            System.out.println("로그인 실패");
        }
    }
}

