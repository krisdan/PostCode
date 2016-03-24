package co.uk.krisdan.postcode.exceptions;

public class FrTooHighPostCodeException extends TooHighPostCodeException {

	public FrTooHighPostCodeException() {
	}

	public FrTooHighPostCodeException(String message) {
		super(message);
	}

	public FrTooHighPostCodeException(String message, String postCode) {
		super(message, postCode);
	}

	public FrTooHighPostCodeException(Throwable cause, String postCode) {
		super(cause, postCode);
	}

	public FrTooHighPostCodeException(String message, Throwable cause,
			String postCode) {
		super(message, cause, postCode);
	}

	public FrTooHighPostCodeException(String message, String postCode,
			Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, postCode, cause, enableSuppression, writableStackTrace);
	}
	
	public String getLocalizedMessage() {
		
		return this.tooHighMsg();
	}

	@Override
	protected String tooHighMsg() {
		
		String newLine = System.lineSeparator();
		
		String message;
		
		message = "This French Post Code does not exist"  + newLine;
		message += "because it is higher than 73450." + newLine;
		message += "Please ensure that its value is 00000 or" + newLine;
		message += "between 01000 and 73450" + newLine;
		
		return message;
	}

}