/*Problem Statement
Inside the college library, bookshelves were connected through hidden smart paths. Some shelves also had shortcut portals connecting to distant shelves.

A student named Devansh discovered that two different library maps actually merged into the same final pathway.

Each library map is represented as a linked list, and both lists may intersect at a common shelf.

Your task is to find the first shelf where both paths intersect.

Note: If the two paths do not intersect, print -1.

Input Format
The first line contains an integer N — the number of shelves in the first path.

The second line contains N integers representing the nodes of the first linked path.

The third line contains an integer M — the number of shelves in the second path.

The fourth line contains M integers representing the nodes of the second linked path.

The fifth line contains an integer X — the value of the node where the intersection begins.

If no intersection exists, X = -1.

Output Format
Print a single integer — the value of the first common shelf where the two paths intersect.

If no intersection exists, print -1.

Example
Input
N = 5

Path1 = 1 2 3 8 10

M = 4

Path2 = 5 6 8 10

X = 8

Output
8

Explanation:

The two linked paths merge at shelf 8.

After that point, both paths share the same sequence of shelves: 8 → 10

Therefore, the first common shelf where both maps intersect is 8.

Constraints
1 ≤ N, M ≤ 10⁵
1 ≤ Node Value ≤ 10⁹

Hints (3) */
import java.util.*;

class Node{
  int data;
  Node next;

  Node(int data){
    this.data = data;
  }
}
public class intersection{
  public static Node getIntersection(Node headA, Node headB){
    Node p1 = headA;
    Node p2 = headB;

    while(p1 != p2){
      p1 = (p1 == null) ? headB : p1.next;
      p2 = (p2 == null) ? headA : p2.next;
    }
    return p1;
  }

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    Node head1 = null, tail1 = null;

    HashMap<Integer, Node> map = new HashMap<>();

    for(int i = 0; i < n; i++){
      int val = sc.nextInt();

      Node node = new Node(val);
      map.put(val, node);

      if(head1 == null){
        head1 = tail1 = node;
      } else {
        tail1.next = node;
        tail1 = node;
      }
    }
    int m = sc.nextInt();
    Node head2 = null, tail2 = null;
    int[] arr2 = new int[m];

    for(int i = 0; i < m; i++){
      arr2[i] = sc.nextInt();
    }

    int x = sc.nextInt();
    if(x == -1){
    for(int i = 0; i < m; i++){
      Node node = new Node(arr2[i]);

      if(head2 == null){
        head2 = tail2 = node;
      } else {
        tail2.next = node;
        tail2 = node;
      }
    }
  } else {
    int idx = 0;
    while(idx < m && arr2[idx] != x){
      Node node = new Node(arr2[idx]);

      if(head2 == null){
        head2 = tail2 = node;
      } else {
        tail2.next = node;
        tail2 = node;
        
      }
      idx++;
    }
    if(head2 == null){
      head2 = map.get(x);
    } else {
      tail2.next = map.get(x);
    }
  }
  Node intersection = getIntersection(head1, head2);

  if(intersection == null){
    System.out.println(-1);
  } else {
    System.out.println(intersection.data);
  }
}
}