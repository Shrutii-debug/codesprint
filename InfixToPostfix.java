/*Problem Statement
Vanshika discovers an old notebook containing mathematical formulas used by previous CodeSprint champions.

The formulas are written in standard infix notation, but the evaluation machine in the lab understands only postfix notation.

To run the formulas successfully, Vanshika must convert the given infix expression into its equivalent postfix expression.

Help her perform the conversion.

Supported Symbols

Operands

Uppercase letters: A-Z

Lowercase letters: a-z

Operators

+

-

*

/

Parentheses

(

)

Operator Precedence

Highest: *, /

Lowest: +, -

All operators are left-associative.

Input Format

A single string S representing a valid infix expression.

Output Format


Print the equivalent postfix expression.

Example
Input
A+(B*C)

Output
ABC*+

Explanation:

B*C has higher precedence than +.

So: A + (B*C)

becomes: ABC*+

Constraints
1 ≤ |S| ≤ 10^5
The expression contains only valid operands, operators, and parentheses.
The expression is guaranteed to be valid.

Hints (4) */
import java.util.*;
public class InfixToPostfix{
      static int precedence(char ch){
      if(ch == '+' || ch == '-') return 1;
      if(ch == '*' || ch == '/') return 2;

      return 0;
    }
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    String s = sc.next();

    StringBuilder ans = new StringBuilder();
    Stack<Character> stack = new Stack<>();

    for(char ch : s.toCharArray()){
      if(Character.isLetterOrDigit(ch)){
        ans.append(ch);
      }
      else if(ch == '('){
        stack.push(ch);
      }
      else if(ch == ')'){
        while(!stack.isEmpty() && stack.peek() != '('){
          ans.append(stack.pop());
        }
        stack.pop();
      }
   else {
      while(!stack.isEmpty() && precedence(stack.peek()) >= precedence(ch)){
        ans.append(stack.pop());
      }
      stack.push(ch);
    }
    
    }
  while(!stack.isEmpty()){
    ans.append(stack.pop());
  }
  System.out.println(ans);
}
}