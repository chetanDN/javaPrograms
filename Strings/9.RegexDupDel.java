/*
When we write something, it is easy to repeat words by mistake. For example: Monmoy loves to to code. Here, "to" is written multiple times.

Using Regex, we can easily identify the repeated pattern in a given text. In this problem, you will be given a text. Your task is to identify the consecutively repeated words and delete them after the first occurrence of the word.

Complete the code in the editor to solve this problem. Don't modify any extra lines. You will get the wrong answer if you modify more than  lines.

To restore the original code in the editor, create a new buffer by clicking on the top-left button in the editor.

Input Format

The first line of input contains an integer , representing the number of testcases. The next  lines contain a string of English letters and whitespaces.

Constraints

In each line, there will be at most  English letters and whitespaces.


Output Format

Print the input string after deleting the consecutive words after the first occurrence of the word.

Sample Input

5
Goodbye bye bye world world world
Swapnil went went to to to his business
Rana is is the the best player in eye eye game
in inthe
Hello hello Ab aB
Sample Output

Goodbye bye world
Swapnil went to his business
Rana is the best player in eye game
in inthe
Hello Ab
*/
import java.util.Scanner;
    import java.util.regex.Matcher;
    import java.util.regex.Pattern;

    public class DuplicateWords
    {
        public static void main(String[] args){

            String pattern = "\\b(\\w+)(\\b\\W+\\1\\b)*";

            Pattern r = Pattern.compile(pattern,Pattern.CASE_INSENSITIVE);

            Scanner in = new Scanner(System.in);
            int testCases = Integer.parseInt(in.nextLine());
            while(testCases>0){
                String input = in.nextLine();
                Matcher m = r.matcher(input);
                boolean findMatch = true;
                while(m.find( )){
                    input = input.replaceAll(m.group(),m.group(1));
                    findMatch = false;
                }
                System.out.println(input);
                testCases--;
            }
        }
    }

	/*
	\b : Any word boundary 
	(\w+) : Select any word character (letter, number, underscore)

	Once all the words are selected, now it's time to select the common words.

	( : Grouping starts
	\b : Any word boundary
	\W+ : Any non-word character
	\1 : Select repeated words
	\b : Un select if it repeated word is joined with another word
	) : Grouping ends
	//example http://www.rubular.com/r/kn4ZMtBnny
	*/
