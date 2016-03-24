package co.uk.krisdan.postcode.exceptions;

public class FrUnusedPostCodeException extends UnusedPostCodeException {

	public FrUnusedPostCodeException() {
	}

	public FrUnusedPostCodeException(String message) {
		super(message);
	}

	public FrUnusedPostCodeException(String message, String postCode) {
		super(message, postCode);
	}

	public FrUnusedPostCodeException(Throwable cause, String postCode) {
		super(cause, postCode);
	}

	public FrUnusedPostCodeException(String message, Throwable cause, String postCode) {
		super(message, cause, postCode);
	}

	public FrUnusedPostCodeException(String message, String postCode,
			Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, postCode, cause, enableSuppression, writableStackTrace);
	}
	
	public String getLocalizedMessage() {
		
		return this.unusedMsg();
	}

	@Override
	protected String unusedMsg() {
		
		String newLine = System.lineSeparator();
		
		String message;
		
		message = "This French Post Code does not exist"  + newLine;
		message += "because it is between 00001 and 00999." + newLine;
		message += "Please ensure that its value is 00000 or" + newLine;
		message += "between 01000 and 73450" + newLine;
		
		return message;
	}

}