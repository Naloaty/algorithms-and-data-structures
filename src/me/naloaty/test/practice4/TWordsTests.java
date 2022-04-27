package me.naloaty.test.practice4;

import me.naloaty.main.practice4.TWords;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class TWordsTests {

    private final int mTableSize = 10;
    private final List<String> mWords = new ArrayList<>();

    public TWordsTests() throws IOException {
        Path path = Paths.get("D:/Test.txt");

        try (Stream<String> stream = Files.newBufferedReader(path).lines()) {
            stream.forEach(mWords::add);
        }
    }

    @Test
    void printTableTask()  {
        TWords words = new TWords(mTableSize);
        mWords.forEach(words::add);

        System.out.println(words);
    }

    @Test
    void findWordTask() {
        TWords words = new TWords(mTableSize);
        mWords.forEach(words::add);

        System.out.println("between: " + words.indexOf("last"));
        System.out.println("plant: " + words.indexOf("plant"));
        System.out.println("computer: " + words.indexOf("computer"));
    }

    @Test
    void compareCollisionsTask() {
        for (int i = 1; i < 200; i++) {
            TWords words = new TWords(i);
            mWords.forEach(words::add);

            System.out.println("Size " + i + ", collisions " + words.getCollisions());
        }
    }

    @Test
    void removeStartsOfTask() {
        TWords words = new TWords(mTableSize);
        mWords.forEach(words::add);

        for (String word : mWords) {
            if (word.startsWith("f"))
                words.remove(word);
        }

        System.out.println(words);
    }
}
