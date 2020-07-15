package com.coffeeprince.web.dto;

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
}
