/*
You are given a  2D array. An hourglass in an array is a portion shaped like this:

a b c
  d
e f g
For example, if we create an hourglass using the number 1 within an array full of zeros, it may look like this:

1 1 1 0 0 0
0 1 0 0 0 0
1 1 1 0 0 0
0 0 0 0 0 0
0 0 0 0 0 0
0 0 0 0 0 0
Actually, there are many hourglasses in the array above. The three leftmost hourglasses are the following:

1 1 1     1 1 0     1 0 0
  1         0         0
1 1 1     1 1 0     1 0 0
The sum of an hourglass is the sum of all the numbers within it. The sum for the hourglasses above are 7, 4, and 2, respectively.

In this problem you have to print the largest sum among all the hourglasses in the array.

Input Format

There will be exactly  lines, each containing  integers seperated by spaces. Each integer will be between  and inclusive.

Output Format

Print the answer to this problem on a single line.

Sample Input

1 1 1 0 0 0
0 1 0 0 0 0
1 1 1 0 0 0
0 0 2 4 4 0
0 0 0 2 0 0
0 0 1 2 4 0
Sample Output

19
Explanation

The hourglass which has the largest sum is:

2 4 4
  2
1 2 4
*/

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
	public static int BigSum=-9*6*6-1;		//dont take =0, if may all elements be negative also, -1 make one more

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int arr[][] = new int[6][6];
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 6; j++) {
				arr[i][j] = in.nextInt();
			}
		}
		
		for (int i=0;i<6-2;i++){
			for (int j=0;j<6-2;j++){
				int currResult = hourGlassResult(arr,i,j);
				BigSum = currResult>BigSum ?  currResult : BigSum;
			}
		}
		
		System.out.println(BigSum);
		
	}

	public static int hourGlassResult(int subArray[][],int r,int c){					//logic to compute smaller hour glass
		int sum=subArray[r+0][c+0]+subArray[r+0][c+1]+subArray[r+0][c+2]
				+subArray[r+1][c+1]
				+subArray[r+2][c+0]+subArray[r+2][c+1]+subArray[r+2][c+2];
		return sum;
	}
	
}
