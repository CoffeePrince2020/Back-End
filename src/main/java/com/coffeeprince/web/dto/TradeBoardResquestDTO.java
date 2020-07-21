package com.coffeeprince.web.dto;

import com.coffeeprince.domain.TradeBoard;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class TradeBoardResquestDTO {
    long eventId;
    private String writer;
    private List<FrequencyTradeRequestDto> frequencyList;

    public TradeBoard tradeBoardInsert () {
        return TradeBoard.builder()
                .eventId(this.eventId)
                .writer(this.writer).build();
    }
}
