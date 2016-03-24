package co.uk.krisdan.postcode.exceptions;

public class FrTooLongPostCodeException extends TooLongPostCodeException {

	public FrTooLongPostCodeException() {
	}

	public FrTooLongPostCodeException(String message) {
		super(message);
	}

	public FrTooLongPostCodeException(String message, String postCode) {
		super(message, postCode);
	}

	public FrTooLongPostCodeException(Throwable cause, String postCode) {
		super(cause, postCode);
	}

	public FrTooLongPostCodeException(String message, Throwable cause,
			String postCode) {
		super(message, cause, postCode);
	}

	public FrTooLongPostCodeException(String message, String postCode,
			Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, postCode, cause, enableSuppression, writableStackTrace);
	}
	
	@Override
	public String getLocalizedMessage() {
		
		return this.tooLongMsg();
	}

	@Override
	protected String tooLongMsg() {
		
		String newLine = System.lineSeparator();
		
		String message;
		
		message = "The French Post Code submitted is longer than 5 digits." + newLine;
		message += "Please ensure that it is exactly 5 digits Long." + newLine;
		
		return message;
	}

}