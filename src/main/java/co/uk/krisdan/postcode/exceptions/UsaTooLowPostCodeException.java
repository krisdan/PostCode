package co.uk.krisdan.postcode.exceptions;

public class UsaTooLowPostCodeException extends TooLowPostCodeException {

	public UsaTooLowPostCodeException() {
	}

	public UsaTooLowPostCodeException(String message) {
		super(message);
	}

	public UsaTooLowPostCodeException(String message, String postCode) {
		super(message, postCode);
	}

	public UsaTooLowPostCodeException(Throwable cause, String postCode) {
		super(cause, postCode);
	}

	public UsaTooLowPostCodeException(String message, Throwable cause,
			String postCode) {
		super(message, cause, postCode);
	}

	public UsaTooLowPostCodeException(String message, String postCode,
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
		
		message = "This United States Post Code does not exist"  + newLine;
		message += "because it is less than 00000." + newLine;
		message += "Please ensure that its value is 00000 or" + newLine;
		message += "between 00001 and 03999" + newLine;
		
		return message;
	}

}