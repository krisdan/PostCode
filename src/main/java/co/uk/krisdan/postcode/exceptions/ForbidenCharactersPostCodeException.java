package co.uk.krisdan.postcode.exceptions;

import java.util.ArrayList;

import co.uk.krisdan.postcode.validators.PostCodeValidator;


public abstract class ForbidenCharactersPostCodeException extends
		SanitizablePostCodeException {

	public ForbidenCharactersPostCodeException(String postCode) {
		super(postCode);
	}

	public ForbidenCharactersPostCodeException(String message, String postCode) {
		super(message, postCode);
		
		this.setPostCode(postCode);
	}

	public ForbidenCharactersPostCodeException(Throwable cause, String postCode) {
		super(cause, postCode);
		
		this.setPostCode(postCode);
	}

	public ForbidenCharactersPostCodeException(String message, Throwable cause,
			String postCode) {
		super(message, cause, postCode);
		
		this.setPostCode(postCode);
	}

	public ForbidenCharactersPostCodeException(String message, String postCode,
			Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, postCode, cause, enableSuppression, writableStackTrace);
		
		this.setPostCode(postCode);
	}
	
	protected String removeForbidenChars(String postCode, String country) {
		
		ArrayList<Character> forbiden = PostCodeValidator.getForbidenCharsByCountry(country);
		
		return postCode.replaceAll(forbiden.toString(), "");
	}
	
	protected abstract String containsForbidenCharsMsg( );

}