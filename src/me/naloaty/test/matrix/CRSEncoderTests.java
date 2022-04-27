package me.naloaty.test.matrix;

import me.naloaty.main.matrix.CRSMatrixEncoder;
import me.naloaty.main.matrix.IMatrixEncoder;
import me.naloaty.main.matrix.Matrix;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Map;

public class CRSEncoderTests {

    @Test
    void encodeSymmetricTest1() {
        Integer[][] matrix = new Integer[][] {
                { 2, 0, 0, 1, 0, 0, 0 },
                { 0, 3, 0, 0, 0, 0, 1 },
                { 0, 0, 4, 0, 0, 0, 0 },
                { 1, 0, 0, 5, 3, 0, 0 },
                { 0, 0, 0, 3, 7, 0, 0 },
                { 0, 0, 0, 0, 0, 8, 2 },
                { 0, 1, 0, 0, 0, 2, 6 }
        };

        IMatrixEncoder<Integer> c = new CRSMatrixEncoder<>(0, false);
        c.encode(new Matrix<>(matrix));

        Map<String, Integer[]> v = c.getValues(new Integer[0]);
        Map<String, int[]> i = c.getIndexes();

        Integer[] value = v.get(CRSMatrixEncoder.VALUE);
        int[] rowIndex = i.get(CRSMatrixEncoder.ROW_INDEX);
        int[] col = i.get(CRSMatrixEncoder.COL);

        Assertions.assertArrayEquals(new int[] { 1, 2, 3, 4, 6, 8, 9, 12 }, rowIndex);
        Assertions.assertArrayEquals(new int[] { 0, 1, 2, 0, 3, 3, 4, 5, 1, 5, 6 }, col);
        Assertions.assertArrayEquals(new Integer[] { 2, 3, 4, 1, 5, 3, 7, 8, 1, 2, 6 }, value);
    }

    @Test
    void encodeSymmetricTest2() {
        Integer[][] matrix = new Integer[][] {
                { 1, 0, 3, 0, 0, 1 },
                { 0, 5, 0, 0, 0, 0 },
                { 3, 0, 8, 0, 0, 0 },
                { 0, 0, 0, 3, 8, 0 },
                { 0, 0, 0, 8, 2, 0 },
                { 1, 0, 0, 0, 0, 7 },
        };

        IMatrixEncoder<Integer> c = new CRSMatrixEncoder<>(0, true);
        c.encode(new Matrix<>(matrix));

        Map<String, Integer[]> v = c.getValues(new Integer[0]);
        Map<String, int[]> i = c.getIndexes();

        Integer[] value = v.get(CRSMatrixEncoder.VALUE);
        int[] rowIndex = i.get(CRSMatrixEncoder.ROW_INDEX);
        int[] col = i.get(CRSMatrixEncoder.COL);

        Assertions.assertArrayEquals(new int[] { 1, 4, 5, 6, 8, 9, 10 }, rowIndex);
        Assertions.assertArrayEquals(new int[] { 0, 2, 5, 1, 2, 3, 4, 4, 5 }, col);
        Assertions.assertArrayEquals(new Integer[] { 1, 3, 1, 5, 8, 3, 8, 2, 7 }, value);
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

        IMatrixEncoder<Integer> c = new CRSMatrixEncoder<>(0, true);
        c.encode(new Matrix<>(matrix));

        Map<String, Integer[]> v = c.getValues(new Integer[0]);
        Map<String, int[]> i = c.getIndexes();

        Integer[] value = v.get(CRSMatrixEncoder.VALUE);
        int[] rowIndex = i.get(CRSMatrixEncoder.ROW_INDEX);
        int[] col = i.get(CRSMatrixEncoder.COL);

        Assertions.assertArrayEquals(new int[] { 1, 3, 3, 5, 7, 7, 10 }, rowIndex);
        Assertions.assertArrayEquals(new int[] { 1, 3, 1, 5, 4, 5, 1, 3, 5 }, col);
        Assertions.assertArrayEquals(new Integer[] { 2, 1, 5, 1, 9, 1, 8, 4, 3 }, value);
    }
}
