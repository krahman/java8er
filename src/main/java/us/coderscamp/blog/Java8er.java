package us.coderscamp.blog;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

import us.coderscamp.blog.pojo.Gender;
import us.coderscamp.blog.pojo.Person;
import us.coderscamp.blog.robo.ITest;
import us.coderscamp.blog.robo.RoboContactMethodsAnonymous;
import us.coderscamp.blog.robo.RoboContactMethodsLambda;

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
        j8.RoboCallTestAnonymous();
        j8.RoboCallTestWithLambda();
    }
    
    // Comparator with lambda 
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
    
    public void RoboCallTestAnonymous(){
    	
		List<Person> pl = Person.createShortList();
		RoboContactMethodsAnonymous robo = new RoboContactMethodsAnonymous();
		
		System.out.println("=== Robo Call With Anonymous Function ===");
		
		System.out.println("=== Calling all drivers ===");
		robo.callDrivers(pl, new ITest<Person>() {
			
			@Override
			public boolean test(Person p) {
				// TODO Auto-generated method stub
				return p.getAge()>= 16;
			}
		});
		
		System.out.println("=== Emailing all draftees ===");
		robo.emailDraftees(pl, new ITest<Person>() {
			
			@Override
			public boolean test(Person p) {
				// TODO Auto-generated method stub
				return p.getAge()>=18 && p.getAge()<=25 && p.getGender() == Gender.MALE;
			}
		});
		
		System.out.println("=== Mail all pilots ===");
		robo.mailPilots(pl, new ITest<Person>() {
			
			@Override
			public boolean test(Person p){
				// TODO Auto-generated method stub
				return p.getAge()>=23 && p.getAge()<=65;
			}
		});
    }
    
    public void RoboCallTestWithLambda(){
    	
    	List<Person> pl = Person.createShortList();
    	RoboContactMethodsLambda robo = new RoboContactMethodsLambda();
    	
    	System.out.println("=== Robo Call With Lambda ===");
    	
    	// Predicates
    	Predicate<Person> allDrivers = p -> p.getAge() >= 16;
    	Predicate<Person> allDraftees = p -> p.getAge()>=18 && p.getAge()<=25 && p.getGender() == Gender.MALE;
    	Predicate<Person> allPilots = p -> p.getAge()>=23 && p.getAge()<=65;
    	
    	System.out.println("=== Calling all drivers ===");
    	robo.callDrivers(pl, allDrivers);
    	System.out.println("=== Emailing all draftees ===");
    	robo.emailDraftees(pl, allDraftees);
    	System.out.println("=== Mail all pilots ===");
    	robo.mailPilots(pl, allPilots);
    }
}
