/*
A Decent Number has the following properties:
Its digits can only be 3's and/or 5's.
The number of 3's it contains is divisible by 5.
The number of 5's it contains is divisible by 3.
*/

import java.util.Scanner;

class Solution{
	public static void main(String args[]){
		Scanner sin = new Scanner(System.in);
		
		while(sin.hasNext()){
			int n = sin.nextInt();
			System.out.println(solveAndPrintFor(n));
		}
	}

	private static String solveAndPrintFor(int n) {
		
		int threePrintCount=0;
		int fivePrintCount=0;
		
		if(n<3){
			return "-1";			
		}
		
		int i=n;
		for( ; i>=0; i--){
			if(i%3 == 0 && (n-i)%5 == 0){
				threePrintCount = i/3;		//if printing single char use threePrintCount=i and fivePrintCount = (n-i)
				fivePrintCount = (n-i)/5;	//
			}
		}
		
		if(threePrintCount ==0 && fivePrintCount == 0)
			return "-1";
		
		
		StringBuilder sB = new StringBuilder();
		
		for(int j=0;j<threePrintCount;j++)	//if in line 27 didnt divide then
			sB.append("555");				// sB.append("5");
		for(int k=0; k<fivePrintCount;k++)
			sB.append("33333");
		//finally
		return sB.toString();
	}
}
