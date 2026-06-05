/*Problem Statement
Abhishek was practicing coding problems for CodeSprint 3.0 when he discovered a strange number sequence.

The sequence was already sorted in increasing order, but it contained both:

negative numbers

positive numbers

Abhishek’s challenge was simple:

Square every number and print the resulting array in sorted order.

Help Abhishek complete the challenge.

Input Format
The first line contains an integer N — the size of the array.

The second line contains N sorted integers.

Output Format
Print the squared values in sorted order.

Example
Input
N = 5

-7 -3 2 3 11

Output
4 9 9 49 121

Explanation:

1. After squaring the numbers: 49 9 4 9 121

2. Sorting them gives: 4 9 9 49 121 */
import java.util.*;

class squareTwoPointers{
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter the number of elements");
    int n = sc.nextInt();

    int[] arr = new int[n];
    int[] result = new int[n];
    System.out.println("Enter the numbers");
    for(int i = 0; i < n; i++){
      arr[i] = sc.nextInt();
    }

    int left = 0;
    int right = n - 1;
    int index = n - 1;

    while(left <= right){
      int leftSquare = arr[left] * arr[left];
      int rightSquare = arr[right] * arr[right];

      if(leftSquare > rightSquare){
        result[index] = leftSquare;
        left++;
      } else {
        result[index] = rightSquare;
        right--;
      }
      index--;
    }
    for(int i = 0; i < n; i++){
      System.out.print(result[i] + " ");
    }
  }
}