package com.example.demospringbasic.application.dto;

import com.example.demospringbasic.domain.ProductNumber;
import lombok.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

// Multipart 포함된 form-data 요청시 setter 필요
@Setter
@Getter
@NoArgsConstructor
public class ProductCreateDto {
    private String productName;

    private int count;

    private List<ImageCreateDto> imageCreateDtos;

    private ProductNumber productNumber;

    @Builder
    public ProductCreateDto(final String productName, final int count, final List<ImageCreateDto> imageCreateDtos, final ProductNumber productNumber) {
        this.productName = productName;
        this.count = count;
        this.imageCreateDtos = imageCreateDtos;
        this.productNumber = productNumber;
    }

    @Setter
    @Getter
    @NoArgsConstructor
    public static class ImageCreateDto {
        private String imageName;

        private int number;

        private boolean deleted;

        private MultipartFile imageFile;

        @Builder
        public ImageCreateDto(final String imageName, final int number, final boolean deleted, final MultipartFile imageFile) {
            this.imageName = imageName;
            this.number = number;
            this.deleted = deleted;
            this.imageFile = imageFile;
        }
    }
}
