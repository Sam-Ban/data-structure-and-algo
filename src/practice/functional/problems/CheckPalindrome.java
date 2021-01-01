package practice.functional.problems;

import java.util.Scanner;
import java.util.function.Predicate;

public class CheckPalindrome {

    public static void main(String... args) {
        Scanner s = new Scanner(System.in);
        String str = s.next();
        if (checkPalindrome.test(str))
            System.out.println("Palindrome");
        else
            System.out.println("Not Palindrome");
    }

    private static Predicate<String> checkPalindrome = (str) -> str
            .equalsIgnoreCase(new StringBuilder(str)
                    .reverse()
                    .toString());
}
