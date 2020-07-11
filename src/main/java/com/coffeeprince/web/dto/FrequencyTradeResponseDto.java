package com.coffeeprince.web.dto;

import com.coffeeprince.domain.FrequencyTradeList;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
