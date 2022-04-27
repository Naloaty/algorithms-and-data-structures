package me.naloaty.test.matrix;

import me.naloaty.main.matrix.COOMatrixEncoder;
import me.naloaty.main.matrix.IMatrixEncoder;
import me.naloaty.main.matrix.Matrix;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Map;


public class COOEncoderTests {

    @Test
    void encodeSymmetricTest() {
        Integer[][] matrix = new Integer[][] {
                { 2, 0, 0, 1, 0, 0, 0 },
                { 0, 3, 0, 0, 0, 0, 1 },
                { 0, 0, 4, 0, 0, 0, 0 },
                { 1, 0, 0, 5, 3, 0, 0 },
                { 0, 0, 0, 3, 7, 0, 0 },
                { 0, 0, 0, 0, 0, 8, 2 },
                { 0, 1, 0, 0, 0, 2, 6 }
        };

        COOMatrixEncoder<Integer> c = new COOMatrixEncoder<>(0, false);
        c.encode(new Matrix<>(matrix));

        Map<String, Integer[]> v = c.getValues(new Integer[0]);
        Map<String, int[]> i = c.getIndexes();

        Integer[] value = v.get(COOMatrixEncoder.VALUE);
        int[] row = i.get(COOMatrixEncoder.ROW);
        int[] col = i.get(COOMatrixEncoder.COL);

        Assertions.assertArrayEquals(new int[] { 0, 1 ,2 ,3, 3, 4, 4, 5, 6, 6, 6 }, row);
        Assertions.assertArrayEquals(new int[] { 0, 1 ,2 ,0, 3, 3, 4, 5, 1, 5, 6 }, col);
        Assertions.assertArrayEquals(new Integer[] { 2, 3, 4, 1, 5, 3, 7, 8, 1, 2, 6 }, value);
    }

    @Test
    void encodeAsymmetricTest1() {
        Integer[][] matrix = new Integer[][] {
                { 0, 0, 0, 0, 1 },
                { 8, 0, 0, 0, 0 },
                { 0, 0, 3, 0, 0 },
                { 0, 0, 0, 0, 0 },
                { 4, 0, 7, 0, 0 },
        };

        IMatrixEncoder<Integer> c = new COOMatrixEncoder<>(0, false);
        c.encode(new Matrix<>(matrix));

        Map<String, Integer[]> v = c.getValues(new Integer[0]);
        Map<String, int[]> i = c.getIndexes();

        Integer[] value = v.get(COOMatrixEncoder.VALUE);
        int[] row = i.get(COOMatrixEncoder.ROW);
        int[] col = i.get(COOMatrixEncoder.COL);

        Assertions.assertArrayEquals(new int[] { 0, 1, 2, 4, 4 }, row);
        Assertions.assertArrayEquals(new int[] { 4, 0, 2, 0, 2 }, col);
        Assertions.assertArrayEquals(new Integer[] { 1, 8, 3, 4, 7 }, value);
    }

    @Test
    void encodeAsymmetricTest2() {
        Integer[][] matrix = new Integer[][] {
                { 0, 0, 0, 0, 1 },
                { 8, 0, 0, 0, 0 },
                { 0, 0, 3, 0, 0 },
                { 0, 0, 0, 0, 0 },
                { 4, 0, 7, 0, 0 },
        };

        IMatrixEncoder<Integer> c = new COOMatrixEncoder<>(0, false);
        c.encode(new Matrix<>(matrix));

        Map<String, Integer[]> v = c.getValues(new Integer[0]);
        Map<String, int[]> i = c.getIndexes();

        Integer[] value = v.get(COOMatrixEncoder.VALUE);
        int[] row = i.get(COOMatrixEncoder.ROW);
        int[] col = i.get(COOMatrixEncoder.COL);

        Assertions.assertArrayEquals(new int[] { 0, 1, 2, 4, 4 }, row);
        Assertions.assertArrayEquals(new int[] { 4, 0, 2, 0, 2 }, col);
        Assertions.assertArrayEquals(new Integer[] { 1, 8, 3, 4, 7 }, value);
    }
}
