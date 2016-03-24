package co.uk.krisdan.postcode.exceptions;

import co.uk.krisdan.postcode.PostCodeFormat;

public class UsaTooShortPostCodeException extends TooShortPostCodeException {

	public UsaTooShortPostCodeException() {
	}

	public UsaTooShortPostCodeException(String message) {
		super(message);
	}

	public UsaTooShortPostCodeException(String message, String postCode) {
		super(message, postCode);
	}

	public UsaTooShortPostCodeException(Throwable cause, String postCode) {
		super(cause, postCode);
	}

	public UsaTooShortPostCodeException(String message, Throwable cause, String postCode) {
		super(message, cause, postCode);
	}

	public UsaTooShortPostCodeException(String message, String postCode, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
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
		
		message = "The UNited States Post Code submitted is shorter than 5 digits." + newLine;
		message += "Please ensure that it is 5 digits Long." + newLine;
		message += "Unless it is a 5 dash 4 format post code. In which case" + newLine ;
		message += "it should contain 5 digits followed by a - and then followed by four digits." + newLine;
		message += newLine + newLine + PostCodeFormat.ukFormatMsg();
		
		return message;
	}

}