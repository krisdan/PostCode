package co.uk.krisdan.postcode.exceptions;

import java.util.ArrayList;

import co.uk.krisdan.postcode.validators.PostCodeValidator;

public class FrNumericPostCodeException extends NumericPostCodeException {

	public FrNumericPostCodeException(String postCode) {
		super(postCode);
	}

	public FrNumericPostCodeException(String message, String postCode) {
		super(message, postCode);
	}

	public FrNumericPostCodeException(Throwable cause, String postCode) {
		super(cause, postCode);
	}

	public FrNumericPostCodeException(String message, Throwable cause,
			String postCode) {
		super(message, cause, postCode);
	}

	public FrNumericPostCodeException(String message, String postCode,
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
		
		if (PostCodeValidator.hasForbidenChars(postCode, "France")) {
			
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
		message += "The French Post Code submitted is not numeric." + newLine;
		message += "Please ensure that it contains only whole numbers" + newLine;
		message += "and has exactly 5 digits." + newLine;
		
		return message;
	}

	@Override
	protected String containsForbidenCharsMsg() {
		
		String newLine = System.lineSeparator();
		
		StringBuilder message = new StringBuilder();
		
		message.append("This French Post Code may also contain non numeric characters." + newLine);
		message.append("such as asterix, punctuation or white space." + newLine + newLine);
		message.append("The following Characters are not permitted:" + newLine);
		
		ArrayList<Character> forbidenChars = PostCodeValidator.getForbidenCharsByCountry("France");
		
		for(char ch : forbidenChars) {
			
			message.append(ch + ", ");
		}
		
		message.append(newLine);
		
		return message.toString();
	}
	
	protected String sanitize(String postCode) {
		
		String noAlphas = this.removeAlphaChars(postCode);
		
		String sanitized = this.removeForbidenChars(noAlphas, "France");
		
		return sanitized;
	}

}