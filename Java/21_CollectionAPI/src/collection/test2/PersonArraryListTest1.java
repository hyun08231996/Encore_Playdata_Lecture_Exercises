package collection.test2;

import java.util.ArrayList;

import collection.vo.Person;

/*
 * List안에 여러명의 사람을 추가하는 로직을 작성
 * 추가된 사람의 정보를 핸들링하는 방법도 로직으로 작성
 * 
 */
public class PersonArraryListTest1 {

	public static void main(String[] args) {
		ArrayList<Person> list = new ArrayList<Person>(); //예전에는 Array를 사용했지만.. 이제는 List
		
		list.add(new Person("강호동", "서초동", 45));
		list.add(new Person("이수근", "방배동", 42));
		list.add(new Person("강호동", "여의도", 33));
		list.add(new Person("서장훈", "평창동", 40));
		list.add(new Person("김희철", "서초동", 36));
		
		System.out.println(list);
		
		//1. 리스트에 들어있는 사람이 몇명인지 출력
		System.out.println(list.size());
		//2. 리스트에 저장된 사람의 평균 연령을 출력
		int sum = 0;
		for(Person p : list) {
			sum += p.getAge();
		}
		System.out.println(sum/list.size());
		//3. 저장된 사람들 중에서 서초동에 사는 사람을 출력
		for(Person p : list) {
			if(p.getAddr().equals("서초동")) System.out.println(p.getName());
		}
	}

}
