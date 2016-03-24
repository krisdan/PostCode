package co.uk.krisdan.postcode.exceptions;

public class UkUnusedPostCodeException extends UnusedPostCodeException {

	public UkUnusedPostCodeException() {
	}

	public UkUnusedPostCodeException(String message) {
		super(message);
	}

	public UkUnusedPostCodeException(String message, String postCode) {
		super(message, postCode);
	}

	public UkUnusedPostCodeException(Throwable cause, String postCode) {
		super(cause, postCode);
	}

	public UkUnusedPostCodeException(String message, Throwable cause,
			String postCode) {
		super(message, cause, postCode);
	}

	public UkUnusedPostCodeException(String message, String postCode,
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
		
		String code = "";
		
		if (this.getPostCode().isEmpty()) {
			
			code = "it";
		} else {
			
			code = this.getPostCode();
		}
		
		message = "This UK Post Code does not exist"  + newLine;
		message += "Although " + code + " follows the UK format it is not Allocated." + newLine;
		message += "Please check your post code and try again." + newLine;
		
		return message;
	}

}