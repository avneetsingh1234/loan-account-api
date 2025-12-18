package com.externalApi.service;

import com.externalApi.dto.EmiDetail;
import com.externalApi.dto.ExternalLoanResponse;
import com.externalApi.dto.LoanResponse;
import com.externalApi.integration.LoanIntegrationClient;
import com.externalApi.model.LoanAccountEntity;
import com.externalApi.repository.LoanAccountRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;

@Slf4j
@Service
@RequiredArgsConstructor
public class LoanService {

    private final LoanIntegrationClient integrationClient;
    private final LoanAccountRepository repository;

    public LoanResponse getLoanDetails(String loanAccountNumber) {

        ExternalLoanResponse externalResponse =
                integrationClient.fetchLoanDetails(loanAccountNumber);

        log.info("External response: {}", externalResponse);
        EmiDetail dueEmi = externalResponse.getEmiDetails().stream()
                .filter(EmiDetail::getDueStatus)
                .findFirst()
                .orElseThrow(() -> new RuntimeException("No due EMI found"));

        LocalDate dueDate = YearMonth
                .parse(dueEmi.getMonth(), DateTimeFormatter.ofPattern("MMMM yyyy"))
                .atDay(15);

        // 3️⃣ Save to DB
        LoanAccountEntity entity = LoanAccountEntity.builder()
                .loanAccountNumber(externalResponse.getLoanAccountNumber())
                .dueDate(dueDate)
                .emiAmount(dueEmi.getEmiAmount())
                .build();

        repository.save(entity);

        // 4️⃣ Return API response
        return LoanResponse.builder()
                .loanAccountNumber(entity.getLoanAccountNumber())
                .dueDate(entity.getDueDate())
                .emiAmount(entity.getEmiAmount())
                .build();
    }

}
