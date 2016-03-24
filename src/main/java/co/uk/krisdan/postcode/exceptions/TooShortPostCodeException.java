package co.uk.krisdan.postcode.exceptions;

public abstract class TooShortPostCodeException extends
PostCodeException {

public TooShortPostCodeException() {
}

public TooShortPostCodeException(String postCode) {
super(postCode);
}

public TooShortPostCodeException(String message, String postCode) {
super(message, postCode);
}

public TooShortPostCodeException(Throwable cause, String postCode) {
super(cause, postCode);
}

public TooShortPostCodeException(String message, Throwable cause,
	String postCode) {
super(message, cause, postCode);
}

public TooShortPostCodeException(String message, String postCode,
	Throwable cause, boolean enableSuppression,
	boolean writableStackTrace) {
super(message, postCode, cause, enableSuppression, writableStackTrace);
}

protected abstract String tooShortMsg();

}