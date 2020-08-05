package com.coffeeprince.frequency.sale.service;

import com.coffeeprince.frequency.sale.domain.SaleBoard;
import com.coffeeprince.frequency.sale.repository.FrequencySaleListRepository;
import com.coffeeprince.frequency.sale.repository.SaleboardRepository;
import com.coffeeprince.frequency.sale.web.dto.FrequencySaleRequestDto;
import com.coffeeprince.frequency.sale.web.dto.SaleBoardRequestDTO;
import com.coffeeprince.frequency.sale.web.dto.SaleEventResponseDto;
import com.coffeeprince.frequency.trade.domain.TradeBoard;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class SaleEventService {

    private final SaleboardRepository saleboardRepository;
    private final FrequencySaleListRepository frequencySaleListRepository;

    public List<SaleEventResponseDto> boardList(Integer page, Integer size) {
        PageRequest pageRequest = PageRequest.of(page, size);
        List<SaleBoard> tbs = saleboardRepository.findAll(pageRequest).getContent();
        List<SaleEventResponseDto> erdtos = new ArrayList<>();
        for (SaleBoard tb : tbs) {
            SaleEventResponseDto erdto = new SaleEventResponseDto(tb);
            erdtos.add(erdto);

        }
        return erdtos;

    }

    public SaleEventResponseDto getBoard(Long boardId) {
        return saleboardRepository.findById(boardId).map(SaleEventResponseDto::new).orElseThrow(() -> new IllegalArgumentException("없는 게시물입니다."));
    }

    public void saveBoard(SaleBoardRequestDTO req) {
        long boardId = saleboardRepository.save(req.saleBoardInsert()).getId();

        for (FrequencySaleRequestDto frequecyDto : req.getFrequencyList()) {
            frequencySaleListRepository.save(frequecyDto.frequencyInsert(boardId));
        }
    }


}
