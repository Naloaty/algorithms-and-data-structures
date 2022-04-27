package me.naloaty.test.practice3;

import me.naloaty.main.practice3.TQueue;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class TQueueTests {

    @Test
    void test1() {
        Queue<Integer> mock = new LinkedList<>(Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10));

        TQueue.removeEven(mock);

        Assertions.assertArrayEquals(new Integer[] { 1, 3, 5, 7, 9 }, mock.toArray());
    }

    @Test
    void test2() {
        Queue<Integer> mock = new LinkedList<>(Arrays.asList(0, -1, -2, -3, -4, -5, -6, -7, -8, -9, -10));

        TQueue.removeEven(mock);

        Assertions.assertArrayEquals(new Integer[] { -1, -3, -5, -7, -9 }, mock.toArray());
    }

    @Test
    void test3() {
        Queue<Integer> mock = new LinkedList<>(Arrays.asList(0, 0, 0, 0, 0));

        TQueue.removeEven(mock);

        Assertions.assertArrayEquals(new Integer[0], mock.toArray());
    }

    @Test
    void test4() {
        Queue<Integer> mock = new LinkedList<>(Arrays.asList(1, 1, 1, 1, 1));

        TQueue.removeEven(mock);

        Assertions.assertArrayEquals(new Integer[] {1, 1, 1, 1, 1}, mock.toArray());
    }
}
