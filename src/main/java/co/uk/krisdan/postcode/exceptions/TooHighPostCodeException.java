package co.uk.krisdan.postcode.exceptions;

public abstract class TooHighPostCodeException extends PostCodeException {

	public TooHighPostCodeException() {
		super();
	}

	public TooHighPostCodeException(String message) {
		super(message);
	}

	public TooHighPostCodeException(String message, String postCode) {
		super(message, postCode);
	}

	public TooHighPostCodeException(Throwable cause, String postCode) {
		super(cause, postCode);
	}

	public TooHighPostCodeException(String message, Throwable cause,
			String postCode) {
		super(message, cause, postCode);
	}

	public TooHighPostCodeException(String message, String postCode,
			Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, postCode, cause, enableSuppression, writableStackTrace);
	}

	protected abstract String tooHighMsg( );
}
