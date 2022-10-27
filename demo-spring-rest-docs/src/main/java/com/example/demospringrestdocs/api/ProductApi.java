package com.example.demospringrestdocs.api;

import com.example.demospringrestdocs.application.dto.request.ProductDetailRequestDto;
import com.example.demospringrestdocs.response.ApiResponseDto;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductApi {

    @PostMapping("/details")
    public ApiResponseDto<?> saveProductDetails(@RequestBody List<ProductDetailRequestDto> productRequestDtos) {

        return ApiResponseDto.DEFAULT_OK;
    }

    @PostMapping
    public ApiResponseDto<?> save(@RequestBody String memberId) {
        System.out.println("Save");
        return ApiResponseDto.DEFAULT_OK;
    }
}
