package practice.problems.quicksort;

import java.util.Random;
import java.util.Scanner;

/*
The Hexagon University of India will be hosting its Prom Night tonight.There would be M boys and N girls at the prom tonight.
Each boy wants a girl who is strictly shorter than him. A girl can dance with only one boy and vice-versa.
Given the heights of all the boys and girls tell whether it is possible for all boys to get a girl.

Input:
The first line contains T denoting the number of test cases.
Each test case contains three lines.
The first line contains M and N.
The second line contains M integers each denoting the height of boy.
The third contains N integers each denoting the height of girl.

Output:
Print YES if it is possible for each boy to get a girl else print NO.

Constraints:
1<=T<=10
1<=N, M<=10000
1<=Height<=200

SAMPLE INPUT
1
4 5
2 5 6 8
3 8 5 1 7

SAMPLE OUTPUT
YES
 */
public class PromNight {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        for (int i = 0; i < t; i++) {
            int nb = s.nextInt();
            int[] arrb = new int[nb];
            int ng = s.nextInt();
            int[] arrg = new int[ng];
            for (int j = 0; j < nb; j++)
                arrb[j] = s.nextInt();
            for (int j = 0; j < ng; j++)
                arrg[j] = s.nextInt();
            PromNight.quickSort(arrb, 0, nb - 1);
            PromNight.quickSort(arrg, 0, ng - 1);
            PromNight.determineDanceInPromNight(arrb, arrg);
        }
    }

    private static void determineDanceInPromNight(int[] arrb, int[] arrg) {
        Boolean flag = true;
        for (int j = 0; j < arrb.length; j++) {
            if (arrg[j] >= arrb[j]) {
                flag = false;
                break;
            } else
                continue;
        }
        if (flag == true)
            System.out.println("YES");
        else
            System.out.println("NO");
    }

    private static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = randomPartition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    private static int randomPartition(int[] arr, int low, int high) {
        Random r = new Random();
        int rNumber = r.nextInt((high - low) + 1) + low;
        int temp = arr[rNumber];
        arr[rNumber] = arr[high];
        arr[high] = temp;
        return partition(arr, low, high);
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        for (int i = low; i < high; i++) {
            if (arr[i] < pivot) {
                int temp = arr[low];
                arr[low] = arr[i];
                arr[i] = temp;
                low++;
            }
        }
        int temp = arr[low];
        arr[low] = pivot;
        arr[high] = temp;
        return low;
    }
}
