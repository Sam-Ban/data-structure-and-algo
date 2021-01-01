package practice.problems.linearsearch;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/*
Today, Monk went for a walk in a garden. There are many trees in the garden and each tree has an English alphabet on it.
While Monk was walking, he noticed that all trees with vowels on it are not in good state. He decided to take care of them.
So, he asked you to tell him the count of such trees in the garden.
Note : The following letters are vowels: 'A', 'E', 'I', 'O', 'U' ,'a','e','i','o' and 'u'.

Input:
The first line consists of an integer T denoting the number of test cases.
Each test case consists of only one string, each character of string denoting the alphabet (may be lowercase or uppercase) on a tree in the garden.

Output:
For each test case, print the count in a new line.

SAMPLE INPUT :
2
nBBZLaosnm
JHkIsnZtTL

SAMPLE OUTPUT :
2
1

Explanation
In test case 1, a and o are the only vowels. So, count=2
 */
public class MonkTakesAWalk {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        ArrayList<Character> arrVowel = new ArrayList();
        arrVowel.add(0,'a');
        arrVowel.add(0,'e');
        arrVowel.add(0,'i');
        arrVowel.add(0,'o');
        arrVowel.add(0,'u');
        arrVowel.add(0,'A');
        arrVowel.add(0,'E');
        arrVowel.add(0,'I');
        arrVowel.add(0,'O');
        arrVowel.add(0,'U');
        int n = s.nextInt();
        for(int i =0;i<n;i++) {
           String str= s.next();
           System.out.println(MonkTakesAWalk.countVowel(str,arrVowel));
        }
    }
    private static int countVowel(String str,ArrayList<Character> arrVowel){
        char[] ch = str.toCharArray();
        int count=0;
        for(int i=0;i<ch.length;i++){
            if(arrVowel.contains(ch[i])){
               count++;
            }else
                continue;
        }
        return count;
    }
}
