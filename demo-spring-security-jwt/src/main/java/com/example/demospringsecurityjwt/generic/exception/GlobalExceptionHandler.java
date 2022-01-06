package com.example.demospringsecurityjwt.generic.exception;

import com.example.demospringsecurityjwt.generic.response.ApiResponseCode;
import com.example.demospringsecurityjwt.generic.response.error.ApiError;
import com.example.demospringsecurityjwt.generic.response.error.ApiSubError;
import com.example.demospringsecurityjwt.member.exception.MemberException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.orm.ObjectOptimisticLockingFailureException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingRequestHeaderException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolationException;
import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

  @ExceptionHandler(MissingRequestHeaderException.class)
  protected ResponseEntity<ApiError> handle(MissingRequestHeaderException e) {
    ApiError apiError = new ApiError(ApiResponseCode.MISSING_REQUEST_HEADER, ApiResponseCode.MISSING_REQUEST_HEADER.getMessage(), e);
    return new ResponseEntity<>(apiError, HttpStatus.BAD_REQUEST);
  }


  @ExceptionHandler(ConstraintViolationException.class)
  protected ResponseEntity<ApiError> handle(ConstraintViolationException e) {
    ApiError apiError = new ApiError(ApiResponseCode.BAD_REQUEST_HEADER, ApiResponseCode.BAD_REQUEST_HEADER.getMessage(), e);
    return new ResponseEntity<>(apiError, HttpStatus.BAD_REQUEST);
  }

  @ExceptionHandler(MethodArgumentNotValidException.class)
  protected ResponseEntity<ApiError> handle(MethodArgumentNotValidException e) {
    List<ApiSubError> subErrors =
        e.getBindingResult().getFieldErrors().stream()
            .map(
                fieldError ->
                    ApiSubError.builder()
                        .object(fieldError.getObjectName())
                        .field(fieldError.getField())
                        .rejectedValue(fieldError.getRejectedValue())
                        .message(fieldError.getDefaultMessage())
                        .build())
            .collect(Collectors.toList());

    ApiError apiError = new ApiError(ApiResponseCode.BAD_PARAMETER, "요청 Body 정보가 잘못되었습니다.", subErrors);
    return new ResponseEntity<>(apiError, HttpStatus.BAD_REQUEST);
  }

  @ExceptionHandler(ObjectOptimisticLockingFailureException.class)
  protected ResponseEntity<ApiError> handle(ObjectOptimisticLockingFailureException e) {
    ApiError apiError =
        new ApiError(
                ApiResponseCode.SERVER_ERROR, "일시적으로 받기 요청을 처리하지 못했습니다. 잠시 후 다시 시도해주세요.", e);
    return new ResponseEntity<>(apiError, HttpStatus.INTERNAL_SERVER_ERROR);
  }

  @ExceptionHandler(MemberException.class)
  protected ResponseEntity<ApiError> handle(MemberException e) {
    ApiError apiError = new ApiError(ApiResponseCode.BAD_PARAMETER, e.getLocalizedMessage(), e);
    return new ResponseEntity<>(apiError, HttpStatus.BAD_REQUEST);
  }

  @ExceptionHandler(Exception.class)
  protected ResponseEntity<ApiError> handle(Exception e) {
    e.printStackTrace();
    ApiError apiError = new ApiError(ApiResponseCode.SERVER_ERROR, "예기치 않은 예외가 발생하였습니다.", e);
    return new ResponseEntity<>(apiError, HttpStatus.INTERNAL_SERVER_ERROR);
  }
}
