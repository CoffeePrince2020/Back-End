package com.coffeeprince.frequency.sale.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

// 교환하려는 프리퀀시 리스트 종류
@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FrequencySaleList {

    @Id @Column(name = "frequencySaleId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long Id;

    // boardid
    @JoinColumn(name = "boardId")
    private long boardId;

    // frequencyid
    @JoinColumn(name="frequencyId")
    private long frequencyId;

    // count
    private Integer quantity;

    // 개당 금액
    private Integer price;
}
