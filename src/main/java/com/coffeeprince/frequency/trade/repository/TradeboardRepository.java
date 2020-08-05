package com.coffeeprince.frequency.trade.repository;

import com.coffeeprince.frequency.trade.domain.TradeBoard;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TradeboardRepository extends JpaRepository<TradeBoard, Long> {
}
