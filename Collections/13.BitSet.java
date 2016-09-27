/*
Java's BitSet class implements a vector of bit values (i.e.:  () or  ()) that grows as needed, allowing us to easily manipulate bits while optimizing space (when compared to other collections). Any element having a bit value of  is called a set bit.

Given  BitSets,  and , of size  where all bits in both BitSets are initialized to , perform a series of operations. After each operation, print the number of set bits in the respective BitSets as two space-separated integers on a new line.

Input Format

The first line contains  space-separated integers,  (the length of both BitSets  and ) and  (the number of operations to perform), respectively. 
The  subsequent lines each contain an operation in one of the following forms:

AND 
OR 
XOR 
FLIP
SET 
In the list above,  is the integer  or , where  denotes  and  denotes . 
 is an integer denoting a bit's index in the BitSet corresponding to .

For the binary operations , , and , operands are read from left to right and the BitSet resulting from the operation replaces the contents of the first operand. For example:

AND 2 1
 is the left operand, and  is the right operand. This operation should assign the result of  to .

Constraints

Output Format

After each operation, print the respective number of set bits in BitSet  and BitSet  as  space-separated integers on a new line.

Sample Input

5 4
AND 1 2
SET 1 4
FLIP 2 2
OR 2 1
Sample Output

0 0
1 0
1 1
1 2
Explanation

Initially: , , , and . At each step, we print the respective number of set bits in  and  as a pair of space-separated integers on a new line.

 
 
,  
The number of set bits in  and  is .

 
Set  to  (). 
, . 
The number of set bits in  is  and  is .

 
Flip  from  () to  (). 
, . 
The number of set bits in  is  and  is .

 
. 
, . 
The number of set bits in  is  and  is .

*/



import java.util.BitSet;
import java.util.Scanner;
public class Solution {

  public static void main(String args[]) {
	  
	  Scanner sin = new Scanner(System.in);
	  int n = sin.nextInt();
	  int m = sin.nextInt();
	  
	   
      BitSet B[] = { new BitSet(n),			//bit set array[2] , cannot --> new Bitset(n)[2];
    		  			new BitSet(n)};		//take array as B1 or B2 can be switched easily by passing index
      
      for(int i=0;i<m;i++){
    	  String keyWord = sin.next();
    	  int oprnd1 = sin.nextInt();
    	  int oprnd2 = sin.nextInt();
    	  
    	  if(keyWord.equals("AND") ){
    		  B[oprnd1 - 1].and(B[oprnd2 - 1]);   //otherwise take B1 and B2, and use if-else to operation on B1 or B2
    	  }else if (keyWord.equals("OR") ){		// otherwise  switch(s){ case("OR") : if(i==1) { b1.and(b2);} else b2.and(b1); break;
    		  B[oprnd1 - 1].or(B[oprnd2 - 1]);
    	  }else if ( keyWord.equals("XOR") ){
    		  B[oprnd1 - 1].xor(B[oprnd2 - 1]);	//operate and value is stored in left operand always, in BitSet opn
    	  }else if ( keyWord.equals("FLIP") ){
    		  B[oprnd1 - 1].flip(oprnd2);
    	  }else if ( keyWord.equals("SET") ){
    		  B[oprnd1 - 1].set(oprnd2);
    	  }
    	  
    	  
          System.out.println(B[0].cardinality()+" "+B[1].cardinality());   	  //int cardinality( ) Returns the number of set bits in the invoking object.
    	  
      }
      

    
   }
}
