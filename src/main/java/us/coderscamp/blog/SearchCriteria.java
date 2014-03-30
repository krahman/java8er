package us.coderscamp.blog;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Predicate;

import us.coderscamp.blog.pojo.Gender;
import us.coderscamp.blog.pojo.Person;

public class SearchCriteria {
	
	private final Map<String, Predicate<Person>> searchMap = new HashMap<>();
	
	private SearchCriteria(){
		super();
		initSearchMap();
	}
	
	private void initSearchMap(){
		Predicate<Person> allDrivers = p -> p.getAge() >= 16;
		Predicate<Person> allDraftees = p -> p.getAge() >= 18 && p.getAge() <= 25 && p.getGender() == Gender.MALE;
		Predicate<Person> allPilots = p -> p.getAge() >= 23 && p.getAge() <= 65;
		
		searchMap.put(Constants.ALL_DRIVERS, allDrivers);
		searchMap.put(Constants.ALL_DRAFTEES, allDraftees);
		searchMap.put(Constants.ALL_PILOTS, allPilots);
	}
	
	public Predicate<Person> getCriteria(String predicateName){
		Predicate<Person> target;
		target = searchMap.get(predicateName);
		
		if(target == null){
			System.out.println("\n=== Search criteria not found ===");
			System.exit(1);
		}
		
		return target;
	}
	
	public static SearchCriteria getInstance(){
		return new SearchCriteria();
	}

}
