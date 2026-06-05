/*Problem Statement
Hritika was working in her college science lab on a special temperature balancing machine.

The machine recorded both:

negative temperatures

positive temperatures

To stabilize the system, Hritika needed to find:

Two temperature values whose sum is closest to zero.

Help Hritika identify the required pair.

Input Format
The first line contains an integer N — size of the array.

The second line contains N space-separated integers.

Output Format
Print the pair whose sum is closest to zero.

Example
Input
N = 6

-8, -4, -1, 2, 10, 6

Output
-1 2

Explanation

Possible sum:

-1 + 2 = 1

The closest sum to zero is: 1

So one valid pair is: -1 2 */

import java.util.*;

public class closestSum{
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    System.out.println("enter the size of array");
    int n = sc.nextInt();

    int[] arr = new int[n];
    System.out.println("enter the elements");
    for(int i = 0; i < n; i++){
      arr[i] = sc.nextInt();
    }

    Arrays.sort(arr);

    int left = 0, right = n - 1;

    int minSum = Integer.MAX_VALUE;
    int num1 = 0, num2 = 0;

    while(left < right){
      int sum = arr[left] + arr[right];

      if(Math.abs(sum) < Math.abs(minSum)){
        minSum = sum;
        num1 = arr[left];
        num2 = arr[right];
      }
      if(sum < 0){
        left++;
      } else {
        right--;
      }
    }
    System.out.println("the numbers are: ");
    System.out.println(num1 + " " + num2);
  }
}