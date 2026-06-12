/*Problem Statement
Saptarshi is organizing a coding challenge where participants stand in a circle. Each participant is assigned a unique ID, and the participants are arranged in the form of a circular linked list.

Starting from the first participant, every K-th participant is eliminated from the circle. After each elimination, counting resumes from the next participant still in the game.

The process continues until only one participant remains.

Your task is to determine the ID of the participant who survives till the end.

Input Format
The first line contains an integer N — the number of participants.

The second line contains N distinct integers representing the participant IDs in circular order.

The third line contains an integer K — every K-th participant will be eliminated.

Output Format
Print a single integer representing the ID of the last remaining participant.

Example
Input
N = 7

IDs = 10 20 30 40 50 60 70

K = 3

Output
40

Explanation

Participants are arranged in a circle. Every third participant is removed from the game until only one participant remains. The surviving participant's ID is 40.

Constraints
1 ≤ N ≤ 10⁵
1 ≤ K ≤ 10⁵
Participant IDs are distinct and fit within a 32-bit signed integer.

Hints (3) */

import java.util.*;

public class josephusProblem{
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();

    int[] ids = new int[n];
    for(int i = 0; i < n; i++){
      ids[i] = sc.nextInt();
    }

    int k = sc.nextInt();

    int survivor = 0;

    for(int i = 1; i <= n; i++){
      survivor = (survivor + k) % i;
    }
    System.out.println(ids[survivor]);
  }
  }


  /* using circular linked list
  
  import java.util.*;

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
    }
}

public class Main {

    public static int josephus(int[] arr, int k) {

        int n = arr.length;

        Node head = new Node(arr[0]);
        Node tail = head;

        for (int i = 1; i < n; i++) {
            tail.next = new Node(arr[i]);
            tail = tail.next;
        }

        // Make circular
        tail.next = head;

        Node curr = head;
        Node prev = tail;

        while (curr.next != curr) {

            for (int i = 1; i < k; i++) {
                prev = curr;
                curr = curr.next;
            }

            // delete curr
            prev.next = curr.next;
            curr = curr.next;
        }

        return curr.data;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int k = sc.nextInt();

        System.out.println(josephus(arr, k));
    }
}*/