/*
You are given a class Solution and its main method in the editor. In each test cases, it takes an input  which represents a choice of the following:

 represents the volume of a cube that has to be calculated where  represents the length of the sides of the cube.
 represents the volume of a cuboid that has to be calculated where  represent the dimensions of a cuboid.
 represents the volume of a hemisphere that has to be calculated where  represents the radius of a hemisphere.
 represents the volume of a cylinder that has to be calculated where  represent the radius and height of the cylinder respectively.
Your task is to create the class Calculate and the required methods so that the code prints the volume of the figures rounded to exactly  decimal places.

In case any of the dimensions of the figures are , print "java.lang.NumberFormatException: All the values must be positive" without quotes and terminate the program.

Note: Use Math.PI or  as the value of pi.

Input Format

First line contains , the number of test cases. Each test case contains ch, representing the choice as given in the problem statement.

When ch=1, Next line contains , length of the sides of the cube.
When ch=2, Next three lines contain , ,  representing length, breadth and height of the cuboid respectively. , ,  will be in three separate lines
When ch=3, Next line contains , the radius of the hemisphere
When ch=4, Next two lines contain ,  representing the radius and height of the cylinder respectively. ,  will be in two separate lines.
Note: You have to determine the data type of each parameter by looking at the code given in the main method.

Constraints 
 
 
There will be at most  digits after decimal point in input.

Output Format

For each test case, print the answer rounded up to exactly 3 decimal places in a single line. For example, 1.2345 should be rounded to 1.235, 3.12995 should be rounded to 3.130.

Sample Input 1

2
1
4
4
67.89
-98.54
Sample Output 1

64.000
java.lang.NumberFormatException: All the values must be positive
Explanation 
There are two test cases. In the first test case , means you have to calculate the volume of a cube. The next line contains the =4, means the side of the cube is . So the volume of the cube is . 
In the second test case, you have to calculate volume of a cylinder. But the height of the cylinder is negative, so an exception is thrown.

Sample Input 2

1
3
1.02
Sample Output 2

2.223
*/


package helloWorld;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
import java.lang.reflect.*;
import java.security.Permission;

//Write your code here

class Calculate{
	Scanner sin = new Scanner(System.in);
	Output output= new Output();
	
	int get_int_val() throws IOException{		//throws IOException important
		int num = sin.nextInt();
		if(num<=0)
			throw new NumberFormatException("All the values must be positive");
		else
			return num;
	}
	
	double get_double_val() throws IOException{ //throws IOException important
		double num = sin.nextDouble();
		if(num<=0)
			throw new NumberFormatException("All the values must be positive");
		else
			return num;
	}

	public static Volume do_calc() {
		// TODO Auto-generated method stub
		return new Volume();
	}
}

class Volume{

	//volume of cube
	public double get_volume(int a) {
		return a*a*a;
	}
	
	//get_volume overloaded - volume of cuboid
	public double get_volume(int l,int b, int h) {
		return l*b*h;
	}
	
	//get_volume overloaded - volume of hemisphere 
	public double get_volume(double r) {
		return (Math.PI)*r*r*r*2/3;		//dont 2/3*(Math.PI)*r*r*r -> ans 0
	}
	
	//get_volume overloaded - volume of cylinder  
	public double get_volume(double r,double h) {
		return (Math.PI)*r*r*h;
	}
}

class Output{

	void display(double volume) {
		System.out.printf("%.3f",volume);		
		System.out.println();
	}
	
}

//code blocked below

public class Solution {

	public static void main(String[] args) {
		DoNotTerminate.forbidExit();
		try {
			Calculate cal = new Calculate();
			int T = cal.get_int_val();
			while (T--> 0) {
				double volume = 0.0;
				int ch = cal.get_int_val();
				if (ch == 1) {
					int a = cal.get_int_val();
					volume = Calculate.do_calc().get_volume(a);	//do_calc() will return a object that will have methods of get_volume
																//so  in Calculate class , in  do_calc() method should call another class object (volume), that has get_volume() methods
				} else if (ch == 2) {
					int l = cal.get_int_val();
					int b = cal.get_int_val();
					int h = cal.get_int_val();
					volume = Calculate.do_calc().get_volume(l, b, h); 
				} else if (ch == 3) {
					double r = cal.get_double_val();
					volume = Calculate.do_calc().get_volume(r);

				} else if (ch == 4) {
					double r = cal.get_double_val();
					double h = cal.get_double_val();
					volume = Calculate.do_calc().get_volume(r, h);

				}
				cal.output.display(volume);
			}

		} catch (NumberFormatException e) {
			System.out.print(e);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (DoNotTerminate.ExitTrappedException e) {
			System.out.println("Unsuccessful Termination!!");
		}

  } //end of main
} //end of Solution

/**
 *This class prevents the user form using System.exit(0)
 * from terminating the program abnormally.
 *
 */
class DoNotTerminate {

	public static class ExitTrappedException extends SecurityException {}

	public static void forbidExit() {
		final SecurityManager securityManager = new SecurityManager() {
			@Override
			public void checkPermission(Permission permission) {
				if (permission.getName().contains("exitVM")) {
					throw new ExitTrappedException();
				}
			}
		};
		System.setSecurityManager(securityManager);
	}
} //end of Do_Not_Terminate

/*


*/
