package com.coffeeprince.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

// 교환 글 엔티티
@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class tradeboard {

    //게시물 아이디   등록일 / 작성자 / 상태
    @Id @Column(name = "boardId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long Id;

    // 이벤트 내용Id
    private long eventId;

    // 등록일
    private LocalDateTime writeDate;

    // 작성자
    private String writer;

    // 상태
    private Integer status;

    // 교환할 프리퀀시 종류?
    @OneToMany
    @JoinColumn(name="frequencyTradeId")
    List<frequencyTradeList> frequencyTradeLists;
}
