package com.andrey.lab1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    @DisplayName("check wright swap method")
    void swap() {
        int[] array = {1, 2, 3, 4, 5, 6};
        boolean swap = Main.swap(3, 4, array);
        assertTrue(swap);
        assertEquals(array[3], 5);
        assertEquals(array[4], 4);
    }
    @Test
    @DisplayName("check swap method with NULL")
    void swapNull(){
        assertThrows(NullPointerException.class, () -> Main.swap(0, 0, null));
    }

    @Test
    @DisplayName("check wrong swap method with the same indexes")
    void swapTheSameIndex(){
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        boolean swap = Main.swap(3, 3, array);
        assertTrue(swap);
    }

    @Test
    @DisplayName("check wrong swap method with incorrect indexes")
    void swapIndexOutOfBounds(){
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        boolean swap = Main.swap(6, 7, array);
        assertFalse(swap);
    }
}