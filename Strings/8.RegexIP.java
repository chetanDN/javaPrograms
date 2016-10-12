/*
Write a class called myRegex which will contain a string pattern. You need to write a regular expression and assign it to the pattern such that it can be used to validate an IP address. Use the following definition of an IP address:

IP address is a string in the form "A.B.C.D", where the value of A, B, C, and D may range from 0 to 255. Leading zeros are allowed. The length of A, B, C, or D can't be greater than 3.
Some valid IP address:

000.12.12.034
121.234.12.12
23.45.12.56
Some invalid IP address:

000.12.234.23.23
666.666.23.23
.213.123.23.32
23.45.22.32.
I.Am.not.an.ip
In this problem you will be provided strings containing any combination of ASCII characters. You have to write a regular expression to find the valid IPs.

Just write the myRegex class, and we will append your code after the following piece of code automatically before running it:
*/
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Scanner;

class Solution{

    public static void main(String []args)
    {
        Scanner in = new Scanner(System.in);
        while(in.hasNext())
        {
            String IP = in.next();
            System.out.println(IP.matches(new myRegex().pattern));
        }

    }
}
/*
(The class written by you MUST NOT be public)

Sample Input

000.12.12.034
121.234.12.12
23.45.12.56
00.12.123.123123.123
122.23
Hello.IP
Sample Output

true
true
true
false
false
false
*/

//-----------------------need to write a new class-------------------
class myRegex {
	String pattern = "([0-9]{1,2}|[01]{1}[0-9]{2}|[2]{1}[0-5]{1}[0-9]{1})\\.([0-9]{1,2}|[01]{1}[0-9]{2}|[2]{1}[0-5]{1}[0-9]{1})\\.([0-9]{1,2}|[01]{1}[0-9]{2}|[2]{1}[0-5]{1}[0-9]{1})\\.([0-9]{1,2}|[01]{1}[0-9]{2}|[2]{1}[0-5]{1}[0-9]{1})";
	
	// one or two digits range[0-9] | three digit starting digit[0 or 1] ,last two digit range[0-9] | three digit starting with 2, tens place range[0 to 5], units place range [0-9] \\.	(")\\.	(")\\.	(")    <--no \\at end  
}


