package exception.runtime.test;

public class RuntimeExceptionTest3 {
	public static void main(String[] args) {
		String[] str = {
				"Hello Java",
				"No, I mean it",
				"Nice to meet you"
		};
		
		int i=0;
		while(i<4) {
			try {
				System.out.println(str[i]);
			}catch(ArrayIndexOutOfBoundsException e) {
				System.out.println("Nice catch1!!");
			}catch(Exception e) {//�ѹ� ������ �ٽ� ����´�
				System.out.println("Nice catch2!!");
			}
			i++;
		}
		System.out.println("the end...");
		
		
	}

}
