package practice.problems.stack;
/*
There are N frustrated coders standing in a circle with a gun in their hands.
Each coder has a skill value S[ i ] and he can only kill those coders that have strictly less skill than him.
One more thing, all the guns have only 1 bullet. This roulette can take place in any random order.
Fortunately, you have the time stone (haaan wo harre wala) and you can see all possible outcomes of this scenario.
Find the outcome where the total sum of the remaining coder's skill is minimum. Print this sum.

INPUT

The first line contains N the no. of coders

The next line contains N  elements where the ith element is theS[ i ] of ith coder.

OUTPUT

Print a single line containing the minimum sum

CONSTRAINTS

1<= N <= 1000000

1<=S[ i ]<=1000

SAMPLE INPUT:
6
1 7 2 2 4 4

SAMPLE OUTPUT:
11

Explanation:
the coder of skill 2 kills coder skill 1

Both coders of skill 4 kill both coders of skill 2

the coder of skill 7 kills 1 coder of skill 4

remaining skills = 7+4 = 11
 */




import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class FrustratedProgrammer {


    public static void main(String args[]) throws IOException{
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        ArrayList<Integer> skill = new ArrayList<>();

        try {
            FrustratedProgrammer.getInput(skill, s,n);
            Collections.sort(skill);

            FrustratedProgrammer.computeSkill(skill);
            int sum = FrustratedProgrammer.computeSum(skill);
            System.out.println(sum);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static void getInput(ArrayList<Integer> skill, Scanner s, int n) throws ArrayIndexOutOfBoundsException, IOException {
        for (int i = 0; i < n; i++) {
            skill.add(i, s.nextInt());
        }
    }

    static void computeSkill(ArrayList<Integer> skill) throws ArrayIndexOutOfBoundsException {
        for (int i = 1; i < skill.size(); i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (skill.get(i) > skill.get(j) && skill.get(j) != 0) {
                    skill.set(j, 0);
                    break;
                }
            }
        }
    }

    static int computeSum(ArrayList<Integer> skill) throws ArrayIndexOutOfBoundsException {
        int sum = 0;
        for (int i = 0; i < skill.size(); i++) {
            sum += skill.get(i);
        }
        return sum;
    }
}
