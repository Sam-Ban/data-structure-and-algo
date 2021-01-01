package practice.problems.stack;

/*
You are given a stack of N integers. In one operation, you can either pop an element from the stack or push any popped
element into the stack. You need to maximize the top element of the stack after performing exactly K operations. If the
stack becomes empty after performing K operations and there is no other way for the stack to be non-empty, print -1.

Input format :

The first line of input consists of two space-separated integers N and K.
The second line of input consists N space-separated integers denoting the elements of the stack. The first element represents
the top of the stack and the last element represents the bottom of the stack.
Output format :

Print the maximum possible top element of the stack after performing exactly K operations.

SAMPLE INPUT:
6 4
1 2 4 3 3 5

SAMPLE OUTPUT:
4

Explanation
In 3 operations, we remove 1,2,4 and in the fourth operation, we push 4 back into the stack. Hence, 4 is the answer.
 */

import java.util.Scanner;
import java.util.Stack;

public class StackOperations {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int k = s.nextInt();
        int[] inputArr = new int[n];
        Stack<Integer> st = StackOperations.getInput(inputArr, n, s);
        StackOperations.computeMaxTop(inputArr, st, n, k);
    }

    static Stack<Integer> getInput(int[] inputArr, int n, Scanner s) {
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < n; i++) {
            inputArr[i] = s.nextInt();
        }
        for (int i = n - 1; i >= 0; i--) {
            st.push(inputArr[i]);
        }
        return st;
    }

    static void computeMaxTop(int[] inputArr, Stack<Integer> st, int n, int k) {
        int[] interimArr = new int[k - 1];
        if (n == k) {
            System.out.println(-1);
        } else {
            for (int i = 0; i < k - 1; i++) {
                interimArr[i] = st.pop();
            }

            if (computeMaxValue(interimArr) <= inputArr[k])
                st.pop();
            else
                st.push(computeMaxValue(interimArr));
        }
        System.out.println(st.pop());
    }

    static int computeMaxValue(int[] interimArr) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < interimArr.length; i++) {
            if (interimArr[i] >= max)
                max = interimArr[i];
        }
        return max;
    }

}
