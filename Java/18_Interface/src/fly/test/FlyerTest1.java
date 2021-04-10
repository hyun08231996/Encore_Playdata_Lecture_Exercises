package fly.test;

import fly.child.AirPlane;
import fly.child.Bird;
import fly.child.SuperMan;
import fly.parent.Flyer;

public class FlyerTest1 {

	public static void main(String[] args) {
		//1. 폴리몰피즘 방식으로 자식객체를 3개 생성...bird, superman, airplane
		//2. for, instanceof 이용해서 각각 자식클래스의 기능을 전부다 호출...
		//Flyer flyer = new Flyer(); -> 객체생성을 못한다
		//인터페이스는 객체생성의 대상이 아니고 객체를 생성하기 위한 타입으로서만 존재한다.
		Flyer bird = new Bird();
		Flyer superman = new SuperMan();
		Flyer airplane = new AirPlane();
		
		Flyer[] flyers = {bird, superman, airplane};
		
		for(Flyer f : flyers) {
			if(f instanceof Bird) {
				System.out.println(((Bird) f).layEggs());
			}
			else if(f instanceof SuperMan) {
				System.out.println(((SuperMan) f).stop_Bullet());
			}
			f.fly();
			f.land();
			f.take_off();
			System.out.println("=====================================");
		}

	}

}
