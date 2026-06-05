/*Problem Statement
A grand music concert is taking place in the city, and thousands of fans are standing in a long queue.

Each person in the queue has a different height. To capture the best moments of the event, Asish has installed a special VIP camera at the front of the queue.

The camera always focuses on two people at a time:

one person from the left side of the queue

one person from the right side of the queue

The camera's visibility score is calculated as:

minimum height of the two people × distance between them

Asish wants to capture the most impressive shot possible.

Help him find the maximum visibility score that can be achieved.

Input Format
The first line contains an integer N — the number of people in the queue.

The second line contains N space-separated integers representing the heights of the people.

Output Format
Print a single integer representing the maximum visibility score.

Example
Input
8

1 8 6 2 5 4 8 3

Output
40

Explanation:

1. Choose the two people with heights: 8 and 8

2. The distance between them is: 5

3. So the visibility score is: min(8, 8) × 5 = 40

Therefore, the maximum visibility score is: 40 */
import java.util.*;

public class maximumVisibility{
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    System.out.println("enter the number of people");
    int n = sc.nextInt();

    System.out.println("enter the heights of the people");
    int[] arr = new int[n];

    for(int i = 0; i < n; i++){
      arr[i] = sc.nextInt();
    }

    int left = 0;
    int right = n - 1;
    int maxScore = 0;

    while(left < right){
      int width = right - left;
      int score = Math.min(arr[left], arr[right]) * width;

      maxScore = Math.max(maxScore, score);

      if(arr[left] < arr[right]){
        left++;
      } else {
        right--;
      }
    }
    System.out.println(maxScore);
  }
}