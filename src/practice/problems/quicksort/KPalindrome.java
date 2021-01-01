package practice.problems.quicksort;

import com.sun.deploy.security.SelectableSecurityManager;

import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

/*
Moriarty has given Sherlock a string challenge.

Sherlock will be given a string S consisting of only lower case English alphabets.

Sherlock needs to find the minimum number of steps required for converting the given string into a
K- Palindrome string.

Note :- Here we are considering 1 based index.

What is a K- Palindrome string ?
Let's define a function f, such that f(i) is the character at ith index in the given string. Now, ith index is considered to
be a palindromic index if f(i) = f(len - i + 1) (where len is the length of the given string S).
So, if the number of the palindromic indices in the given string is exactly k , then the string is considered to be a
K-palindrome string.

In each step, you are allowed to either increase the character or decrease the character, i.e. - if the character is 'c',
you can convert it into 'b' or 'd' in one step. So, steps required to convert 'c' to 'a' will be 2. Of course, you can't
increase 'z' or decrease 'a'. So, steps required to convert 'a' to 'z' will be 25. Sherlock needs to use minimum number of
such steps. Find the minimum number of steps required to make the given string K - palindrome.
See Sample test-case for better understanding.


Input format:

First line consists of an integer T, denoting the number of testcases.

Each test case consists of 2 lines. First line has a string S and second line has an integer K.

Output format:

For each string, output the minimum number of steps required for converting the given string into a
K- palindrome string .

If it is not possible to convert the given string into a K-palindrome string then output -1.


Constraints:

1 <= T <= 20

1 <= |S| <= 500000

1 <= K <= |S|


Subtasks:

Subtask #1 (30 points) : 1 <= |S| <= 500

Subtask #2 (70 points) : Original Constraints

SAMPLE INPUT :
2
deck
2
aaaaaa
6

SAMPLE OUTPUT :
2
0

Explanation
In first testcase, given string is "deck", we need to convert it into a 2-palindrome string as k is given to be 2.
Here, we can convert 'e' to 'd' in first step and we can convert 'c' to 'd' in second step. So, in two steps,
the string becomes "dddk", which is a 2-palindrome string (as 2nd and 3rd index are palindromic indices). Hence, answer is 2.

In second testcase, given string is "aaaaaa", which is already a 6-palindrome string and so answer is 0.
 */
public class KPalindrome {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        for(int i=0;i<n;i++) {
            String str = s.next();
            int k = s.nextInt();
            System.out.println(KPalindrome.determineNoStepsForKPalindrome(str,k));
        }
    }
    private static int determineNoStepsForKPalindrome(String str,int k){
        char[] ch = str.toCharArray();
        int[] arr = new int[ch.length/2];
        if(ch.length%2!=0) {
            arr = new int[(ch.length / 2) + 1];
        }
        else{
            arr = new int[ch.length/2];
        }
        int low = 0;
        int high = ch.length-1;
        int count=0;
        while(low<=high){
            arr[low] = Math.abs((int)(ch[high]-ch[low]));
            if(arr[low]==0)count+=2;
            low++;
            high--;
        }
        KPalindrome.quickSort(arr,0,arr.length-1);
        int sum = 0;
        if(count<k)
            return -1;
        else {
            for (int j = 0; j < k / 2; j++)
                sum += arr[j];
            return sum;
        }
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
