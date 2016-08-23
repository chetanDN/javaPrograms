/*
Sometimes it's better to use dynamic size arrays. Java's Arraylist can provide you this feature. Try to solve this problem using Arraylist.

You are given  lines. In each line there are zero or more integers. You need to answer a few queries where you need to tell the number located in  position of  line. 

Take your input from System.in.

Input Format
The first line has an integer . In each of the next  lines there will be an integer  denoting number of integers on that line and then there will be  space-separated integers. In the next line there will be an integer  denoting number of queries. Each query will consist of two integers  and .

Constraints






Each number will fit in signed integer.
Total number of integers in  lines will not cross 100000.

Output Format
In each line, output the number located in  position of  line. If there is no such position, just print "ERROR!"

Sample Input

5
5 41 77 74 22 44
1 12
4 37 34 36 52
0
3 20 22 33
5
1 3
3 4
3 1
4 3
5 5
Sample Output

74
52
37
ERROR!
ERROR!
*/

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        		Scanner sin = new Scanner(System.in);
		int mlc = Integer.parseInt(sin.next());	//mainListCount
		
		ArrayList<ArrayList<Integer>> mal = new ArrayList<ArrayList<Integer>>();	//main array list
		
		for(int i=0; i<mlc; i++){
			int slc = Integer.parseInt(sin.next());		//sub list count
			
			mal.add(new ArrayList<Integer>());
			
			for(int j=0;j<slc;j++){
				int ele = Integer.parseInt(sin.next());
				
				mal.get(i).add(ele);	//adding the elements
			}
		}
		
		//now, printing the elements based on user dual index
		
		int r =Integer.parseInt(sin.next()); //no. of search requests
		
		for(int R= 0;R<r;R++){
			int i=Integer.parseInt(sin.next());
			int j=Integer.parseInt(sin.next());
			
			if( i>mal.size() || j>mal.get(i-1).size() )
				System.out.println("ERROR!");
			else
				System.out.println(mal.get(i-1).get(j-1));
		}
        
    }
}
