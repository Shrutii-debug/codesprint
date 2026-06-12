/*Problem Statement
Dwipayan stored his semester notes in a unique multi-level linked structure.

Some notes contained another complete sorted sub-list of related notes attached downward. While this organization helped keep topics grouped together, it made revision difficult before exams.

To make studying easier, help Dwipayan flatten the entire notes structure into a single sorted linked list.

Input Format
The first line contains an integer N — the number of top-level notes.

The next N lines contain sorted linked sublists.

Each line represents one sorted sublist, and elements within a sublist are separated by spaces.

Output Format

Print the flattened sorted linked list.

Elements should be separated by a single space.

Example
Input
3

1 4 7

2 5 8

3 6 9

Output
1 2 3 4 5 6 7 8 9

Explanation:

1. The three sorted sublists are:

1 → 4 → 7

2 → 5 → 8

3 → 6 → 9

2. Flattening the structure means merging all sorted sublists while maintaining sorted order, resulting in: 1 → 2 → 3 → 4 → 5 → 6 → 7 → 8 → 9

3. Hence, the output is: 1 2 3 4 5 6 7 8 9

Constraints
1 ≤ N ≤ 10⁵
Each sublist is sorted in non-decreasing order.
Total nodes ≤ 10⁵

Hints (2) */

import java.util.*;

class MultiLevelNode{
  int data;
  MultiLevelNode next;
  MultiLevelNode bottom;

  MultiLevelNode(int data){
    this.data = data;
    this.next = null;
    this.bottom = null;
  }
}

public class flattenLL{
  static MultiLevelNode mergeBottomLists(MultiLevelNode a, MultiLevelNode b){
    MultiLevelNode dummy = new MultiLevelNode(-1);
    MultiLevelNode curr = dummy;

    while(a != null && b != null){
      if(a.data <= b.data){
        curr.bottom = a;
        a = a.bottom;
      } else {
        curr.bottom = b;
        b = b.bottom;
      }
      curr = curr.bottom;
      curr.next = null;
    }
    curr.bottom = (a != null) ? a : b;

    return dummy.bottom;
  }
  static MultiLevelNode flatten(MultiLevelNode root){
    if(root == null || root.next == null){
      return root;
    }
    root.next = flatten(root.next);

    return mergeBottomLists(root, root.next);
  }

  static void printFlattenedList(MultiLevelNode head){
    while(head != null){
      System.out.print(head.data);
      if(head.bottom != null){
        System.out.print(" ");
      }
      head = head.bottom;
    }
  }
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    int n = Integer.parseInt(sc.nextLine().trim());

    MultiLevelNode head = null;
    MultiLevelNode prevTop = null;

    int listsRead = 0;

    while(listsRead < n && sc.hasNextLine()){
      String line = sc.nextLine().trim();

      if(line.isEmpty()){
        continue;
      }

      String[] values = line.split("\\s+");

      MultiLevelNode verticalHead = null;
      MultiLevelNode verticalTail = null;

      for(String value : values){
        MultiLevelNode node = new MultiLevelNode(Integer.parseInt(value));

        if(verticalHead == null){
          verticalHead = node;
          verticalTail = node;
        } else {
          verticalTail.bottom = node;
          verticalTail = node;
        }
      }
      if(head == null){
        head = verticalHead;
      } else {
        prevTop.next = verticalHead;
      }

      prevTop = verticalHead;
      listsRead++;
    }
    MultiLevelNode flattenedHead = flatten(head);
    printFlattenedList(flattenedHead);
  }
}
