/* Problem Statement
Sagnik recently joined a streaming platform as a junior recommendation engineer.

His task is to improve the platform’s suggestion system by grouping users who watch similar types of shows.

To do this, the system looks at the starting letters of all the series names watched by a user.If several series names begin with the same sequence of characters, that sequence helps the platform identify similar interests.

Your job is to help Sagnik find the Longest Common Prefix among all the given series names.

Input Format
First line contains integer N

Next N lines contain series names

Output Format
Print the longest common prefix.

Example
Input
N = 3

moneyheistseason1

moneyheistseason2

moneyheistdocumentary

Output
moneyheist

Explanation:

1. All three strings start with "moneyheist".

2. Characters stop matching after "moneyheist", so it becomes the longest common prefix.*/
import java.util.*;

public class longestCommonPrefix{
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    System.out.println("Enter the number of strings");
    int n = sc.nextInt();
    /*Golden Rule

Whenever you mix:

nextInt()
nextDouble()
nextFloat()

with:

nextLine()

ALWAYS add:

sc.nextLine();

in between. */
    sc.nextLine();
    String[] arr = new String[n];
    

    System.out.println("Enter the strings");
    for(int i = 0; i < n; i++){
      arr[i]  = sc.nextLine().toLowerCase();
    }
    String first = arr[0];
    String ans = "";

    for(int i = 0; i < first.length(); i++){
      char ch = first.charAt(i);

      boolean same = true;

      for(int j = 1; j < n; j++){
        if(i >= arr[j].length() || arr[j].charAt(i) != ch){
          same = false;
          break;
        }
      }
      if(same){
        ans += ch;
      } else {
        break;
      }
    }
    System.out.println(ans);
  }
}