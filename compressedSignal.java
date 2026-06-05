/*Problem Statement
Marutwan was working on a secret communication system for CodeSprint 3.0.
During transmission, some signals were repeated continuously because of a network glitch.

As a result, the received message contained many consecutive repeating characters.

To make the message shorter and easier to process, Marutwan decided to compress the signal using this rule:

Replace consecutive repeating characters with: character + count

Help Marutwan generate the compressed signal.

Input Format
A single string S containing lowercase English letters.

Output Format
Print the compressed string.

Example
Input
aaabbcccc

Output
a3b2c4

Explanation:

1. a appears 3 times consecutively → a3

2. b appears 2 times consecutively → b2

3. c appears 4 times consecutively → c4

So the compressed string becomes: a3b2c4 */

import java.util.*;

class compressedSignal{
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    System.out.println("Enter the string");
    String s = sc.nextLine().toLowerCase();

    StringBuilder result = new StringBuilder();

    int count = 1;
    for(int i = 1; i < s.length(); i++){
      if(s.charAt(i) == s.charAt(i-1)){
        count++;
      } else {
        result.append(s.charAt(i-1)).append(count);
        count = 1;
      }
    }
    result.append(s.charAt(s.length() - 1)).append(count);

    System.out.println(result);
  }
}