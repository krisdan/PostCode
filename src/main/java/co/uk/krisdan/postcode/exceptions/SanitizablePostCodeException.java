package co.uk.krisdan.postcode.exceptions;

public abstract class SanitizablePostCodeException extends
PostCodeException {

String sanitizedPostCode = null;

public SanitizablePostCodeException(String postCode) {
super(postCode);
}

public SanitizablePostCodeException(String message, String postCode) {
super(message, postCode);
}

public SanitizablePostCodeException(Throwable cause, String postCode) {
super(cause, postCode);
}

public SanitizablePostCodeException(String message, Throwable cause,
	String postCode) {
super(message, cause, postCode);
}

public SanitizablePostCodeException(String message, String postCode,
	Throwable cause, boolean enableSuppression,
	boolean writableStackTrace) {
super(message, postCode, cause, enableSuppression, writableStackTrace);
}

public String getSanitizedPostCode() {
return this.sanitizedPostCode;
}

protected void setSanitizedPostCode(String sanitizedPostCode) {

this.sanitizedPostCode = sanitizedPostCode;
}

protected abstract String sanitize(String postCode);

}