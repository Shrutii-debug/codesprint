
import java.util.*;

class Node{
  int data;
  Node next;

  Node(int data){
    this.data = data;
  }
}

public class MiddleLL{
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();

    Node head = null, tail = null;

    for(int i = 0; i < n; i++){
      int val = sc.nextInt();
      Node newNode = new Node(val);

      if(head == null){
        head = tail = newNode;
      } else {
        tail.next = newNode;
        tail = newNode;
      }
    }
    Node slow = head;
    Node fast = head;

    while(fast != null && fast.next != null){
      slow = slow.next;
      fast = fast.next.next;
    }
    System.out.print(slow.data);
  }
}