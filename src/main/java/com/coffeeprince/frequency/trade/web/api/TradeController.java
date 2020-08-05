package com.coffeeprince.frequency.trade.web.api;

import com.coffeeprince.frequency.trade.service.TradeService;
import com.coffeeprince.frequency.trade.web.dto.EventResponseDto;
import com.coffeeprince.frequency.trade.web.dto.TradeBoardResquestDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/api/v1/trade-board")
@RestController
public class TradeController {

    private final TradeService tradeService;


    /* 교환글 리스트*/
    @GetMapping("list")
    public List<EventResponseDto> tradeList(
            @RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "10") Integer size) {
        return tradeService.tradeList(page, size);
    }

    /* 교환글 상세보기*/
    @GetMapping("{tradeId}")
    public EventResponseDto getTradeBoard(@PathVariable(value = "tradeId")Long tradeId) {
        return tradeService.getTradeDetail(tradeId);
    }

    /* 교환글 저장*/
    @PostMapping("{userId}")
    public void tradeBoardSave(
            @RequestBody TradeBoardResquestDTO req
            ) {
        tradeService.saveTrade(req);
    }

    /* 교환글 삭제*/
    @DeleteMapping("{tradeId}")
    @Transactional
    public void tradeBoardUpdate(@PathVariable(value="tradeId")Long tradeId) {
        tradeService.deleteTrade(tradeId);
    }
}
