/*Problem Statement
While exploring an abandoned laboratory beneath the CodeSprint arena, Prashant discovers an ancient evaluation machine.

Unlike modern calculators, this machine understands only prefix expressions.

To activate the machine and unlock its hidden records, Prashant must evaluate the given prefix expression.

Help him determine the final result.

Supported Symbols

Operands

Digits 0–9

Every operand is a single-digit integer

Operators

+

-

*

/

Division should perform integer division.

Input Format

A single string representing a valid prefix expression.

Output Format


Print the evaluated result.

Example
Input
-*+2345

Output
15

Explanation:

The expression is: ((2 + 3) * 4) - 5

Evaluation:

2 + 3 = 5

5 * 4 = 20

20 - 5 = 15

Answer: 15

Constraints
1 ≤ Length of Expression ≤ 10^5
All operands are single-digit numbers.
The expression is guaranteed to be valid.
Intermediate and final results fit within a 32-bit signed integer.

Hints (3) */
import java.util.*;

class EvaluatingPrefix{
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    String s = sc.next();
    Stack<Integer> stack = new Stack<>();
    for(int i = s.length() - 1; i >= 0; i--){
      char ch = s.charAt(i);

      if(Character.isDigit(ch)){
        stack.push(ch - '0');
      } else{
        int a = stack.pop();
        int b = stack.pop();

        int result = 0;

        switch(ch){
          case '+':
            result = a + b;
            break;

          case '-':
            result = a - b;
            break;

          case '*':
            result = a * b;
            break;

          case '/':
            result = a/b;
            break;
        }
        stack.push(result);
      }
    }
    System.out.println(stack.pop());
  }
}