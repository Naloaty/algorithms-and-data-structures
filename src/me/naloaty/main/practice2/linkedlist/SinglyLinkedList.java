package me.naloaty.main.practice2.linkedlist;

import java.util.Comparator;

public class SinglyLinkedList<T> {
    private Node<T> head;
    private int size = 0;

    public int size() {
        return size;
    }

    public void add(T element) {
        Node<T> node = new Node<>(element);

        if (head == null) {
            head = node;
        }
        else {
            Node<T> current = head;

            while (current.next != null) {
                current = current.next;
            }

            current.next = node;
        }

        size++;
    }


    private Node<T> getNode(int index) {
        if (size() == 0)
            throw new IndexOutOfBoundsException();

        Node<T> current = head;
        int i = 0;

        while (i < index) {
            current = current.next;
            i++;
        }

        return current;
    }

    public T get(int index) {
        if (index < 0 || index >= size())
            throw new IndexOutOfBoundsException();

        return getNode(index).data;
    }

    public void set(int index, T element) {
        if (index < 0 || index >= size())
            throw new IndexOutOfBoundsException();

        getNode(index).data = element;
    }

    public void remove(int index) {
        if (index < 0 || index >= size())
            throw new IndexOutOfBoundsException();

        Node<T> before = getNode(index - 1);
        before.next = before.next.next;

        size--;
    }

    // BubbleSort
    public void sort(Comparator<? super T> c) {
        if (size() <= 1)
            return;

        for (int i = 0; i < size(); i++) {
            Node<T> n1 = head;
            Node<T> n2 = head.next;

            if (c.compare(n1.data, n2.data) > 0) {
                head = n2;
                n1.next = n2.next;
                n2.next = n1;
            }

            Node<T> p = head;

            while (p.next.next != null) {
                n1 = p.next;
                n2 = p.next.next;

                if (c.compare(n1.data, n2.data) > 0) {
                    p.next = n2;
                    p = n2;
                    n1.next = n2.next;
                    n2.next = n1;
                }
                else {
                    p = n1;
                }
            }
        }
    }

    public SinglyLinkedList<T> find(Search<T> params) {
        SinglyLinkedList<T> matches = new SinglyLinkedList<>();

        for (Node<T> i = head; i != null; i = i.next) {
            if (params.matches(i.data))
                matches.add(i.data);
        }

        return matches;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        int num = 1;

        for (Node<T> i = head; i != null; i = i.next) {
            builder.append(String.format("%d) %s; \n", num, i.data.toString()));
            num++;
        }

        return builder.toString();
    }

    static class Node<T> {
        T data;
        Node<T> next;

        public Node(T data) {
            this.data = data;
        }
    }

    public interface Search<T> {
        boolean matches(T obj);
    }
}
