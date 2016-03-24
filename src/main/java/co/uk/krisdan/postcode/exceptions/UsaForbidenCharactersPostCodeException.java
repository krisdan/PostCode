package co.uk.krisdan.postcode.exceptions;

import java.util.ArrayList;

import co.uk.krisdan.postcode.validators.PostCodeValidator;

public class UsaForbidenCharactersPostCodeException extends
		ForbidenCharactersPostCodeException {

	public UsaForbidenCharactersPostCodeException(String message) {
		super(message);
	}

	public UsaForbidenCharactersPostCodeException(String message, String postCode) {
		super(message, postCode);
	}

	public UsaForbidenCharactersPostCodeException(Throwable cause,
			String postCode) {
		super(cause, postCode);
	}

	public UsaForbidenCharactersPostCodeException(String message,
			Throwable cause, String postCode) {
		super(message, cause, postCode);
	}

	public UsaForbidenCharactersPostCodeException(String message,
			String postCode, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, postCode, cause, enableSuppression, writableStackTrace);
	}
	
	@Override
	public String getLocalizedMessage() {
		
		String newLine = System.lineSeparator();
		
		String postCode = this.getPostCode();
		
		String message = "";
		
		if (PostCodeValidator.hasForbidenChars(postCode, "United States")) {
			
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
		
		message.append("This US Post Code contains forbiden characters," + newLine);
		message.append("such as asterix, punctuation or white space." + newLine);
		message.append("Please ensure that it contains only whole numbers." + newLine + newLine);
		message.append("The following Characters are not permitted:" + newLine);
		
		ArrayList<Character> forbidenChars = PostCodeValidator.getForbidenCharsByCountry("United States");
		
		for(char ch : forbidenChars) {
			
			message.append(ch + ", ");
		}
		
		message.append(newLine);
		
		return message.toString();
	}
	
	protected String sanitize(String postCode) {
		
		return this.removeForbidenChars(postCode, "United States");
	}

}