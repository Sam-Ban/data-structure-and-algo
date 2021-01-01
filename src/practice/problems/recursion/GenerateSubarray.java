package practice.problems.recursion;

import java.util.Scanner;

public class GenerateSubarray {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++)
            arr[i]=s.nextInt();
        GenerateSubarray.buildSubarray(arr,0,0);

    }
    private static void buildSubarray(int[] arr,int start,int end){

        if (end == arr.length)
            return;
            // Increment the end point and start from 0
        else if (start > end)
            buildSubarray(arr, 0, end + 1);
        // Print the subarray and increment the starting point
        else
        {
            System.out.print("[");
            for (int i = start; i < end; i++){
                System.out.print(arr[i]+", ");
            }

            System.out.println(arr[end]+"]");
            buildSubarray(arr, start + 1, end);
        }
    }
}
