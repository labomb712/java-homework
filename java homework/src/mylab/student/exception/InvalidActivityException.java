package mylab.student.exception;

public class InvalidActivityException extends Exception{
	public InvalidActivityException(String errorMessage) {
		super(errorMessage);
	}
}