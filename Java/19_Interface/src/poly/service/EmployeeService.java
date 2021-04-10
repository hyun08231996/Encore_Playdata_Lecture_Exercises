package poly.service;

import poly.vo.Employee;

public interface EmployeeService {
	//�� 7���� Template Method�� �����ߴ�...
	void changeEmployee(Employee e, String name);
	void printInfo(Employee emp);//�տ� �ڵ������� public abstract�� �پ��ִ�...
	void printAllInfo(Employee[] emp);
	Employee findByEmpId(Employee[] emp, String empID);
	Employee[] findByAddress(Employee[] emp, String address);
	int getAnnualSalary(Employee emp);
	int getTotalCost(Employee[] emp);
}
