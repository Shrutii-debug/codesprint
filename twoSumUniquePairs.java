/*Sushree manages package deliveries between multiple cities.

Each package has a weight associated with it.

A pair of packages is considered balanced if the sum of their weights is exactly X.

Help Sushree determine the number of unique balanced pairs that can be formed.

Two pairs are considered the same if they contain the same pair of weights, regardless of their positions in the array.

Input Format

First line contains two integers N and X

Second line contains N space-separated integers representing package weights

Output Format

Print a single integer representing the number of unique balanced pairs.

Example
Input
6 10

1 4 7 5 5 9

Output
2

Explanation:

1. The unique pairs whose sum equals 10 are (1, 9),(5, 5)

2. No other distinct pair of weights satisfies the condition.

3. Therefore, the number of unique balanced pairs is: 2

Constraints
1 ≤ N ≤ 10^5
1 ≤ Weight[i] ≤ 10^9
1 ≤ X ≤ 10^9

Hints (3) */
import java.util.*;

public class twoSumUniquePairs {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        long x = sc.nextLong();

        HashSet seen = new HashSet<>();
        HashSet pairs = new HashSet<>();

        for (int i = 0; i < n; i++) {
            long num = sc.nextLong();
            long complement = x - num;

            if (seen.contains(complement)) {
                long a = Math.min(num, complement);
                long b = Math.max(num, complement);
                pairs.add(a + "#" + b);
            }

            seen.add(num);
        }

        System.out.println(pairs.size());
    }
}