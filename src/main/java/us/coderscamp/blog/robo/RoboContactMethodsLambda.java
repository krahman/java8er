package us.coderscamp.blog.robo;

import java.util.List;
import java.util.function.Predicate;

import us.coderscamp.blog.pojo.Person;

public class RoboContactMethodsLambda {
	public void callDrivers(List<Person> pl, Predicate<Person> pred){
		for(Person p:pl){
			if(pred.test(p)){
				roboCall(p);
			}
		}
	}
	
	public void emailDraftees(List<Person> pl, Predicate<Person> pred){
		for(Person p:pl){
			if(pred.test(p)){
				roboEmail(p);
			}
		}
	}
	
	public void mailPilots(List<Person> pl, Predicate<Person> pred){
		for(Person p:pl){
			if(pred.test(p)){
				roboMail(p);
			}
		}
	}
	
	public void roboCall(Person p){
		System.out.println("Calling " + p.getGivenName() + " " + p.getSurName() + " age " + p.getAge() + " at " + p.getPhone());
	}
	
	public void roboEmail(Person p){
		System.out.println("Calling " + p.getGivenName() + " " + p.getSurName() + " age " + p.getAge() + " at " + p.getEmail());
	}
	
	public void roboMail(Person p){
		System.out.println("Calling " + p.getGivenName() + " " + p.getSurName() + " age " + p.getAge() + " at " + p.getAddress());
	}
}
