package helloWorld;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Dog implements Comparator<Dog>, Comparable<Dog> {
	private Integer id;
   private String name;
   private int age;
   Dog() {
   }

   Dog(int d, String n, int a) {
	  id = d;
      name = n;
      age = a;
   }

   public String getDogName() {
      return name;
   }

   public Integer getDogAge() {
      return age;
   }

   public Integer getDogId() {
	      return id;
	   }
   // Overriding the compareTo method
   public int compareTo(Dog d) {
      return (this.id).compareTo(d.id);
   }

   // Overriding the compare method to sort the age 
   public int compare(final Dog d,final Dog d1) {
	   Integer c;
	   c = (d.getDogName()).compareTo(d1.getDogName());
	   if (c == 0)
		   c = (d.getDogId()).compareTo(d1.getDogId());
	   if (c== 0)
		   c = (d.getDogAge()).compareTo(d1.getDogAge());
      return c;
   }
}

public class Solution {

   public static void main(String args[]) {
      // Takes a list o Dog objects
      List<Dog> list = new ArrayList<Dog>();

//      list.add(new Dog("Shaggy", 3));
//      list.add(new Dog("Lacy", 2));
//      list.add(new Dog("Roger", 10));
//      list.add(new Dog("Tommy", 4));
//      list.add(new Dog("Tammy", 1));
      
      
      list.add(new Dog(128,"Lacy", 2));
      list.add(new Dog(156,"Roger", 10));
      list.add(new Dog(125, "Shaggy", 3));
     
      list.add(new Dog(523,"Tammy", 1));
      list.add(new Dog(215,"Tommy", 4));
      
      Collections.sort(list);   // Sorts the array list

      for(Dog a: list)   // printing the sorted list of names
         System.out.print(a.getDogName() + ", ");

      // Sorts the array list using comparator
      Collections.sort(list, new Dog());
      
      
      
      System.out.println(" ");
      
      for(Dog a: list)   // printing the sorted list of ages
         System.out.print(a.getDogId() + " "+a.getDogName() +"  : "+ a.getDogAge() + ", ");
   }
}
