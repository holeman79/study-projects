package com.example.demospringrestdocs.application.dto.response;

import com.example.demospringrestdocs.domain.Category;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
public class ProductDetailResponseDto {
    private List<ProductImage> productImages;

    private List<String> productNames;

    @Builder
    private ProductDetailResponseDto(final List<ProductImage> productImages, final List<String> productNames) {
        this.productImages = productImages;
        this.productNames = productNames;
    }

    @Getter
    public static class ProductImage {
        private Category category;

        private String fileName;

        private String storedFilePath;

        @Builder
        private ProductImage(final Category category, final String fileName, final String storedFilePath) {
            this.category = category;
            this.fileName = fileName;
            this.storedFilePath = storedFilePath;
        }
    }
}
