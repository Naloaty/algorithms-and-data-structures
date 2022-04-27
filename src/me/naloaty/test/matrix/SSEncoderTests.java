package me.naloaty.test.matrix;

import me.naloaty.main.matrix.IMatrixEncoder;
import me.naloaty.main.matrix.Matrix;
import me.naloaty.main.matrix.SSMatrixEncoder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Map;

public class SSEncoderTests {

    @Test
    void encodeTest1() {
        Integer[][] matrix = new Integer[][] {
                { 0, 2, 0, 1, 0, 0 },
                { 1, 0, 0, 0, 0, 0 },
                { 0, 0, 5, 0, 0, 0 },
                { 5, 0, 0, 7, 9, 1 },
                { 0, 0, 0, 4, 0, 0 },
                { 0, 0, 0, 4, 0, 3 },
        };

        IMatrixEncoder<Integer> c = new SSMatrixEncoder<>(0);
        c.encode(new Matrix<>(matrix));

        Map<String, Integer[]> v = c.getValues(new Integer[0]);
        Map<String, int[]> i = c.getIndexes();

        Integer[] value = v.get(SSMatrixEncoder.VALUE);
        Integer[] valueUp = v.get(SSMatrixEncoder.VALUE_UP);
        Integer[] valueDown = v.get(SSMatrixEncoder.VALUE_DOWN);
        int[] upJ = i.get(SSMatrixEncoder.UP_J);
        int[] upI = i.get(SSMatrixEncoder.UP_I);

        Assertions.assertArrayEquals(new Integer[] { 0, 0, 5, 7, 0, 3 }, value);
        Assertions.assertArrayEquals(new Integer[] { 2, 1, 9, 1 }, valueUp);
        Assertions.assertArrayEquals(new Integer[] { 1, 5, 4, 4 }, valueDown);

        Assertions.assertArrayEquals(new int[] { 1, 3, 4, 5 }, upJ); // Differ (-1) from lectures
        Assertions.assertArrayEquals(new int[] { 1, 3, 3, 3, 5, 5 }, upI);
    }

    @Test
    void encodeTest2() {
        Integer[][] matrix = new Integer[][] {
                { 3, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 8, 0, 0, 0, 1, 5, 0 },
                { 0, 0, 3, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 4, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 5, 3, 0, 0 },
                { 0, 7, 0, 0, 5, 1, 0, 0 },
                { 0, 8, 0, 0, 0, 0, 9, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 6 }
        };

        IMatrixEncoder<Integer> c = new SSMatrixEncoder<>(0);
        c.encode(new Matrix<>(matrix));

        Map<String, Integer[]> v = c.getValues(new Integer[0]);
        Map<String, int[]> i = c.getIndexes();

        Integer[] value = v.get(SSMatrixEncoder.VALUE);
        Integer[] valueUp = v.get(SSMatrixEncoder.VALUE_UP);
        Integer[] valueDown = v.get(SSMatrixEncoder.VALUE_DOWN);
        int[] upJ = i.get(SSMatrixEncoder.UP_J);
        int[] upI = i.get(SSMatrixEncoder.UP_I);

        Assertions.assertArrayEquals(new Integer[] { 3, 8, 3, 4, 5, 1, 9, 6 }, value);
        Assertions.assertArrayEquals(new Integer[] { 1, 5, 3 }, valueUp);
        Assertions.assertArrayEquals(new Integer[] { 7, 8, 5 }, valueDown);

        Assertions.assertArrayEquals(new int[] { 5, 6, 5 }, upJ);
        Assertions.assertArrayEquals(new int[] { 1, 1, 3, 3, 3, 4, 4, 4 }, upI);
    }
}
