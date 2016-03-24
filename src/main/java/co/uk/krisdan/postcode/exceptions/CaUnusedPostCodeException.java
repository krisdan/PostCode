package co.uk.krisdan.postcode.exceptions;

public class CaUnusedPostCodeException extends UnusedPostCodeException {

	public CaUnusedPostCodeException() {
	}

	public CaUnusedPostCodeException(String postCode) {
		super(postCode);
	}

	public CaUnusedPostCodeException(String message, String postCode) {
		super(message, postCode);
	}

	public CaUnusedPostCodeException(Throwable cause, String postCode) {
		super(cause, postCode);
	}

	public CaUnusedPostCodeException(String message, Throwable cause,
			String postCode) {
		super(message, cause, postCode);
	}

	public CaUnusedPostCodeException(String message, String postCode,
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
		
		message = "This Canadian Post Code does not exist"  + newLine;
		message += "Although, " + code + " follows the Canadian format, it is not Allocated." + newLine;
		message += "Please check your post code and try again." + newLine;
		
		return message;
	}

}