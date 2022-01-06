package com.example.demospringrestdocs.application;

import com.example.demospringrestdocs.application.dto.request.ProductDetailRequestDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    public void save(final List<ProductDetailRequestDto> productDetailRequestDto) {
        //return ProductDetailResponseDto.builder().build();
    }
}
