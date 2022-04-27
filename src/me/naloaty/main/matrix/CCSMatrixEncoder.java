package me.naloaty.main.matrix;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* Compressed Column Storage (CCS) matrix encoder */

public class CCSMatrixEncoder<T> implements IMatrixEncoder<T> {

    public static final String VALUE = "VALUE";
    public static final String ROW = "ROW";
    public static final String COL_INDEX = "COL_INDEX";

    private final Map<String, List<T>> values = new HashMap<>();
    private final Map<String, List<Integer>> indexes = new HashMap<>();

    private final T background;
    private final boolean upperTriangle;

    public CCSMatrixEncoder(T background, boolean upperTriangle) {
        this.background = background;
        this.upperTriangle = upperTriangle;
    }


    @Override
    public void encode(IMatrix<T> m) {
        values.clear();
        indexes.clear();

        List<T> value = new ArrayList<>();
        List<Integer> row = new ArrayList<>();
        List<Integer> colIndex = new ArrayList<>();

        boolean symmetric = m.isSymmetric();
        boolean firstElement;
        int emptyCols = 0;
        int valueToDuplicate = 0;

        for (int j = 0; j < m.cols(); j++) {
            firstElement = true;

            for (int i = 0; i < m.rows(); i++) {
                T v = m.get(i, j);

                if (v.equals(background))
                    continue;

                boolean triangle = upperTriangle ? i > j : i < j;

                if (symmetric && triangle)
                    continue;

                row.add(i);
                value.add(v);

                if (firstElement) {
                    colIndex.add(value.size());
                    valueToDuplicate = value.size();
                    firstElement = false;
                }
            }

            if (firstElement) {
                emptyCols += 1;
            } else {
                while (emptyCols != 0) {
                    colIndex.add(valueToDuplicate);
                    emptyCols--;
                }
            }
        }

        valueToDuplicate = value.size() + 1;

        colIndex.add(valueToDuplicate);

        while (emptyCols != 0) {
            colIndex.add(valueToDuplicate);
            emptyCols--;
        }

        values.put(VALUE, value);
        indexes.put(ROW, row);
        indexes.put(COL_INDEX, colIndex);
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
        map.put(COL_INDEX, indexes.get(COL_INDEX).stream().mapToInt(i -> i).toArray());

        return map;
    }

}
