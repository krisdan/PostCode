package co.uk.krisdan.postcode.exceptions;

public abstract class NumericPostCodeException extends
ForbidenCharactersPostCodeException {

public NumericPostCodeException(String postCode) {
	super(postCode);
}

public NumericPostCodeException(String message, String postCode) {
super(message, postCode);
}

public NumericPostCodeException(Throwable cause, String postCode) {
super(cause, postCode);
}

public NumericPostCodeException(String message, Throwable cause,
	String postCode) {
super(message, cause, postCode);
}

public NumericPostCodeException(String message, String postCode,
	Throwable cause, boolean enableSuppression,
	boolean writableStackTrace) {
super(message, postCode, cause, enableSuppression, writableStackTrace);
}

protected String removeAlphaChars(String postCode) {

String noAlphas = "";

for (char ch : postCode.toCharArray()) {
	
	if (!Character.isAlphabetic(ch)) {
		
		noAlphas += ch;
	}
}

return noAlphas;
}

protected abstract String containsAlphaCharsMsg( );

}