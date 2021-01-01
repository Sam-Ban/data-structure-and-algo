package practice.problems.greedy;

import java.util.Scanner;

/*
Little robot CJ-17 is exploring ancient ruins. He found a piece of paper with a word written on it.
Fortunately, people who used to live at this location several thousand years ago used only two letters of modern English alphabet:
'a' and 'b'. It's also known, that no ancient word contains two letters 'a' in a row.
CJ-17 has already recognized some of the word letters, the others are still unknown.

CJ-17 wants to look up all valid words that could be written on this paper in an ancient dictionary. He needs your help.
Find him the word, which is the first in alphabetical order and could be written on the paper.

Input format

The first line contains non-empty string s consisting of 'a', 'b' and '?' characters. Character '?' corresponds
to unrecognized letter.

It's guaranteed, that there exists at least one ancient word, that could be written on the paper.

Constraints

Length of s is at most 50.

Output format

Output the first in alphabetical order word, that could be written on the paper, found by CJ-17.

SAMPLE INPUT :
?ba??b

SAMPLE OUTPUT :
ababab

Explanation
Words ababab, ababbb, bbabab and bbabbb could be written on paper. The first in alphabetical order is ababab.
 */
public class ExploringRuins {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        String str = s.next();
        char[] ch = str.toCharArray();
        if(str.length()==1){
            if(ch[0]=='?')
                ch[0]='a';
            System.out.print(ch[0]);
            System.exit(0);
        }

        if(ch[0]=='?') {
            if (ch[1] == '?') {
                ch[0] = 'a';
                ch[1] = 'b';
            } else if (ch[1] == 'a')
                ch[0] = 'b';
            else {
                ch[0] = 'a';
            }
        }
        for(int i=1;i<str.length()-1;i++){
            if(ch[i]=='?'){
                if(ch[i+1]=='?'){
                    if(ch[i-1]=='a')
                        ch[i]='b';
                    else
                        ch[i]='a';
                }else if(ch[i+1]=='a'){
                    if(ch[i-1]=='a' || ch[i-1]=='b')
                        ch[i]='b';
                }else{
                    if(ch[i-1]=='a')
                        ch[i]='b';
                    else
                        ch[i]='a';
                }
            }
        }
        if(ch[str.length()-1]=='?'){
            if(ch[str.length()-2]=='a')
                ch[str.length()-1]='b';
            else
                ch[str.length()-1]='a';
        }
        for(int i=0;i<str.length();i++){
            System.out.print(ch[i]);
        }
    }

}
