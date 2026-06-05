/* Problem Statement
Rahul’s professor has a very strange attendance rule during coding lectures. Every student’s roll number is checked in binary form before class begins.

The professor says:

If the binary representation of a roll number contains an odd number of ON bits (1s), the student must answer questions in class today 

Otherwise, the student is considered safe.

Rahul has been asked to quickly identify which students are:

ANSWER

or SAFE

Help him automate the process before the professor starts calling names.

Input Format

First line contains an integer N

Second line contains N space-separated integers representing roll numbers

Output Format

For every roll number, print:

ANSWER

or SAFE

on a new line.

Example
Input
4

3 5 8 7

Output
SAFE

SAFE

ANSWER

ANSWER

Explanation:

1. 3 → 11 → 2 ON bits → SAFE

2. 5 → 101 → 2 ON bits → SAFE

3. 8 → 1000 → 1 ON bit → ANSWER

4. 7 → 111 → 3 ON bits → ANSWER */
/* So what is happening overall?

We are checking binary digits one by one.

Example: 13

13
10
	​

=1101
2
	​


Loop works like:

num	last bit (num & 1)
1101	1
110	0
11	1
1	1

Then number becomes 0, so stop.

BUT YES — THERE IS A SIMPLER WAY 🔥

Instead of all this:

just use:

Integer.bitCount(num)

This directly counts number of 1s.

Simplest Solution
import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        for(int i = 0; i < n; i++) {

            int num = sc.nextInt();

            int ones = Integer.bitCount(num);

            if(ones % 2 == 1) {
                System.out.println("ANSWER");
            }
            else {
                System.out.println("SAFE");
            }
        }
    }
}
Why this is easier

Instead of:

✅ checking bits manually
✅ shifting manually
✅ XOR manually

Java already gives:

Integer.bitCount()

which does everything internally.

So for exams/interviews:

use bitwise if specifically asked
otherwise Integer.bitCount() is cleaner and simpler. */

import java.util.*;

class attendanceRule{
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
      System.out.println("Enter the number of students");

      int n = sc.nextInt();
    System.out.println("enter the numbers");

    for(int i = 0; i < n; i++){
      int num = sc.nextInt();

      int xor = 0;

      while(num > 0){
        xor ^= (num & 1);
        num = num >> 1;
      }
      if(xor == 1){
        System.out.println("ANSWER");
      } else {
        System.out.println("SAFE");
      }
    }
  }
}