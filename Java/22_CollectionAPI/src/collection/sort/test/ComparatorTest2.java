package collection.sort.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

//앞에서 작성된 Person을 여기서 그대로 사용합니다.
public class ComparatorTest2 {

	public static void main(String[] args) {
		ArrayList<Person> list = new ArrayList<Person>();
		list.add(new Person("강호동", 48));
		list.add(new Person("이수근", 43));
		list.add(new Person("서장훈", 38));
		
		//Arrays.sort(배열) | Collections.sort(리스트, Comparator객체)
		
		Collections.sort(list, new Comparator<Person>() {

			@Override
			public int compare(Person p1, Person p2) {
				return p2.getAge()-p1.getAge();//내림차순
			}
		});
		
		//확인
		for(Person p : list) System.out.println(p);

	}

}
