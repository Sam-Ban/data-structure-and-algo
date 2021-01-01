package practice.problems.stack;

/*
Pink is sad because of some reasons, he wants to cheer up by listening to some songs from his favourite band, Pink Floyd.

There are N records and Pink will be happy if he listens to them in the ascending order, i.e, first the song No. 1, then No.2 and so on(He has to listen to all the N songs to become Happy).

Pink is delivered his records in some given order, he can either add the record to the Playlist in the delivered order or put some on an another table. After being put on the table only the topmost record can be added to the playlist at any time.

Print whether Pink will be sad or happy after the delivery of the records.

INPUT

N - Number of records followed  by

N numbers- order of records

OUTPUT

Print "Happy" if the playlist has songs from 1 to N in order else "Sad".

CONSTRAINTS

1<=N<=10^5

The array consists of 1-N distinct numbers.

SAMPLE INPUT :
5
1 2 4 3 5

Output:
Happy

Explanation
1 2 4 3 5

1 is passed to the playlist

stack -> empty

2 is passed to the playlist

stack -> empty

4 is passed to the stack

stack -> {4}

3 is passed to the playlist

stack -> {4}

now 4 is passed from the stack

stack -> empty

now 5 is passed to the playlist

The passed becomes 1 2 3 4 5 and hence pink is happy.


 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.Stack;

public class PinkFloydAndHappiness {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[] arr = new int[n];
        Stack<Integer> table = new Stack<>();
        Stack<Integer> playList = new Stack<>();
        for (int i = 0; i < n; i++) {
            arr[i] = s.nextInt();
            if (playList.isEmpty() && arr[i] == 1) {
                playList.push(arr[i]);
                continue;
            }
            while (!table.isEmpty() && !playList.isEmpty() && table.peek() == playList.peek() + 1) {
                playList.push(table.pop());
            }
            if (!playList.isEmpty() && playList.peek() + 1 == arr[i]) {
                playList.push(arr[i]);
            } else {
                table.push(arr[i]);
            }
        }
        while (!table.isEmpty()) {
            if (table.peek() == playList.peek() + 1) {
                playList.push(table.pop());
            } else {
                System.out.println("Sad");
                break;
            }
        }
        if (table.isEmpty())
            System.out.println("Happy");
    }

}
