/*
A palindrome is a word, phrase, number, or other sequence of characters which reads the same backward or forward.(Wikipedia)
Given a string , print Yes if it is a palindrome, print No otherwise.

Constraints

 will consist at most  lower case english letters.
Sample Input

madam
Sample Output

Yes
*/

import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        
        Scanner sc=new Scanner(System.in);
        String A=sc.next();
        
        int subLen=A.length()/2;
        int strLen=A.length();
        
        for(int i=0;i<subLen;i++){
        	if( A.charAt(i) != A.charAt(strLen-1-i) ){
        		System.out.println("No");
        		return;
        	}
        }
        
        System.out.println("Yes");
    }

}

//--------------------other one line solution---------------
/*
System.out.println( A.equals( new StringBuilder(A).reverse().toString()) ? "Yes" : "No" );    //toString() is required to convert string builder object to string object to compare
*/

//-----------------other solution to check palindrom by comparing reverse string---------------------------
/*
public class Solution {

    public static void main(String[] args) {
        
        Scanner sc=new Scanner(System.in);
        String A=sc.next();
        
        String B=new StringBuilder(A).reverse().toString();
        
//      if(A.compareTo(B) == 0)
        if(A.equals(B))
        	System.out.println("Yes");
        else
        	System.out.println("No");
        
    }

}
*/
