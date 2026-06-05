/* Problem Statement
During the annual college fest, Shristi was given the responsibility of managing hundreds of event announcements sent by different student clubs.
To organize the announcements better, she decided to create a smart text analyzer for the fest committee.

The analyzer should:

Count the total number of vowels (a, e, i, o, u) irrespective of case.

Count the total number of consonants.

Count the total number of words in the sentence.

However, spaces, digits, and punctuation marks should not be counted as vowels or consonants.

Help Shristi analyze the announcements correctly.

Input Format
A single line of text (may contain letters, spaces, and punctuation; max 200 chars)

Output Format

Line 1: Total vowels

Line 2: Total consonants

Line 3: Total words

Example
Input
Welcome to KIIT Fest 2026!

Output
Total Vowels: 7

Total Consonants: 10

Total Words: 5
 */

import java.util.Scanner;

public class textAnalyzer{
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    System.out.println("Enter the string");

    String str = sc.nextLine();

    int vowels = 0;
    int consonants = 0;
    int words = 0;

    for(int i = 0; i < str.length(); i++){
      char ch = Character.toLowerCase(str.charAt(i));

      if(Character.isLetter(ch)){
          if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u'){
            vowels++;
          } else {
            consonants++;
          }
      }
    }

    String[] arr = str.trim().split("\\s+");

    for(String word : arr){
      boolean isWord = false;

      for(int i = 0; i < word.length(); i++){
        if(Character.isLetter(word.charAt(i))){
          isWord = true;
          break;
        }
      }
      if(isWord){
        words++;
      }
    }

    
    System.out.println("Total vowels: " +vowels);
    System.out.println("Total consonants: " +consonants);
    System.out.println("Total words: " +words);

    sc.close();
  }
}