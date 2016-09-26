/*
In computer science, a double-ended queue (dequeue, often abbreviated to deque, pronounced deck) is an abstract data type that generalizes a queue, for which elements can be added to or removed from either the front (head) or back (tail).

Deque interfaces can be implemented using various types of collections such as LinkedList or ArrayDeque classes. For example, deque can be declared as:

Deque deque = new LinkedList<>();
or
Deque deque = new ArrayDeque<>();
You can find more details about Deque here.

In this problem, you are given  integers. You need to find the maximum number of unique integers among all the possible contiguous subarrays of size .

Note: Time limit is  second for this problem.

Input Format

The first line of input contains two integers  and : representing the total number of integers and the size of the subarray, respectively. The next line contains  space separated integers.

Constraints




The numbers in the array will range between .

Output Format

Print the maximum number of unique integers among all possible contiguous subarrays of size .

Sample Input

6 3
5 3 5 2 3 2
Sample Output

3
Explanation

In the sample testcase, there are 4 subarrays of contiguous numbers.

 - Has  unique numbers.

 - Has  unique numbers.

 - Has  unique numbers.

 - Has  unique numbers.

In these subarrays, there are  unique numbers, respectively. The maximum amount of unique numbers among all possible contiguous subarrays is .
*/

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Solution {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		Deque<Integer> deque = new ArrayDeque<Integer>();
		int n = in.nextInt();
		int m = in.nextInt();

		int maxUnqEle = 0;								//maximum unique ele in a sub array so far 
		int subArrUnqEle = 0;
		Map<Integer, Integer> map = new HashMap<>();

		for (int i = 0; i < n; i++) {
			int num = in.nextInt();						// new element to sub array of 

/*Step 4:  when moving to next sub array, delete last ele from deque, correspondingly reduce recurrence count in map */
			if (deque.size() == m) {					// of size three
				int last = (int) deque.pollLast();		//therefore last element is removed to form new sub array of size 3
				int val = map.get(last) - 1;			// correspondingly reduce its(removing ele) occurance value in map
				map.put(last, val);						// update it in map
				if (val == 0) {							// since a unique ele gone
					--subArrUnqEle;					// current unique ele count of sub array reduces
				}
			}
/*step 1: count unique elements in sub array */			
			//main logic of calculating the unique elements of sub array
			if (!map.containsKey(num) || map.get(num) == 0) {		// if there is no such key or such key present and value is zero
				++subArrUnqEle;
			}
			deque.offerFirst(num);
/* step 2 : store it in max unique ele  */
			maxUnqEle = Math.max(maxUnqEle, subArrUnqEle);		// highest unique ele achieved so far --> max(previous Max, current sub array max)
			/* or use if (subArrUnqEle > maxUnqEle) 
			 			maxUnqEle = subArrUnqEle;
			 */
/* step 3: enter recurrence count of each num in map   */		
			Integer val = map.get(num);		// in  map increase count of num correspondingly
			if (val == null)		// if first time occurrence --> null 
				val = new Integer(0);	// so set to zero
			map.put(num, val + 1);		// update the count  of num in map
		}

		System.out.println(maxUnqEle);		// print the max unique ele in sub arrays formed
	}
}
