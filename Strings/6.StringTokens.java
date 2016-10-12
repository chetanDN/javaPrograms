/*
Given a string, , matching the regular expression [A-Za-z !,?._'@]+, split the string into tokens. We define a token to be one or more consecutive English alphabetic letters. Then, print the number of tokens, followed by each token on a new line.

Input Format

A single string, .

Constraints

 is composed of English alphabetic letters, blank spaces, and any of the following characters: !,?._'@
Output Format

On the first line, print an integer, , denoting the number of tokens in string  (they do not need to be unique). Next, print each of the  tokens on a new line in the same order as they appear in input string .

Sample Input

He is a very very good boy, isn't he?
Sample Output

10
He
is
a
very
very
good
boy
isn
t
he
Explanation

We consider a token to be a contiguous segment of alphabetic characters. There are a total of  such tokens in string , and each token is printed in the same order in which it appears in string .
*/

import java.io.*;
import java.util.*;

class Solution{
	public static void main(String[]args){
		Scanner sin=new Scanner(System.in);
		
		//String[] arrayOfStrings = sin.nextLine().trim().split("[ !,?\\._'@]+",0);	// replace space" " with \\s | "+" for one or more times
		
		String str= sin.nextLine().trim();
		String delims = "[ !,?\\._'@]+";
		String[] arrayOfStrings=str.split(delims); //.split(delims,0) --> if 2nd arg=0,  If it is zero, it will returns all the strings matching regex, if 1 ponly one token, if 2, only two token matching regex
		
		if(arrayOfStrings.length==1&&arrayOfStrings[0].equals("")){		//if string length is zero, like all spaces
			System.out.println("0");
		}else{
			System.out.println(arrayOfStrings.length);
			for(String ss:arrayOfStrings)System.out.println(ss);
		}
	}
}

/*
//using advanced string tokenizer

class Solution{
	public static void main(String[]args){
		Scanner sin=new Scanner(System.in);

		String str= sin.nextLine().trim();
		String delims = "[ !,?\\._'@]+";
		
		StringTokenizer st = new StringTokenizer(str,delims);
		
		System.out.println(st.countTokens());//print the no of tokens
		
		while(st.hasMoreTokens()){	//StringTokenizer implements the Enumeration interface. so hasMoreElements==hasMoreTokens()
			System.out.println(st.nextToken());   //nextToken==nextElement().toString()
		}
		//not used String nextToken(String delim)-->This method returns the next token in this string tokenizer's string.
	}
}
*/
