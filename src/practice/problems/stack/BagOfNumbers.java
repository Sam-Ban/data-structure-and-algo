package practice.problems.stack;

/*
Vikas is given a bag which consists of numbers (integers) blocks,Vikas has to organize the numbers
again in the same order as he has inserted it into the bag, i.e. the first number inserted into the bag by Vikas
should be picked up first followed by other numbers in series. Help Vikas to complete this work in O(n) time complexity with the
condition to use one extra bag to complete the work (assume that the bags are compact and is in the form of a stack structure and
has the same width as that of the number blocks and is large enough to fill the bag to the top and the
number taken from bag is in reverse order).

Hint: You may use the concept of Stacks.

SAMPLE INPUT :
input: 15 21 39 390 392 380.
SAMPLE OUTPUT :
output: 15 21 39 390 392 380.
 */

import java.util.Scanner;
import java.util.Stack;

public class BagOfNumbers {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        Stack<Integer> auxBag = new Stack<>();
        int n = s.nextInt();
        int[] inputArr = new int[n];
        BagOfNumbers.getInput(inputArr,n,s);
        BagOfNumbers.organizeBag(inputArr,n,auxBag);
    }

    static void getInput(int[] inputArr, int n, Scanner s) {
        for (int i = 0; i < n; i++) {
            inputArr[i]= s.nextInt();
        }
    }

    static void organizeBag(int[] inputArr,int n, Stack<Integer> auxBag){
        for(int i=n-1;i>=0;i--){
            auxBag.push(inputArr[i]);
        }
        while(!auxBag.isEmpty()){
            System.out.println(auxBag.pop());
        }
    }
}
