/*Problem Statement
During placement season, Juhi tracks her stress levels every day. To monitor her well-being, she uses a special stack-based system that supports the following operations:

PUSH X → Add a stress level X.

POP → Remove the most recently added stress level.

MIN → Display the minimum stress level currently present in the system.

For every MIN operation, print the answer.

If MIN is called on an empty stack, print -1.

If POP is called on an empty stack, ignore the operation.

All operations should be performed efficiently.

Input Format
The first line contains an integer Q, representing the number of operations.

The next Q lines each contain one operation:

PUSH X

POP

MIN

Output Format
For every MIN operation, print the minimum stress level currently present in the stack.

If the stack is empty, print -1.

Example
Input
8

PUSH 5

PUSH 2

MIN

PUSH 1

MIN

POP

MIN

POP

Output
2

1

2

Explanation:

The stack initially becomes [5, 2], so the minimum stress level is 2.

After pushing 1, the stack becomes [5, 2, 1], and the minimum stress level is 1.

After removing 1, the stack becomes [5, 2], so the minimum stress level becomes 2 again.

Hence, the output is:

2

1

2

Constraints
1 ≤ Q ≤ 10⁵
0 ≤ X ≤ 10⁹

Hints (2) */
import java.util.*;

class MinStack{
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    int q = sc.nextInt();
    sc.nextLine();

    Stack<Integer> stack = new Stack<>();
    Stack<Integer> minStack = new Stack<>();

    while(q-- > 0){
      String line = sc.nextLine();

      if(line.startsWith("PUSH")){
        String[] parts = line.split(" ");
        int x = Integer.parseInt(parts[1]);
        stack.push(x);

        if(minStack.isEmpty()){
          minStack.push(x);
        } else {
          minStack.push(Math.min(x, minStack.peek()));
        }
      }
      else if(line.equals("POP")){
        if(!stack.isEmpty()){
          stack.pop();
          minStack.pop();
        }
      }
      else if(line.equals("MIN")){
        if(minStack.isEmpty()){
          System.out.println("-1");
        } else {
          System.out.println(minStack.peek());
        }
      }
    }
  }
}