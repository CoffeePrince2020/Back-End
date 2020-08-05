package com.coffeeprince.frequency.sale.web.dto;

import com.coffeeprince.frequency.sale.domain.SaleBoard;
import com.coffeeprince.frequency.trade.domain.TradeBoard;
import com.coffeeprince.frequency.trade.web.dto.FrequencyTradeRequestDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class SaleBoardRequestDTO {
    long eventId;
    private String writer;
    private List<FrequencySaleRequestDto> frequencyList;

    public SaleBoard saleBoardInsert () {
        return SaleBoard.builder()
                .eventId(this.eventId)
                .writer(this.writer).build();
    }
}
