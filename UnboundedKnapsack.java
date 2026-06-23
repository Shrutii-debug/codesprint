/*Problem Statement
Govind is preparing for a marathon gaming tournament. To stay energized throughout the competition, he can buy different types of energy drinks.

Govind has X coins to spend.

There are N types of energy drinks available. For each drink:

It costs cost[i] coins.

It provides energy[i] energy points.

Since the store has an unlimited supply of every drink, Govind can buy any drink any number of times.

Help Govind determine the maximum energy he can obtain using at most X coins.

Input Format
The first line contains two integers N and X.

The next N lines each contain two integers:

cost[i] — cost of the drink

energy[i] — energy gained from the drink

Output Format
Print a single integer — the maximum energy Govind can obtain.

Example
Input
3 7

2 10

3 14

5 25

Output
35

Explanation:

Govind has 7 coins.

One possible choice:

Drink 1 → Cost = 2, Energy = 10

Drink 1 → Cost = 2, Energy = 10

Drink 2 → Cost = 3, Energy = 14

Total: Cost = 7, Energy = 34

A better choice is:

Drink 3 → Cost = 5, Energy = 25

Drink 1 → Cost = 2, Energy = 10

Total: Cost = 7, Energy = 35

Therefore, the maximum energy obtainable is: 35

Constraints
1≤N≤100
1≤X≤5000
1≤cost[i]≤100
1≤energy[i]≤1000

Hints (2) */
import java.util.*;

class UnboundedKnapsack{
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int x = sc.nextInt();

    int[] dp = new int[x + 1];
    for(int i = 0; i < n; i++){
      int cost = sc.nextInt();
      int energy = sc.nextInt();

      for(int j = cost; j <= x; j++){
        dp[j] =  Math.max(dp[j], dp[j - cost] + energy);
      }
    }
    System.out.println(dp[x]);
  }
}