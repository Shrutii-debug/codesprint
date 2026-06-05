/*Problem Statement
During his college fest, Aditya collected badges from various events held across the campus. Some of these badges belonged to premium events organized by the college committee.

Each premium badge type is represented by a unique character in a string called jewels. The complete collection of badges gathered by Aditya is represented by another string called stones.

Your task is to help Aditya determine how many badges in his collection are premium badges.

Note: Characters are case-sensitive, which means 'a' and 'A' are considered different badge types.

Input Format
The first line contains a string jewels — representing the premium badge types.

The second line contains a string stones — representing all the badges collected by Aditya.

Output Format
Print a single integer — the total number of premium badges present in the collection.

Example
Input
jewels = aA

stones = aAAbbbb

Output
3

Explanation

The premium badge types are 'a' and 'A'.

In the string "aAAbbbb", 'a' appears 1 time and 'A' appears 2 times.

Therefore, the total number of premium badges is 1 + 2 = 3.

Constraints
1 ≤ jewels.length, stones.length ≤ 50
jewels and stones contain only English letters.
All characters in jewels are unique.

Hints (3)
1
Hint 1: Traverse each character of the stones string one by one.

2
Hint 2: Check whether the current character exists in the jewels string.

3
Hint 3: If it exists, increase the count. Remember that uppercase and lowercase letters are treated as different characters. */

import java.util.*;

public class countJewels{
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    String jewels = sc.nextLine();
    String stones = sc.nextLine();

    HashSet<Character> set = new HashSet<>();
    int count = 0;

    for(char ch : jewels.toCharArray()){
      set.add(ch);
    }
    for(char ch : stones.toCharArray()){
      if(set.contains(ch)){
        count++;
      }
    }
    System.out.println(count);
  }
}