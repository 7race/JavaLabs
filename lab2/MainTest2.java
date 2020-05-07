package com.andrey.lab2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainTest2 {
    @Test
    @DisplayName("check min from three method")
    void min() {
        assertEquals(Main.min(100, 243, 31), 31);
        assertEquals(Main.min(0, 0, 0), 0);
    }
}
