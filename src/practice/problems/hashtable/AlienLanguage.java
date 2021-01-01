package practice.problems.hashtable;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Scanner;

/*
Little Jhool considers Jaadu to be a very close friend of his. But, he ends up having some misunderstanding
with him a lot of times, because Jaadu's English isn't perfect, and Little Jhool sucks at the language Jaadu speaks.
So, he's in a fix - since he knows that Jaadu has got magical powers, he asks him to help so as to clear all the issues
they end up having with their friendship.

Now, Jaadu can only focus at one task, so to fix these language issues he comes up with a magical way out, but someone
needs to do the rest of it; this is where Little Jhool has asked for your help.

Little Jhool says a word, and then Jaadu says another word. If any sub-string of the word said by Jaadu is a sub-string of
the word said by Little Jhool, the output should be "YES", else "NO". (Without the quotes.)

Input:
First line contains number of test case T. Each test case contains two strings *Text ( Said by Jhool ) * and Pattern
(Said by Jaadu ).Both strings contains only lowercase alphabets ['a'-'z'].

Output:
For each test case print YES if any sub-string of Pattern is sub-string of Text else print NO.

Constraints:
1<=T<=5
1<=|Text|<=100000
1<=|Pattern|<=100000

SAMPLE INPUT :
2
hackerearth
hacker
hackerearth
wow

SAMPLE OUTPUT :
YES
NO
*/
public class AlienLanguage {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        ArrayList<String> str1Arr = new ArrayList<>();
        ArrayList<String> str2Arr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            str1Arr.add(i, s.next());
            str2Arr.add(i, s.next());
        }
        for (int i = 0; i < n; i++) {
            HashSet<Character> hsJhool = new HashSet<>();
            String str1 = str1Arr.get(i);
            String str2 = str2Arr.get(i);
            Boolean flag = false;
            for (int k = 0; k < str1.length(); k++) {
                hsJhool.add(str1.charAt(k));
            }
            for (int j = 0; j < str2.length(); j++) {
                if (hsJhool.contains(str2.charAt(j))) {
                    flag = true;
                    break;
                }

            }
            if(flag== true)
                System.out.println("YES");
            else
                System.out.println("NO");
        }
    }
}

