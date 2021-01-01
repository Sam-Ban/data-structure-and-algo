package practice.problems.stack;

import java.util.Collections;
import java.util.Scanner;
import java.util.Stack;

/*
Harry is a bright student. To prepare thoroughly for exams, he completes all the exercises in his book! Now that the exams
are approaching fast, he is doing book exercises day and night. He writes down and keeps updating the
remaining number of exercises on the back cover of each book.

Harry has a lot of books messed on the floor. Therefore, he wants to pile up the books that still have some remaining exercises
into a single pile. He will grab the books one-by-one and add the books that still have remaining exercises to the top of the pile.

Whenever he wants to do a book exercise, he will pick the book with the minimum number of remaining exercises from the pile.
In order to pick the book, he has to remove all the books above it. Therefore, if there are more than one books with the
minimum number of remaining exercises, he will take the one which requires the least number of books to remove.
The removed books are returned to the messy floor. After he picks the book, he will do all the remaining exercises and trash the book.

Since number of books is rather large, he needs your help to tell him the number of books he must remove,
for picking the book with the minimum number of exercises.

Note that more than one book can have the same name.



Input Format

The first line contains a single integer N denoting the number of actions. Then N lines follow.
Each line starts with an integer. If the integer is -1, that means Harry wants to do a book exercise.
Otherwise, the integer is number of the remaining exercises in the book he grabs next. This is followed by a string
denoting the name of the book.

Output Format

For each -1 in the input, output a single line containing the number of books Harry must remove, followed by the
name of the book that Harry must pick.



Constraints

1 < N ≤ 1,000,000

0 ≤ (the number of remaining exercises of each book) < 100,000

The name of each book consists of between 1 and 15 characters 'a' - 'z'.

Whenever he wants to do a book exercise, there is at least one book in the pile.

SAMPLE INPUT:
6
9|english
6|mathematics
8|geography
-1
3|graphics
-1

SAMPLE OUTPUT :
1 mathematics
0 graphics
 */
public class BookExercise implements Comparable<BookExercise> {
    int index;
    int num;
    String subject;

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    @Override
    public int compareTo(BookExercise be) {
        int comparedVal = ((BookExercise) be).getNum();
        return comparedVal - this.num; //Sorting in descending order
        //this.num - comparedVal ; Ascending order sort
    }

    public static void main(String[] args) throws Exception {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        Stack<BookExercise> st = new Stack<>();
        BookExercise.getInputAndCompute(st, n, s);
    }

    static void getInputAndCompute(Stack<BookExercise> st, int n, Scanner s) {
        for (int i = 0; i < n; i++) {
            String str = s.next();
            if (!str.equalsIgnoreCase("-1")) {
                BookExercise bk = new BookExercise();
                bk.index = i;
                bk.num = Integer.parseInt(str.split("\\|")[0]);
                bk.subject = str.split("\\|")[1];
                st.push(bk);
            } else {
                Collections.sort(st);
                BookExercise bt = st.pop();
                int removedBooks = (i - 1) - bt.getIndex();
                System.out.println(removedBooks + " " + bt.getSubject());
            }
        }

    }
}

