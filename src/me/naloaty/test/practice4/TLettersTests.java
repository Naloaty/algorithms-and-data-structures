package me.naloaty.test.practice4;

import me.naloaty.main.practice4.TLetters;
import org.junit.jupiter.api.Test;

public class TLettersTests {

    private final TLetters mTask;

    public TLettersTests() {
        mTask = new TLetters("Hello world!");
    }

    @Test
    void printTableTask() {
        System.out.println(mTask);
    }

    @Test
    void findLetterTask() {
        System.out.println("H: " + mTask.indexOf('H'));
        System.out.println("e: " + mTask.indexOf('e'));
        System.out.println("l: " + mTask.indexOf('l'));
        System.out.println("A: " + mTask.indexOf('A'));
    }
}
