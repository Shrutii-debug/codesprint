/*Problem Statement
Aroosa is preparing for placements and tracks the number of hours she spends studying every day.

She believes she is entering a burnout zone if there exists a continuous streak of exactly K consecutive days such that:

The total study hours during those K days is at least X.

She studied on every day of that streak (no day has 0 hours).

Help Aroosa determine whether such a streak exists.

Input Format

The first line contains three integers: N, K, X

N → number of days

K → required streak length

X → minimum total study hours

The second line contains N integers representing study hours for each day.

Output Format

Print: YES

if such a streak exists, otherwise print: NO

Example
Input
7 3 15

4 5 7 2 8 1 9

Output
YES

Explanation

The first streak of 3 consecutive days is: 4 5 7

Its total study hours are: 4 + 5 + 7 = 16

Since 16 ≥ 15 and all days have non-zero study hours, a valid burnout streak exists.

Hence, the answer is: YES

Constraints
1 ≤ N ≤ 10^5
1 ≤ K ≤ N
0 ≤ arr[i] ≤ 10^4
1 ≤ X ≤ 10^9

Hints (3) */
import java.util.*;

public class streakBurnout{
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int k = sc.nextInt();
    long x = sc.nextLong();

    int[] arr = new int[n];
    for(int i = 0; i < n; i++){
      arr[i] = sc.nextInt();
    }

    long windowSum = 0;
    long zeroCount = 0;

    for(int i = 0; i < k; i++){
      windowSum += arr[i];
      if(arr[i] == 0){
        zeroCount++;
      }
    }
      if(windowSum >= 0 && zeroCount == 0){
        System.out.println("YES");
        return;
      }

    for(int i = k; i < n; i++){
      windowSum += arr[i];
      if(arr[i] == 0){
        zeroCount++;
      }
      windowSum -= arr[i - k];
      if(arr[i - k] == 0){
        zeroCount--;
      }
      if(windowSum >= k && zeroCount == 0){
        System.out.println("YES");
        return;
      }
    }
    System.out.println("NO");
  }
}