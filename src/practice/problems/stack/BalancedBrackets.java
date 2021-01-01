package practice.problems.stack;

/*
A bracket is considered to be any one of the following characters: (, ), {, }, [, or ].

Two brackets are considered to be a matched pair if the an opening bracket (i.e., (, [, or {) occurs to the left of a closing bracket (i.e., ), ], or }) of the exact same type. There are three types of matched pairs of brackets: [], {},and ().

A matching pair of brackets is not balanced if the set of brackets it encloses are not matched. For example, {[(])} is not balanced because the contents in between { and } are not balanced. The pair of square brackets encloses a single, unbalanced opening bracket, (, and the pair of parentheses encloses a single, unbalanced closing square bracket, ].

By this logic, we say a sequence of brackets is balanced if the following conditions are met:

It contains no unmatched brackets.
The subset of brackets enclosed within the confines of a matched pair of brackets is also a matched pair of brackets.
Given n strings of brackets, determine whether each sequence of
brackets is balanced. If a string is balanced, return YES. Otherwise, return NO.


INPUT:

The first line contains a single integer n, the number of strings.

Each of the next n lines contains a single string s, a sequence of brackets.

CONSTRAINTS:

1<=n<=10^3
1<=|s|<=10^3, where  is the length of the sequence.
All characters in the sequences ? { {, }, (, ), [, ] }.

OUTPUT:
For each string, return YES or NO.

SAMPLE INPUT :
3
{[()]}
{[(])}
{{[[(())]]}}

SAMPLE OUTPUT
YES
NO
YES

Explanation
1.The string {[()]} meets both criteria for being a balanced string, so we print YES on a new line.
2.The string {[(])} is not balanced because the brackets enclosed by the matched pair { and } are not balanced: [(]).
3.The string {{[[(())]]}} meets both criteria for being a balanced string, so we print YES on a new line.
 */

import java.util.Scanner;
import java.util.Stack;

public class BalancedBrackets {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        String[] arr = BalancedBrackets.getInput(n, s);
        for (String str : arr) {
            System.out.println(BalancedBrackets.computeBalancing(str));
        }

    }

    private static String[] getInput(int n, Scanner s) {
        String[] arr = new String[n];
        for (int i = 0; i < n; i++) {
            arr[i] = s.next();
        }
        return arr;
    }

    private static String computeBalancing(String str) {
        Stack<Character> st = new Stack<Character>();
        Boolean flag = true;
        for (char c : str.toCharArray()) {
            if (c == '(')
                st.push(')');
            else if (c == '{')
                st.push('}');
            else if (c == '[')
                st.push(']');
            else {
                if (st.isEmpty() || c != st.peek()) {
                    flag = false;
                    break;
                } else {
                    st.pop();
                }
            }

        }
        if (st.isEmpty() && !flag == false)
            return "YES";
        else
            return "NO";
    }
}
