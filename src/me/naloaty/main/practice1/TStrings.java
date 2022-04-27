package me.naloaty.main.practice1;

public class TStrings {

    public static char findFirstMatch(String from, String in) {
        for (int i = 0; i < from.length(); i++) {
            for (int j = 0; j < in.length(); j++) {
                if (from.charAt(i) == in.charAt(j))
                    return from.charAt(i);
            }
        }

        return 0;
    }

}
