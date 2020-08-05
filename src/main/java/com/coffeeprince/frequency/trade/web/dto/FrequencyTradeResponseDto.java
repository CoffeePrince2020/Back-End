package com.coffeeprince.frequency.trade.web.dto;

import com.coffeeprince.frequency.trade.domain.FrequencyTradeList;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class FrequencyTradeResponseDto {

    private long boardId;

    private long frequencyId;

    private Integer quantity;

    public FrequencyTradeResponseDto(FrequencyTradeList entity) {
        this.boardId = entity.getBoardId();
        this.frequencyId = entity.getFrequencyId();
        this.quantity = entity.getQuantity();
    }
}
