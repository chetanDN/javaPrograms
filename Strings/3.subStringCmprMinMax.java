/*
Given a string, find out the lexicographically smallest and largest substring of length .

[Note: Lexicographic order is also known as alphabetic order dictionary order. So "ball" is smaller than "cat", "dog" is smaller than "dorm". Capital letter always comes before smaller letter, so "Happy" is smaller than "happy" and "Zoo" is smaller than "ball".]

Input Format

First line will consist a string containing english alphabets which has at most  characters. 2nd line will consist an integer .

Output Format

In the first line print the lexicographically minimum substring. In the second line print the lexicographically maximum substring.

Sample Input

welcometojava
3
Sample Output

ava
wel
Explanation

Here is the list of all substrings of length :

wel
elc
lco
com
ome
met
eto
toj
oja
jav
ava
Among them ava is the smallest and wel is the largest.

*/

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sin = new Scanner(System.in);
        String mString = sin.nextLine();		//main String
        int ssLength = sin.nextInt();		//sub string length
       
//      Step 1: Initialise both for starting string
        String max=mString.substring(0, ssLength);
        String min = max;
        
        for(int i=0;i<=mString.length()-ssLength;i++){	// <'='stringLength-ssLength *importannt
        	
        	if( (mString.substring(i, i+ssLength)).compareTo(max) > 0){	//if present sub string is > prev maxString  
        		max=mString.substring(i, i+ssLength);					//store present substring as max
        	}
        	
        	if((mString.substring(i, i+ssLength)).compareTo(min) < 0){	//if present substring is < prev minString
        		min=mString.substring(i, i+ssLength);					//store present substring as min
        	}
        }
        
        
        System.out.println(min);
        System.out.println(max);
        
    }
    
    
}

//-------------------------can be solved using sorted set also---------------------------------------------
/*
public class Solution {

	public static void main(String[] args) {
		Scanner sin = new Scanner(System.in);
		String mString = sin.nextLine(); // main String
		int ssLength = sin.nextInt(); // sub string length

		SortedSet<String> sets = new TreeSet<String>();
		for (int i = 0; i <= mString.length() - ssLength; i++) {
			sets.add(mString.substring(i, i + ssLength));
		}
		System.out.println(sets.first());
		System.out.println(sets.last());

	}

}
*/

