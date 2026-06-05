/*Problem Statement
Saptarshi is organizing a coding challenge where participants stand in a circle. Each participant is assigned a unique ID, and the participants are arranged in the form of a circular linked list.

Starting from the first participant, every K-th participant is eliminated from the circle. After each elimination, counting resumes from the next participant still in the game.

The process continues until only one participant remains.

Your task is to determine the ID of the participant who survives till the end.

Input Format
The first line contains an integer N — the number of participants.

The second line contains N distinct integers representing the participant IDs in circular order.

The third line contains an integer K — every K-th participant will be eliminated.

Output Format
Print a single integer representing the ID of the last remaining participant.

Example
Input
N = 7

IDs = 10 20 30 40 50 60 70

K = 3

Output
40

Explanation

Participants are arranged in a circle. Every third participant is removed from the game until only one participant remains. The surviving participant's ID is 40.

Constraints
1 ≤ N ≤ 10⁵
1 ≤ K ≤ 10⁵
Participant IDs are distinct and fit within a 32-bit signed integer.

Hints (3) */

