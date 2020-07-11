package com.coffeeprince.service;

import com.coffeeprince.domain.Tradeboard;
import com.coffeeprince.repository.TradeboardRepository;
import com.coffeeprince.web.dto.EventResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class EventService {

    public final TradeboardRepository tradeboardRepository;

    public List<EventResponseDto> boardList(Integer page, Integer size) {
        PageRequest pageRequest = PageRequest.of(page, size);
        List<Tradeboard> tbs = tradeboardRepository.findAll(pageRequest).getContent();
        List<EventResponseDto> erdtos = new ArrayList<>();
        for(Tradeboard tb : tbs) {
            EventResponseDto erdto = new EventResponseDto(tb);
            erdtos.add(erdto);
        }

        return erdtos;
    }
}
