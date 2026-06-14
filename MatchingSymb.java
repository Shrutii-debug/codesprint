/*Problem Statement
A professor stores attendance logs using special symbols:

() [] {} <>

A log is considered valid if:

Every opening symbol has a matching closing symbol.

Symbols close in the correct order.

No closing symbol appears before its opening symbol.

Help Arnav determine whether the attendance log is valid.

Input Format

A single string S.

Output Format

Print:

VALID

if the attendance log is valid.

Otherwise print:

INVALID

Example
Input
{(<[]>)}

Output
VALID

Explanation:

The symbols are matched in the correct order:

{

(

<

[]

>

)

}

Every opening symbol is closed properly.

Constraints
1 ≤ |S| ≤ 10^5
S contains only the characters:
(
)
[
]
{
}
<
>

Hints (2) */
import java.util.*;

class MatchingSymb{
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    String s = sc.next();

    Deque<Character> stack = new ArrayDeque<>();

    boolean valid = true;
    for(char ch : s.toCharArray()){
      if(ch == '(' || ch == '{' || ch == '[' || ch == '<'){
        stack.push(ch);
      } else {
        if (stack.isEmpty()) {
          valid = false;
          break;
        }
        char top = stack.pop();

        if((ch == ')' && top != '(') ||
           (ch == '}' && top != '{') ||
           (ch == ']' && top != '[') ||
           (ch == '>' && top != '<'))
          valid = false;
        break;
      }
    }
    if(stack.isEmpty()) valid = false;
    if(valid){
      System.out.println("VALID");
    } else {
      System.out.println("INVALID");
    }
  }
  
}