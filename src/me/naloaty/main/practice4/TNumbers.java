package me.naloaty.main.practice4;

public class TNumbers extends THashTable<Integer> {

    public TNumbers(int tableSize) {
        super(tableSize);
    }

    @Override
    protected int getHash(Integer obj) {
        return obj % mTableSize;
    }
}
