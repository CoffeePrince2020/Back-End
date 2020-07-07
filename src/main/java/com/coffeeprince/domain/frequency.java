package com.coffeeprince.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

//이벤트 별 프리퀀시 종류
@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class frequency {

    //id
    @Id @Column(name="frequencyId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long Id;

    //frequencyName
    private String frequencyName;

    //eventId
    @JoinColumn(name="eventId")
    private long eventId;
}
