package broker.twotier.exception;

public class DuplicateSSNException extends Exception {
	public DuplicateSSNException() {
		this("Duplicate SSN Error");
	}

	public DuplicateSSNException(String message) {
		super(message);
	}
}
