/*
You are given a phone book that consists of people's names and their phone number. After that you will be given some person's name as query. For each query, print the phone number of that person.

Input Format

The first line will have an integer  denoting the number of entries in the phone book. Each entry consists of two lines: a name and the corresponding phone number. 

After these, there will be some queries. Each query will contain a person's name. Read the queries until end-of-file.

Constraints:
A person's name consists of only lower-case English letters and it may be in the format 'first-name last-name' or in the format 'first-name'. Each phone number has exactly 8 digits without any leading zeros.




Output Format

For each case, print "Not found" if the person has no entry in the phone book. Otherwise, print the person's name and phone number. See sample output for the exact format.

To make the problem easier, we provided a portion of the code in the editor. You can either complete that code or write completely on your own.

Sample Input

3
uncle sam
99912222
tom
11122222
harry
12299933
uncle sam
uncle tom
harry
Sample Output

uncle sam=99912222
Not found
harry=12299933
*/

//Complete this code or write your own from scratch
import java.util.*;
import java.io.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

class TestCollection {

	public static void main(String[] args) {
		Scanner sin = new Scanner(System.in);

		int entry = Integer.parseInt(sin.nextLine());
		
		HashMap<String,Integer> dir = new HashMap<String,Integer>();
		
		for(int e=0;e<entry;e++){
			String name = sin.nextLine();
			int phone = Integer.parseInt(sin.nextLine());
			
			dir.put(name, phone);
		}
		
		//Set mapSet = dir.entrySet();
		
		while(sin.hasNext()){
			String qry = sin.nextLine();
			
						
			if(dir.containsKey(qry)){
				System.out.println(qry+"="+dir.get(qry));       //use map.get when key is known, other wise set, iterator,Map.Entry to getKey and getValue
			}
			else{
				System.out.println("Not found");
			}
		}
		
	}
}
