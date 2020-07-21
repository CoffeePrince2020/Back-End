package com.coffeeprince.web.dto;

import com.coffeeprince.domain.FrequencyTradeList;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class FrequencyTradeRequestDto {

    private long frequencyId;

    private Integer quantity;

    public FrequencyTradeList frequencyInsert(long boardId) {
        return FrequencyTradeList
                            .builder()
                            .boardId(boardId)
                            .frequencyId(this.frequencyId)
                            .quantity(this.quantity).build();
    }
}
