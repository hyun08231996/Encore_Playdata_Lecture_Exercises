package fly.test;

import fly.child.AirPlane;
import fly.child.Bird;
import fly.child.SuperMan;
import fly.parent.Flyer;

public class FlyerTest1 {

	public static void main(String[] args) {
		//1. ���������� ������� �ڽİ�ü�� 3�� ����...bird, superman, airplane
		//2. for, instanceof �̿��ؼ� ���� �ڽ�Ŭ������ ����� ���δ� ȣ��...
		//Flyer flyer = new Flyer(); -> ��ü������ ���Ѵ�
		//�������̽��� ��ü������ ����� �ƴϰ� ��ü�� �����ϱ� ���� Ÿ�����μ��� �����Ѵ�.
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
