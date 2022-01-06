package com.example.demojavabasic;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

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
}
