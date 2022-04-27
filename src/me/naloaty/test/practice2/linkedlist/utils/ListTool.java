package me.naloaty.test.practice2.linkedlist.utils;

import me.naloaty.main.practice2.linkedlist.SinglyLinkedList;

import java.util.ArrayList;
import java.util.List;

public class ListTool<T> {

    private final List<Integer> order = new ArrayList<>();

    public void rememberOrder(SinglyLinkedList<T> list) {
        order.clear();

        for (int i = 0; i < list.size(); i++)
            order.add(list.get(i).hashCode());
    }

    public boolean checkOrder(SinglyLinkedList<T> list, int[] seq) {
        if (order.size() != seq.length)
            return false;

        for (int i = 0; i < seq.length; i++) {
            if (list.get(i).hashCode() != order.get(seq[i]))
                return false;
        }

        return true;
    }

    public boolean checkItems(SinglyLinkedList<T> items, int[] seq) {
        if (items.size() != seq.length)
            return false;

        for (int i = 0; i < seq.length; i++) {
            if (items.get(i).hashCode() != order.get(seq[i]))
                return false;
        }

        return true;
    }
}