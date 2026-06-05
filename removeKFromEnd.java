/*Problem Statement
Kohinoor is managing the queue for the hostel's famous midnight Maggi counter.

The queue is stored as a linked list, where each node represents a student's token number.

Just before ordering, one student checks their account balance, realizes they have only ₹12 left, and quietly disappears from the line.

The student happens to be the Kth person from the end of the queue.

Help Kohinoor update the linked list by removing that student and print the updated queue.

Input Format

The first line contains an integer N — the number of students in the queue.

The second line contains N space-separated integers representing the linked list.

The third line contains an integer K — the position of the student from the end.

Output Format


Print the updated linked list after removing the Kth node from the end.

Example
Input
5

101 102 103 104 105

2

Output
101 102 103 105

Explanation

Current Queue: 101 → 102 → 103 → 104 → 105

The 2nd student from the end has token: 104

After removing that student, the queue becomes: 101 → 102 → 103 → 105

Therefore, the output is: 101 102 103 105 */
import java.util.*;

class Node{
  int data;
  Node next;

  Node(int data){
    this.data = data;
  }
}

public class removeKFromEnd{
  public static Node remove(Node head, int k){
    Node dummy = new Node(0);
    dummy.next = head;
    
    Node fast = dummy;
    Node slow = dummy;

    for(int i = 0; i <= k; i++){
      fast = fast.next;
    }
    while(fast != null){
      fast = fast.next;
      slow = slow.next;
    }
    slow.next = slow.next.next;

    return dummy.next;
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
    int k = sc.nextInt();

    head = remove(head, k);
    printList(head);
  }
}