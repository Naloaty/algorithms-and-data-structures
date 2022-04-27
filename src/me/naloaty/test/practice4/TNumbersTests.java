package me.naloaty.test.practice4;

import me.naloaty.main.practice4.TNumbers;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class TNumbersTests {

    private final int mTableSize = 17;

    private final List<Integer> mBundle1 = new ArrayList<>();
    private final List<Integer> mBundle2 = new ArrayList<>();
    private final List<Integer> mBundle3 = new ArrayList<>();


    public TNumbersTests() throws IOException {
        Path bundle1 = Paths.get("D:/Test2.txt");
        Path bundle2 = Paths.get("D:/Test3.txt");
        Path bundle3 = Paths.get("D:/Test4.txt");

        try (Stream<String> stream = Files.newBufferedReader(bundle1).lines()) {
            stream.forEach(num -> mBundle1.add(Integer.parseInt(num)));
        }

        try (Stream<String> stream = Files.newBufferedReader(bundle2).lines()) {
            stream.forEach(num -> mBundle2.add(Integer.parseInt(num)));
        }

        try (Stream<String> stream = Files.newBufferedReader(bundle3).lines()) {
            stream.forEach(num -> mBundle3.add(Integer.parseInt(num)));
        }
    }

    @Test
    void printTableTask() {
        TNumbers nums = new TNumbers(mTableSize);
        mBundle1.forEach(nums::add);

        System.out.println(nums);
    }

    @Test
    void searchNumberTask() {
        TNumbers nums = new TNumbers(mTableSize);
        mBundle1.forEach(nums::add);

        System.out.println("2479: " + nums.indexOf(2479));
        System.out.println("2693: " + nums.indexOf(2693));
        System.out.println("2771: " + nums.indexOf(2771));
    }

    @Test
    void compareBundles() {
        TNumbers nums1 = new TNumbers(mTableSize);
        mBundle1.forEach(nums1::add);

        TNumbers nums2 = new TNumbers(mTableSize);
        mBundle2.forEach(nums2::add);

        TNumbers nums3 = new TNumbers(mTableSize);
        mBundle3.forEach(nums3::add);

        System.out.printf("Bundle 1, collisions %d%n", nums1.getCollisions());
        System.out.printf("Bundle 2, collisions %d%n", nums2.getCollisions());
        System.out.printf("Bundle 3, collisions %d%n", nums2.getCollisions());
    }
}
