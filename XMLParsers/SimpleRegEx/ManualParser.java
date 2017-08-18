import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ManualParser {

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);

		String regexPatern = "(<[^>]*>)";
		Pattern stringPatern = Pattern.compile(regexPatern);
		while (in.hasNext()) {
			String line = in.nextLine();
			Matcher m = stringPatern.matcher(line);
			String startTag = null;
			int startTagEndPos = -1;
			
			while (m.find()) {		//using regex find starting or end tag either
				String xmlTag = line.substring(m.start(), m.end());
				if (xmlTag.charAt(1) != '/') {	//check the xmlTag got is not endTag
					startTag = xmlTag;
					startTagEndPos = m.end();
				} else if (xmlTag.charAt(1) == '/' && startTag != null) {	//second condition to make sure you have got startTag first
					if (startTag.substring(1).equals(xmlTag.substring(2)) 
							&& startTag.length() > 2 
							&& m.start() > startTagEndPos + 1) {	//now endTag pattern is > startTagEndPos
						System.out.print(startTag.substring(1,startTag.length()-1)+":"); //tagName
						System.out.println(line.substring(startTagEndPos, m.start()));
					}
					startTag = null;
				}

			}

		}

	}
}
