/*Problem Statement
Baibhavi is managing the lift system in her hostel. Throughout the day, students submit requests for different floors, and the lift must serve these requests in the exact order in which they were received.

To optimize the system, Baibhavi has decided to implement the request queue using only stacks.

The system supports the following operations:

ADD X → Add a new floor request X.

NEXT → Serve the oldest pending floor request.

If a NEXT operation is performed when there are no pending requests, print -1.

Help Baibhavi process all the operations correctly.

Input Format
The first line contains an integer Q, representing the number of operations.

The next Q lines each contain one operation:

ADD X

NEXT

Output Format
For every NEXT operation, print the floor being served.

If no pending request exists, print -1.

Example
Input
7

ADD 5

ADD 8

NEXT

ADD 3

ADD 10

NEXT

NEXT

Output
5

8

3

Explanation:

The lift follows the First-In-First-Out (FIFO) rule. Requests are added in the order 5, 8, 3, and 10. Therefore, the first three NEXT operations serve 5, 8, and 3 respectively.

Hence, the output is:

5

8

3

Constraints
1 ≤ Q ≤ 10⁵
0 ≤ Floor ≤ 10⁵

Hints (3) */
import java.util.*;

class QueueUsingStack{
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    int q = sc.nextInt();
    sc.nextLine();

    Stack<Integer> s1 = new Stack<>();
    Stack<Integer> s2 = new Stack<>();

    while(q-- > 0){
      String line = sc.nextLine();
      if(line.startsWith("ADD")){
        String[] parts = line.split(" ");
        int x = Integer.parseInt(parts[1]);
        s1.push(x);
      }

      else if(line.equals("NEXT")){
        if(s2.isEmpty()){
          while(!s1.isEmpty()){
            s2.push(s1.pop());
          }
        }
        if(s2.isEmpty()){
          System.out.println("-1");
        } else {
          System.out.println(s2.pop());
        }
      }
    }
  }
}