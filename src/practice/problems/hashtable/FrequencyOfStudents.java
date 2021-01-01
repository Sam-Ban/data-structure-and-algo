package practice.problems.hashtable;

/*
There is a class consisting of 'N' students . There can be many students with the same name.

Now, you have to print the names of the students followed by there frequency as shown in the sample explanation given below.

Output the names in the lexicographical order.

Input :

First line contains an integer 'N', i.e the no. of students in the class.
Next 'N' lines contains the names of the students.
Output:

Each line consists of the name of student space and separated its frequency.
Constraints:

1<=N<=1000
string length<=100
string consists of lowercase letters
Note : For practicing use Map technique only .

SAMPLE INPUT:
5
sumit
ambuj
himanshu
ambuj
ambuj

SAMPLE OUTPUT :
ambuj 3
himanshu 1
sumit 1
 */

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FrequencyOfStudents {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        ArrayList<String> arr = new ArrayList<>();
        for (int i = 0; i < n; i++)
            arr.add(i, s.next());
       // FrequencyOfStudents.countFrequency(arr, n);
     //   printFrequency.accept(arr);
    }

    static Consumer<ArrayList<String>> printFrequency =  (arrayList) -> {
        arrayList.stream()
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
                .forEach((x,y) -> System.out.println(x + " " + y));
    };

    private static void countFrequency(ArrayList<String> arr, int n) {
        TreeMap<String, Integer> hm = new TreeMap<>();
        while (!arr.isEmpty()) {
            String str = arr.remove(0);
            if (hm.containsKey(str))
                hm.put(str, (Integer) hm.get(str) + 1);
            else
                hm.put(str, 1);
        }
        hm.keySet().forEach(x -> System.out.println(x + "  " + hm.get(x)));
    }
}
