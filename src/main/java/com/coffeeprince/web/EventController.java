package com.coffeeprince.web;

import com.coffeeprince.service.EventService;
import com.coffeeprince.web.dto.EventResponseDto;
import com.coffeeprince.web.dto.TradeBoardResquestDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/api/v1/board")
@RestController
public class EventController {

    private final EventService eventService;

    @GetMapping("list")
    public List<EventResponseDto> boardList(
            @RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "10") Integer size) {
        return eventService.boardList(page, size);
    }

    @GetMapping("{boardId}")
    public EventResponseDto getBoard(@PathVariable(value = "boardId")Long boardId) {
        return eventService.getBoard(boardId);
    }

    @PostMapping("{userId}")
    public void boardSave(
            @RequestBody TradeBoardResquestDTO req
            ) {
        eventService.saveBoard(req);
    }
}
