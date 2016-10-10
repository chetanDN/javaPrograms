/*
Exception handling is the process of responding to the occurrence, during computation, of exceptions – anomalous or exceptional conditions requiring special processing – often changing the normal flow of program execution. (Wikipedia)

Java has built-in mechanism to handle exceptions. Using the try statement we can test a block of code for errors. The catch block contains the code that says what to do if exception occurs.

This problem will test your knowledge on try-catch block.

You will be given two integers  and  as input, you have to compute x/y. If x and y are not 32 bit signed integers or if y is zero, exception will occur and you have to report it. Read sample Input/Output to know what to report in case of exceptions.

Sample Input 0:

10
3
Sample Output 0:

3
Sample Input 1:

10
Hello
Sample Output 1:

java.util.InputMismatchException
Sample Input 2:

10
0
Sample Output 2:

java.lang.ArithmeticException: / by zero
Sample Input 3:

23.323
0
Sample Output 3:

java.util.InputMismatchException
*/
import java.util.InputMismatchException;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sin = new Scanner(System.in);
        

        
        try{
            int m = sin.nextInt();
            int n = sin.nextInt();
            
            int res = m/n;
            
            System.out.println(res);
            
        }catch(InputMismatchException i){
            //i.printStackTrace();
        	//System.out.println(i);
        	System.out.println(i.getClass().getName());	//only to resolve for testcase 4 -> i/p -> 2147483648 2147483648 -> o/p required just-> java.util.InputMismatchException (not extended  For input string: "2147483648") 
        }catch(ArithmeticException a){
        	//a.printStackTrace();
        	System.out.println(a);	// as case 2 reuires--> i/p -> 10 0 -> o/p required -> java.lang.ArithmeticException: / by zero
        	//System.out.println(a.getClass().getName());
        }
    }
}
