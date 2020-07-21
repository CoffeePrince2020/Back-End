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
import java.util.NoSuchElementException;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class EventService {

    public final TradeboardRepository tradeboardRepository;
    public final FrequencyTradeListRepository frequencyTradeListRepository;

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
        Optional<TradeBoard> tb = tradeboardRepository.findById(boardId);
        if(tb.isPresent()) {
            EventResponseDto erdto = new EventResponseDto(tb.get());

            return erdto;
        } else {
            throw new NoSuchElementException();
        }
    }

    @Transactional
    public void saveBoard(TradeBoardResquestDTO req) {
         TradeBoard tradeBoard =  tradeboardRepository.save(req.tradeBoardInsert());

         long boardId = tradeBoard.getId();

         for(FrequencyTradeRequestDto frequecyDto : req.getFrequencyList()) {
            frequencyTradeListRepository.save(frequecyDto.frequencyInsert(boardId));
         }
    }
}
