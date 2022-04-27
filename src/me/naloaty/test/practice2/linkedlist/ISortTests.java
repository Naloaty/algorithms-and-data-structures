package me.naloaty.test.practice2.linkedlist;

import me.naloaty.main.practice2.linkedlist.Furniture;
import me.naloaty.main.practice2.linkedlist.SinglyLinkedList;
import me.naloaty.test.practice2.linkedlist.utils.ListTool;
import me.naloaty.test.practice2.linkedlist.utils.Mock;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Comparator;

public class ISortTests {

    @Test
    void sortByCodeTest() {
        ListTool<Furniture> order = new ListTool<>();
        SinglyLinkedList<Furniture> list = Mock.mockFiveFurniture();;
        order.rememberOrder(list);

        list.sort(new Furniture.CodeComparator());

        System.out.println("After sorting by code:");
        System.out.println(list);

        assertTrue(order.checkOrder(list, new int[] { 1, 0, 3, 2, 4 }));
    }

    @Test
    void sortByManufactureDateTest() {
        ListTool<Furniture> order = new ListTool<>();
        SinglyLinkedList<Furniture> list = Mock.mockFiveFurniture();
        order.rememberOrder(list);

        list.sort(new Furniture.DateComparator());

        System.out.println("After sorting by manufacture date:");
        System.out.println(list);

        assertTrue(order.checkOrder(list, new int[] { 4, 3, 2, 1, 0 }));
    }

    @Test
    void sortByAmountInStockTest() {
        ListTool<Furniture> order = new ListTool<>();
        SinglyLinkedList<Furniture> list = Mock.mockFiveFurniture();
        order.rememberOrder(list);

        list.sort(new Furniture.AmountComparator());

        System.out.println("After sorting by amount in stock:");
        System.out.println(list);

        assertTrue(order.checkOrder(list, new int[] { 4, 3, 2, 1, 0}));
    }

    @Test
    void sortByCodeThenByAmountInStockSortTest() {
        ListTool<Furniture> order = new ListTool<>();
        SinglyLinkedList<Furniture> list = Mock.mockFiveFurniture();
        order.rememberOrder(list);

        Comparator<Furniture> byCode = new Furniture.CodeComparator();
        Comparator<Furniture> byAmount = new Furniture.AmountComparator();
        Comparator<Furniture> combined = byCode.thenComparing(byAmount);

        list.sort(combined);

        System.out.println("After initial sorting by code, then by amount in stock:");
        System.out.println(list);

        assertTrue(order.checkOrder(list, new int[] { 1, 0, 3, 2, 4 }));
    }
}
