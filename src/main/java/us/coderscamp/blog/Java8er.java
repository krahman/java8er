package us.coderscamp.blog;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.OptionalDouble;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

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
        j8.NameTestNew();
        j8.Test1ForEach();
        j8.Test2Filter();
        j8.Test3ToList();
        j8.Test4ToSum();
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
    
    // Robo Call Test with Anonymous Function
    public void RoboCallTestAnonymous(){
    	
		List<Person> pl = Person.createShortList();
		RoboContactMethodsAnonymous robo = new RoboContactMethodsAnonymous();
		
		System.out.println("\n=== Robo Call With Anonymous Function ===");
		
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
    
    // Robo Call Test With Lambda Expression
    public void RoboCallTestWithLambda(){
    	
    	List<Person> pl = Person.createShortList();
    	RoboContactMethodsLambda robo = new RoboContactMethodsLambda();
    	
    	System.out.println("\n=== Robo Call With Lambda ===");
    	
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
    
    public void NameTestNew(){
    	System.out.println("\n=== NameTestNew ===");
    	
    	List<Person> pl = Person.createShortList();
    	
    	// Print custom first name + email
    	for(Person person:pl){
    		System.out.println(person.printCustom(p -> "Name: " + p.getGivenName() + " EMail: " + p.getEmail()));
    	}
    	
    	// Define Western and Eastern with Lambda
    	Function<Person, String> westernStyle = p ->{
    		return "\nName: " + p.getGivenName() + " " + p.getSurName() + "\n" +
    				"Age: " + p.getAge() + "  " + 
    				"Gender: " + p.getGender() + "\n" +
    				"EMail: " + p.getEmail() + "\n" + 
    				"Phone: " + p.getPhone() + "\n" +
    				"Address: " + p.getAddress();
    	};
    	
    	Function<Person, String> easternStyle = p ->{
    		return "\nName: " + p.getSurName() + " "  + p.getGivenName() + "\n" + 
    				"Age: " + p.getAge() + "  " +
    				"Gender: " + p.getGender() + "\n" +
    				"EMail: " + p.getEmail() + "\n" +
    				"Phone: " + p.getPhone() + "\n" +
    				"Address: " + p.getAddress();
    	};
    	
    	// Print western style
    	System.out.println("\n=== Western List ===");
    	for (Person p:pl){
    		System.out.println(p.printCustom(westernStyle));
    	}
    	
    	System.out.println("\n=== Eastern List ===");
    	for(Person p:pl){
    		System.out.println(p.printCustom(easternStyle));
    	}
    	
    }
    
    public void Test1ForEach(){
    	
    	List<Person> pl = Person.createShortList();
    	
    	System.out.println("\n=== Western Phone List ===");
    	pl.forEach(p -> p.printWesternName());
    	
    	System.out.println("\n=== Eastern Phone List ===");
    	pl.forEach(Person::printEasternName);
    	
    	System.out.println("\n=== Custom Phone List ===");
    	pl.forEach(p -> { System.out.println(p.printCustom(f-> "Name :" + f.getGivenName() + " EMail :" + f.getEmail()));});
    }
    
    public void Test2Filter(){
    	
    	List<Person> pl = Person.createShortList();
    	
    	SearchCriteria search = SearchCriteria.getInstance();
    	
    	System.out.println("\n=== Western Pilot Phone List ===");
    	pl.stream().filter(search.getCriteria(Constants.ALL_PILOTS))
    		.forEach(Person::printWesternName);
    	
    	System.out.println("\n=== Eastern Draftee Phone List ===");
    	pl.stream().filter(search.getCriteria(Constants.ALL_DRAFTEES))
    		.forEach(Person::printEasternName);
    	
    	System.out.println("\n=== Eastern Pilot Phone List ===");
    	pl.stream().filter(search.getCriteria(Constants.ALL_PILOTS))
    		.forEach(Person::printEasternName);
    }
    
    public void Test3ToList(){
    	
    	List<Person> pl = Person.createShortList();
    	
    	SearchCriteria search = SearchCriteria.getInstance();
    	
    	// Make a list after filtering
    	List<Person> pilotList = pl
    			.stream()
    			.filter(search.getCriteria(Constants.ALL_PILOTS))
    			.collect(Collectors.toList());
    	
    	System.out.println("\n=== Western Pilot Phone List ===");
    	pilotList.forEach(Person::printEasternName);
    }
    
    public void Test4ToSum(){
    	
    	List<Person> pl = Person.createShortList();
    	
    	SearchCriteria search = SearchCriteria.getInstance();
    	
    	// Old style sum
    	int sum = 0;
    	int count = 0;
    	
    	for(Person p:pl){
    		if (p.getAge() >= 23 && p.getAge() <= 65 ){
    			sum = sum + p.getAge();
    			count++;
    		}
    	}
    	
    	long average = sum/count;
    	System.out.println("\n=== Total ages : " + sum);
    	System.out.println("\n=== Average age : " + average);
    	
    	
    	System.out.println("\n=== Calc new style ===");
    	
    	// Get sum of ages
    	long totalAges = pl
    			.stream()
    			.filter(search.getCriteria(Constants.ALL_DRAFTEES))
    			.mapToInt(p -> p.getAge())
    			.sum();
    	
    	// Get average of ages
    	OptionalDouble averageAge = pl
    			.stream()
    			.filter(search.getCriteria(Constants.ALL_DRIVERS))
    			.mapToDouble(p->p.getAge())
    			.average();
    	
    	System.out.println("\n=== Total ages : " + totalAges);
    	System.out.println("\n=== Average age : " + averageAge);
    }
}
