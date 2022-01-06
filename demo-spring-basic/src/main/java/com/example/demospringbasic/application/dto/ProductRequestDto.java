package com.example.demospringbasic.application.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor // 이게 없으면 값이 들어가지 않음.
public class ProductRequestDto {
    private Long productId;

    private Long productDetailId;
}
