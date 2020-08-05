package com.coffeeprince.frequency.sale.domain;

import com.coffeeprince.frequency.common.domain.BaseTimeEntity;
import com.coffeeprince.frequency.trade.domain.FrequencyTradeList;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import java.util.List;

// 교환 글 엔티티
@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SaleBoard extends BaseTimeEntity {

    //게시물 아이디   등록일 / 작성자 / 상태
    @Id @Column(name = "boardId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long Id;

    // 이벤트 내용Id
    private long eventId;

    // 작성자
    private String writer;

    // 상태
    private Integer status;

    // 판매할 프리퀀시
    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name="boardId")
    List<FrequencySaleList> FrequencySaleLists;
}
