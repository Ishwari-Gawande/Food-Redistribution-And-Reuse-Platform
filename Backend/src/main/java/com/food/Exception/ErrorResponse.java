package com.food.Exception;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
@AllArgsConstructor
@Getter
@Setter
public class ErrorResponse {
private LocalDate timestamp;
private int status;
private String error;
private String message;
private String path;
}
