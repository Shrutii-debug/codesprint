/*Problem Statement
Subhajeet's college is distributing scholarships based on student performance.

However, the dean has introduced a special eligibility rule:

A student qualifies for a scholarship only if the sum of all scores strictly smaller than their score is at least K.

Help Subhajeet determine how many students qualify for the scholarship.

Input Format

First line contains two integers N and K

Second line contains N space-separated integers representing student scores

Output Format

Print a single integer representing the number of students who qualify for the scholarship.

Example
Input
5 60

10 20 30 40 50

Output
2

Explanation:

1. After sorting the scores: 10 20 30 40 50

2. For score 40, the sum of all smaller scores is: 10 + 20 + 30 = 60

3. For score 50, the sum of all smaller scores is: 10 + 20 + 30 + 40 = 100

4. Both satisfy the condition: Sum of smaller scores ≥ 60

5. Therefore, the number of eligible students is: 2

Constraints
1 ≤ N ≤ 10^5
0 ≤ Score[i] ≤ 10^9
0 ≤ K ≤ 10^15

Hints (3) */

import java.util.*;

public class prefixSumHard {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        long k = sc.nextLong();

        long[] arr = new long[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextLong();
        }

        Arrays.sort(arr);

        long[] prefix = new long[n];
        prefix[0] = arr[0];

        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] + arr[i];
        }

        int count = 0;
        int i = 0;

        while (i < n) {
            int j = i;

            while (j < n && arr[j] == arr[i]) {
                j++;
            }

            long smallerSum = (i == 0) ? 0 : prefix[i - 1];

            if (smallerSum >= k) {
                count += (j - i);
            }

            i = j;
        }

        System.out.println(count);
    }
}