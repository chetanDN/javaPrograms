/*
In a tag-based language like XML or HTML, contents are enclosed between a start tag and an end tag like <tag>contents</tag>. Note that the corresponding end tag starts with a /.

Given a string of text in a tag-based language, parse this text and retrieve the contents enclosed within sequences of well-organized tags meeting the following criterion:

The name of the start and end tags must be same. The HTML code <h1>Hello World</h2> is not valid, because the text starts with an h1 tag and ends with a non-matching h2 tag.

Tags can be nested, but content between nested tags is considered not valid. For example, in <h1><a>contents</a>invalid</h1>, contents is valid but invalid is not valid.

Tags can consist of any printable characters.

Input Format

The first line of input contains a single integer,  (the number of lines). 
The  subsequent lines each contain a line of text.

Constraints

Each line contains a maximum of  printable characters.
The total number of characters in all test cases will not exceed .
Output Format

For each line, print the content enclosed within valid tags. 
If a line contains multiple instances of valid content, print out each instance of valid content on a new line; if no valid content is found, print None.

Sample Input

4
<h1>Nayeem loves counseling</h1>
<h1><h1>Sanjay has no watch</h1></h1><par>So wait for a while</par>
<Amee>safat codes like a ninja</amee>
<SA premium>Imtiaz has a secret crush</SA premium>
Sample Output

Nayeem loves counseling
Sanjay has no watch
So wait for a while
None
Imtiaz has a secret crush
*/

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution{
   public static void main(String[] args){
      
      Scanner in = new Scanner(System.in);
      int testCases = Integer.parseInt(in.nextLine());
      while(testCases>0){
         String line = in.nextLine();
         
             //Write your code here
                int count=0;
         Pattern r = Pattern.compile("<(.+?)>([^<>]+)</\\1>");
         Matcher m = r.matcher(line);
         while(m.find()) {
             if (m.group(2).length() !=0) {
                 System.out.println(m.group(2));
             count++;
             }
         }
         if (count == 0) System.out.println("None");
         
         testCases--;
      }
   }
}

/*
There are two capture groups in this expression. They are surrounded by ( and ) the first is in the opening tag the second is the content between the opening and closing tag. so group(2) gets the content of that capture group. Also of note is the \1 in the closing tag. This is called a backreference and it has to match what was in the first capture group which is the opening tag. So for < B > text < / B > group(1) == "B", group(2) == "text" and \1 has to be == to group on in the closing tag to make sure its < / B > and not something like < / I >. spaces added so that html tags aren't suppressed by editor
*/
