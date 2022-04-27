package me.naloaty.test.practice1;

import me.naloaty.main.practice1.TArrays;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class TArraysTests {

    @Test
    void arraysTest1() {
        int[] data = { -2, -1, 0, 1, 2, 3 };
        int result = TArrays.findMinPositive(data);

        assertEquals(0, result);
    }

    @Test
    void arraysTest2() {
        int[] data = { 3, 2, 1, -1, -2, -3 };
        int result = TArrays.findMinPositive(data);

        assertEquals(1, result);
    }

    @Test
    void arraysTest3() {
        int[] data = { -1, -2, -3, -4, -5, -6 };
        int result = TArrays.findMinPositive(data);

        assertEquals(-1, result);
    }
}
