package practice.problems.hashtable;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.Map.Entry.comparingByValue;

/*
Max likes football very much. In order to check the popularity of the game, he decided to talk to random people and
ask them about their favourite game and note it down in a list.

Given a list of name of people and their favourite sport, help Max in finding the sport liked by most of the people,
and also how many people like football.

He could have met same people more than once, he will only count response of his first meet with any person.

Note : Name of person as well as sport is a single string in lowercase. Length of name of people as well as sport is less than 11.

Input :: First line will contain no of entries in the list. i.e. N Next N lines will contain two strings, person's
name and sports he like.

Output :: In first ine, name of sport liked by most no of people (In case of more than one games is liked by highest no of people,
output the first one in lexicographical order). In second line, no of people having football as their favourite game.

Constraints: 1<=N<=100000 1<=Name of person<=10 1<=Name of sport<=10

SAMPLE INPUT:
7
abir cricket
aayush cricket
newton kabaddi
abhinash badminton
sanjay kabaddi
abhinash badminton
govind football

SAMPLE OUTPUT:
cricket
1
 */
public class Statistics {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        HashMap<String, String> hm = Statistics.getInput(n, s);
        HashMap<String, Integer> tm = new HashMap<>();
        for (String str : hm.values()) {
            int count = Collections.frequency(hm.values(), str);
            tm.put(str, count);
        }
        int maxValueInMap = (Collections.max(tm.values())); // This will return max value in the Hashmap
        TreeSet<String> ts = new TreeSet<>();
        for (Map.Entry<String, Integer> entry : tm.entrySet()) {  // Iterate through hashmap
            if (entry.getValue() == maxValueInMap) {
                // Print the key with max value
                ts.add(entry.getKey());
            }
        }
        System.out.println(ts.first());
        System.out.println(tm.getOrDefault("football",0));
    }

    private static HashMap<String, String> getInput(int n, Scanner s) {
        HashMap<String, String> hm = new HashMap<>();
        HashMap<String, Integer> hmOut = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String name = s.next();
            String game = s.next();
            hm.putIfAbsent(name, game);
        }
        return hm;
    }
}
