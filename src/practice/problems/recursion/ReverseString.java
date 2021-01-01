package practice.problems.recursion;

import java.util.Scanner;

public class ReverseString {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String str = s.next();
        int n = str.length();
        char[] arr = str.toCharArray();
        StringBuilder sb = new StringBuilder();
        System.out.println(ReverseString.reverse(arr, n, sb));
    }

    private static StringBuilder reverse(char[] arr, int n, StringBuilder sb) {
        if (n == 0)
            return sb;
        else {
            sb.append(Character.toString(arr[n - 1]));
            return reverse(arr, n - 1, sb);
        }
    }
}
