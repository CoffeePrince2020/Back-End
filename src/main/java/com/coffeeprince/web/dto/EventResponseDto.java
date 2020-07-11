package com.coffeeprince.web.dto;

import com.coffeeprince.domain.FrequencyTradeList;
import com.coffeeprince.domain.Tradeboard;

import java.time.LocalDateTime;
import java.util.List;

public class EventResponseDto {

    private long Id;

    private long eventId;

    private LocalDateTime writeDate;

    private String writer;

    List<FrequencyTradeList> FrequencyTradeLists;

    public EventResponseDto(Tradeboard entity) {
        this.Id = entity.getId();
        this.eventId = entity.getEventId();
        this.writeDate = entity.getWriteDate();
        this.writer = entity.getWriter();
        this.FrequencyTradeLists = entity.getFrequencyTradeLists();
    }
}
