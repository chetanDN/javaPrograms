/*
In computer science, a stack or LIFO (last in, first out) is an abstract data type that serves as a collection of elements, with two principal operations: push, which adds an element to the collection, and pop, which removes the last element that was added.(Wikipedia)
A string containing only parentheses is balanced if the following is true: 1. if it is an empty string 2. if A and B are correct, AB is correct, 3. if A is correct, (A) and {A} and [A] are also correct.

Examples of some correctly balanced strings are: "{}()", "[{()}]", "({()})" 

Examples of some unbalanced strings are: "{}(", "({)}", "[[", "}{" etc.

Given a string, determine if it is balanced or not.

Input Format

There will be multiple lines in the input file, each having a single non-empty string. You should read input till end-of-file.

The part of the code that handles input operation is already provided in the editor.

Output Format

For each case, print 'true' if the string is balanced, 'false' otherwise.

Sample Input

{}()
({()})
{}(
[]
Sample Output

true
true
false
true
Submissions: 8319
Max Score: 20
Difficulty: Medium
Rate This Challenge:
    
More
Current Buffer (saved locally, editable)     

*/

import java.util.*;
class Solution{
   
	static Map<Character,Character> tbl;

	public static void main(String[] args) {
		tbl= new HashMap<Character,Character>();
		
		tbl.put('(', ')');
		tbl.put('[', ']');
		tbl.put('{', '}');
		
		Scanner sin = new Scanner(System.in);
		
		while(sin.hasNext()){
			String strg = sin.nextLine();
			
			System.out.println(check(strg));
		}

	}

	private static boolean check(String strg) {
		Stack<Character> stk = new Stack<Character>();
		
		for(int i=0;i<strg.length();++i){		//go through whole string
			
			if( (strg.charAt(i)=='(' ) || ( strg.charAt(i)=='[') || ( strg.charAt(i)=='{' ) ){ 	//initially check for forwadrd character
				stk.push(strg.charAt(i));
			}else if(stk.empty() ){			//if you receive backwaork char an stack is empty,its mismatch
				return false;
			}else if(strg.charAt(i) == tbl.get(stk.peek())){ //if received backward char ']' and match with forward '[' char of stk 
				stk.pop();
			}else {				//( if strg.charAt(i) != tbl.get(stk.peek() ) i.e if received backward char '}' dont match with forward '[' char of stk
				return false;
			}
			
		}
		
		return stk.empty();	//(if stack is empty after loop ) returns true if stack is empty after iteration
	}
}
