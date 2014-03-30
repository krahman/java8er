package us.coderscamp.blog.robo;

import java.util.List;

import us.coderscamp.blog.pojo.Gender;
import us.coderscamp.blog.pojo.Person;

public class RoboContactMethodsAnonymous {
	public void callDrivers(List<Person> pl, ITest<Person> iTest){
		for(Person p:pl){
			if(iTest.test(p)){
				roboCall(p);
			}
		}
	}
	
	public void emailDraftees(List<Person> pl, ITest<Person> iTest){
		for(Person p:pl){
			if(iTest.test(p)){
				roboEmail(p);
			}
		}
	}
	
	public void mailPilots(List<Person> pl, ITest<Person> iTest){
		for(Person p:pl){
			if(iTest.test(p)){
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
