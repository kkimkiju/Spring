package com.kh.totalEx.repository;

import com.kh.totalEx.entitiy.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {
    List<Member> findAll(); //전체 회원 조회
    Optional<Member> findByEmail(String email); //null이여도 죽지 않음 , 개별 회원 정보 조회
    List<Member> findByEmailAndPwd(String email,String pwd);

}


// JUnit테스트
// 전체 회원 조회
// 이메일로 개별 회원 조회
// 가입 여부 확인(이메일로 가입 여부 확인)
// 로그인 체크