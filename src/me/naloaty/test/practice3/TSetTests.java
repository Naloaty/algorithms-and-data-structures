package me.naloaty.test.practice3;

import me.naloaty.main.practice3.TSet;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

public class TSetTests {

    @Test
    void test1() {
        Set<String> names = new HashSet<>(List.of("Alice", "Bob", "Charlie", "Daniel"));

        List<List<String>> klasses = new ArrayList<>(List.of(
           List.of("Liam", "Oliver", "Bob", "James", "Daniel"),
           List.of("Alice", "Lucas", "Carol", "Daniel", "Robert", "Bob"),
           List.of("Bob", "Thomas", "Daniel", "Linda", "Donald"),
           List.of("Mary", "Richard", "Bob", "Daniel", "Lisa", "Oliver")
        ));

        Map<String, Set<String>> expected = new HashMap<>();

        expected.put(TSet.ALL,       new HashSet<>(List.of("Bob", "Daniel")));
        expected.put(TSet.PARTIALLY, new HashSet<>(List.of("Alice")));
        expected.put(TSet.NOT_FOUND, new HashSet<>(List.of("Charlie")));

        Assertions.assertEquals(expected, TSet.checkIfContains(names, klasses));
    }

    @Test
    void test2() {
        Set<String> names = new HashSet<>(List.of("Alice", "Bob", "Charlie", "Daniel"));

        List<List<String>> klasses = new ArrayList<>(List.of(
                List.of("Liam", "Oliver", "Karol", "James", "Kevin"),
                List.of("Lucas", "Carol", "Oliver", "Robert", "Liam")
        ));

        Map<String, Set<String>> expected = new HashMap<>();

        expected.put(TSet.ALL,       new HashSet<>());
        expected.put(TSet.PARTIALLY, new HashSet<>());
        expected.put(TSet.NOT_FOUND, new HashSet<>(List.of("Alice", "Bob", "Charlie", "Daniel")));

        Assertions.assertEquals(expected, TSet.checkIfContains(names, klasses));
    }

    @Test
    void test3() {
        Set<String> names = new HashSet<>(List.of("Alice", "Bob", "Charlie", "Daniel"));

        List<List<String>> klasses = new ArrayList<>(List.of(
                List.of("Liam", "Oliver", "Daniel"),
                List.of("Alice", "Lucas", "Carol", "Kevin"),
                List.of("Charlie", "Thomas", "Linda", "Donald"),
                List.of("Mary", "Richard", "Bob", "Lisa", "Oliver")
        ));

        Map<String, Set<String>> expected = new HashMap<>();

        expected.put(TSet.ALL,       new HashSet<>());
        expected.put(TSet.PARTIALLY, new HashSet<>(List.of("Alice", "Bob", "Charlie", "Daniel")));
        expected.put(TSet.NOT_FOUND, new HashSet<>());

        Assertions.assertEquals(expected, TSet.checkIfContains(names, klasses));
    }

    @Test
    void test4() {
        Set<String> names = new HashSet<>(List.of("Alice", "Bob", "Charlie", "Daniel"));

        List<List<String>> klasses = new ArrayList<>(List.of(
                List.of("Liam", "Oliver", "Daniel", "Alice", "Bob", "Charlie"),
                List.of("Alice", "Lucas", "Carol", "Kevin", "Bob", "Charlie", "Daniel"),
                List.of("Charlie", "Thomas", "Linda", "Donald", "Alice", "Bob", "Daniel"),
                List.of("Mary", "Richard", "Bob", "Lisa", "Oliver", "Alice", "Charlie", "Daniel")
        ));

        Map<String, Set<String>> expected = new HashMap<>();

        expected.put(TSet.ALL,       new HashSet<>(List.of("Alice", "Bob", "Charlie", "Daniel")));
        expected.put(TSet.PARTIALLY, new HashSet<>());
        expected.put(TSet.NOT_FOUND, new HashSet<>());

        Assertions.assertEquals(expected, TSet.checkIfContains(names, klasses));
    }
}
