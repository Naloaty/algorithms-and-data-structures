package me.naloaty.main.matrix;

import java.util.ArrayList;
import java.util.List;

public class Matrix<T> implements IMatrix<T>{

    private final List<List<T>> data = new ArrayList<>();

    public Matrix(int n, int m, ICreator<T> initial) {
        if (n <= 0 || m <= 0)
            throw new IllegalArgumentException("Matrix size cannot be negative or zero");

        for (int i = 0; i < n; i++) {
            List<T> col = new ArrayList<>(m);

            for (int j = 0; j < m; j++) {
                col.add(initial.create());
            }

            data.add(col);
        }
    }

    public Matrix(T[][] matrix) {
        if (matrix == null)
            throw new IllegalArgumentException("Null cannot be represented as matrix");

        if (matrix.length == 0 || matrix[0].length == 0)
            throw new IllegalArgumentException("Zero-sized array cannot be represented as matrix");

        if (!isRectangular(matrix))
            throw new IllegalArgumentException("Only rectangular array can be represented as matrix");

        for (T[] t : matrix)
            data.add(new ArrayList<>(List.of(t)));
    }

    private boolean isRectangular(T[][] matrix) {
        int m = matrix[0].length;

        for (int i = 1; i < matrix.length; i++) {
            if (matrix[i].length != m)
                return false;
        }

        return true;
    }

    private boolean validIndexes(int n, int m) {
        if (n >= data.size() || m >= data.get(0).size())
            return false;

        if (n < 0 || m < 0)
            return false;

        return true;
    }

    @Override
    public int rows() {
        return data.size();
    }

    @Override
    public int cols() {
        return data.get(0).size();
    }

    @Override
    public boolean isSquare() {
        return rows() == cols();
    }

    @Override
    public boolean isSymmetric() {
        if (!isSquare())
            return false;

        for (int i = 0; i < data.size(); i++) {
            for (int j = 0; i > j; j++) {
                T ij = data.get(i).get(j);
                T ji = data.get(j).get(i);

                if (!ij.equals(ji))
                    return false;
            }
        }

        return true;
    }

    @Override
    public boolean isStructureSymmetric(T background) {
        if (!isSquare())
            return false;

        for (int i = 0; i < data.size(); i++) {
            for (int j = 0; i > j; j++) {
                T ij = data.get(i).get(j);
                T ji = data.get(j).get(i);

                if (!ij.equals(background) && ji.equals(background))
                    return false;

                if (ij.equals(background) && !ji.equals(background))
                    return false;
            }
        }

        return true;
    }

    @Override
    public T get(int n, int m) {
        if (!validIndexes(n, m))
            throw new IndexOutOfBoundsException();

        return data.get(n).get(m);
    }

    @Override
    public void set(int n, int m, T value) {
        if (!validIndexes(n, m))
            throw new IndexOutOfBoundsException();

        data.get(n).set(m, value);
    }
}
