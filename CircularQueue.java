/*Problem Statement
Ram manages the parcel pickup counter in the college mail room.

The digital display can keep track of only K active parcel tokens at a time.

To make the best use of the limited display, the system stores the tokens using a circular queue.

Help Ram process the parcel counter operations.

Operations

ENQUEUE X
 Add parcel token X to the queue.

DEQUEUE
 Serve the parcel token at the front of the queue.

FRONT
 Print the parcel token currently at the front.

Rules

If ENQUEUE is performed when the queue is full, print FULL.

If DEQUEUE is performed when the queue is empty, print EMPTY.

If FRONT is performed when the queue is empty, print -1.

Input Format

The first line contains two integers K and Q.

K represents the capacity of the circular queue.

Q represents the number of operations.

Each of the next Q lines contains one operation:

ENQUEUE X

DEQUEUE

FRONT

Output Format

For every FRONT operation, print the parcel token at the front of the queue.

If ENQUEUE is performed when the queue is full, print FULL.

If DEQUEUE is performed when the queue is empty, print EMPTY.

If FRONT is performed when the queue is empty, print -1.

Example
Input
3 7

ENQUEUE 10

ENQUEUE 20

ENQUEUE 30

FRONT

DEQUEUE

FRONT

DEQUEUE

Output
10

20

Explanation:

Initially, the queue is empty.

1. ENQUEUE 10

Queue: 10

2. ENQUEUE 20

Queue: 10 20

3. ENQUEUE 30

Queue: 10 20 30

4. FRONT

Output: 10

5. DEQUEUE

Queue: 20 30

6. FRONT

Output: 20

7. DEQUEUE

Queue: 30

Only the FRONT operations produce output in this example.

Constraints
1 ≤ K ≤ 10⁵
1 ≤ Q ≤ 10⁵
1 ≤ X ≤ 10⁹

Hints (4) */
import java.util.*;

class CircularQueue{
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    int k = sc.nextInt();
    int q = sc.nextInt();
    sc.nextLine();

    int[] queue = new int[k];
    int front = 0;
    int rear = -1;
    int size = 0;

    while(q-- > 0){
      String line = sc.nextLine();

      if(line.startsWith("ENQUEUE")){
        String[] parts = line.split(" ");
        int x = Integer.parseInt(parts[1]);
        if(size == k){
          System.out.println("FULL");
        } else{
          rear = (rear + 1) % k;
          queue[rear] = x;
          size++;
        }
      }
      else if(line.equals("DEQUEUE")){
        if(size == 0){
          System.out.println("EMPTY");
        } else{
          front = (front + 1) % k;
          size--;
        }
      }
      else if (line.equals("FRONT")){
        if(size == 0){
          System.out.println(-1);
        } else {
          System.out.println(queue[front]);
        }
      }
    }
  }
}