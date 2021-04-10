package poly.service;

import poly.vo.Employee;
import poly.vo.Engineer;
import poly.vo.Manager;

public class EmployeeService2 {
	
	static private EmployeeService2 service = new EmployeeService2();
	private EmployeeService2() {}
	public static EmployeeService2 getInstance() {
		return service;
	}

	public void changeEmployee(Employee e, String name) {
		if(e instanceof Manager) {
			((Manager) e).changeDept(name);
			System.out.println(e);
		}
		if(e instanceof Engineer) {
			((Engineer) e).changeTech(name);
			System.out.println(e);
		}
		
	}
	
	//public EmployeeService2(){}
	
	public void printInfo(Employee emp) {
		System.out.println(emp);
	}
	
	public void printAllInfo(Employee[] emp) {
		for(int i = 0; i<emp.length; i++) {
			System.out.println(emp[i]);
		}
	}
	
	public Employee findByEmpId(Employee[] emp, String empID) {
		Employee employee = null;
		for(Employee e : emp) {
			if(e.getEmpId().equals(empID)) employee = e;
		}
		return employee;
	}
	
	public Employee[] findByAddress(Employee[] emp, String address) {
		Employee[] temp = new Employee[emp.length];
		int cnt = 0;
		for(Employee e : emp) {
			if(e.getAddr().equals(address)) temp[cnt++] = e;
		}
		return temp;
	}
	
	public int getAnnualSalary(Employee emp) {
		if(emp instanceof Engineer) {
			return emp.getSalary()*12 + ((Engineer) emp).getBonus();
		}
		else return emp.getSalary()*12;
	}
	
	public int getTotalCost(Employee[] emp) {
		int total = 0;
		for(Employee e : emp) {
			if(e instanceof Engineer) {
				total += e.getSalary()*12 + ((Engineer) e).getBonus();
			}
			else total += e.getSalary()*12;
		}
		return total;
	}
}
