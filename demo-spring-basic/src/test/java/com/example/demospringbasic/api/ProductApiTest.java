package com.example.demospringbasic.api;

import com.example.demospringbasic.application.dto.ProductCreateDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Builder;
import lombok.Getter;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import java.util.Arrays;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ProductApi.class)
class ProductApiTest {

    @Autowired
    protected MockMvc mockMvc;

    @Autowired
    protected ObjectMapper objectMapper;

    @DisplayName("파일이 포함된 productCreateDto 요청")
    @Test
    @Disabled
    void create() throws Exception {
        //given
        ProductCreateDto request = ProductCreateDto.builder()
                .productName("Brown Knit")
                .count(10)
                .imageCreateDtos(Arrays.asList(
                        ProductCreateDto.ImageCreateDto.builder()
                                .number(1)
                                .imageName("image01")
                                .deleted(true)
                                .build(),
                        ProductCreateDto.ImageCreateDto.builder()
                                .number(2)
                                .imageName("image02")
                                .build()
                ))
                .build();

        //when
        String requestUrl = "/api/products";
        ResultActions result = this.mockMvc.perform(
                post(requestUrl)
                        .content(this.objectMapper.writeValueAsString(request))
                        .contentType(MediaType.APPLICATION_JSON)
        );

        result.andDo(print())
                .andExpect(status().isOk());

    }

    @Test
    void find() throws Exception {

        //when
        String requestUrl = "/api/products";
        ResultActions result = this.mockMvc.perform(
                get(requestUrl)
                        .param("productId", "1")
                        .param("productDetailId", "2")
        );

        result.andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void findList() throws Exception {

        //when
        String requestUrl = "/api/products/list";
        ResultActions result = this.mockMvc.perform(
                get(requestUrl)
                        .param("productRequestDtos[0].productId", "1")
                        .param("productRequestDtos[0].productDetailId", "2")
                        .param("productRequestDtos[1].productId", "2")
                        .param("productRequestDtos[1].productDetailId", "5")
        );

        result.andDo(print())
                .andExpect(status().isOk());
    }



    @Getter
    @Builder
    public static class Request {
        private Long productId;
        private Long productDetailId;

    }
}