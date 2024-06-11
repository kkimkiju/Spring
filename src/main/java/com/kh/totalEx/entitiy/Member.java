package com.kh.totalEx.entitiy;

import com.kh.totalEx.constant.Authority;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "member")
@Getter
@Setter
@ToString

@NoArgsConstructor
public class Member {
    @Id
    @Column(name = "member_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String pwd;
    @Column(unique = true)
    private String email;
    private String image;
    private LocalDateTime regDate;
    @Enumerated(EnumType.STRING) //저장할 때 문자열 자체로 저장
    private Authority authority;
    @Builder
    public Member(String name, String email, String pwd,String image, Authority authority) {
        this.name = name;
        this.pwd = pwd;
        this.email = email;
        this.image = image;
        this.authority = authority;
        this.regDate = LocalDateTime.now();
    }
}
