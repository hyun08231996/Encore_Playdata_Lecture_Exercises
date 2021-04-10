package poly.test;

import poly.service.EmployeeService;
import poly.vo.Employee;
import poly.vo.Engineer;
import poly.vo.Manager;

public class EmployeeServiceTest {

	public static void main(String[] args) {
		Employee e1 = new Manager("123", "asdf", "1234qwer", 1000, "hjhlk");
		Employee e2 = new Manager("234", "qwer", "53246sdgf", 2000, "asttdf");
		Employee e3 = new Engineer("456", "zxcv", "5678jhgk", 3000, "fgh", 500);
		Employee e4 = new Engineer("789", "ghjk", "234sgdf", 4000, "atdf", 600);
		
		Employee[] employees = {e1, e2, e3, e4};
		
		EmployeeService service = new EmployeeService();
		
		service.changeEmployee(e1, "gjhj");
		service.changeEmployee(e3, "kyui");
		System.out.println("====================================");
		service.printInfo(e4);
		service.printAllInfo(employees);
		System.out.println("====================================");
		System.out.println(service.findByEmpId(employees, "123"));
		Employee[] returnEmp = service.findByAddress(employees, "5678jhgk");
		for(Employee e : returnEmp) {
			if(e == null) continue;
			System.out.println(e);
		}
		System.out.println("====================================");
		System.out.println(service.getAnnualSalary(e4));
		System.out.println(service.getAnnualSalary(e2));
		System.out.println("====================================");
		System.out.println(service.getTotalCost(employees));

	}

}
