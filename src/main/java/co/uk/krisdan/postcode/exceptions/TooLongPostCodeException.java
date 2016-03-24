package co.uk.krisdan.postcode.exceptions;

public abstract class TooLongPostCodeException extends PostCodeException {

	public TooLongPostCodeException() {
	}

	public TooLongPostCodeException(String postCode) {
		super(postCode);
	}

	public TooLongPostCodeException(String message, String postCode) {
		super(message, postCode);
	}

	public TooLongPostCodeException(Throwable cause, String postCode) {
		super(cause, postCode);
	}

	public TooLongPostCodeException(String message, Throwable cause,
			String postCode) {
		super(message, cause, postCode);
	}

	public TooLongPostCodeException(String message, String postCode,
			Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, postCode, cause, enableSuppression, writableStackTrace);
	}
	
	protected abstract String tooLongMsg();

}