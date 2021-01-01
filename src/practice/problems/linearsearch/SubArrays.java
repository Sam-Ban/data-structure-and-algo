package practice.problems.linearsearch;
/*
You are given an array  of length . You are required to select  non-intersecting subarrays. The cost will be considered as the sum of all numbers in these subarrays divided by . Your task is to maximize this cost.

A subarray of  is a non-empty sequence obtained by deleting a prefix and/or a suffix from the sequence . The prefix or suffix can be empty which means that  is considered to be a subarray of . There are  subarrays in an array of length .

You can select no subarrays () and the cost is considered to be equal to .

If there are more than one solutions that contain the same cost, then select the one that contains the highest .

Input format
First line: Integer -
Second line:  integers -
Output format

If the maximum cost is equal to  , then print two integers  and  respectively.

Note: The value of  is equal to the biggest integer less than or equal to .

Additional information

For  points:
For additional  points:
Original constraints for remaining points

SAMPLE INPUT :
5
1 -5 3 -1 4

SAMPLE OUTPUT :
6 1
Explanation
It is optimal to choose only one subarray. If we .choose subarray , we get cost .

If we had chosen subarrays  and , we would have obtained cost , which is smaller than .

Note that we can't choose subarrays  and , because they are intersecting each other.
 */

import java.util.Scanner;

public class SubArrays {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++)
            arr[i] = s.nextInt();
    }
}
