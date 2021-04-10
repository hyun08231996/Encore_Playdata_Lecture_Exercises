package collection.test2;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

import collection.vo.Customer;

public class CustomerMapTest2 {

	public static void main(String[] args) {
		HashMap<String, Customer> map = new HashMap<String, Customer>();
		
		map.put("111", new Customer("KANG", "강호동", 48));
		map.put("222", new Customer("LEE", "이수근", 42));
		map.put("333", new Customer("SEO", "서장훈", 44));
		map.put("444", new Customer("KIM", "김희철", 37));
		
		//1. KEY 값이 222인 사람의 정보를 출력
		System.out.println(map.get("222"));
		
		//2. id가 LEE인 사람을 찾아서 그 사람의 이름을 출력
		Collection<Customer> col = map.values();
		Iterator<Customer> it2 = col.iterator();
		while(it2.hasNext()) {
			Customer c = it2.next();
			if(c.getId().equals("LEE")) System.out.println(c.getName());
		}
		
		Set<String> set = map.keySet();
		Iterator<String> it = set.iterator();
		while(it.hasNext()) {
			Customer c = map.get(it.next());
			if(c.getId().equals("LEE")) System.out.println(c.getName());
		}
		
		//3. MAP에 저장된 데이터의 모든 KEY값들을 출력
		System.out.println(map.keySet());
		
		//4. MAP에 저장된 사람들 나이의 총합과 평균연령을 출력
		Iterator<Customer> it3 = col.iterator();
		int total = 0;
		while(it3.hasNext()) {
			Customer c = it3.next();
			total += c.getAge();
		}
		System.out.println(total);
		System.out.println(total/map.size());
		
		Set<String> keys = map.keySet();
		int totalAge = 0;
		for(String s : keys) {
			totalAge += map.get(s).getAge();
		}
		System.out.println(totalAge);
		System.out.println(totalAge/map.size());
	}

}
