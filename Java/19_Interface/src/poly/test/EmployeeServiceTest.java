package poly.test;

import poly.service.impl.EmployeeServiceImpl;
import poly.vo.Employee;
import poly.vo.Engineer;
import poly.vo.Manager;

public class EmployeeServiceTest {

	public static void main(String[] args) {
		Employee e1 = new Manager("m667", "bbb", "천호동", 320, "개발부");
		Employee e2 = new Employee("e123", "aaa", "상일동", 450);
		Employee e3 = new Engineer("eg334", "ccc", "일산", 100, "JAVA", 500);
		Employee e4 = new Engineer("eg155", "ddd", "일산", 400, "JQuery", 50);
		
		Employee[] employees = {e1, e2, e3, e4};
		
		//EmployeeService service = new EmployeeService2();
		
		EmployeeServiceImpl.getInstance().changeEmployee(e1, "관리부");
		EmployeeServiceImpl.getInstance().changeEmployee(e3, "Python");
		System.out.println("====================================");
		EmployeeServiceImpl.getInstance().printInfo(e4);
		System.out.println("====================================");
		EmployeeServiceImpl.getInstance().printAllInfo(employees);
		System.out.println("====================================");
		System.out.println(EmployeeServiceImpl.getInstance().findByEmpId(employees, "e123"));
		System.out.println("====================================");
		Employee[] returnEmp = EmployeeServiceImpl.getInstance().findByAddress(employees, "일산");
		for(Employee e : returnEmp) {
			if(e == null) continue;
			System.out.println(e);
		}
		System.out.println("====================================");
		System.out.println(EmployeeServiceImpl.getInstance().getAnnualSalary(e4));
		System.out.println(EmployeeServiceImpl.getInstance().getAnnualSalary(e2));
		System.out.println("====================================");
		System.out.println(EmployeeServiceImpl.getInstance().getTotalCost(employees));

	}

}
