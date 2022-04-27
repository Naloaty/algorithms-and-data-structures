package me.naloaty.main.matrix;

public interface IMatrix<T> {

    int rows();
    int cols();

    boolean isSymmetric();
    boolean isStructureSymmetric(T background);
    boolean isSquare();

    T get(int n, int m);
    void set (int n, int m, T value);


}
