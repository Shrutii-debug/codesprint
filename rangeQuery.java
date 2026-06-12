/*Problem Statement
Anish is working on a weather monitoring system for his college research project.
Every day, temperature readings are recorded and stored in an array. To analyze weather fluctuations, Anish frequently receives queries asking for a specific range of days.
For each query [L, R], he wants to find:
Highest Temperature − Lowest Temperature
within that range.
Since the number of queries can be very large, your solution should answer each query efficiently.
Help Anish process all the queries.
Input Format
The first line contains an integer N — the number of temperature readings.
The second line contains N space-separated integers representing the temperatures.
The third line contains an integer Q — the number of queries.
The next Q lines each contain two integers L and R, representing a query range (0-indexed).
Output Format
For each query, print: maximum temperature in the range - minimum temperature in the range on a new line.
Example
Input
8

15 20 10 25 18 30 12 22

3

1 4

2 6

0 7

Output
15

20

20

Explanation:

Query 1: [1, 4]

Elements: 20 10 25 18

Maximum = 25

Minimum = 10

Answer: 25 - 10 = 15

Query 2: [2, 6]

Elements: 10 25 18 30 12

Maximum = 30

Minimum = 10

Answer: 30 - 10 = 20

Query 3: [0, 7]

Elements: 15 20 10 25 18 30 12 22

Maximum = 30

Minimum = 10

Answer: 30 - 10 = 20

Constraints
1≤N≤100
−10^9≤temperature[i]≤10^9
1≤Q≤10^5
0≤L≤R<N

Hints (2) */
import java.util.*;

public class rangeQuery{
  static int[] arr;
  static long[] maxTree;
  static long[] minTree;

  static void buildMax(int node, int start, int end){
    if(start == end){
      maxTree[node] = arr[start];
      return;
    }
    int mid = start + (end - start)/2;

    buildMax(2 * node, start, mid);
    buildMax(2 * node + 1, mid + 1, end);

    maxTree[node] = Math.max(maxTree[2 * node], maxTree[2 * node + 1]);
  }
  static void buildMin(int node, int start, int end){
    if(start == end){
      minTree[node] = arr[start];
      return;
    }
    int mid = start + (end - start)/2;

    buildMin(2 * node, start, mid);
    buildMin(2 * node + 1, mid + 1, end);

    minTree[node] = Math.min(minTree[node * 2], minTree[2 * node + 1]);
  }
  static long queryMax(int node, int start, int end, int l, int r){
    if(r < start || end < l)
      return Long.MIN_VALUE;

    if(l <= start && end <= r)
      return maxTree[node];

    int mid = start + (end - start)/2;

    long left = queryMax(2 * node, start, mid, l, r);
    long right = queryMax(2 * node + 1, mid + 1, end, l, r);

    return Math.max(left, right);
  }

  static long queryMin(int node, int start, int end, int l, int r){
    if(r < start || end < l)
      return Long.MAX_VALUE;

    if(l <= start && end <= r)
      return minTree[node];

    int mid = start + (end - start)/2;

    long left = queryMin(2 * node, start, mid, l, r);
    long right = queryMin(2 * node + 1, mid + 1, end, l, r);

    return Math.min(left, right);
  }
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    arr = new int[n];

    for(int i = 0; i < n; i++){
      arr[i] = sc.nextInt();
    }
    maxTree = new long[4 * n];
    minTree = new long[4 * n];

    buildMax(1, 0, n - 1);
    buildMin(1, 0, n - 1);

    int q = sc.nextInt();

    while(q-- > 0){
      int l = sc.nextInt();
      int r = sc.nextInt();

      long maxVal = queryMax(1, 0, n - 1, l, r);
      long minVal = queryMin(1, 0, n - 1, l, r);

      System.out.println(maxVal - minVal);
    }
  }
}