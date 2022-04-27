package me.naloaty.test.practice2.linkedlist.utils;

import me.naloaty.main.practice2.linkedlist.Color;
import me.naloaty.main.practice2.linkedlist.Furniture;
import me.naloaty.main.practice2.linkedlist.SinglyLinkedList;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Mock {

    public static SinglyLinkedList<Furniture> mockFiveFurniture() {
        Calendar cal = new GregorianCalendar();
        cal.set(2010, Calendar.DECEMBER, 31, 14, 45, 57);

        String[] codes   = { "bbb", "aaa", "ddd", "ccc", "zzz"};
        String[] titles  = { "Chair", "Sofa", "Table", "Lamp", "Cabinet" };
        Color[]  colors  = { Color.BLACK, Color.WHITE, Color.GRAY, Color.INDIGO, Color.BLACK };
        double[] prices  = { 999, 2999.99, 499, 99, 799 };
        Date[]   dates   = new Date[5];
        int[]    amounts = { 1000, 500, 250, 150, 50 };

        for (int i = 0; i < 5; i++) {
            cal.add(Calendar.YEAR, -i);
            cal.add(Calendar.MONTH, i * 5);
            cal.add(Calendar.DAY_OF_MONTH, i);
            cal.add(Calendar.HOUR, i * 2);
            cal.add(Calendar.MINUTE, i * 3);
            cal.add(Calendar.SECOND, i * 4);
            dates[i] = cal.getTime();
        }

        SinglyLinkedList<Furniture> list = new SinglyLinkedList<>();

        for (int i = 0; i < 5; i++)
            list.add(new Furniture(codes[i], titles[i], colors[i], prices[i], dates[i], amounts[i]));

        System.out.println("Initial mock:");
        System.out.println(list);

        return list;
    }
}
