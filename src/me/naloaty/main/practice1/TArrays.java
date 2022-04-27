package me.naloaty.main.practice1;

public class TArrays {

    public static int findMinPositive(int[] array) {
        int min = Integer.MAX_VALUE;

        for (int i: array) {
            if (i < 0)
                continue;

            if (i <= min)
                min = i;
        }

        if (min != Integer.MAX_VALUE)
            return min;
        else
            return -1;
    }
}
