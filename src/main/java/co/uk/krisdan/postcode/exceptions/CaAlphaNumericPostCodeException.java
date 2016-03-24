package co.uk.krisdan.postcode.exceptions;

import java.util.ArrayList;

import co.uk.krisdan.postcode.PostCodeFormat;
import co.uk.krisdan.postcode.validators.PostCodeValidator;

public class CaAlphaNumericPostCodeException extends
		AlphaNumericPostCodeException {

	public CaAlphaNumericPostCodeException(String message) {
		super(message);
	}

	public CaAlphaNumericPostCodeException(String message, String postCode) {
		super(message, postCode);
	}

	public CaAlphaNumericPostCodeException(Throwable cause,
			String postCode) {
		super(cause, postCode);
	}

	public CaAlphaNumericPostCodeException(String message,
			Throwable cause, String postCode) {
		super(message, cause, postCode);
	}

	public CaAlphaNumericPostCodeException(String message,
			String postCode, Throwable cause, boolean enableSuppression,
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
		
		if (PostCodeValidator.hasForbidenChars(postCode, "Canada")) {
			
			message += this.containsForbidenCharsMsg();
		}
		
		String sanitized = this.sanitize(postCode);
		
		this.setSanitizedPostCode(sanitized);
		
		message += newLine + newLine + "Is this Post Code correct: " + sanitized + " ?";
		
		return message;
	}

	@Override
	protected String numericsMissingMsg() {
		
		String newLine = System.lineSeparator();
		
		StringBuilder message = new StringBuilder();
		
		message.append("This Canadian Post Code contains no Numeric characters," + newLine);
		message.append("Canadian Post Codes should contain both Alpha and" + newLine);
		message.append("Numeric characters, Please ensure that it" + newLine);
		message.append("contains both alpha and numeric characters" + newLine);
		message.append("and follows the format bellow." + newLine + newLine);
		
		message.append(PostCodeFormat.canadianFormatMsg() +newLine + newLine);
		
		message.append("The following Characters are not permitted:" + newLine + newLine);
		
		ArrayList<Character> forbidenChars = PostCodeValidator.getForbidenCharsByCountry("Canada");
		
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
		
		message.append("This Canadian Post Code contains no Alpha characters," + newLine);
		message.append("Canadian Post Codes should contain both Alpha and" + newLine);
		message.append(" numeric characters, Please ensure that it" + newLine);
		message.append("contains both alpha and numeric characters" + newLine);
		message.append("and follows the format bellow." + newLine + newLine);
		
		message.append(PostCodeFormat.canadianFormatMsg() +newLine + newLine);
		
		message.append("The following Characters are not permitted:" + newLine + newLine);
		
		ArrayList<Character> forbidenChars = PostCodeValidator.getForbidenCharsByCountry("Canada");
		
		for(char ch : forbidenChars) {
			
			message.append(ch + ", ");
		}
		
		message.append(newLine);
		
		return message.toString();
	}

	@Override
	protected String containsForbidenCharsMsg() {
		
		String newLine = System.lineSeparator();
		
		StringBuilder message = new StringBuilder();
		
		message.append("This Canadian Post Code contains forbiden characters," + newLine);
		message.append("such as asterix, punctuation or white space." + newLine);
		message.append("Please ensure that it contains only alpha numeric characters," + newLine);
		message.append("is 6 characters long, 7 if it includes the space including a space." + newLine + newLine);
		message.append("The following Characters are not permitted:" + newLine + newLine);
		
		ArrayList<Character> forbidenChars = PostCodeValidator.getForbidenCharsByCountry("Canada");
		
		for(char ch : forbidenChars) {
			
			message.append(ch + ", ");
		}
		
		message.append(newLine);
		
		return message.toString();
	}

	@Override
	protected String sanitize(String postCode) {
		
		return this.removeForbidenChars(postCode, "Canada");
	}

}
