package me.naloaty.main.practice3;

import java.util.Queue;

public class TQueue {

    public static void removeEven(Queue<Integer> queue) {
        int size = queue.size();

        for (int i = 0; i < size; i++) {
            if (queue.isEmpty())
                break;

            int e = queue.poll();

            if (e % 2 != 0)
                queue.add(e);
        }
    }
}
