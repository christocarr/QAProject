package com.christocarr.qaproject.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class ErrorDetails {
  private String timestamp;
  private String message;
  private String details;

  public ErrorDetails(Date timestamp, String message, String details) {
    this.timestamp = timestamp.toString();
    this.message = message;
    this.details = details;
  }
}
