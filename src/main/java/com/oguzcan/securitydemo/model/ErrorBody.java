package com.oguzcan.securitydemo.model;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ErrorBody {


    private Integer errorCode;
    private String errorDescription;
}
