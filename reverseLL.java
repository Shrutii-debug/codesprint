/*Problem Statement
Lovely is the coordinator of a college technical club and maintains the attendance record of members using a linked sequence, where each member's entry points to the next member.

For an upcoming club report, she wants to view the attendance records in reverse order.

Help Lovely reverse the linked list and print the resulting sequence.

Important Rule

You may only change the links between nodes.

You are not allowed to modify the values stored inside the nodes.

Input Format


The first line contains an integer N — the number of members in the attendance list.

The second line contains N space-separated integers representing the linked list.

Output Format


Print the elements of the reversed linked list.

Example
Input
5

10 20 30 40 50

Output
50 40 30 20 10

Explanation

Original Attendance List: 10 → 20 → 30 → 40 → 50

After reversing the links: 50 → 40 → 30 → 20 → 10

Therefore, the output is: 50 40 30 20 10

Constraints
1 ≤ N ≤ 10⁵
-10⁹ ≤ Node Value ≤ 10⁹

Hints (3) */
import java.util.*;

class Node{
  int data;
  Node next;

  Node(int data){
    this.data = data;
  }
}
public class reverseLL{

  public static Node reverse(Node head){
    Node prev = null;
    Node curr = head;

    while(curr != null){
    Node next = curr.next;
    curr.next = prev;

      prev = curr;
      curr = next;
    } 
    return prev;
  }

  public static void printList(Node head){
    while(head != null){
      System.out.print(head.data + " ");
      head = head.next;
    }
  }
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();

    Node head = null;
    Node tail = null;

    for(int i = 0; i < n; i++){
      Node node = new Node(sc.nextInt());

      if(head == null){
        head = tail = node;
      } else {
        tail.next = node;
        tail = node;
      }
    }
    head = reverse(head);
    printList(head);
    
  }
}