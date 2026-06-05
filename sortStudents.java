/*Problem Statement
During the annual fest at Sitanshu’s college, students from different clubs were gathering for the opening ceremony.

Each student belonged to one of these clubs:

0 → Music Club

1 → Dance Club

2 → Photography Club

Unfortunately, the students were standing in a random order. 

The event coordinator asked Sitanshu to arrange the lineup properly so that:

all Music Club students stand first

followed by Dance Club students

and finally Photography Club students

Help Sitanshu sort the club lineup in linear time.

Input Format
The first line contains an integer N — number of students.

The second line contains N space-separated integers containing only 0, 1, and 2.

Output Format
Print the sorted array.

Example
Input
6

2 0 2 1 1 0

Output
0 0 1 1 2 2

Explanation:

After arranging the students:

1. all Music Club (0) students come first

2. followed by Dance Club (1) students

3. followed by Photography Club (2) students

So the final arrangement becomes: 0 0 1 1 2 2 */
import java.util.*;

public class sortStudents{
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    System.out.println("Enter the number of students");
    int n = sc.nextInt();

    System.out.println("Enter the club numbers");
    int[] arr = new int[n];
    for(int i = 0; i < n; i++){
      arr[i] = sc.nextInt();
    }
    int low = 0;
    int mid = 0;
    int high = n - 1;

    while(mid <= high){
      if(arr[mid] == 0){
      int temp = arr[low];
      arr[low] = arr[mid];
      arr[mid] = temp;
        low++;
        mid++;
      } else if(arr[mid] == 1) {
        mid++;
      } else {
        int temp = arr[mid];
        arr[mid] = arr[high];
        arr[high] = temp;
        high--;
      }
    }
    for(int num : arr){
      System.out.print(num + " ");
    }
  }
}