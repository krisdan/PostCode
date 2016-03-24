package co.uk.krisdan.postcode.exceptions;

import java.util.ArrayList;

import co.uk.krisdan.postcode.validators.PostCodeValidator;

public class UkAlphaNumericPostCodeException extends
		AlphaNumericPostCodeException {

	public UkAlphaNumericPostCodeException(String postCode) {
		super(postCode);
	}

	public UkAlphaNumericPostCodeException(String message, String postCode) {
		super(message, postCode);
	}

	public UkAlphaNumericPostCodeException(Throwable cause, String postCode) {
		super(cause, postCode);
	}

	public UkAlphaNumericPostCodeException(String message, Throwable cause,
			String postCode) {
		super(message, cause, postCode);
	}

	public UkAlphaNumericPostCodeException(String message, String postCode,
			Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, postCode, cause, enableSuppression, writableStackTrace);
	}
	
	@Override
	public String getLocalizedMessage() {
		
		String newLine = System.lineSeparator();
		
		String postCode = this.getPostCode();
		
		String message = "";
		
		if(PostCodeValidator.isAlpha(postCode)) {
			
			message += this.numericsMissingMsg();
		}
		
		if(PostCodeValidator.isNumeric(postCode)) {
			
			message += this.alphasMissingMsg();
		}
		
		if (PostCodeValidator.hasForbidenChars(postCode, "United Kingdom")) {
			
			message += this.containsForbidenCharsMsg();
		}
		
		String sanitized = this.sanitize(postCode);
		
		this.setSanitizedPostCode(sanitized);
		
		message += newLine + newLine + "Is this Post Code correct: " + sanitized + " ?";
		
		return message;
	}

	@Override
	protected String containsForbidenCharsMsg() {
		
		String newLine = System.lineSeparator();
		
		StringBuilder message = new StringBuilder();
		
		message.append("This Uk Post Code contains forbiden characters," + newLine);
		message.append("such as asterix, punctuation or white space." + newLine);
		message.append("Please ensure that it contains only alpha numeric characters," + newLine);
		message.append("is between 6 and 9 characters long including a space." + newLine + newLine);
		message.append("The following Characters are not permitted:" + newLine + newLine);
		
		ArrayList<Character> forbidenChars = PostCodeValidator.getForbidenCharsByCountry("United Kingdom");
		
		for(char ch : forbidenChars) {
			
			message.append(ch + ", ");
		}
		
		message.append(newLine);
		
		return message.toString();
	}

	@Override
	protected String numericsMissingMsg() {
		
		String newLine = System.lineSeparator();
		
		StringBuilder message = new StringBuilder();
		
		message.append("This Uk Post Code contains no Numeric characters," + newLine);
		message.append("Uk Post Codes should contain both Alpha and" + newLine);
		message.append("Numeric characters, Please ensure that it" + newLine);
		message.append("contains both alpha and numeric characters." + newLine + newLine);
		message.append("The following Characters are not permitted:" + newLine + newLine);
		
		ArrayList<Character> forbidenChars = PostCodeValidator.getForbidenCharsByCountry("United Kingdom");
		
		for(char ch : forbidenChars) {
			
			message.append(ch + ", ");
		}
		
		message.append(newLine);
		
		return message.toString();
	}

	@Override
	protected String alphasMissingMsg() {
		
		String newLine = System.lineSeparator();
		
		StringBuilder message = new StringBuilder();
		
		message.append("This Uk Post Code contains no Alpha characters," + newLine);
		message.append("Uk Post Codes should contain both Alpha and" + newLine);
		message.append(" numeric characters, Please ensure that it" + newLine);
		message.append("contains both alpha  and numeric characters." + newLine + newLine);
		message.append("The following Characters are not permitted:" + newLine + newLine);
		
		ArrayList<Character> forbidenChars = PostCodeValidator.getForbidenCharsByCountry("United Kingdom");
		
		for(char ch : forbidenChars) {
			
			message.append(ch + ", ");
		}
		
		message.append(newLine);
		
		return message.toString();
	}

	@Override
	protected String sanitize(String postCode) {
		
		return this.removeForbidenChars(postCode, "United Kingdom");
	}

}