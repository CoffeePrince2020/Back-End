package com.coffeeprince.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@NoArgsConstructor
@Getter
public class test {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String category;    // frequency? coupon?
}
