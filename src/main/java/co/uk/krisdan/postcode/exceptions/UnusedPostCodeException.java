package co.uk.krisdan.postcode.exceptions;

public abstract class UnusedPostCodeException extends PostCodeException {

	public UnusedPostCodeException() {
	}

	public UnusedPostCodeException(String postCode) {
		super(postCode);
	}

	public UnusedPostCodeException(String message, String postCode) {
		super(message, postCode);
	}

	public UnusedPostCodeException(Throwable cause, String postCode) {
		super(cause, postCode);
	}

	public UnusedPostCodeException(String message, Throwable cause,
			String postCode) {
		super(message, cause, postCode);
	}

	public UnusedPostCodeException(String message, String postCode,
			Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, postCode, cause, enableSuppression, writableStackTrace);
	}
	
	protected abstract String unusedMsg( );

}