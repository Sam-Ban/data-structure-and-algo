package practice.problems.stack;
/*
Steve has a string of lowercase characters in range ascii[‘a’..’z’]. He wants to reduce the string to its shortest
length by doing a series of operations. In each operation he selects a pair of adjacent lowercase letters that match, and
he deletes them. For instance, the string aab could be shortened to b in one operation.

Steve’s task is to delete as many characters as possible using this method and print the resulting string.
If the final string is empty, print "Empty String" without quotes.

characters can be deleted only if they form a pair and are same(i.e from aaa we can only delete 2 a's and will be left with a single a).

INPUT:

A single string, s.

CONSTRAINTS:

1<=|s|<=1000

OUTPUT:

If the final string is empty, print Empty String; otherwise, print the final non-reducible string.

SAMPLE INPUT :
aaabccddd

SAMPLE OUTPUT :
abd
Explanation
Steve performs the following sequence of operations to get the final string:

aaabccddd ? abccddd ? abddd ? abd
 */

import java.util.Scanner;
import java.util.Stack;

public class SuperReducedString {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String input = s.next();
        System.out.println(SuperReducedString.computeReduction(input));
    }

    private static String computeReduction(String input) {
        Stack<Character> st = new Stack<>();
        for (char c : input.toCharArray()) {
            if (st.isEmpty() || c != st.peek())
                st.push(c);
            else if (c == st.peek())
                st.pop();
            else st.push(c);
        }
        if (st.isEmpty())
            return "Empty String";
        else {
            StringBuilder str = new StringBuilder("");
            for (int i = 0; i < st.size(); i++) {
                str.append(new StringBuilder(st.get(i).toString()));
            }
            return str.toString();
        }
    }
}
