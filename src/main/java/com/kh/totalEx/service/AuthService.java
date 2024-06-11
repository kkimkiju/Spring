package com.kh.totalEx.service;

import com.kh.totalEx.dto.MemberReqDto;
import com.kh.totalEx.dto.MemberResDto;
import com.kh.totalEx.dto.TokenDto;
import com.kh.totalEx.entitiy.Member;
import com.kh.totalEx.jwt.TokenProvider;
import com.kh.totalEx.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class AuthService {

        private final AuthenticationManagerBuilder managerBuilder;
        private final MemberRepository memberRepository;
        private final PasswordEncoder passwordEncoder;
        private final TokenProvider tokenProvider;

        public MemberResDto signup(MemberReqDto requestDto) {
            if (memberRepository.existsByEmail(requestDto.getEmail())) {
                throw new RuntimeException("이미 가입되어 있는 유저입니다");
            }

            Member member = requestDto.toEntity(passwordEncoder);
            return MemberResDto.of(memberRepository.save(member));
        }

        public TokenDto login(MemberReqDto requestDto) {
            UsernamePasswordAuthenticationToken authenticationToken = requestDto.toAuthentication();

            Authentication authentication = managerBuilder.getObject().authenticate(authenticationToken);

            return tokenProvider.generateTokenDto(authentication);
        }
    }