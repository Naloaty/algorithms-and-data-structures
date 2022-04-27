package me.naloaty.test.practice2.linkedlist;

import me.naloaty.main.practice2.linkedlist.Furniture;
import me.naloaty.main.practice2.linkedlist.SinglyLinkedList;
import me.naloaty.test.practice2.linkedlist.utils.ListTool;
import me.naloaty.test.practice2.linkedlist.utils.Mock;
import org.junit.jupiter.api.Test;

import java.util.Calendar;
import java.util.GregorianCalendar;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class SearchTests {

    @Test
    void searchByCodeTest() {
        ListTool<Furniture> order = new ListTool<>();
        SinglyLinkedList<Furniture> list = Mock.mockFiveFurniture();
        order.rememberOrder(list);

        System.out.println("Search by code 'ccc' results:");
        SinglyLinkedList<Furniture> result = list.find((obj) -> obj.getCode().equals("ccc"));
        System.out.println(result);

        assertTrue(order.checkItems(result, new int[] { 3 }));
    }

    @Test
    void searchByAmountInStock() {
        ListTool<Furniture> order = new ListTool<>();
        SinglyLinkedList<Furniture> list = Mock.mockFiveFurniture();
        order.rememberOrder(list);

        System.out.println("Search by amount in stock '> 300' results:");
        SinglyLinkedList<Furniture> result = list.find((obj) -> obj.getAmountInStock() > 300);
        System.out.println(result);

        assertTrue(order.checkItems(result, new int[] { 0, 1 }));
    }

    @Test
    void searchByManufactureDate() {
        ListTool<Furniture> order = new ListTool<>();
        SinglyLinkedList<Furniture> list = Mock.mockFiveFurniture();
        order.rememberOrder(list);

        Calendar cal = new GregorianCalendar();
        cal.set(2009, Calendar.APRIL, 3);

        System.out.println("Search by manufacture date after 'Apr 02, 2009' results:");
        SinglyLinkedList<Furniture> result = list.find((obj) -> obj.getManufactureDate().compareTo(cal.getTime()) > 0);
        System.out.println(result);

        assertTrue(order.checkItems(result, new int[] { 0, 1, 2 }));
    }


}
