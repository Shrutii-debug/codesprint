 /*Problem Statement
Namita is managing the leaderboard for her college coding contest, where participants are ranked based on their scores.

Each participant has:

a name

a score

The leaderboard must be sorted in increasing order of scores. 

However, there is one important rule:

If two participants have the same score, their original relative order in the input must remain unchanged.

To maintain fairness, Namita uses a sorting method that repeatedly compares adjacent participants and swaps them only when the left participant has a higher score.

Help Namita generate the final stable leaderboard.

Input Format

The first line contains an integer N — the number of participants.

The next N lines each contain: a string Name and an integer Score



Output Format

Print the reordered leaderboard in increasing order of scores.

Each line should contain: Name Score

Example
Input
5

Aman 50

Riya 30

Kabir 50

Neha 20

Aryan 30

Output
Neha 20

Riya 30

Aryan 30

Aman 50

Kabir 50

Explanation:

1. The leaderboard is sorted in increasing order of scores.

2. Riya 30 stays before Aryan 30 because equal scores are not swapped.

3. Aman 50 also remains before Kabir 50 for the same reason.

4. Swapping happens only when: leftScore > rightScore, making the sorting stable. */
import java.util.*;

class Participant{
  String name;
  int score;

  Participant(String name, int score){
    this.name = name;
    this.score = score;
  }
}
public class sortParticipants{
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter the no of participants");
    int n = sc.nextInt();

    System.out.println("enter the participant and their scores");

    Participant[] arr = new Participant[n];

    for(int i = 0; i < n; i++){
      String name = sc.next();
      int score = sc.nextInt();

      arr[i] = new Participant(name, score);
    }

    for(int i = 0; i < n - 1; i++){
      boolean swapped = false;
      for(int j = 0; j < n - i - 1; j++){
        if(arr[j].score > arr[j + 1].score){
          Participant temp = arr[j];
          arr[j] = arr[j + 1];
          arr[j + 1] = temp;

          swapped = true;
        }
      }
      if(!swapped){
        break;
      }
    }
    System.out.println("the participants are");
    for(Participant p : arr){
      System.out.println(p.name + " " + p.score);
    }
  }
}