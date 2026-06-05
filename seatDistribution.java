/* Problem Statement
During exam week, Sneha is trying to find the quietest seats in the college library.

The library is represented as an N × N matrix where:

1 represents an occupied seat

0 represents an empty seat

Sneha believes students sitting next to each other will start gossiping instead of studying.

So, an empty seat becomes disturbed if at least one of its neighboring seats (top, bottom, left, or right) is occupied.

Help Sneha mark the library seats using:

O → Occupied seat

X → Disturbed seat

S → Safe empty seat

Input Format

First line contains an integer N

Next N lines contain N space-separated integers (0 or 1)

Output Format


Print the final seating matrix.

Example
Input
N = 3

1 0 0

0 0 1

0 0 0

Output
O X X

X X O

S S X

Explanation:

1.Occupied seats (1) are marked as O.

2.Empty seats adjacent to occupied seats are marked as X.

3.Remaining empty seats are marked as S.

Constraints
1 ≤ N ≤ 50 */
import java.util.*;

public class seatDistribution{
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    System.out.println("Enter N");

    int N = sc.nextInt();

    int[][] arr = new int[N][N];

    System.out.println("Enter the elements");

    for(int i = 0; i < N; i++){
      for(int j = 0; j < N; j++){
        arr[i][j] = sc.nextInt();
      }
    }

    int[] dr = {-1, 1, 0, 0};
    int[] dc = {0, 0, -1, 1};

    for(int i = 0; i < N; i++){
      for(int j = 0; j < N; j++){
        if(arr[i][j] == 1){
          System.out.print("O ");
        } else {
          boolean disturbed = false;

          for(int k = 0; k < 4; k++){
            int newRow = i + dr[k];
            int newCol = j + dc[k];

            if(newRow >= 0 && newRow < N && newCol >= 0 && newCol < N){
              if(arr[newRow][newCol] == 1){
                disturbed = true;
                break;
              }
            }
            
          }
          if(disturbed){
            System.out.print("X ");
          } else {
            System.out.print("S ");
          }
        }
      }
      System.out.println();
    }
  }
}