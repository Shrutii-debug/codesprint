/*Problem Statement
Satyam is helping manage boarding at a busy airport.

Every passenger is assigned a boarding priority. Passengers with a higher priority board the flight before others.

If two passengers have the same priority, the passenger who checked in earlier boards first.

Help Satyam determine the boarding order.

Input Format

The first line contains an integer N, the number of passengers.

Each of the next N lines contains two integers:

PassengerID

Priority

Output Format

Print the PassengerID of each passenger in the order they board.

Print one ID per line.

Example
Input
4

101 2

102 5

103 3

104 5

Output
102

104

103

101

Explanation:

The passengers arrive in this order:

Passenger 101 → Priority 2

Passenger 102 → Priority 5

Passenger 103 → Priority 3

Passenger 104 → Priority 5

Passengers 102 and 104 have the highest priority.

Since 102 checked in earlier, 102 boards first.

Among the remaining passengers, 103 has the next highest priority, followed by 101.

Therefore, the boarding order is:

102

104

103

101

Constraints
1 ≤ N ≤ 10⁵
1 ≤ PassengerID ≤ 10⁹
1 ≤ Priority ≤ 10⁹

Hints (3) */
import java.util.*;

class Passenger{
  long id;
  long priority;
  int index;

  Passenger(long id, long priority, int index){
    this.id = id;
    this.priority = priority;
    this.index = index;
  }
}

public class FindPriority{
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();

    PriorityQueue<Passenger> pq = new PriorityQueue<>((a, b) -> {
      if(a.priority != b.priority){
        return Long.compare(b.priority, a.priority);
      }
      return Integer.compare(a.index, b.index);
    });
    for(int i = 0; i < n; i++){
      long id = sc.nextLong();
      long priority = sc.nextLong();

      pq.offer(new Passenger(id, priority, i));
    }
    while(!pq.isEmpty()){
      System.out.println(pq.poll().id);
    }
  }
}