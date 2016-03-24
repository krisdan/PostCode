package co.uk.krisdan.postcode.exceptions;

public class FrTooLowPostCodeException extends TooLowPostCodeException {

	public FrTooLowPostCodeException() {
	}

	public FrTooLowPostCodeException(String message) {
		super(message);
	}

	public FrTooLowPostCodeException(String message, String postCode) {
		super(message, postCode);
	}

	public FrTooLowPostCodeException(Throwable cause, String postCode) {
		super(cause, postCode);
	}

	public FrTooLowPostCodeException(String message, Throwable cause,
			String postCode) {
		super(message, cause, postCode);
	}

	public FrTooLowPostCodeException(String message, String postCode,
			Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, postCode, cause, enableSuppression, writableStackTrace);
	}
	
	@Override
	public String getLocalizedMessage() {
		
		return this.tooLowMsg();
	}

	@Override
	protected String tooLowMsg() {
		
		String newLine = System.lineSeparator();
		
		String message;
		
		message = "This French Post Code does not exist"  + newLine;
		message += "because it is less than 00000." + newLine;
		message += "Please ensure that its value is 00000 or" + newLine;
		message += "between 01000 and 73450" + newLine;
		
		return message;
	}

}