/*Problem Statement
In a secret coding lab, Rishav was experimenting with a special data structure called an XOR Linked List to reduce memory usage.

Instead of storing separate next and previous pointers, each node stores the XOR of both addresses.

One day, the traversal system failed, and Rishav could no longer verify whether the list was being traversed correctly.

Your task is to help Rishav print all the nodes of the XOR Linked List from left to right.

Input Format
The first line contains an integer N — the number of nodes in the XOR Linked List.

The second line contains N integers representing the values stored in the nodes.

Output Format
Print all node values in their traversal order from left to right.

Values should be separated by a single space.

Example
Input
N = 5

Nodes = 11 22 33 44 55

Output
11 22 33 44 55

Explanation:

The XOR Linked List contains the nodes: 11 ↔ 22 ↔ 33 ↔ 44 ↔ 55

Traversing from the head node to the tail node visits the values in the order: 11 22 33 44 55

Constraints
1 ≤ N ≤ 10⁵
1 ≤ Node Value ≤ 10⁹

Hints (3) */
import java.util.*;
public class xorLL{
  static class Node{
    int data;
    int both;

    Node(int data){
      this.data = data;
      this.both = 0;
    }
  }
  static class XORLinkedList{
    private Map<Integer, Node> memory = new HashMap<>();
    private int head = 0;
    private int tail = 0;
    private int nextId = 1;

    public void add(int data){
      Node node = new Node(data);
      int id = nextId++;

      memory.put(id, node);

      if(head == 0){
        head = tail = id;
      } else {
        Node tailNode = memory.get(tail);

        tailNode.both ^= id;

        node.both = tail;

        tail = id;
      }
    }

    public void traverse(){
      int prev = 0;
      int curr = head;

      while(curr != 0){
        Node currNode = memory.get(curr);

        System.out.print(currNode.data);

        int next = prev ^ currNode.both;

        if(next != 0){
          System.out.print(" ");
        }

        prev = curr;
        curr = next;
      }
      System.out.println();
    }
  }
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();

    XORLinkedList list = new XORLinkedList();

    for(int i = 0; i < n; i++){
      list.add(sc.nextInt());
    }
      list.traverse();
    
  }
  
}