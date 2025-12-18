package com.externalApi.dto;

import lombok.Data;
import java.util.List;

@Data
public class ExternalLoanResponse {

    private String loanAccountNumber;
    private List<EmiDetail> emiDetails;
}
