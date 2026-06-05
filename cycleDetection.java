/*Problem Statement
Swastik is tracking the route of a campus shuttle bus. Each stop points to the next stop, forming a linked list.

One day, due to a routing bug, the shuttle starts going back to a previously visited stop instead of moving forward.

If this happens, the shuttle will keep circling the campus forever!

Help Swastik determine whether the route contains a loop.

Input Format
The first line contains an integer N — the number of stops.

The second line contains N space-separated integers representing the linked list.

The third line contains an integer POS.

If POS = -1, the last node points to NULL.

Otherwise, the last node points to the node at index POS (0-indexed).

Output Format


Print: YES.

if the linked list contains a loop, otherwise print: NO.

Example
Input
5

10 20 30 40 50

1

Output
YES

Explanation

The route is:

10 → 20 → 30 → 40 → 50

↑ ↓

└──────────────┘

The last stop points back to the stop at index 1 (value 20), creating a loop.

The shuttle will keep circling forever.

Constraints
1 ≤ N ≤ 10⁵
-10⁹ ≤ Node Value ≤ 10⁹
-1 ≤ POS < N
Note:
POS is used by the system to connect the last node to the node at index POS.
If POS = -1, the linked list does not contain a cycle.

Hints (3) */
import java.util.*;

class Node{
  int data;
  Node next;

  Node(int data){
    this.data = data;
  }
}

public class cycleDetection{
  public static boolean hasCycle(Node head){
    Node slow = head;
    Node fast = head;

    while(fast != null && fast.next != null){
      slow = slow.next;
      fast = fast.next.next;

      if(slow == fast){
        return true;
      }
    }
    return false;
  }

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    Node[] nodes = new Node[n];

    Node head = null;
    Node tail = null;

    for(int i = 0; i < n; i++){
      int val = sc.nextInt();

      Node node = new Node(val);
      nodes[i] = node;

      if(head == null){
        head = tail = node;
      } else {
        tail.next = node;
        tail = node;
      }
      
    }
    int pos = sc.nextInt();

    if(pos != -1){
      tail.next = nodes[pos];
    }

    System.out.println(hasCycle(head) ? "YES" : "NO");
  }
}