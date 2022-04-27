package me.naloaty.main.matrix;

import java.util.Arrays;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        Matrix<Integer> matrix = new Matrix<>(new Integer[][] {
                { 1, 0, 0, 0, 0, 0, 0 },
                { 0, 3, 0, 0, 8, 8, 0 },
                { 0, 0, 5, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0 },
                { 4, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 7 },
        });

        /* Available encoders:
         * COOMatrixEncoder - Coordinate Storage matrix encoder
         * CRSMatrixEncoder - Compressed Row Storage matrix encoder
         * CCSMatrixEncoder - Compressed Column Storage matrix encoder
         * SSMatrixEncoder  - Structure Symmetric matrix encoder
         */
        IMatrixEncoder<Integer> c = new CRSMatrixEncoder<>(0, false);


        c.encode(matrix);
        Map<String, Integer[]> v = c.getValues(new Integer[0]);
        Map<String, int[]> i = c.getIndexes();

        for (Map.Entry<String, Integer[]> entry : v.entrySet()) {
            System.out.print(entry.getKey());
            System.out.print(": ");
            System.out.print(Arrays.toString(entry.getValue()));
            System.out.println();
        }

        for (Map.Entry<String, int[]> entry : i.entrySet()) {
            System.out.print(entry.getKey());
            System.out.print(": ");
            System.out.print(Arrays.toString(entry.getValue()));
            System.out.println();
        }

    }
}
