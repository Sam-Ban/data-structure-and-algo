package practice.problems.linearsearch;

import java.util.Scanner;

/*
It's a holiday season for all school students around the world! Unfortunately, Mahamba is busy preparing for International
Olympiad in Informatics, which will be held in Tehran, Iran. He is now facing a new challenge from his teacher Aceka,
and it goes something like this:

You have a string x of length N, which consists of small English letters. You have to find the number of indexes
a, b, c and d, such that  and , as well as .

He is baffled and definitely needs some help. So, you, the best programmer in Lalalandia,
decided to give him a hand!

Input format

The first line contains the number N - the length of a string x. The second line contains the string x itself.

Output format

The first and only line should contain the answer to the problem.

Constraints


The string x only contains small English letters.

SAMPLE INPUT:
5
ababa

SAMPLE OUTPUT :
2
Explanation
There are only 2 variants: (a=1,b=2,c=3,d=4) and (a=2,b=3,c=4,d=5)
 */
public class HolidaySeason {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        String str = s.next();
        char[] ch = str.toCharArray();
        System.out.println(HolidaySeason.determineNumber(ch, n));
    }

    private static int determineNumber(char[] ch, int n) {
        int count = 0;
        for (int a = 0; a < n; a++) {
            for (int b = a + 1; b < n; b++) {
                for (int c = b + 1; c < n; c++) {
                    for (int d = c + 1; d < n; d++) {
                        if (ch[a] == ch[c] && ch[b] == ch[d])
                            count++;
                    }
                }
            }
        }
        return count;
    }
}
