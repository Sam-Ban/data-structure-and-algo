package practice.problems.queue;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
Albus Dumbledore announced that the school will host the legendary event known as Wizard Tournament where four magical
schools are going to compete against each other in a very deadly competition by facing some dangerous challenges.
Since the team selection is very critical in this deadly competition. Albus Dumbledore asked Little Monk to
help him in the team selection process. There is a long queue of students from all the four magical schools.
Each student of a school have a different roll number. Whenever a new student will come, he will search for his schoolmate
from the end of the queue. As soon as he will find any of the schoolmate in the queue, he will stand behind him,
otherwise he will stand at the end of the queue. At any moment Little Monk will ask the student, who is standing in
front of the queue, to come and put his name in the Goblet of Fire and remove him from the queue. There are Q operations
of one of the following types:

E x y: A new student of school x(1<=x<=4)  whose roll number is y(1<=y<=50000)  will stand in queue according to the method mentioned above.

D: Little Monk will ask the student, who is standing in front of the queue, to come and put his name in the Goblet of Fire
and remove him from the queue

Now Albus Dumbledore asked Little Monk to tell him the order in which student put their name. Little Monk is too lazy
to do that so he asked you to write a program to print required order.


Note: Number of dequeue operations will never be greater than enqueue operations at any point of time.

Input Format:
First line contains an integer Q , denoting the number of operations. Next Q lines will contains one of the 2 types of operations.

Output Format:
For each  type of operation, print two space separated integers, the front student's school and roll number.

SAMPLE INPUT:
5
E|1|1
E|2|1
E|1|2
D
D
SAMPLE OUTPUT:
1 1
1 2
Explanation
After first operation, student of  school with roll number 1, will stand in the front of the queue as the queue is empty initially.

In the image the student is represented by , which means that student is in x school and his roll number is y, and
rightmost cell is the front of the queue.
(1,1)

After second operation, student of  school with roll number 1, will stand behind the first student as there is
no other member of the same in the queue.

(1,1)   (2,1)

After third operation, student of  school with roll number 2, will stand behind the member of his school in the queue.

(1,1)   (1,2)   (2,1)

After fourth operation, the student in the front will put his name in the Goblet of Fire and move out of the queue.

(1,2)   (2,1)

After fifth operation, the student in the front will put his name in the Goblet of Fire and move out of the queue.

(2,1)

 */
public class LittleMonkAndGobletOfFire {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        ArrayDeque<Integer> qr = new ArrayDeque<>();
        Queue<Integer>[] qs = new LinkedList[n];
        LittleMonkAndGobletOfFire.takeInputAndCompute(qr,qs,n,s);
    }

    private static void takeInputAndCompute(ArrayDeque<Integer> qr, Queue<Integer>[] qs, int n, Scanner s) {
        for (int i = 0; i < n; i++) {
            qs[i] = new LinkedList<>();
        }
        for (int i = 0; i < n; i++) {
            String input = s.next();
            if (input.split("\\|")[0].equalsIgnoreCase("E")) {
                if (!qr.contains(Integer.parseInt(input.split("\\|")[1])))
                    qr.add(Integer.parseInt(input.split("\\|")[1]));

                qs[Integer.parseInt(input.split("\\|")[1])].add(Integer.parseInt(input.split("\\|")[2]));
            } else {
                int k = qr.peekFirst();
                System.out.println(k + " " + qs[k].remove());

                if (qs[k].size() == 0)
                    qr.remove();
            }
        }
    }
}
