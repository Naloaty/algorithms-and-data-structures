package me.naloaty.main.practice3;

import java.util.*;

public class TSet {

    public static final String ALL = "ALL";
    public static final String PARTIALLY = "PARTIALLY";
    public static final String NOT_FOUND = "NOT_FOUND";

    public static Map<String, Set<String>> checkIfContains(Set<String> names, List<List<String>> klasses) {
        Set<String> all       = new HashSet<>();
        Set<String> partially = new HashSet<>();
        Set<String> notFound  = new HashSet<>();

        for (String name: names) {
            int count = 0;

            for (List<String> klass: klasses) {
                if (klass.contains(name))
                    count++;
            }

            if (count == klasses.size()) {
                all.add(name);
                continue;
            }

            if (count >= 1) {
                partially.add(name);
                continue;
            }

            notFound.add(name);
        }

        Map<String, Set<String>> map = new HashMap<>();

        map.put(ALL,       all);
        map.put(PARTIALLY, partially);
        map.put(NOT_FOUND, notFound);

        return map;
    }
}
