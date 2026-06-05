/*Problem Statement
A coastal rescue team lead Tannu is evacuating people from an island before a storm arrives.

Each rescue boat can carry exactly two people, and for safety reasons, the total weight of the two people assigned to the same boat determines the load on that boat.

To keep the evacuation as safe as possible, the team wants to arrange the people so that the heaviest-loaded boat is as light as possible.You are given the weights of N people (where N is even). Help Tannu to determine the minimum possible value of the maximum boat load if everyone must be assigned to a boat and each boat carries exactly two people

Input Format
The first line contains an integer N — the number of people.

The second line contains N space-separated integers representing the weights of the people.

Output Format
Print a single integer — the minimum possible value of the maximum boat load.

Example
Input
6

70 50 80 60 40 90

Output
130

Explanation:

1. Sort the weights: 40 50 60 70 80 90

2. Pair the lightest person with the heaviest:

- 40 + 90 = 130

- 50 + 80 = 130

- 60 + 70 = 130

3. The maximum boat load among all pairs is 130.

4. No other pairing can achieve a smaller maximum load.

Constraints
2 ≤ Number of people(N) ≤ 2×10^5
N is even
1 ≤ Weight of the ith person ≤ 10^9

Hints (4) */
import java.util.*;
public class pairing{
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int[] persons = new int[n];

    for(int i = 0; i < n; i++){
      persons[i] = sc.nextInt();
    }

    Arrays.sort(persons);
    int left = 0;
    int right = n - 1;
    int sum = 0;
    long maxSum = 0;

  while(left < right){
    sum = persons[left] + persons[right];
    maxSum = Math.max(maxSum, sum);
    left++;
    right--;
    }
    System.out.println(maxSum);
  }
}