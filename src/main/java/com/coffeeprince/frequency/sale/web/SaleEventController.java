package com.coffeeprince.frequency.sale.web;

import com.coffeeprince.frequency.sale.service.SaleEventService;
import com.coffeeprince.frequency.sale.web.dto.SaleBoardRequestDTO;
import com.coffeeprince.frequency.sale.web.dto.SaleEventResponseDto;
import com.coffeeprince.frequency.trade.service.EventService;
import com.coffeeprince.frequency.trade.web.dto.EventResponseDto;
import com.coffeeprince.frequency.trade.web.dto.TradeBoardResquestDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/api/v1/sale-board")
@RestController
public class SaleEventController {

    private final SaleEventService eventService;

    @GetMapping("list")
    public List<SaleEventResponseDto> boardList(
            @RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "10") Integer size) {
        return eventService.boardList(page, size);
    }

    @GetMapping("{boardId}")
    public SaleEventResponseDto getBoard(@PathVariable(value = "boardId")Long boardId) {
        return eventService.getBoard(boardId);
    }

    @PostMapping("{userId}")
    public void boardSave(@RequestBody SaleBoardRequestDTO req) {
        eventService.saveBoard(req);
    }
}
