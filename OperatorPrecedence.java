/*Problem Statement
Pratyush was practicing coding problems late at night when his calculator suddenly stopped following operator precedence correctly.

To verify his answers, he decides to write a program that evaluates mathematical expressions containing:

Addition (+)

Subtraction (-)

Multiplication (*)

Division (/)

The expression contains only non-negative integers and valid operators. Help Pratyush evaluate the expression correctly according to standard operator precedence. Division should perform integer division (truncate toward zero).

Input Format

A single string S representing the expression.

Output Format

Print a single integer — the value of the expression.

Example
Input
3+2*2

Output
7

Explanation:

2 * 2 = 4

3 + 4 = 7

Constraints
1 ≤ |S| ≤ 10^5
Expression contains only digits and operators (+, -, *, /)
Expression is guaranteed to be valid

Hints (2) */
import java.util.*;

class OperatorPrecedence{
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    String s = sc.next();

    Deque<Integer> stack = new ArrayDeque<>();

    int num = 0;
    char sign = '+';

    for(int i = 0; i < s.length(); i++){

      char ch = s.charAt(i);
      if(Character.isDigit(ch)){
      num = num * 10 + (ch - '0');
      }

      if((!Character.isDigit(ch)) || i == s.length() - 1){
        if(sign == '+') stack.push(num);
        else if (sign == '-') stack.push(-num);
        else if (sign == '*') stack.push(stack.pop() * num);
        else if (sign == '/') stack.push(stack.pop()/num);

        sign = ch;
        num = 0;
      }
    }
    int result = 0;
    while(!stack.isEmpty()) result += stack.pop();

    System.out.println(result);
  }
}