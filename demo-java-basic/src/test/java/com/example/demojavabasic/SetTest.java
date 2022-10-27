package com.example.demojavabasic;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

public class SetTest {

    @Test
    void test1() {
        Set<Long> set = new HashSet<>();
        set.add(1L);
        set.add(3L);
        set.add(5L);
        set.add(7L);

        Set<Long> set2 = new HashSet<>();
        set2.add(5L);
        set2.add(3L);

        set.removeAll(set2);

        System.out.println(set.toString());
    }
}
