package com.kh.totalEx.entitiy;

import com.kh.totalEx.constant.ItemSellStatus;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity //JPA Entity 클래스임을 지정, Entity 클래스는 반드시 기본키를 가져야 함
@ToString
public class Item {
    @Id
    @Column(name = "item_id") //PR키
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id; //상품 코드
    @Column(nullable = false, length = 50) //db의 not null과 같음
    private String itemNm; //상품명
    @Column(nullable = false)
    private int price; //가격
    @Column(nullable = false)
    private int stockNumber; //재고 수량
    @Lob //엄청 긴 문자열을 표현하기 위한 것
    @Column(nullable = false)
    private String itemDetail; // 상품 상세 설명
    @Enumerated(EnumType.STRING)
    private ItemSellStatus itemSellStatus;
    private LocalDateTime regTime;
    private LocalDateTime updateTime;

}
