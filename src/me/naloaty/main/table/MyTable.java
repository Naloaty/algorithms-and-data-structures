package me.naloaty.main.table;

import java.util.ArrayList;
import java.util.List;

public class MyTable {

    public enum Align {
        LEFT,
        CENTER,
        RIGHT
    }

    public List<String> mColumns;
    public List<Align> mAlignment;
    public List<Integer> mMaxWidth;
    public List<List<String>> mRows;

    public MyTable() {
        mColumns = new ArrayList<>();
        mAlignment = new ArrayList<>();
        mRows = new ArrayList<>();
        mMaxWidth = new ArrayList<>();
    }

    public void addColumn(String title, Align alignment) {
        if (title == null)
            throw new IllegalArgumentException("Column title cannot be null");

        if (alignment == null)
            throw new IllegalArgumentException("Column alignment cannot be null");

        if (title.isEmpty())
            throw new IllegalArgumentException("Column title cannot be empty");

        if (mRows.size() > 0)
            throw new IllegalStateException("Cannot add column to non-empty table");

        mColumns.add(title);
        mAlignment.add(alignment);
        mMaxWidth.add(title.length());
    }

    public void addColumn(String title) {
        addColumn(title, Align.LEFT);
    }

    public void addRow(List<String> args) {
        if (mColumns.size() == 0)
            throw new IllegalStateException("Table is not initialized: zero columns");

        if (mColumns.size() != args.size())
            throw new IllegalArgumentException(
                    String.format("Number of elements must be equal to the number of columns: %d != %d",
                            args.size(), mColumns.size())
            );

        for (int i = 0; i < args.size(); i++) {
            if (args.get(i).length() > mMaxWidth.get(i))
                mMaxWidth.set(i, args.get(i).length());
        }

        mRows.add(args);
    }

    private static String complete(String str, int width, Align align) {
        int toAdd = width - str.length();

        if (toAdd <= 0)
            return str;
        else
            return switch (align) {
                case LEFT -> str + " ".repeat(toAdd);
                case RIGHT -> " ".repeat(toAdd) + str;
                case CENTER -> " ".repeat(toAdd / 2) + str + " ".repeat(toAdd / 2);
            };
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < mColumns.size(); i++) {
            sb.append("|");
            sb.append(" ");
            sb.append(complete(mColumns.get(i), mMaxWidth.get(i), Align.LEFT));
            sb.append(" ");

            if (i + 1 == mColumns.size())
                sb.append("|");
        }

        sb.append("\n");

        for (int i = 0; i < mColumns.size(); i++) {
            sb.append("|");
            sb.append(" ");
            sb.append("-".repeat(mMaxWidth.get(i)));
            sb.append(" ");

            if (i + 1 == mColumns.size())
                sb.append("|");
        }

        sb.append("\n");

        for (int i = 0; i < mRows.size(); i++) {
            List<String> row = mRows.get(i);

            for (int j = 0; j < row.size(); j++) {
                sb.append("|");
                sb.append(" ");
                sb.append(complete(row.get(j), mMaxWidth.get(j), mAlignment.get(j)));
                sb.append(" ");

                if (j + 1 == mColumns.size())
                    sb.append("|");
            }

            if (i + 1 != mRows.size())
                sb.append("\n");
        }

        return sb.toString();
    }
}