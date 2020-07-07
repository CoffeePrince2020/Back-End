package com.coffeeprince.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

// 교환하려는 프리퀀시 리스트 종류
@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class frequencyTradeList {

    @Id @Column(name = "frequencyTradeId")
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
}
