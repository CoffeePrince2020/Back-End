package com.coffeeprince.service;

import com.coffeeprince.domain.TradeBoard;
import com.coffeeprince.repository.FrequencyTradeListRepository;
import com.coffeeprince.repository.TradeboardRepository;
import com.coffeeprince.web.dto.EventResponseDto;
import com.coffeeprince.web.dto.FrequencyTradeRequestDto;
import com.coffeeprince.web.dto.TradeBoardResquestDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class EventService {

    private final TradeboardRepository tradeboardRepository;
    private final FrequencyTradeListRepository frequencyTradeListRepository;

    public List<EventResponseDto> boardList(Integer page, Integer size) {
        PageRequest pageRequest = PageRequest.of(page, size);
        List<TradeBoard> tbs = tradeboardRepository.findAll(pageRequest).getContent();
        List<EventResponseDto> erdtos = new ArrayList<>();
        for(TradeBoard tb : tbs) {
            EventResponseDto erdto = new EventResponseDto(tb);
            erdtos.add(erdto);

        }
        return erdtos;

    }

    public EventResponseDto getBoard(Long boardId) {
        return tradeboardRepository.findById(boardId).map(EventResponseDto::new).orElseThrow(()->new IllegalArgumentException("없는 게시물입니다."));
    }

    public void saveBoard(TradeBoardResquestDTO req) {
         long boardId = tradeboardRepository.save(req.tradeBoardInsert()).getId();

         for(FrequencyTradeRequestDto frequecyDto : req.getFrequencyList()) {
            frequencyTradeListRepository.save(frequecyDto.frequencyInsert(boardId));
         }
    }


}
