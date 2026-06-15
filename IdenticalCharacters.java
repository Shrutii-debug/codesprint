/*Problem Statement
Soumili is preparing captions for the college fest’s Instagram page.

Sometimes while typing quickly, identical adjacent characters accidentally get repeated.

The editor follows a special cleaning rule:

If two adjacent characters are identical, both are removed.

This process continues until no such adjacent pair exists.

Help Soumili generate the final cleaned caption.

Input Format

A single string S.

Output Format

Print the final cleaned string.

If the entire string gets removed, print:

EMPTY

Example
Input
abbaca

Output
ca

Explanation:

abbaca

→ aaca

→ ca

No adjacent equal characters remain.

Constraints
1 ≤ |S| ≤ 10^5
S contains only lowercase English letters

Hints (2) */
import java.util.*;

class IdenticalCharacters{
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    String s = sc.next();

    Deque<Character> stack = new ArrayDeque<>();

    for(char ch : s.toCharArray()){
      if(!stack.isEmpty() && stack.peek() == ch){
        stack.pop();
      } else {
      stack.push(ch);
      }
    }
    if(stack.isEmpty()){
      System.out.println("EMPTY");
      return;
    }
    StringBuilder ans = new StringBuilder();

    for(char ch : stack){
      ans.append(ch);
    }
    System.out.println(ans.reverse().toString());
  }
}