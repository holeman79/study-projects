package com.example.demospringbasic.api;

import com.example.demospringbasic.application.dto.ProductCreateDto;
import com.example.demospringbasic.application.dto.ProductRequestDto;
import com.example.demospringbasic.exception.MembershipException;
import com.example.demospringbasic.response.ApiResponseDto;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductApi {
    @PostMapping
    public ApiResponseDto<?> save(@ModelAttribute ProductCreateDto productCreateDto) {
        return ApiResponseDto.OK(productCreateDto);
    }

    @GetMapping
    public ApiResponseDto<?> findProduct(ProductRequestDto productRequestDto) {
        throw new MembershipException("illegal Argument Exception");
        //return ApiResponseDto.OK(productRequestDto);
    }

    @GetMapping("/list")
    public ApiResponseDto<?> findProducts( List<ProductRequestDto> productRequestDtos) {
        return ApiResponseDto.OK(productRequestDtos);
    }

    @GetMapping("/{id}")
    public void find(@PathVariable Long id) {
        System.out.println("id : " + id);
    }
}
