/*Problem Statement
Apoorva receives an array that is already sorted except for a few misplaced elements.

She wants to choose a sorting algorithm that performs efficiently on such arrays.

Your task is to sort the array using the insertion process and determine how many shifts are performed during the sorting.

A shift occurs whenever an element moves one position to the right while inserting an element into its correct position.

Count every single-position right movement as one shift.

Input Format
First line contains integer N

Second line contains N integers

Output Format

Print the sorted array on the first line.

Print the total number of shifts performed on the second line.

Example
Input
6

1 2 4 5 3 6

Output
1 2 3 4 5 6

2

Explanation:

1. While inserting 3, the elements 5 and 4 shift one position to the right.

2. Hence, the total number of shifts performed is 2.

Constraints
1 ≤ N ≤ 100
0 ≤ arr[i] ≤ 10^9 */
import java.util.*;

public class insertionSort{
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter the no of integers");
    int n = sc.nextInt();

    long[] arr = new long[n];

    System.out.println("enter the elements");
    for(int i = 0; i < n; i++){
      arr[i] = sc.nextInt();
    }
    long shifts = 0;

    for(int i = 1; i < n; i++){
      long key = arr[i];
      int j = i - 1;

      while(j > 0 && arr[j] > key){
        arr[j + 1] = arr[j];
        shifts++;
        j--;
      }
      arr[j + 1] = key;
    }
    for(int i = 0; i < n; i++){
      System.out.print(arr[i]);
      if(i < n-1){
        System.out.print(" ");
      }
    }
    System.out.println();
    System.out.println(shifts);
  }
}