package us.coderscamp.blog;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import us.coderscamp.blog.pojo.Person;

/**
 * Created by nevda on 27/3/14.
 */
public class Java8er {
    public static void main(String[] args){
    	
    	// Anonymous Runnable
    	Runnable aR = new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				System.out.println();
			}
		};
		aR.run();
    	
    	// Lambda Runnable
        Runnable lR = () -> System.out.println("foo");
        lR.run();
        
        // Run comparator Test
        Java8er j8 = new Java8er();
        j8.ComparatorTest();
    }
    
    public void ComparatorTest(){
    	List<Person> personList = Person.createShortList();
    	
    	// Sort with inner class
    	Collections.sort(personList, new Comparator<Person>() {
    		public int compare(Person p1, Person p2){
    			return p1.getSurName().compareTo(p2.getSurName());
    		}
		});
    	
    	System.out.println("=== Sorted Asc SurName===");
    	for(Person p:personList){
    		p.printName();
    	}
    	
    	// Sort using lambda
    	System.out.println("=== Sorted Asc SurName ===");
    	Collections.sort(personList, (Person p1, Person p2) 
    			-> p1.getSurName().compareTo(p2.getSurName()));
    	
    	for(Person p:personList){
    		p.printName();
    	}
    	
    	System.out.println("=== Sorted Desc SurName ===");
    	Collections.sort(personList, (Person p1, Person p2)
    			-> p2.getSurName().compareTo(p1.getSurName()));
    	
    	for(Person p:personList){
    		p.printName();
    	}
    }
}
