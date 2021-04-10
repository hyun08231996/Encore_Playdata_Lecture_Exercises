package exception.user.test;

class AmountInputException extends Exception{
	AmountInputException(){
		this("입금액이 10000원 이상이여야 합니다.");
	}
	
	AmountInputException(String message){
		super(message);
	}
}

class InvalidAmountException extends Exception{
	InvalidAmountException(){
		this("출금액이 잔액을 초과했습니다.");
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
		//입금하는 로직
		//입금액이 10000원이 안되면 AmountInputException을 발생
		
		//정상적인 입금이면 잔액에 금액을 추가하고 얼마 입금되었고 잔액은 얼마인지 출력한다.
		
		if(amt<10000) {
			throw new AmountInputException();
		}
		else {
			balance += amt;
			System.out.println(amt+"원 입금되었고, 잔액은 "+balance+"원 입니다.");
		}
	}
	
	public void withdraw(int amt) throws InvalidAmountException{
		//출금하는 로직
		//현재 작액보다 더 많은 금액을 출금하려는 경우 InvalidAmountException을 발생
		
		//출금액이 잔액보다 작거나 같다면 잔액에서 출금액을 빼고...얼마 출금했는지와 남아있는 잔액을 출력
		
		if(amt>balance) {
			throw new InvalidAmountException();
		}
		else {
			balance -= amt;
			System.out.println(amt+"원 출금되었고, 잔액은 "+balance+"원 입니다.");
		}		
	}
}
public class BankAccountExceptionTest4 {
	public static void main(String[] args) {
		/*
		 * 개체 생성
		 * 메소드 각각호출...예외를 여기서 잡아준다
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
