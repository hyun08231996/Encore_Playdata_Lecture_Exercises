package fly.child;

import fly.parent.Flyer;

/*
 * 인터페이스를 부모로둔 자식 클래스는
 * 반드시 부모 인터페이스가 가지고 있는 모든 추상메소드를
 * 다 구현해야한다.
 */
public class AirPlane implements Flyer {

	@Override
	public void fly() {
		System.out.println("AirPlane...fly..");
		
	}

	@Override
	public void land() {
		System.out.println("AirPlane...land..");
		
	}

	@Override
	public void take_off() {
		System.out.println("AirPlane...take_off..");
		
	}
	

}
