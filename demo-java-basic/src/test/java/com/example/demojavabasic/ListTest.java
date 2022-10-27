package com.example.demojavabasic;

import com.example.demojavabasic.domain.ProductType;
import com.example.demojavabasic.domain.RandomIntegerBox;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ListTest {

    @Test
    void list_modify() {
        List<String> resultTexts = new ArrayList<>();
        resultTexts.add("abc");
        resultTexts.add("def");
        String s = resultTexts.remove(resultTexts.size() - 1);
        resultTexts.add(s + "ghi");
        System.out.println(resultTexts);
    }

    @Test
    void list_filter() {
        List<ProductType> productTypes = Arrays.asList(ProductType.CLOTH, ProductType.HAT, ProductType.PANTS);
        List<ProductType> before = Arrays.asList(ProductType.CLOTH, ProductType.HAT);

        List<ProductType> collect = productTypes.stream()
                .filter(productType -> !before.contains(productType)).collect(Collectors.toList());
        System.out.println(collect);
        System.out.println(productTypes);
        System.out.println(before);

    }
    
    @Test
    void randomBoxTest() {
        RandomIntegerBox randomIntegerBox = new RandomIntegerBox();

        System.out.println(randomIntegerBox.getRandomNumbers(90));
        System.out.println(randomIntegerBox.getRandomNumbers(7));
        System.out.println(randomIntegerBox.getRandomNumbers(7));

    }
}
