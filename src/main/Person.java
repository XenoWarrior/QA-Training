package main;

public class Person {

	private String personName = "";
	private int personAge = 0;
	private String personJob = "";

	public Person(String name, int age, String job) {
		personName = name;
		personAge = age;
		personJob = job;
	}
	
	public String stringify() {
		return "Name/Age: " + personName + ", " + personAge + ". Job: " + personJob;
	}

	public void setName(String name) {
		personName = name;
	}

	public String getName() {
		return personName;
	}

	public void setAge(int age) {
		personAge = age;
	}

	public int getAge() {
		return personAge;
	}

	public void setJob(String job) {
		personJob = job;
	}

	public String getJob() {
		return personJob;
	}
}
