/*Poulam and the Ancient Treasure Lock
medium
Arrays
Two Pointers
Triplet Sum
Problem Statement
While exploring an ancient temple, Poulam discovered a mysterious treasure chest protected by a magical number lock.

The lock opens only when:

Three numbers from the given list add up exactly to the target value K.

If such a triplet exists, the treasure chest unlocks successfully.

Help Poulam determine whether the treasure can be opened.

Input Format
The first line contains an integer N — the number of values.

The second line contains N space-separated integers.

The third line contains an integer K — the target value.

Output Format
Print "YES" if any triplet sum equals K.

Otherwise, print "NO".

Example
Input
N = 6

1 4 6 8 10 45

K = 22

Output
YES

Explanation:

1. The numbers 4, 8, and 10 form a triplet whose sum is 22.

2. Since a valid triplet exists, the treasure lock opens and hence the output is "YES". */
import java.util.*;
public class threeSum{
  static boolean tripletSum(int[] arr, int k){
    Arrays.sort(arr);

    int n = arr.length;

    for(int i = 0; i < n; i++){
      int left = i + 1;
      int right = n - 1;

      while(left < right){
      int sum = arr[i] + arr[left] + arr[right];

      if(sum == k){
        return true;
      } else if(sum < k){
        left++;
      } else{
        right--;
      }
      }
      
    }
    return false;
  }
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    System.out.println("enter the number of elements");
    int n = sc.nextInt();

    System.out.println("Enter the elements");

    int[] arr = new int[n];
    for(int i = 0; i < n; i++){
      arr[i] = sc.nextInt();
    }
    System.out.println("Enter the target value");
    int k = sc.nextInt();

    if(tripletSum(arr, k)){
      System.out.println("YES");
    } else {
      System.out.println("NO");
    }
  }
}