/*Problem Statement
Atreyee is helping manage the fruit store in his hostel.

One morning, he discovers that some oranges have already become rotten. Every minute, a rotten orange spreads the infection to all adjacent fresh oranges.

Each cell in the store is represented as follows:

0 → Empty cell

1 → Fresh orange

2 → Rotten orange

Two oranges are considered adjacent if they share a side (up, down, left, or right).

Help Atreyee determine the minimum number of minutes required for every fresh orange to become rotten.


If it is impossible, print -1.

Input Format

The first line contains two integers N and M.

The next N lines each contain M integers representing the grid.

Output Format

Print a single integer representing the minimum number of minutes required.

If not all fresh oranges can become rotten, print -1.

Example
Input
3 3

2 1 1

1 1 0

0 1 1

Output
4

Explanation:

Initially, one orange is rotten.

Every minute, all rotten oranges spread the infection simultaneously to their adjacent fresh oranges.

After 4 minutes, every fresh orange becomes rotten.

Constraints
1 ≤ N, M ≤ 100

Hints (3) */
import java.util.*;

class RottingOranges{
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int m = sc.nextInt();

    int[][] grid = new int[n][m];

    Queue<int[]> queue = new LinkedList<>();

    int fresh = 0;

    for(int i = 0; i < n; i++){
      for(int j = 0; j < m; j++){
        grid[i][j] = sc.nextInt();

        if(grid[i][j] == 2){
          queue.offer(new int[]{i, j});
        } else if(grid[i][j] == 1){
          fresh++;
        }
      }
    }
    if(fresh == 0){
      System.out.println(0);
      return;
    }
    int minutes = 0;
    int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    while(!queue.isEmpty() && fresh > 0){
      int size = queue.size();

      for(int i = 0; i < size; i++){
        int[] curr = queue.poll();
        int r = curr[0];
        int c = curr[1];

        for(int[] d : dirs){
          int nr = r + d[0];
          int nc = c + d[1];

          if(nr >= 0 && nr < n && nc >= 0 && nc < m && grid[nr][nc] == 1){
            grid[nr][nc] = 2;
            fresh--;
            queue.offer(new int[]{nr, nc});
          }
        }
      }
      minutes++;
    }
    System.out.println(fresh == 0 ? minutes : -1);
  }
}