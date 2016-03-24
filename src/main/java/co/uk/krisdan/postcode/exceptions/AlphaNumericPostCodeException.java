package co.uk.krisdan.postcode.exceptions;

public abstract class AlphaNumericPostCodeException extends
ForbidenCharactersPostCodeException {

public AlphaNumericPostCodeException(String postCode) {
super(postCode);
}

public AlphaNumericPostCodeException(String message, String postCode) {
super(message, postCode);
}

public AlphaNumericPostCodeException(Throwable cause, String postCode) {
super(cause, postCode);
}

public AlphaNumericPostCodeException(String message, Throwable cause,
	String postCode) {
super(message, cause, postCode);
}

public AlphaNumericPostCodeException(String message, String postCode,
	Throwable cause, boolean enableSuppression,
	boolean writableStackTrace) {
super(message, postCode, cause, enableSuppression, writableStackTrace);
}

protected abstract String numericsMissingMsg( );

protected abstract String alphasMissingMsg( );
}
