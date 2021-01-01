package practice.problems.binarysearch;

import java.util.Scanner;

/*
Bishu went to fight for Coding Club. There were N soldiers with various powers. There will be Q rounds to fight and in each round Bishu's power will be varied. With power M, Bishu can kill all the soldiers whose power is less than or equal to M(<=M). After each round, All the soldiers who are dead in previous round will reborn.Such that in each round there will be N soldiers to fight. As Bishu is weak in mathematics, help him to count the number of soldiers that he can kill in each round and total sum of their powers.

1<=N<=10000

1<=power of each soldier<=100

1<=Q<=10000

1<=power of bishu<=100

SAMPLE INPUT
7
1 2 3 4 5 6 7
3
3
10
2
SAMPLE OUTPUT
3 6
7 28
2 3
Explanation
In first round bhishu power is 3

So there are 3 soldiers whose power is <=3 and the sum of their power is 1+2+3=6

therefore ans= 3 6

same for the next round
 */
public class BishuAndSoldiers {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = s.nextInt();
        //sort the array
        BishuAndSoldiers.mergeSort(arr, 0, n - 1);
        int q = s.nextInt();
        for (int i = 0; i < q; i++) {
            int pb = s.nextInt();
            BishuAndSoldiers.countNoOfSoldiersToBeKilled(arr, pb, n);
        }
    }

    private static void countNoOfSoldiersToBeKilled(int[] arr, int pb, int n) {
        int sum = 0;
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] <= pb) {
                count++;
                sum += arr[i];
            } else break;
        }
        System.out.println(count + " " + sum);
    }

    private static void mergeSort(int[] arr, int low, int high) {
        if (low < high) {
            int mid = (low + high) / 2;
            mergeSort(arr, low, mid);
            mergeSort(arr, mid + 1, high);
            merge(arr, low, mid, high);
        }
    }

    private static void merge(int[] arr, int low, int mid, int high) {

        int[] split1 = new int[mid - low + 1];
        int[] split2 = new int[high - mid];
        for (int i = 0; i < split1.length; i++)
            split1[i] = arr[low + i];
        for (int i = 0; i < split2.length; i++)
            split2[i] = arr[mid + 1 + i];
        int i = 0;
        int j = 0;
        int k = low;
        while (i < split1.length && j < split2.length) {
            if (split1[i] < split2[j])
                arr[k++] = split1[i++];
            else
                arr[k++] = split2[j++];
        }
        for (; i < split1.length; i++)
            arr[k++] = split1[i];
        for (; j < split2.length; j++)
            arr[k++] = split2[j];
    }
}
