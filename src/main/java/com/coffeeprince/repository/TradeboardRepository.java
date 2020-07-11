package com.coffeeprince.repository;

import com.coffeeprince.domain.Tradeboard;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TradeboardRepository extends JpaRepository<Tradeboard, Long> {
}
