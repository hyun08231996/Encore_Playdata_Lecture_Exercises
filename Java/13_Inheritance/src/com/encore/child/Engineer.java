package com.encore.child;

import com.encore.parent.Employee;
import com.encore.util.MyDate;

public class Engineer extends Employee{
	private String tech;


	public Engineer(String name, MyDate birthDay, double salary, String tech) {
		super(name, birthDay, salary);
		this.tech = tech;
	}


	@Override
	public String toString() {
		return super.toString()+","+tech;
	}
	
	


	
	
}
