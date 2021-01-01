package practice.problems.greedy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/*
Given weights and values of n items, we need to put these items in a knapsack of capacity
W to get the maximum total value in the knapsack.

Input:
  Items as (value, weight) pairs
  arr[] = {{60, 10}, {100, 20}, {120, 30}}
  Knapsack Capacity, W = 50;
Output:
  Maximum possible value = 220
  by taking items of weight 20 and 30 kg
 */
public class FractionalKnapsackProblem {
    static class ItemValue {
        Double cost;
        double wt, val, ind;

        // item value function
        public ItemValue(int wt, int val, int ind) {
            this.wt = wt;
            this.val = val;
            this.ind = ind;
            cost = new Double(val / wt);
        }
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int w = s.nextInt();
        int n = s.nextInt();
        int[] arrVal = new int[n];
        int[] arrWeight = new int[n];
        for (int i = 0; i < n; i++)
            arrVal[i] = s.nextInt();
        for (int i = 0; i < n; i++)
            arrWeight[i] = s.nextInt();
        System.out.println(FractionalKnapsackProblem.findMaxValue(w, n, arrVal, arrWeight));
    }

    private static double findMaxValue(int w, int n, int[] arrVal, int[] arrWeight) {
        ItemValue[] arrValPerWeight = new ItemValue[n];
        for (int i = 0; i < n; i++)
            arrValPerWeight[i] = new ItemValue(arrWeight[i], arrVal[i], i);
        //sorting items by value;
        Arrays.sort(arrValPerWeight, (o1, o2) -> o2.cost.compareTo(o1.cost));
        double totalVal = 0;
        int capacity = w;
        for (ItemValue item : arrValPerWeight) {
            int wt = (int) item.wt;
            int value = (int) item.val;

            if (capacity - wt >= 0) {
                capacity -= wt;
                System.out.println("capacity" + "  :  " + capacity);
                totalVal += value;
                System.out.println("totalVal" + "  :  " + totalVal);
            } else {
                double fraction = (double) capacity / (double) wt;
                totalVal += (double) value * fraction;
                capacity = (int) (capacity - wt * fraction);
                break;
            }
        }
        return totalVal;
    }
}
