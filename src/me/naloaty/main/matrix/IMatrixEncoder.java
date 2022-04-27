package me.naloaty.main.matrix;

import java.util.Map;

public interface IMatrixEncoder<T> {

    void encode(IMatrix<T> m);

    Map<String, T[]> getValues(T[] a);
    Map<String, int[]> getIndexes();
}
