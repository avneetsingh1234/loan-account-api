package com.externalApi.controller;

import com.externalApi.dto.LoanResponse;
import com.externalApi.service.LoanService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/loan")
@RequiredArgsConstructor
public class LoanController {

    private final LoanService loanService;

    @GetMapping("/{loanAccountNumber}")
    public LoanResponse getLoan(@PathVariable String loanAccountNumber) {
        return loanService.getLoanDetails(loanAccountNumber);
    }
}

