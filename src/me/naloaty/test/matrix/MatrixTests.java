package me.naloaty.test.matrix;

import me.naloaty.main.matrix.IMatrix;
import me.naloaty.main.matrix.Matrix;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MatrixTests {

    private static final Integer[][] matrix = new Integer[][] {
            { 2, 0, 0, 1, 0, 0, 0 },
            { 0, 3, 0, 0, 0, 0, 1 },
            { 0, 0, 4, 0, 0, 0, 0 },
            { 1, 0, 0, 5, 3, 0, 0 },
            { 0, 0, 0, 3, 7, 0, 0 },
            { 0, 0, 0, 0, 0, 8, 2 },
            { 0, 1, 0, 0, 0, 2, 6 }
    };

    @Test
    void createFromArrayTest1() {
        IMatrix<Integer> m = new Matrix<>(matrix);

        Assertions.assertEquals(7, m.rows());
        Assertions.assertEquals(7, m.cols());
        Assertions.assertTrue(m.isSquare());
        Assertions.assertTrue(m.isSymmetric());
        Assertions.assertTrue(m.isStructureSymmetric(0));
    }

    @Test
    void createFromArrayTest2() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Matrix<>(new Integer[0][0]));
    }

    @Test
    void createFromScratchTest() {
        IMatrix<Integer> m = new Matrix<>(2, 3, () -> new Integer(42));

        Assertions.assertEquals(2, m.rows());
        Assertions.assertEquals(3, m.cols());
        Assertions.assertFalse(m.isSquare());
        Assertions.assertFalse(m.isSymmetric());
        Assertions.assertEquals(42, m.get(0, 0));
        Assertions.assertNotSame(m.get(0, 0), m.get(0, 1));
    }

    @Test
    void createFromScratchTest2() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Matrix<>(0, 0, () -> new Integer(42)));
    }

    @Test
    void getTest() {
        IMatrix<Integer> m = new Matrix<>(matrix);

        Assertions.assertEquals(2, m.get(0, 0));
        Assertions.assertEquals(1, m.get(0, 3));

        Assertions.assertEquals(3, m.get(1, 1));
        Assertions.assertEquals(1, m.get(1, 6));

        Assertions.assertEquals(4, m.get(2, 2));

        Assertions.assertEquals(1, m.get(3, 0));
        Assertions.assertEquals(5, m.get(3, 3));
        Assertions.assertEquals(3, m.get(3, 4));

        Assertions.assertEquals(3, m.get(4, 3));
        Assertions.assertEquals(7, m.get(4, 4));

        Assertions.assertEquals(8, m.get(5, 5));
        Assertions.assertEquals(2, m.get(5, 6));

        Assertions.assertEquals(1, m.get(6, 1));
        Assertions.assertEquals(2, m.get(6, 5));
        Assertions.assertEquals(6, m.get(6, 6));
    }

    @Test
    void setTest() {
        IMatrix<Integer> m = new Matrix<>(matrix);

        m.set(2, 3, 42);

        Assertions.assertEquals(42, m.get(2, 3));
        Assertions.assertFalse(m.isSymmetric());
    }
}
