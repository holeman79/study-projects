package com.example.demospringbasic.config;

import com.example.demospringbasic.exception.MembershipException;
import com.example.demospringbasic.response.ApiResponseCode;
import com.example.demospringbasic.response.error.ApiError;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.orm.ObjectOptimisticLockingFailureException;
import org.springframework.web.bind.MissingRequestHeaderException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

  @ExceptionHandler(MissingRequestHeaderException.class)
  protected ResponseEntity<ApiError> handle(MissingRequestHeaderException e) {
    ApiError apiError = new ApiError(ApiResponseCode.MISSING_REQUEST_HEADER, ApiResponseCode.MISSING_REQUEST_HEADER.getMessage(), e);
    return new ResponseEntity<>(apiError, HttpStatus.BAD_REQUEST);
  }

  @ExceptionHandler(ObjectOptimisticLockingFailureException.class)
  protected ResponseEntity<ApiError> handle(ObjectOptimisticLockingFailureException e) {
    ApiError apiError =
        new ApiError(
                ApiResponseCode.SERVER_ERROR, "일시적으로 받기 요청을 처리하지 못했습니다. 잠시 후 다시 시도해주세요.", e);
    return new ResponseEntity<>(apiError, HttpStatus.INTERNAL_SERVER_ERROR);
  }

  @ExceptionHandler(MembershipException.class)
  protected ResponseEntity<ApiError> handle(MembershipException e) {
    ApiError apiError = new ApiError(ApiResponseCode.BAD_PARAMETER, e.getLocalizedMessage(), e);
    return new ResponseEntity<>(apiError, HttpStatus.BAD_REQUEST);
  }

  @ExceptionHandler(Exception.class)
  protected ResponseEntity<ApiError> handle(Exception e) {
    e.printStackTrace();
    ApiError apiError = new ApiError(ApiResponseCode.SERVER_ERROR, ApiResponseCode.SERVER_ERROR.getMessage(), e);
    return new ResponseEntity<>(apiError, HttpStatus.INTERNAL_SERVER_ERROR);
  }
}
