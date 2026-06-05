/*
Problem Statement
Mounit's company, ChatClean, is a popular messaging platform that processes millions of user messages every day.

Many users accidentally type extra spaces at the beginning, end, or between words. Before displaying messages in a clean format, ChatClean applies the following rules:

Reverse the order of the words.

Remove unnecessary spaces.

Keep exactly one space between consecutive words.

Remove leading and trailing spaces.

Given a string S, help Mounit format the message correctly.

Input Format

A single line containing the string S.

Output Format

Print the formatted string after reversing the order of the words.

Example
Input
the sky is blue

Output
blue is sky the

Explanation:

1. The words in the message are: "the", "sky", "is", "blue".

2. Reversing their order gives: "blue is sky the".

3. Any extra spaces are removed, and only a single space is kept between words.

Constraints
1 ≤ |S| ≤ 10^5
S consists only of uppercase letters, lowercase letters, digits, and spaces.
A word is defined as a maximal sequence of non-space characters.
S contains at least one word.

Hints (3) */
import java.util.*;
public class messageFormatter{
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    System.out.println("enter the string");

    String s = sc.nextLine();
    String[] words = s.trim().split("\\s+");

    StringBuilder result = new StringBuilder();

    for(int i = words.length - 1; i >= 0; i--){
      result.append(words[i]);

      if(i > 0){
        result.append(" ");
      }
    }
    System.out.println(result.toString());
  }
}