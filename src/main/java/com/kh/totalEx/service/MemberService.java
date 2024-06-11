package com.kh.totalEx.service;

import com.kh.totalEx.dto.MemberResDto;
import com.kh.totalEx.entitiy.Member;
import com.kh.totalEx.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;

    //회원 전체 조회
    public List<MemberResDto> getMemberList(){
        List<Member> members = memberRepository.findAll();
        List<MemberResDto> memberDtos = new ArrayList<>();
        for(Member member : members) {
            memberDtos.add(MemberResDto.of(member));
        }
        return memberDtos;
    }
}
