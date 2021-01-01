package practice.problems.greedy;

import java.util.Scanner;

import static java.lang.Math.abs;

public class PikachuAndGameOfStrings {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        String strs = s.next();
        String strt = s.next();
        System.out.println(PikachuAndGameOfStrings.calculateMinDays(n, strs, strt));
    }

    private static int calculateMinDays(int n, String strs, String strt) {
        int count = 0;
        if (strs.equalsIgnoreCase(strt))
            return count;
        else {
            for (int i = 0; i < n; i++) {
                int diff = 0;
                if ((int) strs.charAt(i) > (int) strt.charAt(i)) {
                    diff = abs((int) strs.charAt(i) - (int) 'Z') + abs((int) strt.charAt(i) - (int) 'A') + 1;
                } else
                    diff = abs((int) strs.charAt(i) - (int) strt.charAt(i));
                if (diff == 1 || diff == 13)
                    count++;
                else if (diff > 13) {
                    count += (diff - 13) + 1;
                } else if (diff < 13) {
                    count += diff;
                } else {
                    continue;
                }
            }
            return count;
        }
    }
}
