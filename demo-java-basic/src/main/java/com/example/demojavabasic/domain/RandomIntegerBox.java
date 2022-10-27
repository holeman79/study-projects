package com.example.demojavabasic.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RandomIntegerBox {
    private List<Integer> mobilities;

    public RandomIntegerBox() {
        mobilities = new ArrayList<>();
        for (int i = 1; i < 104; i++) {
            mobilities.add(i);
        }
    }

    public List<Integer> getRandomNumbers(final Integer value) {
        Collections.shuffle(mobilities);

        List<Integer> integers = new ArrayList<>(mobilities.subList(0, value));
        mobilities.removeAll(integers);
        return integers;
    }
}
