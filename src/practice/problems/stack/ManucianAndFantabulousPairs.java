package practice.problems.stack;

import java.util.LinkedHashSet;
import java.util.Scanner;

/*
First off, some definitions.
An array of length at least 2 having distinct integers is said to be fantabulous iff the second highest element lies strictly to the left of the highest value. For example, [1, 2, 13, 10, 15] is fantabulous as the second-highest value 13 lies to the left of highest value 15.
For every fantabulous array, we define a fantabulous pair (a, b) where a denotes the index of the second-highest value (1-indexed) and b denotes the index of the highest value (1-indexed). In the above array, the fantabulous pair is (3, 5).
Mancunian challenges you to solve the following problem. Given an array, find the total number of distinct fantabulous pairs over all its subarrays.

Input:
The first line contains an integer N denoting the length of the array. The next line contains N distinct integers denoting the elements of the array.

Output:
Output a single integer which is the answer to the problem.

Constraints:
1 <= N <= 106
1 <= array elements <= 109
Array elements are distinct.

SAMPLE INPUT
4
1 3 2 4
SAMPLE OUTPUT
3
Explanation
Let us consider all the subarrays of the given array.
The subarray [1] is not fantabulous.
The subarray [2] is not fantabulous.
The subarray [3] is not fantabulous.
The subarray [4] is not fantabulous.
The fantabulous pair for subarray [1, 3] is (1, 2).
The subarray [3, 2] is not fantabulous.
The fantabulous pair for subarray [2, 4] is (1, 2).
The subarray [1, 3, 2] is not fantabulous.
The fantabulous pair for subarray [3, 2, 4] is (1, 3).
The fantabulous pair for subarray [1, 3, 2, 4] is (2, 4).
So, there are the 3 distinct pairs, which are (1, 2), (1, 3) and (2, 4).
 */
public class ManucianAndFantabulousPairs {
    static LinkedHashSet<String> lsh = new LinkedHashSet<>();

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = s.nextInt();
       // ManucianAndFantabulousPairs.printFantabulousPair(arr, 0, 0);
        System.out.println(ManucianAndFantabulousPairs.iterativeFanatabolousPair(arr,n));

    }

    /*
    Time complexity O(n2) : But, due to huge input data set, StackOverflowError will occur as we are using recursion
     */
    private static void printFantabulousPair(int[] arr, int start, int end) {
        if (end == arr.length) {
            return;
        } else if (start > end)
            printFantabulousPair(arr, 0, end + 1);
        else {
            if (start == end)
                printFantabulousPair(arr, start + 1, end);
            else {
                int max = Integer.MIN_VALUE;
                int maxSecond = Integer.MIN_VALUE;
                int maxIndex = 0;
                int maxSecondIndex = 0;
                for (int i = start; i <= end; i++) {
                    if (arr[i] > max) {
                        maxSecond = max;
                        maxSecondIndex = maxIndex;
                        max = arr[i];
                        maxIndex = i;
                    } else if (arr[i] > maxSecond && arr[i] != max) {
                        maxSecond = arr[i];
                        maxSecondIndex = i;
                    } else {
                        continue;
                    }
                }
                if (maxSecondIndex < maxIndex) {
                    // System.out.println(maxSecond + " : " + max);
                    // System.out.println((maxSecondIndex - start + 1) + "," + (maxIndex - start + 1));
                    String index = (maxSecondIndex - start + 1) + "," + (maxIndex - start + 1);
                    ManucianAndFantabulousPairs.lsh.add(index);
                }
                printFantabulousPair(arr, start + 1, end);
            }
        }
        return;
    }
/*
Time complexity O(n3) : It will exceed the time limit but StackOverflowError will not occur
 */
    private static int iterativeFanatabolousPair(int[] arr,int n){
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                int max = Integer.MIN_VALUE;
                int maxSecond = Integer.MIN_VALUE;
                int maxIndex = 0;
                int maxSecondIndex = 0;
                for(int k=i;k<=j;k++){

                    if (arr[k] > max) {
                        maxSecond = max;
                        maxSecondIndex = maxIndex;
                        max = arr[k];
                        maxIndex = k;
                    } else if (arr[k] > maxSecond && arr[k] != max) {
                        maxSecond = arr[k];
                        maxSecondIndex = k;
                    } else {
                        continue;
                    }
                }
                if (maxSecondIndex < maxIndex) {
                    // System.out.println(maxSecond + " : " + max);
                    // System.out.println((maxSecondIndex - i + 1) + "," + (maxIndex - i + 1));
                    String index = (maxSecondIndex - i + 1) + "," + (maxIndex - i + 1);
                    ManucianAndFantabulousPairs.lsh.add(index);
                }
            }
        }
        return lsh.size();
    }

    }
