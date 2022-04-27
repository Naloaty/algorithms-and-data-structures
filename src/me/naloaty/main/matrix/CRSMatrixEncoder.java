package me.naloaty.main.matrix;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* Compressed Row Storage (CRS) matrix encoder */

public class CRSMatrixEncoder<T> implements IMatrixEncoder<T> {

    public static final String VALUE = "VALUE";
    public static final String COL = "COL";
    public static final String ROW_INDEX = "ROW_INDEX";

    private final Map<String, List<T>>       values  = new HashMap<>();
    private final Map<String, List<Integer>> indexes = new HashMap<>();

    private final T background;
    private final boolean upperTriangle;

    public CRSMatrixEncoder(T background, boolean upperTriangle) {
        this.background = background;
        this.upperTriangle = upperTriangle;
    }


    @Override
    public void encode(IMatrix<T> m) {
        values.clear();
        indexes.clear();

        List<T> value = new ArrayList<>();
        List<Integer> col = new ArrayList<>();
        List<Integer> rowIndex = new ArrayList<>();

        boolean symmetric = m.isSymmetric();
        boolean firstElement;
        int emptyRows = 0;
        int valueToDuplicate = 0;

        for (int i = 0; i < m.rows(); i++) {
            firstElement = true;

            for (int j = 0; j < m.cols(); j++) {
                T v = m.get(i, j);

                if (v.equals(background))
                    continue;

                boolean triangle = upperTriangle ? i > j : i < j;

                if (symmetric && triangle)
                    continue;

                col.add(j);
                value.add(v);

                if (firstElement) {
                    rowIndex.add(value.size());
                    valueToDuplicate = value.size();
                    firstElement = false;
                }
            }

            if (firstElement) {
                emptyRows += 1;
            }
            else {
                while (emptyRows != 0) {
                    rowIndex.add(valueToDuplicate);
                    emptyRows--;
                }
            }
        }

        valueToDuplicate = value.size() + 1;

        rowIndex.add(valueToDuplicate);

        while (emptyRows != 0) {
            rowIndex.add(valueToDuplicate);
            emptyRows--;
        }

        values.put(VALUE, value);
        indexes.put(COL, col);
        indexes.put(ROW_INDEX, rowIndex);
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
        map.put(COL, indexes.get(COL).stream().mapToInt(i -> i).toArray());
        map.put(ROW_INDEX, indexes.get(ROW_INDEX).stream().mapToInt(i -> i).toArray());

        return map;
    }
}
