package practice.problems.stack;

import java.util.Scanner;

public class NearestSmallerElement {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = s.nextInt();
        NearestSmallerElement.getSmallerElements(arr, n);
    }

    private static void getSmallerElements(int[] arr, int n) {
        int[] arrOut = new int[n];
        arrOut[0] = -1;
        for (int i = 1; i < n; i++) {
            int min = arr[i];
            for (int j = 0; j < i; j++) {
                if (arr[j] <= min)
                    min = arr[j];
                else if(arr[j]> min && arr[j]<arr[i])
                    min=arr[j];
                else continue;
            }
            if(min==arr[i])
                arrOut[i]=-1;
            else
            arrOut[i] = min;
        }
        for (int i = 0; i < n; i++)
            System.out.print(arrOut[i] + " ");
    }
}
