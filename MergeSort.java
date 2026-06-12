/*Problem Statement
Ankita created a magical coding screen that had a unique way of solving problems. Whenever she clicked "Run", the screen automatically split a problem into two smaller versions of itself.

The process continued recursively until each part contained only a single element. The screen then combined these smaller parts step by step to produce the final solution.

Help Ankita sort the given numbers using the Divide & Conquer approach.

Input Format
The first line contains an integer N.

The second line contains N space-separated integers representing the array.

Output Format
Print the sorted array in ascending order.

Elements should be separated by a single space.

Example
Input
6

8 3 1 7 0 10

Output
0 1 3 7 8 10

Explanation:

The array is repeatedly divided into smaller subarrays until each subarray contains a single element.

These subarrays are then merged in sorted order to obtain the final sorted array:

0 1 3 7 8 10

Constraints
1 ≤ N ≤ 10⁵
-10⁹ ≤ Array[i] ≤ 10⁹

Hints (3) */
import java.util.*;
public class MergeSort{
  static void mergeSort(int[] arr, int left, int right){
    if(left >= right){
      return;
    }
    int mid = left + (right - left)/2;
    mergeSort(arr, left, mid);
    mergeSort(arr, mid + 1, right);

    merge(arr, left, mid, right);
    
  }
  static void merge(int[] arr, int left, int mid, int right){
    int n1 = mid - left + 1;
    int n2 = right - mid;

    int[] L = new int[n1];
    int[] R = new int[n2];

    for(int i = 0; i < n1; i++){
      L[i] = arr[left + i];
    }

    for(int i = 0; i < n2; i++){
      R[i] = arr[mid + 1 + i];
    }

    int i = 0, j = 0, k = left;

    while(i < n1 && j < n2){
      if(L[i] <= R[j])
        arr[k++] = L[i++];
      else 
        arr[k++] = R[j++];
    }
    while(i < n1){
      arr[k++] = L[i++];
    }
    while(j < n2){
      arr[k++] = R[j++];
    }
  }
    public static void main(String[] args){
      Scanner sc = new Scanner(System.in);

      int n = sc.nextInt();
      int[] arr = new int[n];

      for(int i = 0; i < n; i++){
        arr[i] = sc.nextInt();
      }
      mergeSort(arr, 0, n - 1);

      for(int i = 0; i < n; i++){
        System.out.print(arr[i]);

        if(i < n - 1){
          System.out.print(" ");
        }
      }
    }
}