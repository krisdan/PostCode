package co.uk.krisdan.postcode.exceptions;

import co.uk.krisdan.postcode.PostCodeFormat;

public class UkTooLongPostCodeException extends TooLongPostCodeException {

	public UkTooLongPostCodeException() {
	}

	public UkTooLongPostCodeException(String postCode) {
		super(postCode);
	}

	public UkTooLongPostCodeException(String message, String postCode) {
		super(message, postCode);
	}

	public UkTooLongPostCodeException(Throwable cause, String postCode) {
		super(cause, postCode);
	}

	public UkTooLongPostCodeException(String message, Throwable cause,
			String postCode) {
		super(message, cause, postCode);
	}

	public UkTooLongPostCodeException(String message, String postCode,
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
		
		message = "The UK Post Code " + code + " is longer than 9 characters." + newLine;
		message += "Please ensure that it is between 6 and 9 characters Long." + newLine;
		message += newLine + newLine + PostCodeFormat.ukFormatMsg();
		
		return message;
	}

}