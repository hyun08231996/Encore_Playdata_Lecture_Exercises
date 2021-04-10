package exception.user.test;

class AmountInputException extends Exception{
	AmountInputException(){
		this("�Աݾ��� 10000�� �̻��̿��� �մϴ�.");
	}
	
	AmountInputException(String message){
		super(message);
	}
}

class InvalidAmountException extends Exception{
	InvalidAmountException(){
		this("��ݾ��� �ܾ��� �ʰ��߽��ϴ�.");
	}
	
	InvalidAmountException(String message){
		super(message);
	}
}

class Account{
	int balance;

	public Account(int balance) {
		super();
		this.balance = balance;
	}

	public int getBalance() {
		return balance;
	}
	
	public void deposit(int amt) throws AmountInputException{
		//�Ա��ϴ� ����
		//�Աݾ��� 10000���� �ȵǸ� AmountInputException�� �߻�
		
		//�������� �Ա��̸� �ܾ׿� �ݾ��� �߰��ϰ� �� �ԱݵǾ��� �ܾ��� ������ ����Ѵ�.
		
		if(amt<10000) {
			throw new AmountInputException();
		}
		else {
			balance += amt;
			System.out.println(amt+"�� �ԱݵǾ���, �ܾ��� "+balance+"�� �Դϴ�.");
		}
	}
	
	public void withdraw(int amt) throws InvalidAmountException{
		//����ϴ� ����
		//���� �۾׺��� �� ���� �ݾ��� ����Ϸ��� ��� InvalidAmountException�� �߻�
		
		//��ݾ��� �ܾ׺��� �۰ų� ���ٸ� �ܾ׿��� ��ݾ��� ����...�� ����ߴ����� �����ִ� �ܾ��� ���
		
		if(amt>balance) {
			throw new InvalidAmountException();
		}
		else {
			balance -= amt;
			System.out.println(amt+"�� ��ݵǾ���, �ܾ��� "+balance+"�� �Դϴ�.");
		}		
	}
}
public class BankAccountExceptionTest4 {
	public static void main(String[] args) {
		/*
		 * ��ü ����
		 * �޼ҵ� ����ȣ��...���ܸ� ���⼭ ����ش�
		 */
		Account account = new Account(10000);

		try{
			account.deposit(20000);
		}catch(AmountInputException e) {
			System.out.println(e.getMessage());
		}
		
		try{
			account.withdraw(50000);
		}catch(InvalidAmountException e) {
			System.out.println(e.getMessage());
		}
		
		
	}
}
