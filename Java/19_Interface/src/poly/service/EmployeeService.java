package poly.service;

import poly.vo.Employee;

public interface EmployeeService {
	//총 7개의 Template Method를 선언했다...
	void changeEmployee(Employee e, String name);
	void printInfo(Employee emp);//앞에 자동적으로 public abstract가 붙어있다...
	void printAllInfo(Employee[] emp);
	Employee findByEmpId(Employee[] emp, String empID);
	Employee[] findByAddress(Employee[] emp, String address);
	int getAnnualSalary(Employee emp);
	int getTotalCost(Employee[] emp);
}
