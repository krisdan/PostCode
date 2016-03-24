package co.uk.krisdan.postcode.exceptions;

import co.uk.krisdan.postcode.PostCodeFormat;

public class UsaTooLongPostCodeException extends TooLongPostCodeException {

	public UsaTooLongPostCodeException() {
	}

	public UsaTooLongPostCodeException(String message) {
		super(message);
	}

	public UsaTooLongPostCodeException(String message, String postCode) {
		super(message, postCode);
	}

	public UsaTooLongPostCodeException(Throwable cause, String postCode) {
		super(cause, postCode);
	}

	public UsaTooLongPostCodeException(String message, Throwable cause,
			String postCode) {
		super(message, cause, postCode);
	}

	public UsaTooLongPostCodeException(String message, String postCode,
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
		
		String code = "";
		
		if (this.getPostCode().isEmpty()) {
			
			code = "submitted";
		} else {
			
			code = this.getPostCode();
		}
		
		message = "The United States Post Code " + code + " is longer than 10 digits." + newLine;
		message += "Please ensure that it is 5 digits Long." + newLine;
		message += "Unless it is a 5 dash 4 format post code. In which case" + newLine ;
		message += "it should contain 5 digits followed by a - and then followed by four digits." + newLine;
		message += newLine + newLine + PostCodeFormat.usaFormatMsg();
		
		return message;
	}

}