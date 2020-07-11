package com.coffeeprince.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

// 이벤트 종류에 관한 테이블
@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FrequencyEventList{

    // id
    @Id @Column(name = "eventId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long Id;

    // Company
    @JoinColumn(name = "companyId")
    private long companyId;

    // name
    private String eventName;

    // startdate
    private LocalDateTime startDate;
    // enddate
    private LocalDateTime endDate;

}
