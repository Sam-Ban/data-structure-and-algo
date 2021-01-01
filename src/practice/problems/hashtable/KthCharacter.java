package practice.problems.hashtable;

import java.util.*;

public class KthCharacter {
    public static void main(String... args){
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int q = s.nextInt();
        String str = s.next();
        for(int i=0;i<q;i++){
            int L = s.nextInt();
            int R = s.nextInt();
            int k = s.nextInt();

            System.out.println(getKthChar(str,L,R,k));
        }
    }
    private static String getKthChar(String str,int L,int R,int k){
        ArrayList<String> ars = new ArrayList<>();
       // System.out.println(str.substring(L-1, R));
         for(char c:str.substring(L-1,R).toCharArray()) {

             ars.add(Character.toString(c));
         }
         ars.sort(Comparator.naturalOrder());
       //  ars.forEach(x -> System.out.println(x));
         return ars.get(k-1);
    }
}
