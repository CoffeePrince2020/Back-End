package com.coffeeprince.web.dto;

import com.coffeeprince.domain.FrequencyTradeList;
import com.coffeeprince.domain.Tradeboard;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class EventResponseDto {

    private long Id;

    private long eventId;

    private LocalDateTime createDate;

    private String writer;

    List<FrequencyTradeResponseDto> FrequencyTradeLists;

    public EventResponseDto(Tradeboard entity) {
        this.Id = entity.getId();
        this.eventId = entity.getEventId();
        this.createDate = entity.getCreatedDate();
        this.writer = entity.getWriter();
        this.FrequencyTradeLists = new ArrayList<>();
        for(FrequencyTradeList frlists : entity.getFrequencyTradeLists()) {
            FrequencyTradeResponseDto frlist = new FrequencyTradeResponseDto(frlists);
            this.FrequencyTradeLists.add(frlist);
        }
    }
}
