package com.coffeeprince.web;

import com.coffeeprince.service.EventService;
import com.coffeeprince.web.dto.EventResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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

}
