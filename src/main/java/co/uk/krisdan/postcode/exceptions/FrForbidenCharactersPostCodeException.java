package co.uk.krisdan.postcode.exceptions;

import java.util.ArrayList;

import co.uk.krisdan.postcode.validators.PostCodeValidator;

public class FrForbidenCharactersPostCodeException extends
		ForbidenCharactersPostCodeException {

	public FrForbidenCharactersPostCodeException(String message) {
		super(message);
	}

	public FrForbidenCharactersPostCodeException(String message, String postCode) {
		super(message, postCode);
	}

	public FrForbidenCharactersPostCodeException(Throwable cause,
			String postCode) {
		super(cause, postCode);
	}

	public FrForbidenCharactersPostCodeException(String message,
			Throwable cause, String postCode) {
		super(message, cause, postCode);
	}

	public FrForbidenCharactersPostCodeException(String message,
			String postCode, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, postCode, cause, enableSuppression, writableStackTrace);
	}
	
	@Override
	public String getLocalizedMessage() {
		
		String newLine = System.lineSeparator();
		
		String postCode = this.getPostCode();
		
		String message = "";
		
		if (PostCodeValidator.hasForbidenChars(postCode, "France")) {
			
			message += this.containsForbidenCharsMsg();
		}
		
		String sanitized = this.sanitize(postCode);
		
		this.setSanitizedPostCode(sanitized);
		
		message += newLine + "Is this Post Code correct: " + sanitized + " ?";
		
		return message;
	}

	@Override
	protected String containsForbidenCharsMsg() {
		
		String newLine = System.lineSeparator();
		
		StringBuilder message = new StringBuilder();
		
		message.append("This French Post Code contains forbiden characters," + newLine);
		message.append("such as asterix, punctuation or white space." + newLine);
		message.append("Please ensure that it contains only whole numbers." + newLine + newLine);
		message.append("The following Characters are not permitted:" + newLine);
		
		ArrayList<Character> forbidenChars = PostCodeValidator.getForbidenCharsByCountry("France");
		
		for(char ch : forbidenChars) {
			
			message.append(ch + ", ");
		}
		
		message.append(newLine);
		
		return message.toString();
	}
	
	protected String sanitize(String postCode) {
		
		return this.removeForbidenChars(postCode, "France");
	}

}