package com.example.demospringrestdocs.product.api.document;

import com.example.demospringrestdocs.api.ProductApi;
import com.example.demospringrestdocs.api.document.ApiDocumentationTest;
import com.example.demospringrestdocs.application.ProductService;
import lombok.Builder;
import lombok.Getter;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.hateoas.MediaTypes;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.restdocs.payload.JsonFieldType;
import org.springframework.test.web.servlet.ResultActions;

import java.util.Arrays;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.springframework.restdocs.headers.HeaderDocumentation.headerWithName;
import static org.springframework.restdocs.headers.HeaderDocumentation.responseHeaders;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.post;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.*;
import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath;
import static org.springframework.restdocs.payload.PayloadDocumentation.requestFields;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ProductApi.class)
public class ProductDetailSaveDocumentTest extends ApiDocumentationTest {
    @MockBean
    private ProductService productService;

    @Test
    void save() throws Exception {
//        ProductDetailResponseDto productDetailResponseDto = ProductDetailResponseDto.builder()
//                .productNames()
//                .productImages()
//                .build()
        //given(productService.save(any(List.class))).willReturn()

        doNothing()
                .when(productService)
                .save(any());

        List<Request> requests = Arrays.asList(Request.builder()
                        .productId(1L)
                        .productDetailId(1L)
                        .build(),
                Request.builder()
                        .productId(2L)
                        .productDetailId(2L)
                        .build());

        ResultActions result = this.mockMvc.perform(
                post("/api/products/details")
                        .content(this.objectMapper.writeValueAsString(requests))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaTypes.HAL_JSON)
        );

        result
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(header().string(HttpHeaders.CONTENT_TYPE, MediaTypes.HAL_JSON_VALUE))
                .andDo(
                        document("product-details-save",
                                preprocessRequest(prettyPrint()),
                                preprocessResponse(prettyPrint()),
                                responseHeaders(
                                        headerWithName(HttpHeaders.CONTENT_TYPE).description("Content-type 헤더(hal+json)")
                                ),
                                requestFields(
                                        fieldWithPath("[].productId").type(JsonFieldType.NUMBER).description("product 아이디"),
                                        fieldWithPath("[].productDetailId").type(JsonFieldType.NUMBER).description("productDetail 아이디")
                                )
                        )
                );
    }

    @Getter
    public static class Request {
        private Long productId;
        private Long productDetailId;

        @Builder
        public Request(final Long productId, final Long productDetailId) {
            this.productId = productId;
            this.productDetailId = productDetailId;
        }
    }
}
