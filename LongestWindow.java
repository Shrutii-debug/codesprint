/*Problem Statement
Supriyo is developing a local AI chat plugin for his note-taking application. The notes are represented as a sequence of encrypted tokens, where each token has a memory weight.

The AI model can process only a continuous sequence of tokens whose total memory weight does not exceed a limit (W).

Help Supriyo find the maximum number of consecutive tokens that can be processed in a single batch without exceeding the memory limit.

Input Format
The first line contains two integers N and W:

N → Total number of tokens.

W → Maximum memory weight that the AI model can process in a single batch.

The second line contains N space-separated integers, where the ith integer represents the memory weight of the ith token.

Output Format
Print a single integer representing the length of the longest continuous subarray whose total memory weight does not exceed W.

Example
Input
6 10

3 1 2 4 5 1

Output
4

Explanation:

The continuous subarray [3, 1, 2, 4] has a total weight of 10, which is equal to the limit W, and its length is 4.

Any longer continuous subarray has a total weight greater than 10, so it is not valid.

Therefore, the maximum number of tokens that can be processed is:

4

Constraints
1 ≤ N ≤ 105, where N is the total number of tokens.
1 ≤ W ≤ 109, where W is the maximum allowed memory weight.
1 ≤ Token Weightᵢ ≤ 104 for every token in the sequence.

Hints (3) */
import java.util.*;

public class LongestWindow{
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    long W = sc.nextLong();

    int[] arr = new int[n];

    for(int i = 0; i < n; i++){
      arr[i] = sc.nextInt();
    }

    int left = 0;
    long sum = 0;
    int maxLen = 0;

    for(int right = 0; right < n; right++){
      sum += arr[right];

      while(sum > W){
        sum -= arr[left];
        left++;
      }
      maxLen = Math.max(maxLen, right - left + 1);
    }
    System.out.println(maxLen);
  }
}
