package me.naloaty.test.practice1;

import me.naloaty.main.practice1.TStrings;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class TStringsTests {

    @Test
    void stringsTest1() {
        String from = "Hello, world!";
        String in = "Oh, Hi!";
        char result = TStrings.findFirstMatch(from, in);

        assertEquals('H', result);
    }

    @Test
    void stringsTest2() {
        String from = "Alice, Bob, and Charlie";
        String in = "What is 42?";
        char result = TStrings.findFirstMatch(from, in);

        assertEquals('i', result);
    }

    @Test
    void stringsTest3() {
        String from = "ABCD";
        String in = "EFG";
        char result = TStrings.findFirstMatch(from, in);

        assertEquals(0, result);
    }
}
