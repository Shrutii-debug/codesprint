/* Problem Statement
Saptak is designing secure passwords for the participants of CodeSprint 3.0.
To keep the accounts safe, every password must follow some important security rules.

A password is considered STRONG if:

it contains at least one uppercase letter

at least one lowercase letter

and at least one digit

Help Saptak determine whether the given password is strong or not.

Input Format
A single string representing the password.

Output Format
Print "STRONG" if the password satisfies all conditions.

Otherwise, print "WEAK".

Example
Input
Code123

Output
STRONG

Explanation:

C → uppercase letter

ode → lowercase letters

123 → digits

Since all conditions are satisfied, the password is strong.

Constraints
1≤length of password≤100

Hints (1) */


import java.util.*;

class passwordChecker{
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    System.out.println("Enter the password");
    String password = sc.nextLine();

    boolean hasUpper = false;
    boolean hasLower = false;
    boolean hasDigit = false;

    for(int i = 0; i < password.length(); i++){
      char ch = password.charAt(i);

      if(Character.isUpperCase(ch)){
        hasUpper = true;
      }
      else if(Character.isLowerCase(ch)){
        hasLower = true;
      }
      else if(Character.isDigit(ch)){
        hasDigit = true;
      }
    }
    if(hasUpper && hasLower && hasDigit){
      System.out.println("STRONG");
    } else {
      System.out.println("WEAK");
    }
  }
}