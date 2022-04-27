package me.naloaty.main.practice2.linkedlist;

import java.util.Comparator;
import java.util.Date;

public class Furniture {

    private final String code; // sort, search
    private final String title;
    private final Color color;
    private final double price;
    private final Date manufactureDate; // sort, search
    private final int amountInStock; // sort, search

    public Furniture(String code, String title, Color color, double price, Date manufactureDate, int amountInStock) {
        this.code = code;
        this.title = title;
        this.color = color;
        this.price = price;
        this.manufactureDate = manufactureDate;
        this.amountInStock = amountInStock;
    }

    public String getCode() {
        return code;
    }

    public String getTitle() {
        return title;
    }

    public Color getColor() {
        return color;
    }

    public double getPrice() {
        return price;
    }

    public Date getManufactureDate() {
        return manufactureDate;
    }

    public int getAmountInStock() {
        return amountInStock;
    }

    @Override
    public String toString() {
        return String.format(
                "%s, %s, %s, %f, %tc, %d",
                code, title, color.toString(), price, manufactureDate, amountInStock);
    }

    public static class CodeComparator implements Comparator<Furniture> {

        @Override
        public int compare(Furniture o1, Furniture o2) {

            if (o1 != null && o2 == null)
                return 1;

            if (o1 == null && o2 == null)
                return 0;

            if (o1 == null && o2 != null)
                return -1;

            return o1.code.compareTo(o2.code);
        }
    }

    public static class AmountComparator implements Comparator<Furniture> {

        @Override
        public int compare(Furniture o1, Furniture o2) {

            if (o1 != null && o2 == null)
                return 1;

            if (o1 == null && o2 == null)
                return 0;

            if (o1 == null && o2 != null)
                return -1;

            return o1.amountInStock - o2.amountInStock;
        }
    }

    public static class DateComparator implements Comparator<Furniture> {

        @Override
        public int compare(Furniture o1, Furniture o2) {

            if (o1 != null && o2 == null)
                return 1;

            if (o1 == null && o2 == null)
                return 0;

            if (o1 == null && o2 != null)
                return -1;

            return o1.manufactureDate.compareTo(o2.manufactureDate);
        }
    }
}
