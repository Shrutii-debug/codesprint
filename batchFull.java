import java.util.*;

public class batchFull{
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    System.out.println("Enter the no of batches");
    int N = sc.nextInt();
    System.out.println("Enter the maximum no of students");
    int X = sc.nextInt();

    int[] arr = new int[N];

    System.out.println("Enter the batch sizes");

    for(int i = 0; i < N; i++){
      arr[i] = sc.nextInt();
    }

    int sum = 0;
    int ans = -1;

    for(int i = 0; i < N; i++){
      sum += arr[i];

      if(sum > X){
        ans = i;
        break;
      }
    }
    System.out.println("The index is " + ans);
  }
}