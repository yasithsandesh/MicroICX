package com.icx.microicx.finance_service.repo;

import com.icx.microicx.finance_service.entity.Cost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
@EnableJpaRepositories
public interface CostRepo extends JpaRepository<Cost, Long> {
    List<Cost> findByDateBetween(LocalDate start, LocalDate end);
}
