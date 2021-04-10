package com.encore.child;

import com.encore.parent.Employee;
import com.encore.util.MyDate;

public class Engineer extends Employee{
	private String tech;
	private int bonus;


	public Engineer(String name, MyDate birthDay, double salary, String tech, int bonus) {
		super(name, birthDay, salary);
		this.tech = tech;
		this.bonus = bonus;
	}


	@Override
	public String getDetails() {
		return super.getDetails()+","+tech;
	}

	
	public void changeTech(String tech) {
		this.tech = tech;
	}


	public int getBonus() {
		return bonus;
	}
	
	
	
}
