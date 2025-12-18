package com.externalApi.dto;

import lombok.Data;

@Data
public class EmiDetail {

    private String month;
    private Integer emiAmount;
    private Boolean paidStatus;
    private Boolean dueStatus;
}
