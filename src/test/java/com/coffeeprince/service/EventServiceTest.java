package com.coffeeprince.service;

import com.coffeeprince.domain.FrequencyTradeList;
import com.coffeeprince.domain.TradeBoard;
import com.coffeeprince.repository.CompanyRepository;
import com.coffeeprince.repository.FrequencyEventListRepository;
import com.coffeeprince.repository.FrequencyRepository;
import com.coffeeprince.repository.FrequencyTradeListRepository;
import com.coffeeprince.repository.TradeboardRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.TestConstructor;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@TestConstructor(autowireMode = TestConstructor.AutowireMode.ALL)
@DataJpaTest
class EventServiceTest {

    @Autowired
    CompanyRepository companyRepository;

    @Autowired
    FrequencyEventListRepository frequencyEventListRepository;

    @Autowired
    FrequencyRepository frequencyRepository;

    @Autowired
    FrequencyTradeListRepository frequencyTradeListRepository;

    @Autowired
    TradeboardRepository tradeboardRepository;

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

    }
}