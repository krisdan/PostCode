package co.uk.krisdan.postcode.exceptions;

import co.uk.krisdan.postcode.PostCodeFormat;

public class CaTooShortPostCodeException extends
		TooShortPostCodeException {

	public CaTooShortPostCodeException() {
	}

	public CaTooShortPostCodeException(String message) {
		super(message);
	}

	public CaTooShortPostCodeException(String message, String postCode) {
		super(message, postCode);
	}

	public CaTooShortPostCodeException(Throwable cause, String postCode) {
		super(cause, postCode);
	}

	public CaTooShortPostCodeException(String message, Throwable cause,
			String postCode) {
		super(message, cause, postCode);
	}

	public CaTooShortPostCodeException(String message, String postCode,
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
		
		String code = "";
		
		if (this.getPostCode().isEmpty()) {
			
			code = "submitted";
		} else {
			
			code = this.getPostCode();
		}
		
		String message;
		
		message = "The Canadian Post Code " + code + " is shorter than 6 characters." + newLine;
		message += "Please ensure that it is 6 or 7 characters Long, if a space is included." + newLine;
		message += newLine + newLine + PostCodeFormat.ukFormatMsg();
		
		return message;
	}

}
