package com.coffeeprince.frequency.sale.web.dto;

import com.coffeeprince.frequency.sale.domain.FrequencySaleList;
import com.coffeeprince.frequency.trade.domain.FrequencyTradeList;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class FrequencySaleResponseDto {

    private long boardId;

    private long frequencyId;

    private Integer quantity;

    private Integer price;

    public FrequencySaleResponseDto(FrequencySaleList entity) {
        this.boardId = entity.getBoardId();
        this.frequencyId = entity.getFrequencyId();
        this.quantity = entity.getQuantity();
        this.price = entity.getPrice();
    }
}
