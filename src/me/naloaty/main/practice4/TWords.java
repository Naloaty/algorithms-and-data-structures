package me.naloaty.main.practice4;

public class TWords extends THashTable<String> {

    public TWords(int tableSize) {
        super(tableSize);
    }

    @Override
    protected int getHash(String str) {
        int code = 0;

        for (int i = 0; i < str.length(); i++)
            code ^= str.charAt(i) * (i + 1);

        return code % mTableSize;
    }
}
