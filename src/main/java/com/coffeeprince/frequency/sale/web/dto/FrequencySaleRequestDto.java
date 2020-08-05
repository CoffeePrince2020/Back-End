package com.coffeeprince.frequency.sale.web.dto;

import com.coffeeprince.frequency.sale.domain.FrequencySaleList;
import com.coffeeprince.frequency.trade.domain.FrequencyTradeList;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class FrequencySaleRequestDto {

    private long frequencyId;

    private Integer quantity;

    public FrequencySaleList frequencyInsert(long boardId) {
        return FrequencySaleList
                            .builder()
                            .boardId(boardId)
                            .frequencyId(this.frequencyId)
                            .quantity(this.quantity).build();
    }
}
