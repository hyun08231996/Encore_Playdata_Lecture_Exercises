package looping.test;
/*
 * �ݺ��� �߿��� ���� ���� ���Ǵ� 
 * for���� ��� �����ϴ��� ��Ȯ�ϰ� �����Ѵ�.
 * 
 * for(�ʱ��; ���ǽ�; ������);
 */
public class LoopingBasicTest1 {

	public static void main(String[] args) {
		System.out.println("========for=======\n");
		for(int i=0; i<10; ++i) {
			System.out.println("hello..."+i);
		}//for
		
		System.out.println("\n========while=======\n");
		
		int i=0;
		while(i < 10) {
			System.out.println("hello..."+i);
			i++;
		}//while
		
		System.out.println("\n========do while=======\n");
		
		int j=0;
		do {
			System.out.println(j+"...Always Print...");
			j++;
		}while(j<10);
		
	}

}
