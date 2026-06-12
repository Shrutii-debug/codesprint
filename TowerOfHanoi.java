/*Problem Statement
An archaeologist Rita discovers N sacred golden plates stacked in a temple vault.
The plates must be transferred from the Source Platform (A) to the Destination Platform (C) using a Temporary Platform (B).
According to ancient rules:
Only one plate may be moved at a time.
A larger plate may never be placed on a smaller plate.
The temporary platform may be used as an intermediate storage area.
Help Rita determine the exact sequence of moves required to relocate all the plates successfully.
Input Format
The first line contains a single integer N, representing the number of sacred golden plates. 

Output Format
Print each move on a separate line in the format:

Move plate X from A to C

where:

X is the plate number.

Platforms are represented by A, B, and C.

After printing all moves, print the total number of moves required.

Format:

Move plate ...

Move plate ...

...

Total Moves = K

Example
Input
N = 2

Output
Move plate 1 from A to B

Move plate 2 from A to C

Move plate 1 from B to C

Total Moves = 3

Explanation:

Initially:

A: 2 1

B:

C:

Steps:

Move plate 1 from A to B.

Move plate 2 from A to C.

Move plate 1 from B to C.

All plates are now successfully relocated.

Constraints
1 ≤ N ≤ 15

Hints (3) */
import java.util.*;
public class TowerOfHanoi{
  static long moves = 0;

  public static void hanoi(int n, char source, char helper, char destination){
    if(n == 1){
      System.out.println("Move plate 1 from " + source + "to" + destination);

      moves++;
      return;
    }
    hanoi(n-1, source, destination, helper);

    System.out.println("Move plate" + n + " from " + source + " to " + destination);
    moves++;
    hanoi(n-1, helper, source, destination);

    
  }
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    hanoi(n, 'A', 'B', 'C');

    System.out.println("Total moves = " +moves);
  }
}