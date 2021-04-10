package com.encore.child;

import com.encore.parent.Employee;
import com.encore.util.MyDate;

public class Secretary extends Employee{
	private String bossOfName;
	

	public Secretary(String name, MyDate birthDay, double salary, String bossOfName) {
		super(name, birthDay, salary);
		this.bossOfName = bossOfName;
	}

	@Override
	public String getDetails() {
		return super.getDetails()+","+bossOfName;
	}

	public void changeBossOfName(String bossOfName) {
		this.bossOfName = bossOfName;
	}
	
	
	
}
