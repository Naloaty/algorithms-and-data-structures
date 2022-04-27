package me.naloaty.main.matrix;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* Structure Symmetric (SS) matrix encoder */

public class SSMatrixEncoder<T> implements IMatrixEncoder<T> {

    public static final String VALUE = "VALUE";
    public static final String VALUE_UP = "VALUE_UP";
    public static final String UP_J = "UP_J";
    public static final String VALUE_DOWN = "VALUE_DOWN";
    public static final String UP_I = "UP_I";

    private final Map<String, List<T>> values = new HashMap<>();
    private final Map<String, List<Integer>> indexes = new HashMap<>();

    private final T background;

    public SSMatrixEncoder(T background) {
        this.background = background;
    }

    @Override
    public void encode(IMatrix<T> m) {
        if (!m.isStructureSymmetric(background))
            throw new IllegalArgumentException("Given matrix is not Structure Symmetric");

        values.clear();
        indexes.clear();

        List<T> value = new ArrayList<>();
        List<T> valueUp = new ArrayList<>();
        List<Integer> upJ = new ArrayList<>();
        List<T> valueDown = new ArrayList<>();
        List<Integer> upI = new ArrayList<>();

        for (int i = 0; i < m.cols(); i++)
            value.add(m.get(i, i));

        boolean firstElement;
        int emptyRows = 0;
        int valueToDuplicate = 0;

        for (int i = 0; i < m.rows() - 1; i++) {
            firstElement = true;

            for (int j = 1; j < m.cols(); j++) {
                if (i >= j)
                    continue;

                T v = m.get(i, j);

                if (v.equals(background))
                    continue;

                valueUp.add(v);
                upJ.add(j);

                if (firstElement) {
                    upI.add(valueUp.size());
                    valueToDuplicate = valueUp.size();
                    firstElement = false;
                }
            }

            if (firstElement) {
                emptyRows += 1;
            }
            else {
                while (emptyRows != 0) {
                    upI.add(valueToDuplicate);
                    emptyRows--;
                }
            }
        }

        valueToDuplicate = valueUp.size() + 1;

        upI.add(valueToDuplicate);

        while (emptyRows != 0) {
            upI.add(valueToDuplicate);
            emptyRows--;
        }

        for (int j = 0; j < m.cols() - 1; j++) {
            for (int i = 1; i < m.rows(); i++) {
                if (i <= j)
                    continue;

                T v = m.get(i, j);

                if (v.equals(background))
                    continue;

                valueDown.add(v);
            }
        }

        values.put(VALUE, value);
        values.put(VALUE_UP, valueUp);
        values.put(VALUE_DOWN, valueDown);

        indexes.put(UP_J, upJ);
        indexes.put(UP_I, upI);
    }

    @Override
    public Map<String, T[]> getValues(T[] a) {
        Map<String, T[]> map = new HashMap<>();
        map.put(VALUE, values.get(VALUE).toArray(a));
        map.put(VALUE_UP, values.get(VALUE_UP).toArray(a));
        map.put(VALUE_DOWN, values.get(VALUE_DOWN).toArray(a));

        return map;
    }

    @Override
    public Map<String, int[]> getIndexes() {
        Map<String, int[]> map = new HashMap<>();
        map.put(UP_J, indexes.get(UP_J).stream().mapToInt(i -> i).toArray());
        map.put(UP_I, indexes.get(UP_I).stream().mapToInt(i -> i).toArray());

        return map;
    }
}
