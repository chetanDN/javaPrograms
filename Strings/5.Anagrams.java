/*
Two strings  and  are called anagrams if they consist same characters, but may be in different orders. So the list of anagrams of  is .

Given two strings, print Anagrams if they are anagrams, print Not Anagrams if they are not. The strings may consist at most  English characters; the comparison should NOT be case sensitive.

This exercise will verify that you can sort the characters of a string, or compare frequencies of characters.

Sample Input 0

anagram
margana
Sample Output 0

Anagrams
Sample Input 1

anagramm
marganaa
Sample Output 1:

Not Anagrams
*/

import java.io.*;
import java.util.*;

public class Solution {   
//code blocked till here------------------------------------------------------------------------------------------
 static boolean isAnagram(String strA, String strB) {
        
        // Complete the function by writing your code here.
        
    	if(strA.length()!=strB.length())
    		return false;
        
        strA = strA.toLowerCase();
        strB = strB.toLowerCase();
        
        
        
        /////////////////Build the map
        HashMap<Character,Integer> hMap = new HashMap<Character,Integer>();
        //map each character as key and freq of char as value
        for(int i=0;i<strA.length();i++){
        	char chr = strA.charAt(i);
        	
        	if( !(hMap.containsKey(chr)) ){	//if doesnot contain key means dont have that char
        		hMap.put(chr, 1);				//then insert that new char, put value as 1, as its first frequency        		
        	}else{	//else if that char already exists increment the frequency
        		int freq=hMap.get(chr);
        		hMap.put(chr, ++freq);
        	}
        }
        
        
        ////////////////Cross-Check each char freq with second String
        for(int j=0;j<strB.length();j++){
        	char chr = strB.charAt(j);
        	
        	if( !(hMap.containsKey(chr)) ){	//if second String doesnot contain char only, return false
        		return false;
        	}
        	
        	int freq = hMap.get(chr);
        	if(freq==0){
        		return false;
        	}else{
        		hMap.put(chr, --freq);
        	}
        	
        }//if everthing of string 2 mathches with string 1 then return true
        
        return true;
        
        
    }
    
    //code blocked below this line-----------------------------------------------------------------------------------------------
        public static void main(String[] args) {
    
        Scanner scan = new Scanner(System.in);
        String a = scan.next();
        String b = scan.next();
        scan.close();
        boolean ret = isAnagram(a, b);
        System.out.println( (ret) ? "Anagrams" : "Not Anagrams" );
    }
}


//above code use less time complexity but shorter code can be written using sorted array with more time complexity
/*
	static boolean isAnagram(String A, String B) {
		char a[] = A.toLowerCase().toCharArray();
		char b[] = B.toLowerCase().toCharArray();
		Arrays.sort(a);
		Arrays.sort(b);

		return Arrays.equals(a, b);
	}
*/


    
