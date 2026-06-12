/*Problem Statement
During her college's annual tech fest, Ridhima is helping decorate the main avenue with a row of vertical banner stands of different heights. She wants to hang a giant fabric banner between any two stands to create the largest possible display area.

The area of the banner depends on:

The shorter of the two stands, as the banner cannot be taller than the shorter stand.

The distance between the two stands.

Help Ridhima determine the maximum possible area that can be formed by choosing any two banner stands.

Input Format
The first line contains an integer N, representing the number of banner stands.

The second line contains N space-separated integers representing the heights of the banner stands.

Output Format
Print a single integer representing the maximum possible area that can be formed by choosing any two banner stands.

Example
Input
9

1 8 6 2 5 4 8 3 7

Output
49

Explanation:

If Ridhima chooses the banner stands with heights 8 and 7:

Distance between them = 7

Effective height of the banner = min(8, 7) = 7

Area formed = 7 × 7 = 49

No other pair of banner stands can create a larger area.

Constraints
2 ≤ N ≤ 10⁵
0 ≤ height[i] ≤ 10⁴

Hints (3) */
import java.util.*;
class MaxArea{
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();

    int[] height = new int[n];

    for(int i = 0; i < n; i++){
      height[i] = sc.nextInt();
    }
    int left = 0;
    int right = n - 1;
    int maxArea = 0;

    while(left < right){
      int width = right - left;
      int area = Math.min(height[left], height[right]) * width;

      maxArea = Math.max(maxArea, area);

      if(height[left] < height[right]) left ++;
      else right--;
    }
    System.out.println(maxArea);
  }
}