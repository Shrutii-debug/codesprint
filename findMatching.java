/*Problem Statement
QuickBite is a rapidly growing food delivery company operating across multiple cities.
The platform stores thousands of restaurant names in its database.
Whenever a customer types a few letters into the search bar, the app should instantly display all matching restaurant names so users can quickly place their orders.
The company wants the suggestions to appear in lexicographical order to improve the user experience.
Help the QuickBite engineering team and nishita build this auto-suggestion feature.
Input Format
First line contains integer N representing the number of restaurants.

Next N lines contain restaurant names.

Last line contains the search prefix.

Output Format
Print all restaurant names matching the given prefix in lexicographical order.

Example
Input
N = 7

pizzapalace

pizzahub

pizzaworld

burgervilla

pizzacity

pastahouse

pizzaexpress

search prefix = pizza

Output
pizzacity

pizzaexpress

pizzahub

pizzapalace

pizzaworld

Explanation:

1. All restaurant names starting with "pizza" are selected.

2. After sorting them lexicographically, the matching names are printed in dictionary order.

Constraints
1 ≤ N ≤ 100
1 ≤ length of each restaurant name ≤ 100
Restaurant names contain lowercase English letters only */
import java.util.*;
public class findMatching{
  static boolean isPrefix(String word, String prefix){
    if(prefix.length() > word.length()){
      return false;
    }
    for(int i = 0; i < prefix.length(); i++){
      if(word.charAt(i) != prefix.charAt(i)){
        return false;
      }
    }
    return true;
  }
  public static void main(String[] args){
  Scanner sc = new Scanner(System.in);

    System.out.println("Enter the number of strings");
    int n = sc.nextInt();
    sc.nextLine();

    String[] restaurants = new String[n];
    System.out.println("Enter the strings");

    for(int i = 0; i < n; i++){
      restaurants[i] = sc.nextLine();
    }

    System.out.println("Enter the prefix");
    String prefix = sc.nextLine();

    Arrays.sort(restaurants);

    System.out.println("The matching strings are:");

    for(String name : restaurants){
      if(isPrefix(name, prefix)){
        System.out.println(name);
      }
    }
  }
}