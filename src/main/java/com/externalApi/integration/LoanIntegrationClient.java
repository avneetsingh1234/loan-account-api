package com.externalApi.integration;

import com.externalApi.dto.ExternalLoanResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Component
public class LoanIntegrationClient {

    private final RestTemplate restTemplate = new RestTemplate();

    public ExternalLoanResponse fetchLoanDetails(String loanAccountNumber) {
        String url = "https://demo9993930.mockable.io/loanaccount/" + loanAccountNumber;
        return restTemplate.getForObject(url, ExternalLoanResponse.class);
    }

}
