/* Problem Statement
Prateek discovered an ancient energy grid hidden beneath the CodeSprint 3.0 arena.
The grid contains magical power values arranged in a square matrix.

According to the ancient rule:

The grid is considered stable only if the sum of both diagonals is equal.

Prateek wants to check whether the energy grid is stable or not.

Help him determine the result.

Input Format
The first line contains an integer N — the size of the square grid.

The next N lines contain N integers each representing the grid values.

Output Format
Print "YES" if the sum of both diagonals is equal.

Otherwise, print "NO".

Example
Input
N = 3

1 2 3

4 5 6

7 8 1

Output
NO

Explanation

Main diagonal sum = 1 + 5 + 1 = 7

Secondary diagonal sum = 3 + 5 + 7 = 15 */

import java.util.*;

class sumDiagonal{
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    System.out.println("Enter the size");
    int N = sc.nextInt();

    System.out.println("Enter the elements");
    int[][] arr = new int[N][N];

    for(int i= 0; i < N; i++){
      for(int j = 0; j < N; j++){
        arr[i][j] = sc.nextInt();
      }
    }
    int mainDiagonal = 0;
    int secondaryDiagonal = 0;

    for(int i = 0; i < N; i++){
      mainDiagonal += arr[i][i];
      secondaryDiagonal += arr[i][N-1-i];
    }
    if(mainDiagonal == secondaryDiagonal){
      System.out.println("YES");
    } else {
      System.out.println("NO");
    }
  }
}