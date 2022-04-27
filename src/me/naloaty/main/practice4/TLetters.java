package me.naloaty.main.practice4;

public class TLetters extends THashTable<Character> {

    private String word;

    public TLetters(String word) {
        super(word.length() + 1);
        this.word = word;

        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == ' ')
                continue;

            this.add(word.charAt(i));
        }
    }

    @Override
    protected int getHash(Character obj) {
        if (obj == null)
            return 0;

        int entries = 0;

        for (int i = 0; i < word.length(); i++) {
            if (obj.equals(word.charAt(i)))
                entries++;
        }

        return entries;
    }
}
