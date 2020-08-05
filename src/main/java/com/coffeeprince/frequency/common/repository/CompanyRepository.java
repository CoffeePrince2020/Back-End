package com.coffeeprince.frequency.common.repository;

import com.coffeeprince.frequency.common.domain.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company, Long> {

}