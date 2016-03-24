package co.uk.krisdan.postcode.exceptions;

import java.util.ArrayList;

import co.uk.krisdan.postcode.validators.PostCodeValidator;

public class UsaNumericPostCodeException extends NumericPostCodeException {

	public UsaNumericPostCodeException(String postCode) {
		super(postCode);
	}

	public UsaNumericPostCodeException(String message, String postCode) {
		super(message, postCode);
	}

	public UsaNumericPostCodeException(Throwable cause, String postCode) {
		super(cause, postCode);
	}

	public UsaNumericPostCodeException(String message, Throwable cause,
			String postCode) {
		super(message, cause, postCode);
	}

	public UsaNumericPostCodeException(String message, String postCode,
			Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, postCode, cause, enableSuppression, writableStackTrace);
	}
	
	@Override
	public String getLocalizedMessage() {
		
		String newLine = System.lineSeparator();
		
		String postCode = this.getPostCode();
		
		String message = "";
		
		if(PostCodeValidator.isAlphaNumeric(postCode) || PostCodeValidator.isAlpha(postCode)) {
			
			message += this.containsAlphaCharsMsg();
		}
		
		if (PostCodeValidator.hasForbidenChars(postCode, "United States")) {
			
			message += this.containsForbidenCharsMsg();
		}
		
		String sanitized = this.sanitize(postCode);
		
		this.setSanitizedPostCode(sanitized);
		
		message += newLine + "Is this Post Code correct: " + sanitized + " ?";
		
		return message;
	}


	protected String containsAlphaCharsMsg() {
		
		String newLine = System.lineSeparator();
		
		String message;
		
		message = newLine;
		message += "The US Post Code submitted is not numeric." + newLine;
		message += "Please ensure that it contains only whole numbers" + newLine;
		message += "and has exactly 5 digits or conforms to the 5 dash 4 format." + newLine;
		
		return message;
	}

	@Override
	protected String containsForbidenCharsMsg() {
		
		String newLine = System.lineSeparator();
		
		StringBuilder message = new StringBuilder();
		
		message.append("This US Post Code may also contain non numeric characters." + newLine);
		message.append("such as asterix, punctuation or white space." + newLine + newLine);
		message.append("The following Characters are not permitted:" + newLine);
		
		ArrayList<Character> forbidenChars = PostCodeValidator.getForbidenCharsByCountry("United States");
		
		for(char ch : forbidenChars) {
			
			message.append(ch + ", ");
		}
		
		message.append(newLine);
		
		return message.toString();
	}
	
	protected String sanitize(String postCode) {
		
		String noAlphas = this.removeAlphaChars(postCode);
		
		String sanitized = this.removeForbidenChars(noAlphas, "United States");
		
		return sanitized;
	}

}