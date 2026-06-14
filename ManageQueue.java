/*Problem Statement
Placement season has begun at KIIT.

Aprajita is volunteering at the Placement Cell and is responsible for managing interview slots.

Students register for interviews throughout the day.

The placement process follows these rules:

Students are interviewed in the exact order they register.

A student may withdraw before being interviewed.

Aprajita can call the next waiting student for an interview.

The system supports:

REGISTER X → Student X registers for an interview.

WITHDRAW → The student currently at the front of the queue withdraws.

NEXT → Aprajita calls the student at the front of the queue for an interview.

If WITHDRAW or NEXT is called when the queue is empty, print -1.

For every NEXT operation, print the student ID being interviewed.

Input Format

The first line contains an integer Q — the number of operations.

The next Q lines contain one of the following operations:

REGISTER X

WITHDRAW

NEXT

Output Format

For every NEXT operation:

Print the student ID being interviewed.

If the queue is empty, print -1.

Example
Input
7

REGISTER 101

REGISTER 102

NEXT

REGISTER 103

WITHDRAW

NEXT

NEXT

Output
101

103

-1

Explanation:

1. Initial registrations: 101 102

2. NEXT: 101 is interviewed

Queue: 102

3. REGISTER 103: 102 103

4. WITHDRAW: 102 leaves the queue

Queue: 103

5. NEXT: 103 is interviewed

Queue becomes empty

6. NEXT: Queue is empty

Output: -1

Constraints
1 ≤ Q ≤ 10^5
1 ≤ X ≤ 10^9

Hints (3) */
import java.util.*;

class ManageQueue{
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    int q = sc.nextInt();
    sc.nextLine();

    Queue<Long> queue = new LinkedList<>();

    while(q-- > 0){
      String operation = sc.nextLine();

      if(operation.startsWith("REGISTER")){
        String[] parts = operation.split(" ");
        long id = Long.parseLong(parts[1]);

        queue.offer(id);
      } else if(operation.equals("WITHDRAW")){
        if(!queue.isEmpty()){
          queue.poll();
        }
      }
      else if(operation.equals("NEXT")){
        if(queue.isEmpty()){
          System.out.println("-1");
        } else {
          System.out.println(queue.poll());
        }
      }
    }
  }
}