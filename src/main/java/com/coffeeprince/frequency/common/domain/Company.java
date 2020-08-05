package com.coffeeprince.frequency.common.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

// 커피 회사 엔티티
@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Company {

    @Id @Column(name = "companyId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long Id;

    private String companyName;
}
