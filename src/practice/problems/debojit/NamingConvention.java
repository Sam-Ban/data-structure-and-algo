package practice.problems.debojit;

import java.util.Scanner;

public class NamingConvention {
    public static void main(String[] args) {
        // Scanner s = new Scanner(System.in);
        String input = "saMIK banDOPAdhyay";
        String str1 = input.split(" ")[0];
        String str2 = input.split(" ")[1];

        char[] ch1 = str1.toCharArray();
        char[] ch2 = str2.toCharArray();
        for (int i = 0; i < ch1.length; i++) {
            if (i == 0)
                ch1[i] = Character.toUpperCase(ch1[i]);
            else
                ch1[i] = Character.toLowerCase(ch1[i]);
        }
        String name = new String(ch1);

        for (int i = 0; i < ch2.length; i++) {
            if (i == 0)
                ch2[i] = Character.toUpperCase(ch2[i]);
            else
                ch2[i] = Character.toLowerCase(ch2[i]);
        }
        String surname = new String(ch2);
        System.out.println(name + " " + surname);
    }
}