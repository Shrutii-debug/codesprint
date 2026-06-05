/*Problem Statement
A biotechnologist Shreyansh is working in a company named GenomeShield.It is researching dangerous virus mutations using long DNA sequences.
Shreyansh observed that certain highly stable virus structures form perfectly symmetrical genetic patterns.
These patterns read exactly the same from left to right and right to left.
To speed up medical research, he needs software that can quickly identify the largest symmetrical DNA segment inside a given sequence.
Since the DNA strings can be extremely large, the algorithm must work efficiently even for sequences containing millions of characters.
Your task is to help Shreyansh and the research team find the longest palindromic substring in the DNA sequence.
Input Format
A single string S representing the DNA sequence.

Output Format
Print the longest symmetrical DNA segment.

If multiple longest substrings exist, print any one of them.

Example
Input
S = aacxyzyxdef

Output
xyzyx

Explanation

In the sample:

"xyzyx" reads the same from both directions.

No longer palindromic substring exists.

Constraints
1 ≤ length of S ≤ 10^4
The string S contains only lowercase English letters ('a'–'z').

Hints (2) */

////// IMPORTANTTTTTTTTT
/// 
 import java.util.*;

public class longestPalString{
  public static String longestPal(String s){
    StringBuilder sb = new StringBuilder();

    for(char c : s.toCharArray()){
      sb.append("#");
      sb.append(c);
    }
    sb.append("#");

    String t = sb.toString();
    int n = t.length();
    int[] p = new int[n];

    int center = 0;
    int right = 0;

    int maxLen = 0;
    int maxCenter = 0;

    for(int i = 0; i < n; i++){
      int mirror = 2 * center - i;

      if(i < right){
        p[i] = Math.min(right - i, p[mirror]);
      }

      while(i - p[i] - 1 >= 0 && i + p[i] + 1 < n && t.charAt(i - p[i] - 1) == t.charAt(i + p[i] + 1)){
        p[i]++;
        
      }

      if(i + p[i] > right){
        center = i;
        right = i + p[i];
      }
      if(p[i] > maxLen){
        maxLen = p[i];
        maxCenter = i;
      }
    }

    int start = (maxCenter - maxLen)/2;

    return s.substring(start, start + maxLen);
  }
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    System.out.println("enter the string");
    String s = sc.next();

    System.out.println(longestPal(s));
  }
}