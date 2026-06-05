/*Problem Statement
Shalini is developing a leaderboard system for CodeSprint 3.0.

The platform stores thousands of usernames submitted by participants.

To make the leaderboard more interesting, Shalini decides to rank usernames using a special set of rules:

Usernames with a higher number of vowels should appear first.

If two usernames have the same number of vowels, the shorter username should appear first.

If there is still a tie, the lexicographically smaller username should appear first.

Help Shalini sort the usernames according to these rules.

Input Format
The first line contains an integer N — the number of usernames.

The next N lines contain a username each.

Output Format
Print the usernames in the required sorted order, one username per line.

Example
Input
5

alex

asish

aaron

john

elena

Output
aaron

elena

alex

asish

john

Explanation:

1. aaron and elena each contain 3 vowels.

2. Since their lengths are equal, lexicographical order is used, so aaron comes before elena.

3. alex and asish each contain 2 vowels.

4. alex has a shorter length, so it appears before asish.

Constraints
1 ≤ N ≤ 100
1 ≤ length of username ≤ 100
Usernames contain only lowercase English letters (a-z)

Hints (2) */
import java.util.*;

public class sortUsername{
  static int countVowels(String s){
    int count = 0;
    for(int ch : s.toCharArray()){
      if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u'){
        count++;
      }
    }
    return count;
  }

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    int n = Integer.parseInt(sc.nextLine());

    String[] names = new String[n];

    for(int i = 0; i < n; i++){
      names[i] = sc.nextLine();
    }
    Arrays.sort(names, (a,b) -> {
      int vowelsA = countVowels(a);
      int vowelsB = countVowels(b);

      if(vowelsA != vowelsB){
        return vowelsB - vowelsA;
      }
      if(a.length() != b.length()){
        return a.length() - b.length();
      }
      return a.compareTo(b);
    });

    for(String s : names){
      System.out.println(s);
    }
  }
}