/*Problem Statement
Soumyadip discovered an ancient magical portal hidden inside a forgotten temple.
The portal activates only when two secret words are perfectly balanced.

According to the ancient rule:

Two strings are considered compatible if they are anagrams of each other.

Two strings are called anagrams if:

they contain the same characters

and each character appears the same number of times

Help Soumyadip determine whether the magical portal will activate.

Input Format
The first line contains a string S1

The second line contains a string S2

Output Format
Print "YES" if the strings are anagrams.

Otherwise, print "NO".

Example
Input
listen

silent

Output
YES

Explanation: Both strings contain the same characters with the same frequency (l, i, s, t, e, n), so the portal activates successfully. */
import java.util.*;

class Anagrams{
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    System.out.println("Enter string 1");
    String s1 = sc.nextLine().toLowerCase();

    System.out.println("Enter string 2");
    String s2 = sc.nextLine().toLowerCase();

    if(s1.length() != s2.length()){
      System.out.println("NO");
      return;
    }

    int[] freq = new int[26];

    for(int i = 0; i < s1.length(); i++){
      freq[s1.charAt(i) - 'a']++;
      freq[s2.charAt(i) - 'a']--;
    }

    for(int count : freq){
      if(count != 0){
        System.out.println("NO");
      } 
    }
    System.out.println("YES");
  }
}