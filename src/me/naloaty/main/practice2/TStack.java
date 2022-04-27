package me.naloaty.main.practice2;

public class TStack {


    public static int count7of2(int arr[], int N) {
        java.util.Stack<Integer> stack = new java.util.Stack<>();

        for (int i = 0; i < N; i++)
            stack.push(arr[i]);

        int count = 0;

        while (!stack.isEmpty()) {
            int value = stack.pop();

            if (value % 7 == 2)
                count++;
        }

        return count;
    }

}
