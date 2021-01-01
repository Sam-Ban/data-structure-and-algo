package practice.problems.hashtable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/*
There are N chocolates denoted by array A where A[i] is the length of the i-th chocolate.
Alice can melt each chocolate and then convert it into a chocolate whose length is any divisor of the number A[i].
So, a chocolate of length A[i] can be converted into X different types of chocolate where X is the count of divisors
of the number A[i]. So you need to count the total unordered pair of chocolates such that their X value is same.

Input Format
The first line contains an integer N as input denoting the total number of elements in the array A.
The next line contains N space-separated integers that denote the elements of the array A.

Output Format
In the output, print the total number of ways as mentioned in the statement.

SAMPLE INPUT :
3
2 3 4

SAMPLE OUTPUT:
1
 */
public class SimilarChocolates {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int arr[] = new int[n];
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int i = 0; i < n; i++) {
            arr[i] = s.nextInt();
            hm.put(arr[i], SimilarChocolates.countNumberOfDivisors(arr[i]));
        }
        ArrayList<Integer> countArr = new ArrayList<>();
        hm.values().stream().distinct().forEach(x -> {
            int numKeys = SimilarChocolates.getAllKeysForValue(hm, x);
           // System.out.println("Number of keys with value : " + x + " : " + numKeys);
            if (numKeys >= 2)
                countArr.add(SimilarChocolates.combination(numKeys, 2));
        });

        int count = 0;
        for (int i = 0; i < countArr.size(); i++)
            count += countArr.get(i);
        System.out.println(count);
    }

    private static int countNumberOfDivisors(int value) {
        int counter = 1;

        for (int i = 1; i <= value / 2; i++) {
            if (value % i == 0)
                counter++;
        }
        return counter;
    }

    private static int getAllKeysForValue(HashMap<Integer, Integer> hm, int value) {
        ArrayList<Integer> keys = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : hm.entrySet()) {
            if (entry.getValue()==value) {
                keys.add(entry.getKey());
            }
        }
        return keys.size();
    }

    private static int combination(int n, int r) {
        if (r == 0 || n == r)
            return 1;
        else
            //return fact(n) / (fact(n - r) * fact(r));
        return n*(n-1)/2;
    }

 /*   private static int fact(int num) {
        int fact = 1, i;
        for (i = 1; i <= num; i++) {
            fact = fact * i;
        }
        return fact;
    } */
}


