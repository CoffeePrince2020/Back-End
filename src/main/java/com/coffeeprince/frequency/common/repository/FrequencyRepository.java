package com.coffeeprince.frequency.common.repository;

import com.coffeeprince.frequency.common.domain.Frequency;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FrequencyRepository extends JpaRepository<Frequency, Long> {
}
