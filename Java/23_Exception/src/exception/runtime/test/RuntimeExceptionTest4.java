package exception.runtime.test;
/*
 * ���ܸ� ó���ϴ� ��� 2��°...throws����غ���.
 */
class Throws{
	//go() �����ϴ��� ���ܰ� �߻�...�װ� ������...go()�� ȣ���� ������ ����ó���� ���� �ϼ���.
	public void go() throws ArithmeticException{//4. //9.
		int i = 10;//5.
		int j = 0;//6.
		
		System.out.println("2. 0�� �и�� �ϸ� �ȵ˴ϴ�....");//7. print �ϰ�
		if(i/j==0) //8.���ܰ� �߻� �ؼ� throws
			System.out.println("ArithmeticException....Boom....");
		
	}
}
public class RuntimeExceptionTest4 {

	public static void main(String[] args) {
		
		Throws t = new Throws();//1. �� ���� ���� ���� ���� (compile���ϰ� ������ ���ϱ� ����)
		System.out.println("1. go() calling....");//2. print �ϰ�
		try{//10.
			t.go();//3. go worker method�� ����
		}catch(ArithmeticException e) {//11.
			System.out.println("3. ȣ���� �������� ���ܸ� ��ҽ��ϴ�.");//12. print
		}
		

	}

}
