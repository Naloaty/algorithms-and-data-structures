package me.naloaty.main.practice2.linkedlist;

public enum Color {
    WHITE(0),
    BLACK(1),
    GRAY(3),
    BROWN(4),
    INDIGO(5);

    private final int id;

    Color(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}