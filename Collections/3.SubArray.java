/*
We define the following:

A subarray of an -element array is an array composed from a contiguous block of the original array's elements. For example, if , then the subarrays are , , , , , and . Something like  would not be a subarray as it's not a contiguous subsection of the original array.
The sum of an array is the total sum of its elements.
An array's sum is negative if the total sum of its elements is negative.
An array's sum is positive if the total sum of its elements is positive.
Given an array of  integers, find and print its number of negative subarrays on a new line.

Input Format

The first line contains a single integer, , denoting the length of array . 
The second line contains  space-separated integers describing each respective element, , in array .

Constraints

Output Format

Print the number of subarrays of  having negative sums.

Sample Input

5
1 -2 4 -5 1
Sample Output

9
Explanation

There are nine negative subarrays of :

Thus, we print  on a new line.
*/

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        		Scanner in = new Scanner(System.in);

		int n = in.nextInt();

		int arr[] = new int[n];

		for (int i = 0; i < n; i++) {
			arr[i] = in.nextInt();
		}

		int si=0,ei=0,sum=0,count=0;
		for (int i = 0; i < n; i++) {
			for(int j=0;j<n;j++){
				sum=0;
				for(si=i,ei=j;si<=ei;si++){		//startIndex and endIndex, take 1st index and go row wise of all sub array instead of finding all hierarchical sub arrays 
					sum=sum+arr[si];
				}
				if(sum<0){
					count++;
				}
			}
		}
		
		System.out.println(count);
    }
}
