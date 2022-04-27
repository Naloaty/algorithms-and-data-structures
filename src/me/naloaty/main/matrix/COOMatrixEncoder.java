package me.naloaty.main.matrix;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* Coordinate Storage (COO) matrix encoder */

public class COOMatrixEncoder<T> implements IMatrixEncoder<T> {

    public static final String VALUE = "VALUE";
    public static final String ROW = "ROW";
    public static final String COL = "COL";

    private final Map<String, List<T>>       values  = new HashMap<>();
    private final Map<String, List<Integer>> indexes = new HashMap<>();

    private final T background;
    private final boolean upperTriangle;

    public COOMatrixEncoder(T background, boolean upperTriangle) {
        this.background = background;
        this.upperTriangle = upperTriangle;
    }

    @Override
    public void encode(IMatrix<T> m) {
        values.clear();
        indexes.clear();

        List<T> value = new ArrayList<>();
        List<Integer> row = new ArrayList<>();
        List<Integer> col = new ArrayList<>();

        boolean symmetric = m.isSymmetric();

        for (int i = 0; i < m.rows(); i++) {
            for (int j = 0; j < m.cols(); j++) {
                T v = m.get(i, j);

                if (v.equals(background))
                    continue;

                boolean triangle = upperTriangle ? i > j : i < j;

                if (symmetric && triangle)
                    continue;

                row.add(i);
                col.add(j);
                value.add(v);
            }
        }

        values.put(VALUE, value);
        indexes.put(ROW, row);
        indexes.put(COL, col);
    }

    @Override
    public Map<String, T[]> getValues(T[] a) {
        Map<String, T[]> map = new HashMap<>();
        map.put(VALUE, values.get(VALUE).toArray(a));

        return map;
    }

    @Override
    public Map<String, int[]> getIndexes() {
        Map<String, int[]> map = new HashMap<>();
        map.put(ROW, indexes.get(ROW).stream().mapToInt(i -> i).toArray());
        map.put(COL, indexes.get(COL).stream().mapToInt(i -> i).toArray());

        return map;
    }
}
