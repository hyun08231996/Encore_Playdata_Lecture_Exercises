package collection.test;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/*
 * Map의 자식 클래스...HashMap
 * key-value를 쌍으로 연결해서 데이터를 저장하는 특징을 가진다.
 * key는 중복을 허용하지 않고 value는 중복 가능하다.
 * 순서는 없다.
 */
public class HashMapTest4 {

	public static void main(String[] args) {
		Map<String, Integer> map= new HashMap<String, Integer>(); //data type 기본형이 들어가면 안된다. int -> Integer
		map.put("강호동", 90);
		map.put("이수근", 95);
		map.put("서장훈", 99);
		map.put("김희철", 80);
		
		//1.키만 받아온다.
		//2.키들을 돌면서
		//3.키값 뽑고
		//4.키값에 해당하는 점수뽑고
		//5.최종적으로 모든성적의 합과 평균값을 출력한다.
		System.out.println("===========keySet() =============");
		Set<String> set = map.keySet();
		System.out.println(set);
		
		Iterator<String> it = set.iterator();
		int total = 0;
		while(it.hasNext()) { //hasMoreElements()
			String name = it.next(); //hasNext()
			int score = map.get(name);
			total += score;
		}
		System.out.println("모든성적의 총합: "+total+"점");
		System.out.println("모든성적의 평균: "+total/map.size()+"점");
		
		System.out.println("===========values() =============");
		Collection<Integer> col = map.values(); //90, 95, 99, 80
		Iterator<Integer> it2 = col.iterator();
		int sum = 0;
		while(it2.hasNext()) {
			int jumsu = it2.next();
			sum += jumsu;
		}
		System.out.println("모든성적의 총합: "+sum+"점");
		System.out.println("모든성적의 평균: "+sum/map.size()+"점");
		
		System.out.println("최고성적: "+Collections.max(col)+"점");
		System.out.println("최저성적: "+Collections.min(col)+"점");
		
	}

}
