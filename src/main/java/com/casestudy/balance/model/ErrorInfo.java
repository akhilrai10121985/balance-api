package com.casestudy.balance.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ErrorInfo {
    private String url;
    private String message;
}
