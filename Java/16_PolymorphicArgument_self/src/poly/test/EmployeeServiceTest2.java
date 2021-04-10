package poly.test;

import poly.service.EmployeeService2;
import poly.vo.Employee;
import poly.vo.Engineer;
import poly.vo.Manager;

public class EmployeeServiceTest2 {

	public static void main(String[] args) {
		Employee e1 = new Manager(null, null, null, 0, null);
		Employee e2 = new Manager(null, null, null, 0, null);
		Employee e3 = new Engineer(null, null, null, 0, null, 0);
		Employee e4 = new Engineer(null, null, null, 0, null, 0);
		
		Employee[] employees = {e1, e2, e3, e4};
		
		//EmployeeService2 service = new EmployeeService2();
		

	}

}
