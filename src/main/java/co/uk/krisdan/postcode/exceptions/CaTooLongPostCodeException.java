package co.uk.krisdan.postcode.exceptions;

import co.uk.krisdan.postcode.PostCodeFormat;

public class CaTooLongPostCodeException extends TooLongPostCodeException {

	public CaTooLongPostCodeException() {
	}

	public CaTooLongPostCodeException(String message) {
		super(message);
	}

	public CaTooLongPostCodeException(String message, String postCode) {
		super(message, postCode);
	}

	public CaTooLongPostCodeException(Throwable cause, String postCode) {
		super(cause, postCode);
	}

	public CaTooLongPostCodeException(String message, Throwable cause,
			String postCode) {
		super(message, cause, postCode);
	}

	public CaTooLongPostCodeException(String message, String postCode,
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
		
		String code = "";
		
		if (this.getPostCode().isEmpty()) {
			
			code = "submitted";
		} else {
			
			code = this.getPostCode();
		}
		
		String message;
		
		message = "The Canadian Post Code " + code + " is longer than 6 characters." + newLine;
		message += "Please ensure that it is 6 or 7 characters Long, if you include a space." + newLine;
		message += newLine + newLine + PostCodeFormat.ukFormatMsg();
		
		return message;
	}

}
