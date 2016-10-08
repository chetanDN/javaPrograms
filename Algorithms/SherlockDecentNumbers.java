/*
Sherlock Holmes suspects his archenemy, Professor Moriarty, is once again plotting something diabolical. Sherlock's companion, Dr. Watson, suggests Moriarty may be responsible for MI6's recent issues with their supercomputer, The Beast.

Shortly after resolving to investigate, Sherlock receives a note from Moriarty boasting about infecting The Beast with a virus; however, he also gives him a clue—a number, . Sherlock determines the key to removing the virus is to find the largest Decent Number having  digits.

A Decent Number has the following properties:

Its digits can only be 3's and/or 5's.
The number of 3's it contains is divisible by 5.
The number of 5's it contains is divisible by 3.
If there are more than one such number, we pick the largest one.
Moriarty's virus shows a clock counting down to The Beast's destruction, and time is running out fast. Your task is to help Sherlock find the key before The Beast is destroyed!

Constraints




Input Format

The first line is an integer, , denoting the number of test cases.

The  subsequent lines each contain an integer, , detailing the number of digits in the number.

Output Format

Print the largest Decent Number having  digits; if no such number exists, tell Sherlock by printing -1.

Sample Input

4
1
3
5
11
Sample Output

-1
555
33333
55555533333
Explanation

For , there is no decent number having  digit (so we print ).
For ,  is the only possible number. The number  appears three times in this number, so our count of 's is evenly divisible by  (Decent Number Property 3).
For ,  is the only possible number. The number  appears five times in this number, so our count of 's is evenly divisible by  (Decent Number Property 2).
For ,  and all permutations of these digits are valid numbers; among them, the given number is the largest one.

*/

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;



import java.util.Scanner;

class Solution{
	public static void main(String args[]){
		Scanner sin = new Scanner(System.in);
		
		int testCase = sin.nextInt();
		
		while(testCase!=0){
			int n = sin.nextInt();
			System.out.println(solveAndPrintFor(n));
			testCase--;
		}
	}

	private static String solveAndPrintFor(int n) {
		
		int threePrintCount=0;
		int fivePrintCount=0;
		
	//	if(n<3){                //not required unless optimization
	//		return "-1";			
	//	}
		
		
		for(int i=n; i>=0; i--){
			if(i%3 == 0 && (n-i)%5 == 0){
				threePrintCount = i/3;		//if printing single char use threePrintCount=i and fivePrintCount = (n-i)
				fivePrintCount = (n-i)/5;	//
                break;                      //much needed otherwise other permutation occurs. eg: for 8 = (3,5) (5,3) pairs
			}
		}
		
		//if(threePrintCount ==0 && fivePrintCount == 0)  // moved to final if else
		//	return "-1";
		
		
		StringBuilder sB = new StringBuilder();
		
		for(int j=0;j<threePrintCount;j++)	//if in line 27 didnt divide then
			sB.append("555");				// sB.append("5");
		for(int k=0; k<fivePrintCount;k++)
			sB.append("33333");
		//finally
		if(sB.length()==0)
			return "-1";
		else
			return sB.toString();
	}
}
