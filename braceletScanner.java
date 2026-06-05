/*Problem Statement
During the annual college fest, every student entering the concert arena receives a digital bracelet with a unique numeric code.

At the main gate, Prema is managing a smart scanner system that continuously combines all scanned bracelet IDs using a special operation called XOR.

The scanner follows one interesting rule:

If the final XOR value becomes 0, the crowd is considered perfectly balanced.

Otherwise, the system marks the crowd as unbalanced.

Prema notices something unusual:
 whenever two identical bracelet IDs are scanned, they somehow “cancel each other out” inside the scanner.

Now she wants your help to determine whether the final crowd status is:

BALANCED

or UNBALANCED

before the concert begins.

Input Format

First line contains an integer N

Second line contains N space-separated integers representing bracelet IDs

Output Format

Print:

BALANCED

or UNBALANCED

Example
Input
6

4 1 1 7 7 4

Output
BALANCED

Explanation:

1. 4 ^ 1 ^ 1 ^ 7 ^ 7 ^ 4 = 0

2. All duplicate bracelet IDs cancel each other, leaving the final XOR as 0. */

import java.util.*;

class braceletScanner{
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    System.out.println("Enter no of ids");
    int n = sc.nextInt();

    int xor = 0;

    System.out.println("Enter the ids");
    for(int i = 0; i < n; i++){
      int num = sc.nextInt();

      xor ^= num;
      
    }
    if( xor == 0){
      System.out.println("BALANCED");
    } else {
      System.out.println("UNBALANCED");
    }
  }
}