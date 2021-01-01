package practice.problems.hashtable;

import java.util.*;
import java.util.stream.Collectors;

/*
Yesterday while Omar was trying to learn English, he saw that there are letters repeated many times in words while some other letters repeated only few times or not repeated at all!

Of course anyone can memorize the letters (repeated many times) better than the letters repeated few times, so Omar will concatenate all the words in the context he has, and try to know the difficulty of each letter according to the number of repetitions of each letter.

So Omar has now the whole context and wants to arrange the letters from the most difficult letter (repeated few times) to the less difficult letter (repeated many times).

If there are 2 letters with the same level of difficulty, the letter with higher value of ASCII code will be more difficult.

Input Format:
Given an integer (T),  (number of test cases).
For each test case:
Given a string of (lower English characters), .
(each string in a new line).

Output Format:
Output the English lower case characters from the most difficult letter to the less difficult letter.
(leave a space between 2 successive letters) (Output each test case in a separate line).

SAMPLE INPUT :
1
oomar

SAMPLE OUTPUT :
z y x w v u t s q p n l k j i h g f e d c b r m a o
 */
public class DifficultCharacters {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        ArrayList<String> inputArr = DifficultCharacters.getInput(n, s);

        for (int i = 0; i < n; i++) {
            DifficultCharacters.calculateDifficultyLevel(inputArr.get(i));
        }
    }

    private static ArrayList<String> getInput(int n, Scanner s) {
        ArrayList<String> inputArr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            inputArr.add(i, s.next());
        }
        return inputArr;
    }

    private static void calculateDifficultyLevel(String s) {
        String alphabetSet = "abcdefghijklmnopqrstuvwxyz";
        ArrayList<Integer> alphabetList = new ArrayList<>();
        char[] alphabetArr = alphabetSet.toCharArray();
        for (int i = 0; i < alphabetArr.length; i++) {
            alphabetList.add(i, (int) alphabetArr[i]);
        }
        char[] arr = s.toCharArray();
        ArrayList<Integer> inputWord = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            inputWord.add(i, (int) arr[i]);
        }
        alphabetList.removeAll(inputWord);
        Collections.sort(alphabetList, Collections.reverseOrder());

        TreeMap<Integer, Integer> tm = DifficultCharacters.countFrequency(inputWord);
        DifficultCharacters.printDifficulties(tm, alphabetList);
    }

    private static TreeMap<Integer, Integer> countFrequency(ArrayList<Integer> inputWord) {
        TreeMap<Integer, Integer> hm = new TreeMap<>(Collections.reverseOrder());
        for (int i = 0; i < inputWord.size(); i++) {
            int key = inputWord.get(i);
            if (hm.containsKey(key))
                hm.put(key, (Integer) hm.get(key) + 1);
            else
                hm.put(key, 1);
        }
        return hm;
    }

    private static void printDifficulties(TreeMap<Integer, Integer> tm, ArrayList<Integer> alphabetList) {
        LinkedHashMap<Integer, Integer> lhmOrder = tm.entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
        LinkedList<Character> ll = new LinkedList<>();
        for (int i = 0; i < alphabetList.size(); i++)
            ll.add(i, (char) alphabetList.get(i).intValue());
        for (Map.Entry<Integer, Integer> entry : lhmOrder.entrySet()) {
            ll.add((char) entry.getKey().intValue());
        }
        ll.stream().forEach(x -> System.out.print(x + " "));
        System.out.println();
    }
}