package com.chozoi.test.domain.exception;

import lombok.Data;

import java.util.Date;
import java.util.Map;

@Data
public class ValidDetails {
    private String message;
    private Map<String, String> data;
    private String error;
    private String path;
    private Date timestamp;

}
