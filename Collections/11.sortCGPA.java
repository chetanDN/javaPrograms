/*
You are given a list of student information: ID, FirstName, and CGPA. Your task is to rearrange them according to their CGPA in decreasing order. If two student have the same CGPA, then arrange them according to their first name in alphabetical order. If those two students also have the same first name, then order them according to their ID. No two students have the same ID.

Hint: You can use comparators to sort a list of objects. See the oracle docs to learn about comparators.

Input Format

The first line of input contains an integer , representing the total number of students. The next  lines contains a list of student information in the following structure:

ID Name CGPA
Constraints






The name contains only lowercase English letters. The  contains only integer numbers without leading zeros. The CGPA will contain, at most, 2 digits after the decimal point.

Output Format

After rearranging the students according to the above rules, print the first name of each student on a separate line.

Sample Input

5
33 Rumpa 3.68
85 Ashis 3.85
56 Samiha 3.75
19 Samara 3.75
22 Fahim 3.76
Sample Output

Ashis
Fahim
Samara
Samiha
Rumpa
*/



import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

class Student {
	private int id;
	private String fname;
	private double cgpa;

	public Student(int id, String fname, double cgpa) {
		super();
		this.id = id;
		this.fname = fname;
		this.cgpa = cgpa;
	}

	public int getId() {
		return id;
	}

	public String getFname() {
		return fname;
	}

	public double getCgpa() {
		return cgpa;
	}
}

class Checker implements Comparator<Student>{ 	//compare() method of Comparator<Student>; compareTo() of Comparable<Student> interface
	 public int compare(Student s1, Student s2){
	     Integer c,d;
	     c=(((Double)s1.getCgpa()).compareTo((Double)s2.getCgpa()));		
	     if( c != 0)                                    //if cgpa of comparing two Student are not same
	         return -c;                                 // sort them, - sign to sort in "decending" order of cgpa
	     else{                                          //if cgpa are same
            if( ( d = (s1.getFname()).compareTo(s2.getFname()) ) != 0 ) //and name are not same
                return d;                                               //then sort name accordingly in ascending order
            else                                                        // if cgpa same, name same, then sort according to Id, ascending, which is unique 
                return  ( (Integer)s1.getId()).compareTo(s2.getId() );
        }                                          
	          
        
		
	 }
}

// Complete the code
public class Solution {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int testCases = Integer.parseInt(in.nextLine());

		List<Student> studentList = new ArrayList<Student>();
		while (testCases > 0) {
			int id = in.nextInt();
			String fname = in.next();
			double cgpa = in.nextDouble();

			Student st = new Student(id, fname, cgpa);
			studentList.add(st);

			testCases--;
		}

		Checker checker = new Checker();
		Collections.sort(studentList, checker);       //Arrays.sort() not working as we use ArrayList here, so Collection.sort();

		for (Student st : studentList) {
			System.out.println(st.getFname());
		}
	}
}
