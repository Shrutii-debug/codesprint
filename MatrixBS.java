/*Problem Statement
Ananya is exploring an ancient treasure vault represented as an N × M matrix.

The vault follows two special rules:

Every row is sorted in strictly increasing order.

The first element of every row is greater than the last element of the previous row.

Because of these properties, all values in the vault can be viewed as a single globally sorted sequence.

Given a treasure value X, determine whether it exists anywhere in the vault. You only need to report whether the value is present or absent.

Input Format
First line contains two integers N and M

Next N lines contain M integers each representing the matrix

Last line contains integer X

Output Format

Print: FOUND if the treasure exists in the matrix, otherwise print: NOT FOUND

Example
Input
3 4

1 3 5 7

10 11 16 20

23 30 34 60

16

Output
FOUND

Explanation:

The matrix can be interpreted as the sorted sequence: 1 3 5 7 10 11 16 20 23 30 34 60

Since: 16 exists in the sequence, the answer is: FOUND

Constraints
1 ≤ N × M ≤ 10^5
-10^9 ≤ Matrix[i][j] ≤ 10^9

Hints (3) */

import java.util.*;

class MatrixBS{
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int m = sc.nextInt();

    int[][] matrix = new int[n][m];

    for(int i = 0; i < n; i++){
      for(int j = 0; j < m; j++){
        matrix[i][j] = sc.nextInt();
      }
    }
    int target = sc.nextInt();

    int left = 0; 
    int right = n * m - 1;

    boolean found = false;

    while(left <= right){
      int mid = left + (right - left)/2;

      int row = mid / m;
      int col = mid % m;

      int value = matrix[row][col];

      if(value == target){
        found = true;
        break;
      } 

      else if(value < target) left = mid + 1;
      else right = mid - 1;
    }
    if(found) System.out.println("FOUND");
    else System.out.println("NOT FOUND");
  }
}