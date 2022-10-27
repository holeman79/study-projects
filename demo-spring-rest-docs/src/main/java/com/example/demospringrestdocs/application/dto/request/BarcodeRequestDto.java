package com.example.demospringrestdocs.application.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor // 이게 없으면 값이 들어가지 않음.
public class BarcodeRequestDto {
    private Long memberId;
}
