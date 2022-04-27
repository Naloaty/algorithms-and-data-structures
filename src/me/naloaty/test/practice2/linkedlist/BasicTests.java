package me.naloaty.test.practice2.linkedlist;

import me.naloaty.main.practice2.linkedlist.SinglyLinkedList;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BasicTests {

    @Test
    void boundsTest() {
        SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
        assertThrows(IndexOutOfBoundsException.class, () -> list.get(0));
        assertThrows(IndexOutOfBoundsException.class, () -> list.get(1));
        assertThrows(IndexOutOfBoundsException.class, () -> list.get(-1));

        list.add(1);
        assertEquals(1, list.get(0));

        assertThrows(IndexOutOfBoundsException.class, () -> list.get(1));
    }

    @Test
    void addTest() {
        SinglyLinkedList<Integer> list = new SinglyLinkedList<>();

        assertEquals(0, list.size());

        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        assertEquals(5, list.size());

        assertEquals(5, list.size());
        assertEquals(1, list.get(0));
        assertEquals(5, list.get(4));

        list.add(6);

        assertEquals(6, list.size());
        assertEquals(6, list.get(5));
    }

    @Test
    void setTest() {
        SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        assertEquals(5, list.size());

        assertEquals(1, list.get(0));
        assertEquals(3, list.get(2));

        list.set(2, 42);
        assertEquals(42, list.get(2));

        list.set(0, 123);
        assertEquals(123, list.get(0));

        assertEquals(5, list.size());
    }

    @Test
    void removeTest() {
        SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        assertEquals(5, list.size());
        assertEquals(5, list.get(4));

        list.remove(4);

        assertEquals(4, list.size());
        assertThrows(IndexOutOfBoundsException.class, () -> list.get(4));

        assertEquals(2, list.get(1));
        list.remove(1);

        assertEquals(3, list.size());
        assertEquals(3, list.get(1));
    }
}
