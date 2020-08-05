package com.coffeeprince.frequency.trade.service;

import com.coffeeprince.frequency.trade.domain.TradeBoard;
import com.coffeeprince.frequency.trade.repository.FrequencyTradeListRepository;
import com.coffeeprince.frequency.trade.repository.TradeboardRepository;
import com.coffeeprince.frequency.trade.web.dto.EventResponseDto;
import com.coffeeprince.frequency.trade.web.dto.FrequencyTradeRequestDto;
import com.coffeeprince.frequency.trade.web.dto.TradeBoardResquestDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

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
        for (TradeBoard tb : tbs) {
            EventResponseDto erdto = new EventResponseDto(tb);
            erdtos.add(erdto);

        }
        return erdtos;

    }

    public EventResponseDto getBoard(Long boardId) {
        return tradeboardRepository.findById(boardId).map(EventResponseDto::new).orElseThrow(() -> new IllegalArgumentException("없는 게시물입니다."));
    }

    public void saveBoard(TradeBoardResquestDTO req) {
        long boardId = tradeboardRepository.save(req.tradeBoardInsert()).getId();

        for (FrequencyTradeRequestDto frequecyDto : req.getFrequencyList()) {
            frequencyTradeListRepository.save(frequecyDto.frequencyInsert(boardId));
        }
    }


}
