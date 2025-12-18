package com.externalApi.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class LoanResponse {
    private String loanAccountNumber;
    private LocalDate dueDate;
    private Integer emiAmount;
}
