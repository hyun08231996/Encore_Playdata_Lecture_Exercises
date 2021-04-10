package exam.test;

class Car{
	int serialNumber;//field
	static int counter;//static
	
	Car(){
		counter++;
		serialNumber = counter;
	}
}

public class StaticExamTest2 {

	public static void main(String[] args) {
		System.out.println(Car.counter);
		Car c1 = new Car();
		Car c2 = new Car();
		Car c3 = new Car();
		
		System.out.println("=========== field ============");
		System.out.println(c1.serialNumber);//1
		System.out.println(c2.serialNumber);//2
		System.out.println(c3.serialNumber);//3
		System.out.println("=========== static variable ============");
		System.out.println(c1.counter);//3
		System.out.println(c2.counter);//3
		System.out.println(c3.counter);//3
		System.out.println(Car.counter);//3
	}

}
