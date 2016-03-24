package co.uk.krisdan.postcode.exceptions;

public class FrTooShortPostCodeException extends TooShortPostCodeException {

	public FrTooShortPostCodeException() {
	}

	public FrTooShortPostCodeException(String message) {
		super(message);
	}

	public FrTooShortPostCodeException(String message, String postCode) {
		super(message, postCode);
	}

	public FrTooShortPostCodeException(Throwable cause, String postCode) {
		super(cause, postCode);
	}

	public FrTooShortPostCodeException(String message, Throwable cause,
			String postCode) {
		super(message, cause, postCode);
	}

	public FrTooShortPostCodeException(String message, String postCode,
			Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, postCode, cause, enableSuppression, writableStackTrace);
	}
	
	@Override
	public String getLocalizedMessage() {
		
		return this.tooShortMsg();
	}

	@Override
	protected String tooShortMsg() {
		
		String newLine = System.lineSeparator();
		
		String message;
		
		message = "The French Post Code submitted is shorter than 5 digits." + newLine;
		message += "Please ensure that it is exactly 5 digits Long." + newLine;
		
		return message;
	}

}