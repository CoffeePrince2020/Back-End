package com.coffeeprince.frequency.trade.service;

import com.coffeeprince.frequency.trade.domain.TradeBoard;
import com.coffeeprince.frequency.trade.repository.FrequencyTradeListRepository;
import com.coffeeprince.frequency.trade.repository.TradeboardRepository;
import com.coffeeprince.frequency.trade.web.dto.EventResponseDto;
import com.coffeeprince.frequency.trade.web.dto.FrequencyTradeRequestDto;
import com.coffeeprince.frequency.trade.web.dto.TradeBoardResquestDTO;
import lombok.RequiredArgsConstructor;
import net.bytebuddy.implementation.bytecode.Throw;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Id;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class TradeService {

    private final TradeboardRepository tradeboardRepository;
    private final FrequencyTradeListRepository frequencyTradeListRepository;

    public List<EventResponseDto> tradeList(Integer page, Integer size) {
        PageRequest pageRequest = PageRequest.of(page, size);
        List<TradeBoard> tbs = tradeboardRepository.findAll(pageRequest).getContent();
        List<EventResponseDto> erdtos = new ArrayList<>();
        for (TradeBoard tb : tbs) {
            EventResponseDto erdto = new EventResponseDto(tb);
            erdtos.add(erdto);

        }
        return erdtos;

    }

    public EventResponseDto getTradeDetail(Long boardId) {
        return tradeboardRepository.findById(boardId).map(EventResponseDto::new).orElseThrow(() -> new IllegalArgumentException("없는 게시물입니다."));
    }

    public void saveTrade(TradeBoardResquestDTO req) {
        long boardId = tradeboardRepository.save(req.tradeBoardInsert()).getId();

        for (FrequencyTradeRequestDto frequecyDto : req.getFrequencyList()) {
            frequencyTradeListRepository.save(frequecyDto.frequencyInsert(boardId));
        }
    }

    //삼항연산자 Throw를 어떻게 할까?
    @Transactional
    public void deleteTrade(Long boardId) {
        tradeboardRepository.findById(boardId).map(
                tradeBoard -> tradeBoard.getStatus() == 0 ? new IllegalArgumentException("이미 삭제된 게시물 입니다.")
                        : TradeBoard.builder().Id(boardId).status(0).build()
        ).orElseThrow(()->new IllegalArgumentException("존재하지 않은 게시물입니다."));
    }
}
