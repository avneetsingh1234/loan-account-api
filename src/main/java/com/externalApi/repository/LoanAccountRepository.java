package com.externalApi.repository;

import com.externalApi.model.LoanAccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoanAccountRepository
        extends JpaRepository<LoanAccountEntity, Long> {
}
