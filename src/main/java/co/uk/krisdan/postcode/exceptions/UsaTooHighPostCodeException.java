package co.uk.krisdan.postcode.exceptions;

public class UsaTooHighPostCodeException extends TooHighPostCodeException {

	public UsaTooHighPostCodeException() {
	}

	public UsaTooHighPostCodeException(String message) {
		super(message);
	}

	public UsaTooHighPostCodeException(String message, String postCode) {
		super(message, postCode);
	}

	public UsaTooHighPostCodeException(Throwable cause, String postCode) {
		super(cause, postCode);
	}

	public UsaTooHighPostCodeException(String message, Throwable cause,
			String postCode) {
		super(message, cause, postCode);
	}

	public UsaTooHighPostCodeException(String message, String postCode,
			Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, postCode, cause, enableSuppression, writableStackTrace);
	}
	
	public String getLocalizedMessage() {
		
		return this.tooHighMsg();
	}

	@Override
	protected String tooHighMsg() {
		
		String newLine = System.lineSeparator();
		
		String message;
		
		message = "This United States Post Code does not exist"  + newLine;
		message += "because it is higher than 99999." + newLine;
		message += "Please ensure that its value is 00000 or" + newLine;
		message += "between 03999 and 99999" + newLine;
		
		return message;
	}

}