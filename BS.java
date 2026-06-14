/*Problem Statement
Saanvi is analyzing signal strengths received from a satellite communication system.

The recorded signal strengths form a bitonic sequence, meaning:

The values strictly increase up to a certain point.

After that point, the values strictly decrease.

The strongest signal is called the Peak Transmission.

Help Saanvi determine the maximum signal strength received.

The expected time complexity is O(log N).

Input Format
First line contains an integer N

Second line contains N space-separated integers representing signal strengths

Output Format
Print a single integer representing the maximum signal strength. (Print the value of the peak element, not its index)


Example
Input
7

1 3 8 12 9 5 2

Output
12

Explanation:

The signal strengths increase as: 1 3 8 12

then decrease as: 12 9 5 2

Therefore, the strongest signal received is: 12

Constraints
3 ≤ N ≤ 10^5
1 ≤ Signal[i] ≤ 10^9
The array is guaranteed to be bitonic
There exists exactly one peak element
The peak is neither the first nor the last element.

Hints (3) */
import java.util.*;

class BS{
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();

    int[] arr = new int[n];
    for(int i = 0; i < n; i++){
      arr[i] = sc.nextInt();
    }

    int left = 0;
    int right = n - 1;

    while(left < right){
      int mid = left + (right - left)/2;

      if(arr[mid] < arr[mid + 1]) left = mid + 1;
      else right = mid;

    }
    System.out.println(arr[left]);
  }
}