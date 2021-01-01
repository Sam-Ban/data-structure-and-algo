package practice.problems.recursion;

import java.util.Scanner;

/*
Given a string, compute recursively (no loops) a new string where all appearances of "pi" have been replaced by "3.14".


changePi("xpix") → "x3.14x"
changePi("pipi") → "3.143.14"
changePi("pip") → "3.14p"
 */
public class ChangePi {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String str = s.next();
        System.out.println(ChangePi.changePi(str));
    }

    private static String changePi(String str) {
        if (!str.contains("pi")) {
            return str;
        } else {
            str = str.replaceFirst("pi", "3.14");
            return changePi(str);
        }
    }
}
