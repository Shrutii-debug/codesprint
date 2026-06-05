/* Problem Statement
Kavya wanted to decorate her hostel room wall with a creative alphabet design for the college fest.
This time, she decided to create a beautiful alphabet pattern using only uppercase English letters and stars (*).
The pattern rules are:
Print alphabets (A, B, C...) on both diagonals.
The alphabet printed depends on the row number.
Print * in all remaining positions.
Help Kavya print this stylish alphabet cross pattern.
Input Format
A single integer N — size of the pattern.
Output Format
Print the required alphabet pattern.
Example
Input
N = 5

Output
A * * * A

* B * B *

* * C * *

* D * D *

E * * * E

Constraints
1 ≤ n ≤26 */

import java.util.*;

class Pattern{
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    System.out.println("Enter N");

    int N = sc.nextInt();

    for(int i = 0; i < N; i++){
      char ch = (char)('A' + i);

      for(int j = 0; j < N; j++){
          if(j == i || j == N-i-1){
          System.out.print(ch);
        } else {
          System.out.print("* ");
        }

        if(j != N - 1){
          System.out.print(" ");
        }
      }
      System.out.println();
    }
  }
}