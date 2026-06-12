/*Problem Statement
In the futuristic kingdom of Nexora, Zara discovered a magical memory chain storing encrypted data blocks. Each block is connected to both its next and previous blocks using a doubly linked structure.

During a system reboot, the chain must be rotated to the right by K positions.

A right rotation means:

The last DLLNode becomes the new head.

Remaining DLLNodes shift one position ahead.

Both forward (next) and backward (prev) connections must be properly updated and maintained.

Help Zara restore the doubly linked memory chain after the rotation.

Input Format
The first line contains two integers N and K:

N → number of DLLNodes in the doubly linked list

K → number of rotations

The second line contains N space-separated integers representing the doubly linked list.

Output Format
Print the doubly linked list after performing the rotation from head to tail.

Example
Input
N = 5, K = 2

List = 1 2 3 4 5

Output
4 5 1 2 3

Explanation:

Original List: NULL ← 1 ↔ 2 ↔ 3 ↔ 4 ↔ 5 → NULL

After 1st rotation: NULL ← 5 ↔ 1 ↔ 2 ↔ 3 ↔ 4 → NULL

After 2nd rotation: NULL ← 4 ↔ 5 ↔ 1 ↔ 2 ↔ 3 → NULL

Constraints
1 ≤ N ≤ 10^5
0 ≤ K ≤ 10^9
-10^9 ≤ Node values ≤ 10^9 */
import java.util.*;

class DLLNode{
  int data;
  DLLNode next;
  DLLNode prev;

  DLLNode(int data){
    this.data = data;
  }
}

public class rotation{
  public static DLLNode rotateRight(DLLNode head, int k){
    if(head == null || head.next == null || k == 0) return head;

    int len = 1;
    DLLNode tail = head;

    while(tail.next != null){
      tail = tail.next;
      len++;
    }
    k = k % len;

    if(k == 0) return head;

    tail.next = head;
    head.prev = tail;

    int steps = len - k;

    DLLNode newTail = head;

    for(int i = 1; i < steps; i++){
      newTail = newTail.next;
    }

    DLLNode newHead = newTail.next;

    newTail.next = null;
    newHead.prev = null;

    return newHead;
    
  }

  public static void printList(DLLNode head){
    while(head != null){
      System.out.print(head.data + " ");
      head = head.next;
    }
  }

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int k = sc.nextInt();

    DLLNode head = null;
    DLLNode tail = null;

    for(int i = 0; i < n; i++){
      DLLNode DLLNode = new DLLNode(sc.nextInt());

      if(head == null){
        head = tail = DLLNode;
      } else {
        tail.next = DLLNode;
        DLLNode.prev = tail;
        tail = DLLNode;
      }
    }
    head = rotateRight(head, k);
    printList(head);
  }
}