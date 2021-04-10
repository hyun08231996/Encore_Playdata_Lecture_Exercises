package broker.twotier.exception;

public class InvalidTransactionException extends Exception {
	public InvalidTransactionException() {
		this("Invalid Transaction");
	}

	public InvalidTransactionException(String message) {
		super(message);
	}
}
