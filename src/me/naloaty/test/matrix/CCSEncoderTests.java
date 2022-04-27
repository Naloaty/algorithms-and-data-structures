package me.naloaty.test.matrix;

import me.naloaty.main.matrix.CCSMatrixEncoder;
import me.naloaty.main.matrix.IMatrixEncoder;
import me.naloaty.main.matrix.Matrix;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Map;

public class CCSEncoderTests {

    @Test
    void encodeSymmetricTest() {
        Integer[][] matrix = new Integer[][] {
                { 1, 0, 3, 0, 0, 1 },
                { 0, 5, 0, 0, 0, 0 },
                { 3, 0, 8, 0, 0, 0 },
                { 0, 0, 0, 3, 8, 0 },
                { 0, 0, 0, 8, 2, 0 },
                { 1, 0, 0, 0, 0, 7 },
        };

        IMatrixEncoder<Integer> c = new CCSMatrixEncoder<>(0, true);
        c.encode(new Matrix<>(matrix));

        Map<String, Integer[]> v = c.getValues(new Integer[0]);
        Map<String, int[]> i = c.getIndexes();


        Integer[] value = v.get(CCSMatrixEncoder.VALUE);
        int[] colIndex = i.get(CCSMatrixEncoder.COL_INDEX);
        int[] row = i.get(CCSMatrixEncoder.ROW);

        Assertions.assertArrayEquals(new int[] { 1, 2, 3, 5, 6, 8, 10 }, colIndex);
        Assertions.assertArrayEquals(new int[] { 0, 1, 0, 2, 3, 3, 4, 0, 5 }, row); // Differ (-1) from lectures
        Assertions.assertArrayEquals(new Integer[] { 1, 5, 3, 8, 3, 8, 2, 1, 7 }, value);
    }

    @Test
    void encodeAsymmetricTest() {
        Integer[][] matrix = new Integer[][] {
                { 0, 2, 0, 1, 0, 0 },
                { 0, 0, 0, 0, 0, 0 },
                { 0, 5, 0, 0, 0, 1 },
                { 0, 0, 0, 0, 9, 1 },
                { 0, 0, 0, 0, 0, 0 },
                { 0, 8, 0, 4, 0, 3 },
        };

        IMatrixEncoder<Integer> c = new CCSMatrixEncoder<>(0, false);
        c.encode(new Matrix<>(matrix));

        Map<String, Integer[]> v = c.getValues(new Integer[0]);
        Map<String, int[]> i = c.getIndexes();


        Integer[] value = v.get(CCSMatrixEncoder.VALUE);
        int[] colIndex = i.get(CCSMatrixEncoder.COL_INDEX);
        int[] row = i.get(CCSMatrixEncoder.ROW);

        Assertions.assertArrayEquals(new int[] { 1, 1, 4, 4, 6, 7, 10 }, colIndex);
        Assertions.assertArrayEquals(new int[] { 0, 2, 5, 0, 5, 3, 2, 3, 5 }, row); // Differ (-1) from lectures
        Assertions.assertArrayEquals(new Integer[] { 2, 5, 8, 1, 4, 9, 1, 1, 3 }, value);
    }
}
