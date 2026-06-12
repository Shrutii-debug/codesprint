/*Problem Statement
A social networking company manager Riju wants to create a backup copy of its user recommendation system.

Each user is represented as a node in a linked list.

Every node contains:

User ID (data)

Next user (next)

Recommended friend (random)

Riju wants to create a deep copy of the entire user network.

A deep copy means:

New nodes must be created.

The copied nodes must preserve both next and random connections.

No node in the cloned list should point to any node in the original list.

You are given the linked list and the index of each node's random connection.

Return the cloned list in the same format.

Input Format
The first line contains an integer N, the number of users (nodes).

The second line contains N space-separated integers representing the user IDs.

The third line contains N space-separated integers representing the random friend connections.

random[i] = j means the random pointer of the i-th node points to the j-th node.

-1 indicates that the random pointer is NULL.

Output Format
Print N lines representing the cloned linked list.

For each cloned node, print:

UserID RandomIndex

where:

UserID is the data stored in the cloned node.

RandomIndex is the index of the node pointed to by its random pointer.

Print -1 if the random pointer is NULL.

Example
Input
5

101 205 309 412 550

2 4 -1 0 1

Output
101 2

205 4

309 -1

412 0

550 1

Explanation:

The original social network is:

User Random Friend

101 309

205 550

309 NULL

412 101

550 205

After cloning:

Five completely new nodes are created.

The next chain remains identical.

The random relationships are preserved.

No cloned node points to any node in the original list.

Thus the cloned list produces the same data and random mapping.

Constraints
1 ≤ N ≤ 10^5
1 ≤ UserID ≤ 10^9
-1 ≤ RandomIndex < N

Hints (3) */

import java.util.*;

class RandomNode{
  int data;
  RandomNode next;
  RandomNode random;

  RandomNode(int data){
    this.data = data;
  }
}

class CloneLL{
  public static RandomNode copyLL(RandomNode head){
    if(head == null) return null;

    HashMap<RandomNode, RandomNode> map = new HashMap<>();

    RandomNode curr = head;
    while(curr != null){
      map.put(curr, new RandomNode(curr.data));
      curr = curr.next;
    }

    curr = head;
    while(curr != null){
      RandomNode clone = map.get(curr);

      clone.next = map.get(curr.next);
      clone.random = map.get(curr.random);

      curr = curr.next;
    }
    return map.get(head);
  }
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();

    int[] values = new int[n];

    for(int i = 0; i < n; i++){
      values[i]  = sc.nextInt();
    }

    int[] randomIndex = new int[n];
    for(int i = 0; i < n; i++){
      randomIndex[i] = sc.nextInt();
    }
    RandomNode[] nodes = new RandomNode[n];

    for(int i = 0; i < n; i++){
      nodes[i] = new RandomNode(values[i]);
    }
    for(int i= 0; i < n - 1; i++){
      nodes[i].next = nodes[i+1];
    }

    for(int i = 0; i < n; i++){
      if(randomIndex[i] != -1){
        nodes[i].random = nodes[randomIndex[i]];
      }
    }
    RandomNode head = nodes[0];

    RandomNode clonedHead= copyLL(head);
    ArrayList<RandomNode> clonedNodes = new ArrayList<>();

    RandomNode temp = clonedHead;
    while(temp != null){
      clonedNodes.add(temp);
      temp = temp.next;
    }
    for(int i = 0; i < clonedNodes.size(); i++){
      RandomNode curr = clonedNodes.get(i);

      int idx = -1;

      if(curr.random != null){
        idx = clonedNodes.indexOf(curr.random);
      }
      System.out.println(curr.data + " " + idx);
    }
  }
}
