package co.uk.krisdan.postcode.exceptions;

public abstract class TooLowPostCodeException extends PostCodeException {

	public TooLowPostCodeException() {
	}

	public TooLowPostCodeException(String message) {
		super(message);	
	}

	public TooLowPostCodeException(String message, String postCode) {
		super(message, postCode);
	}

	public TooLowPostCodeException(Throwable cause, String postCode) {
		super(cause, postCode);
	}

	public TooLowPostCodeException(String message, Throwable cause,
			String postCode) {
		super(message, cause, postCode);
	}

	public TooLowPostCodeException(String message, String postCode,
			Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, postCode, cause, enableSuppression, writableStackTrace);
	}
	
	protected abstract String tooLowMsg( );

}