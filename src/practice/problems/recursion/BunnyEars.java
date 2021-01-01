package practice.problems.recursion;

import java.util.Scanner;

/*
We have bunnies standing in a line, numbered 1, 2, ... The odd bunnies (1, 3, ..) have the normal 2 ears.
The even bunnies (2, 4, ..) we'll say have 3 ears, because they each have a raised foot.
Recursively return the number of "ears" in the bunny line 1, 2, ... n (without loops or multiplication).


bunnyEars2(0) → 0
bunnyEars2(1) → 2
bunnyEars2(2) → 5
 */
public class BunnyEars {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        System.out.println(BunnyEars.countEars(n));
    }

    private static int countEars(int n){
        if(n==0)
            return 0;
        if(n%2==0)
            return 3+countEars(n-1);
        if(n%2!=0)
            return 2+countEars(n-1);
        else return -1;
    }
}
