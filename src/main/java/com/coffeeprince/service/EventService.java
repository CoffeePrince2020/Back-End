package com.coffeeprince.service;

import com.coffeeprince.domain.Tradeboard;
import com.coffeeprince.repository.TradeboardRepository;
import com.coffeeprince.web.dto.EventResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

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

    public EventResponseDto getBoard(Long boardId) {
        Optional<Tradeboard> tb = tradeboardRepository.findById(boardId);
        if(tb.isPresent()) {
            EventResponseDto erdto = new EventResponseDto(tb.get());

            return erdto;
        } else {
            throw new NoSuchElementException();
        }
    }
}
