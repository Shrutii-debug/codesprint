/*Problem Statement
Hundreds of students are registering for CodeSprint 3.0.

Each student receives a registration token in the order they arrive.

Due to a temporary software limitation, the registration system can use only stacks to manage the waiting line.

Help Rohit process the registration requests.

Operations

REGISTER X
 Add registration token X.

NEXT
 Process the next registration token.

If no registration is pending when NEXT is called, print -1.

Input Format

The first line contains an integer Q, the number of operations.

Each of the next Q lines contains one operation:

REGISTER X

NEXT

Output Format

For every NEXT operation, print the registration token being processed.

If no registration is pending, print -1.

Example
Input
6

REGISTER 101

REGISTER 205

NEXT

REGISTER 309

NEXT

NEXT

Output
101

205

309

Explanation:

Initially, the registration queue is empty.

1. REGISTER 101

Queue: 101

2. REGISTER 205

Queue: 101 205

3. NEXT

Processes token 101

Queue: 205

4. REGISTER 309

Queue: 205 309

5. NEXT

Processes token 205

Queue: 309

6. NEXT

Processes token 309

Queue becomes empty

Constraints
1 ≤ Q ≤ 10⁵
1 ≤ X ≤ 10⁹

Hints (3) */
import java.util.*;

class RegistrationRequest{
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    int q = sc.nextInt();
    sc.nextLine();

    Stack<Long> s1 = new Stack<>();
    Stack<Long> s2 = new Stack<>();

    while(q-- > 0){
      String line = sc.nextLine();

      if(line.startsWith("REGISTER")){
        String[] parts = line.split(" ");
        long token = Long.parseLong(parts[1]);

        s1.push(token);
      } else if(line.equals("NEXT")){
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