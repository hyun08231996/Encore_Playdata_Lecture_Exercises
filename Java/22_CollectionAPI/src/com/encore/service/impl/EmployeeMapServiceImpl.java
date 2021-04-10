package com.encore.service.impl;
/*
 * 1. �������̽��� ��ӹ޾Ƽ� ����
 * 2. �̱���
 */
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import com.encore.service.EmployeeMapService;
import com.encore.vo.Employee;
import com.encore.vo.Engineer;
import com.encore.vo.Manager;

public class EmployeeMapServiceImpl implements EmployeeMapService {
	//�߰�
	//private ArrayList<Employee> list;
	
	private HashMap<String, Employee> map;
	
	private static EmployeeMapServiceImpl service = new EmployeeMapServiceImpl();
	
	private EmployeeMapServiceImpl() {
		//list = new ArrayList<Employee>();//ArrayList�� �⺻ 10ĭ���� �����ȴ�
		map = new HashMap<String, Employee>();
	}
	
	public static EmployeeMapServiceImpl getInstance() {
		return service;
	}
	
	
	@Override
	public void addEmployee(Employee e) {
		if(map.containsKey(e.getEmpId())) {//�̹� �׷� ��� �����Ѵٸ�
			System.out.println(e.getName()+"���� �̹� ��ϵǾ��� �ֽ��ϴ�.");
			return;
		}else {//�׷� ����� �������� �ʴ´ٸ�
			map.put(e.getEmpId(), e);
			System.out.println(e.getName()+"���� ��ϵǼ̽��ϴ�.");
		}
	}

	@Override
	public void deleteEmployee(String empId) {
		Employee emp = map.remove(empId);
		if(emp==null) {//������ ����� �������� �ʴ´ٸ�
			System.out.println("������ ����� �����ϴ�.");
		}else System.out.println("���� �Ǽ̽��ϴ�.");
	}

	@Override
	public void updateEmployee(Employee e) {
		if(map.containsKey(e.getEmpId())) {
			//����...update(), set()...key����ũ�� ���� �״�� �ΰ� �������� ����...������ ������ �����
			//������ Ű������ ��ü�� �ٽ� �߰�
			map.put(e.getEmpId(), e);
			System.out.println(e.getName()+" ���� ������ �����Ǽ̽��ϴ�.");
		}else {
			System.out.println("������ ����� �������� �ʽ��ϴ�.");
			return;
		}
	}

	@Override
	public ArrayList<Employee> findEmployees(String addr) {
		ArrayList<Employee> temp = new ArrayList<Employee>();
		Set<String> set = map.keySet();
		Iterator<String> it = set.iterator();
		while(it.hasNext()) {
			String key = it.next();
			Employee emp = map.get(key);
			if(emp.getAddr().equals(addr)) temp.add(emp);
		}
		
		return temp;
	}

	@Override
	public ArrayList<Employee> findEmployees() {
		ArrayList<Employee> temp = new ArrayList<Employee>();
		Set<String> set = map.keySet();
		Iterator<String> it = set.iterator();
		while(it.hasNext()) {
			String key = it.next();
			Employee emp = map.get(key);
			temp.add(emp);
		}
		
		return null;
	}

}
