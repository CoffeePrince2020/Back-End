package com.coffeeprince.web.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class FrequencyTradeRequestDto {

    private long frequencyId;

    private Integer quantity;
}
