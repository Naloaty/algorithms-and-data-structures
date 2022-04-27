package me.naloaty.main.generics;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void read(List<? extends ClassA> list) {
        for (Object obj: list) {
            String sb = "A(" + (obj instanceof ClassA) + "), " +
                    "B(" + (obj instanceof ClassB) + "), " +
                    "C(" + (obj instanceof ClassC) + "), " +
                    "Y(" + (obj instanceof ClassY) + "), " +
                    "Z(" + (obj instanceof IntZ) + ");";
            System.out.println(sb);
        }
    }

    public static void read2(List<? extends ClassA> list) {
        ClassA obj = list.get(0);
        ClassB obj2 = (ClassB) list.get(1);
    }

    public static void write(List<? super ClassA> list) {
        list.add(new ClassA());
        list.add(new ClassB());
        list.add(new ClassC());
        list.add(new ClassK());

        ClassA obj = (ClassA) list.get(0);
    }

    public static void main(String[] args) {
        // read(List.of(new ClassA(), new ClassB(), new ClassC()));

        List<ClassA> list = new ArrayList<>();
        write(list);
        read2(list);
    }
}
