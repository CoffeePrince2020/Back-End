package com.coffeeprince.frequency.trade.web.dto;

import com.coffeeprince.frequency.trade.domain.FrequencyTradeList;
import com.coffeeprince.frequency.trade.domain.TradeBoard;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class EventResponseDto {

    private long Id;

    private long eventId;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createDate;

    private String writer;

    List<FrequencyTradeResponseDto> FrequencyTradeLists;

    public EventResponseDto(TradeBoard entity) {
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
