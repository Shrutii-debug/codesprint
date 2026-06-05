/* Problem Statement
Ansuman recently joined as a volunteer at his college tech fest.
At the main entrance, a digital security system checks a sequence of alarm codes before allowing entry.
The system follows one important rule:
No two consecutive alarm codes should be identical.
If the same code appears back-to-back, the system raises an alert.
Help Ansuman determine:
If no adjacent elements are the same → print "VALID"
Otherwise → print "INVALID" along with the first index where repetition occurs.
Input Format
The first line contains an integer N — the number of alarm codes.
The second line contains N space-separated integers representing the alarm codes. 
Output Format
Print "VALID” if no two adjacent elements are equal.

Otherwise, print: "INVALID index"

where index is the first position (0-indexed) where repetition occurs.

Example
Input
N = 5

Codes = 1 2 2 3 4

Output
INVALID 2

Explanation: At index 2, the code 2 is repeated consecutively. */

import java.util.*;

public class findConsecutive{
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    System.out.println("Enter size");
    int N = sc.nextInt();

    int[] arr = new int[N];

    System.out.println("enter the code");

    for(int i = 0; i < N; i++){
      arr[i] = sc.nextInt();
    }

    for(int i = 0; i < N - 1; i++){
      if(arr[i] == arr[i+1]){
        System.out.println("INVALID " + (i+1));
        return;
      }
    }
    System.out.println("VALID");
  }
}