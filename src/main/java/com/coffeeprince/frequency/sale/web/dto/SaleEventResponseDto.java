package com.coffeeprince.frequency.sale.web.dto;

import com.coffeeprince.frequency.sale.domain.FrequencySaleList;
import com.coffeeprince.frequency.sale.domain.SaleBoard;
import com.coffeeprince.frequency.trade.domain.FrequencyTradeList;
import com.coffeeprince.frequency.trade.domain.TradeBoard;
import com.coffeeprince.frequency.trade.web.dto.FrequencyTradeResponseDto;
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
public class SaleEventResponseDto {

    private long Id;

    private long eventId;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createDate;

    private String writer;

    List<FrequencySaleResponseDto> FrequencySaleLists;

    public SaleEventResponseDto(SaleBoard entity) {
        this.Id = entity.getId();
        this.eventId = entity.getEventId();
        this.createDate = entity.getCreatedDate();
        this.writer = entity.getWriter();
        this.FrequencySaleLists = new ArrayList<>();
        for(FrequencySaleList frlists : entity.getFrequencySaleLists()) {
            FrequencySaleResponseDto frlist = new FrequencySaleResponseDto(frlists);
            this.FrequencySaleLists.add(frlist);
        }
    }
}
