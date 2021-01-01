package practice.problems.debojit;

import java.util.Scanner;

public class MergeProblem {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[] arr1 = new int[n];
        for (int i = 0; i < n; i++)
            arr1[i] = s.nextInt();
        String str = s.next();
        char[] arr2 = str.toCharArray();
        MergeProblem.merge(arr1,arr2);
    }

    private static void merge(int[] arr1, char[] arr2) {
        int i = 0;
        int j = 0;
        int k = 0;
        char[] temp = new char[arr1.length + arr2.length];
        while (i < arr1.length && j < arr2.length) {
            temp[k++] = (char) (arr1[i]+'0');
            i++;
            temp[k++] = arr2[j++];
        }
        for (; i < arr1.length; i++)
            temp[k++] = (char) (arr1[i]+'0');
        for (; j < arr2.length; j++)
            temp[k++] = arr2[j];

        for (int z = 0; z < temp.length;z++)
            System.out.print(temp[z]);
    }
}
