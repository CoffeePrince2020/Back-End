package com.coffeeprince.frequency.common.repository;

import com.coffeeprince.frequency.common.domain.FrequencyEventList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FrequencyEventListRepository extends JpaRepository<FrequencyEventList, Long> {
}
