package me.naloaty.main.practice4;

import me.naloaty.main.table.MyTable;

import java.util.ArrayList;
import java.util.List;

public abstract class THashTable<T> {

    protected final int mTableSize;
    protected final List<List<T>> mHashTable;

    private int collisions;

    public THashTable(int tableSize) {
        mHashTable = new ArrayList<>(tableSize);
        mTableSize = tableSize;

        for (int i = 0; i < tableSize; i++)
            mHashTable.add(new ArrayList<>());
    }

    protected abstract int getHash(T obj);

    public void add(T obj) {
        if (obj == null)
            return;

        int hash = getHash(obj);
        int index = mHashTable.get(hash).indexOf(obj);

        if (index == -1) {
            if (mHashTable.get(hash).size() > 0)
                collisions++;

            mHashTable.get(hash).add(obj);
        }
    }

    public int indexOf(T obj) {
        if (obj == null)
            return -1;

        int hash = getHash(obj);
        int index = mHashTable.get(hash).indexOf(obj);

        if (index != -1)
            return hash;
        else
            return -1;
    }

    public boolean remove(T obj) {
        if (obj == null)
            return false;

        int hash = getHash(obj);

        return mHashTable.get(hash).remove(obj);
    }

    public int getCollisions() {
        return collisions;
    }

    @Override
    public String toString() {
        MyTable table = new MyTable();

        table.addColumn("Hash", MyTable.Align.RIGHT);
        table.addColumn("Value", MyTable.Align.LEFT);

        for (int i = 0; i < mHashTable.size(); i++) {
            table.addRow(List.of(
                    String.valueOf(i),
                    mHashTable.get(i).size() > 0 ? mHashTable.get(i).toString() : " "
            ));
        }

        return table.toString();
    }

}
