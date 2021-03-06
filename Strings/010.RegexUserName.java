/*
Regular expressions () help us match or search for patterns in strings. In this problem, you will be given a username. Your task is to check whether that username is valid. A valid username will have the following properties:

The username can contain alphanumeric characters and/or underscores(_).
The username must start with an alphabetic character.
8  |Username|  30.
To simplify your task, we have provided a portion of the code in the editor. You just need to write down the pattern which will be used to validate the username input.

Input Format

The first line of input contains an integer , representing the number of testcases. Each of the next  lines contains a string that represents a username.

Constraints

The username consists of any printable characters.
Output Format

For each username, output Valid if the username is valid; otherwise, output Invalid.

Sample Input

4
alpha_naheed
xahidbuffon
nagib@007
123Swakkhar
Sample Output

Valid
Valid
Invalid
Invalid
Explanation

The first two cases fulfill the constraints of a valid username. The third case is invalid because it contains an invalid character '@'. The fourth case is also invalid because it starts with a numeric character.
*/

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
   public static void main(String[] args){
      Scanner in = new Scanner(System.in);
      int testCases = Integer.parseInt(in.nextLine());
      while(testCases>0){
         String username = in.nextLine();
         //String pattern = Complete this line in the editable area below  
         
//-------------------------code blocked above
String pattern = "^[a-zA-Z][a-zA-Z0-9_]{7,29}$";
                  //^           = force
                  //[a-zA-Z]    = alphabetic
                  //              first char    ^[a-zA-Z]{1} == ^[a-zA-Z]
                  //              remaining 29 char alpha-numeral-underscore
//-------------------------code bloccked below
  Pattern r = Pattern.compile(pattern);
         Matcher m = r.matcher(username);
          
         if (m.find( )) {
            System.out.println("Valid");
         } else {
            System.out.println("Invalid");
         }
         testCases--;
      }
   }
}
