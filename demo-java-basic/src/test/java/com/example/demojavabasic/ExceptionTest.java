package com.example.demojavabasic;

import org.junit.jupiter.api.Test;

public class ExceptionTest {
    @Test
    void throwRuntimeException() {
        throw new RuntimeException("런타임 exception");
    }

    @Test
    void throwIllegalException() {
        throw new IllegalArgumentException("IllegalArgument exception");
    }
}
