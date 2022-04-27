package me.naloaty.test.practice2;

import me.naloaty.main.practice2.TStack;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TStackTests {

    int getRandomInt(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min) + min;
    }

    @Test
    void test1() {
        int[] arr = { 39, 85, 16, 47, 98, 98, 90, 69, 49, 16, 2 };

        assertEquals(2, TStack.count7of2(arr, 10));
    }

    @Test
    void test2() {
        int[] arr = { 20, 90, 72, 77, 8, 40, 53, 71, 9, 87 };

        assertEquals(2, TStack.count7of2(arr, 10));
    }

    @Test
    void test3() {
        int[] arr = { 78, 26, 82, 60, 42, 12, 70, 30, 25, 19 };

        assertEquals(1, TStack.count7of2(arr, 10));
    }
}
