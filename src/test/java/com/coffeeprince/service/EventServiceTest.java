package com.coffeeprince.service;

import com.coffeeprince.domain.FrequencyTradeList;
import com.coffeeprince.domain.TradeBoard;
import com.coffeeprince.repository.FrequencyTradeListRepository;
import com.coffeeprince.repository.TradeboardRepository;
import com.coffeeprince.web.dto.EventResponseDto;
import com.coffeeprince.web.dto.FrequencyTradeRequestDto;
import com.coffeeprince.web.dto.TradeBoardResquestDTO;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.TestConstructor;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

@TestConstructor(autowireMode = TestConstructor.AutowireMode.ALL)
@DataJpaTest
class EventServiceTest {

    EventService eventService;

   /* CompanyRepository companyRepository;

    FrequencyEventListRepository frequencyEventListRepository;

    FrequencyRepository frequencyRepository;*/

    FrequencyTradeListRepository frequencyTradeListRepository;

    TradeboardRepository tradeboardRepository;

    @BeforeEach
    public void beforeEach() {
        eventService = new EventService(this.tradeboardRepository, this.frequencyTradeListRepository);
    }

    @Test
    void boardList() {
        // given
        //List<TradeBoard> tbs = new ArrayList<TradeBoard>();
        TradeBoard tb = TradeBoard.builder()
                .Id(1L)
                .eventId(1L)
                .writer("mins99").build();

        TradeBoard tb2 = tradeboardRepository.save(tb);

        //List<FrequencyTradeList> ftlists = new ArrayList<FrequencyTradeList>();
        FrequencyTradeList ftlist = FrequencyTradeList.builder()
                .Id(1L)
                .boardId(1L)
                .frequencyId(1L)
                .quantity(1).build();
        //ftlists.add(ftlist);
        FrequencyTradeList ftlist2 = frequencyTradeListRepository.save(ftlist);

        // when
        PageRequest pageRequest = PageRequest.of(0, 1);
        List<TradeBoard> tbs2 = tradeboardRepository.findAll(pageRequest).getContent();

        // then
        assertEquals(tb2.getId(), tbs2.get(0).getId());
        //assertEquals(ftlist2.getId(), tbs2.get(0).getFrequencyTradeLists().get(0).getId());
    }

    @Test
    void getBoard() {

    }

    @Test
    void saveBoard() {
        // given
        List<FrequencyTradeRequestDto> frequencyTradeRequestDtos = new ArrayList<FrequencyTradeRequestDto>();
        FrequencyTradeRequestDto frequencyTradeRequestDto = new FrequencyTradeRequestDto(1L, 1);
        frequencyTradeRequestDtos.add(frequencyTradeRequestDto);
        TradeBoardResquestDTO tradeBoardResquestDTO = new TradeBoardResquestDTO(1L, "mins99", frequencyTradeRequestDtos);

        // when
        eventService.saveBoard(tradeBoardResquestDTO);
        EventResponseDto erdto = eventService.getBoard(1L);

        // then
        assertThat(erdto.getWriter()).isEqualTo("mins99");
    }
}