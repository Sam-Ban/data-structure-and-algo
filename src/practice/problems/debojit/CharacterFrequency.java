package practice.problems.debojit;

import java.util.*;
import java.util.stream.Collectors;

public class CharacterFrequency {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String input = s.next();
        char[] chArr = input.toCharArray();
        LinkedHashMap<Character, Integer> hm = CharacterFrequency.getFrequency(chArr);
        LinkedHashMap<Character, Integer> lhmOrder = hm.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
        for (Map.Entry<Character, Integer> entry : lhmOrder.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }

    private static LinkedHashMap<Character, Integer> getFrequency(char[] chArr) {
        LinkedHashMap<Character, Integer> hm = new LinkedHashMap<>();
        for (int i = 0; i < chArr.length; i++) {
            if (hm.containsKey(chArr[i]))
                hm.put(chArr[i], (Integer) hm.get(chArr[i]) + 1);
            else
                hm.put(chArr[i], 1);
        }
        return hm;
    }
}
