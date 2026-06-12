/*Problem Statement
Ayush is participating in a cybersecurity competition at his college. During the event, he discovers a secret array of numbers.

The organizers define the Range Score of a subarray as:

∑(frequency of each number)^2

In other words, for every distinct number in the selected range:

Count how many times it appears.

Square that frequency.

Add all the squared frequencies together.

Ayush receives multiple queries and must quickly calculate the Range Score for each specified range.

Help Ayush process all the queries efficiently.

Input Format
The first line contains an integer N — the size of the array.

The second line contains N space-separated integers.

The third line contains an integer Q — the number of queries.

The next Q lines contain two integers L and R, representing a query range (0-indexed).

Output Format
For each query, print the Range Score of the subarray [L, R] on a new line.

Example
Input
5

1 2 1 3 2

3

0 4

0 2

1 3

Output
9

5

3

Explanation:

Query 1: [0, 4]

Subarray: 1 2 1 3 2

Frequencies:

1 → 2 times

2 → 2 times

3 → 1 time

Range Score:

2² + 2² + 1²

= 4 + 4 + 1

= 9

Query 2: [0, 2]

Subarray: 1 2 1

Frequencies:

1 → 2 times

2 → 1 time

Range Score:

2² + 1²

= 5

Query 3: [1, 3]

Subarray: 2 1 3

Frequencies:

2 → 1 time

1 → 1 time

3 → 1 time

Range Score:

1² + 1² + 1²

= 3

Constraints
1≤N≤100
1≤Q≤100
1≤arr[i]≤10^6
0≤L≤R<N

Hints (3) */

import java.util.*;

public class freqCount{
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int[] arr = new int[n];

    for(int i = 0; i < n; i++){
      arr[i] = sc.nextInt();
    }
    int q = sc.nextInt();

    while(q-- > 0){
      int l = sc.nextInt();
      int r = sc.nextInt();

      HashMap<Integer, Integer> freq = new HashMap<>();

      for(int i = l; i <= r; i++){
        freq.put(arr[i], freq.getOrDefault(arr[i], 0) + 1);
      }
      long score = 0;

      for(int count : freq.values()){
        score += (long)count * count;
      }
      System.out.println(score);
    }
  }
}