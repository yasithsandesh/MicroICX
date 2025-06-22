package com.icx.microicx.finance_service.repo;

import com.icx.microicx.finance_service.entity.Renewal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Repository
@EnableJpaRepositories
public interface RenewalRepo extends JpaRepository<Renewal, Long> {
}
