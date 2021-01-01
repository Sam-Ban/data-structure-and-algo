package practice.problems.hashtable;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Scanner;

/*
Andi and Bob were friends since childhood days. But, as they grew up Bob started behaving weird and this used to
irritate Andi. Once, while Andi took a break after typing a large program Bob came from nowhere and swapped some
alphabet keys on Andi's keyboard.

Andi got very angry on seeing this and decided to end their friendship once forever. As we all know Bob is
very good at heart and never does anything wrong intentionally. He decided to type the remaining program with the same
keyboard Configuration. Given the original fragment of the code that Bob needs to type, You need to tell Bob the code that
he should type to get the original code as output.

Help him saving his friendship with Andi.

INPUT :

First line of the input contains a single integer N denoting the number of swaps done by Bob. Next N lines contain a pair
of characters A,B denoting the characters which are swapped by Bob (Note that Bob performs these swaps in the given order).
From the very next line of input the remaining fragment of the code starts and ends with an end of file character.

OUTPUT:

print the fragment of the program that Bob types.

CONSTRAINTS:

1 <= N <= 106

1 <= |length of codefragment| <= 106

code fragment contains uppercase and lowercase english alphabets only and space.

A,B belongs to Alphabet set (both upper case and lower case letters are included).

SAMPLE INPUT :
1
W H
WelloHorld

SAMPLE OUTPUT :
HelloWorld
 */
public class BobAnIdiot {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        //   LinkedHashMap<String,String> lk = new LinkedHashMap<>();
        LinkedList<Character> keyList = new LinkedList<>();
        LinkedList<Character> valueList = new LinkedList<>();
        String sb = BobAnIdiot.getInput(keyList, valueList, n, s);
        char[] ch = sb.toCharArray();
        for (int i = 0; i < n; i++) {
            int start = sb.indexOf(keyList.get(i));
                if(start == -1)
                     start = sb.indexOf(Character.toLowerCase(keyList.get(i)));
            System.out.println("start : " + start);
            int end = sb.indexOf(valueList.get(i));
            if(end == -1)
                end = sb.indexOf(Character.toLowerCase(valueList.get(i)));
            System.out.println("end : " + end);
            System.out.println(sb.charAt(start) + " : " + sb.charAt(end));
            BobAnIdiot.swap(ch, start, keyList.get(i),end,valueList.get(i));
        }
        for (int i = 0; i < ch.length; i++)
            System.out.print(ch[i]);
    }

    private static String getInput(LinkedList<Character> keyList, LinkedList<Character> valueList, int n, Scanner s) {
        for (int i = 0; i < n; i++) {
            keyList.add(i, s.next().charAt(0));
            valueList.add(i, s.next().charAt(0));
        }
        StringBuilder sb = new StringBuilder();
        while (s.hasNextLine()) {
            sb.append(s.nextLine());

        }
        return sb.toString();
    }

    private static void swap(char[] ch, int start, char st, int end, char en) {
      //  char temp = ch[start];
        ch[start] = st;
        ch[end] = en;
        System.out.println("After Replace "+ch[start] + " : "+ch[end]);
    }
}
