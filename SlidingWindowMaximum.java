/*Problem Statement
Abhinab is operating the digital scoreboard during a cricket tournament.

Every minute, the scoreboard records the crowd noise level.

For every group of K consecutive minutes, Abhinab wants to display the highest recorded noise level.

Help him compute the maximum value for every window.

Input Format

The first line contains two integers N and K.

N represents the number of readings.

K represents the window size.

The second line contains N integers representing the recorded values.

Output Format

Print the maximum value for every window in a single line.

Separate consecutive values with a single space.

Example
Input
8 3

750 820 900 780 910 860 880 790

Output
900 900 910 910 910 880

Explanation:

The windows are:

750 820 900 → 900

820 900 780 → 900

900 780 910 → 910

780 910 860 → 910

910 860 880 → 910

860 880 790 → 880

Constraints
1 ≤ K ≤ N ≤ 10⁵
0 ≤ Value ≤ 10⁹

Hints (3) */
import java.util.*;

public class SlidingWindowMaximum{
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int k = sc.nextInt();

    long[] arr = new long[n];

    for(int i = 0; i < n; i++){
      arr[i] = sc.nextLong();
    }

      Deque<Integer> dq = new ArrayDeque<>();
    StringBuilder ans = new StringBuilder();

    for(int i = 0; i < n; i++){
      while(!dq.isEmpty() && dq.peekFirst() <= i - k){
        dq.pollFirst();
      }

      while(!dq.isEmpty() && arr[dq.peekLast()] <= arr[i]){
        dq.pollLast();
      }
      dq.offerLast(i);

      if(i >= k - 1){
        ans.append(arr[dq.peekFirst()]).append(" ");
      }
    }
    System.out.println(ans.toString().trim());
  }
}