/*Problem Statement
Deep beneath the KIIT campus lies a mysterious underground maze filled with hidden passages and dead ends.

While exploring the maze, Adyashree discovered that only a few routes lead to the treasure room. Every open path can branch into multiple directions, making it difficult to determine all possible ways to reach the destination.

Help Adyashree find all valid paths from the entrance to the treasure room using recursion and backtracking.

The maze is represented as a binary matrix where:

1 represents an open path.

0 represents a blocked path.

Adyashree starts at position (0, 0) and must reach the treasure room at (N - 1, N - 1).

A cell can be visited at most once in a single path.

Input Format
The first line contains an integer N — the size of the maze.

The next N lines contain N space-separated integers representing the maze.

Output Format
Print all valid paths from the start to the destination.

Use the following characters to represent movements:

D → Down

L → Left

R → Right

U → Up

Print each valid path on a new line.

If no path exists, print -1.
Example
Input
N = 4

1 0 0 0

1 1 0 1

1 1 0 0

0 1 1 1

Output
DDRDRR

DRDDRR

Explanation:

Starting from (0, 0), there are two distinct routes that reach the destination (3, 3) without passing through blocked cells.

These paths are represented by the movement sequences:

DDRDRR

DRDDRR

Constraints
1 ≤ N ≤ 8

Hints (3) */

import java.util.*;
public class Maze{
  static ArrayList<String> paths = new ArrayList<>();

  static void solve(int[][] maze, int n, int row, int col, boolean[][] vis, String path){
    if(row == n - 1 && col == n - 1){
      paths.add(path);
      return;
    }
    vis[row][col] = true;
    if(row + 1 < n && maze[row + 1][col] == 1 && !vis[row + 1][col]){
      solve(maze, n, row + 1, col, vis, path + "D");
    }

    if(col - 1 >= 0 && maze[row][col - 1] == 1 && !vis[row][col - 1]){
      solve(maze, n, row, col - 1, vis, path + "L");
    }

    if(col + 1 < n && maze[row][col + 1] == 1 && !vis[row][col + 1]){
      solve(maze, n, row, col + 1, vis, path + "R");
    }

    if(row - 1 >= 0 && maze[row - 1][col] == 1 && !vis[row - 1][col]){
      solve(maze, n, row - 1, col, vis, path + "U");
    }
    vis[row][col] = false;
  }

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int[][] maze = new int[n][n];

    for(int i = 0; i < n; i++){
      for(int j = 0; j < n; j++){
        maze[i][j] = sc.nextInt();
      }
    }
    if(maze[0][0] == 0 || maze[n - 1][n - 1] == 0){
      System.out.println("-1");
      return;
    }
    boolean[][] vis = new boolean[n][n];

    solve(maze, n, 0, 0, vis, "");

    if(paths.size() == 0){
      System.out.println("-1");
      
    } else{
      for(String p : paths){
        System.out.println(p);
      }
    }
  }
    
}