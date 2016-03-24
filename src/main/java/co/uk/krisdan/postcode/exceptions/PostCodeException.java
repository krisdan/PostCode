package co.uk.krisdan.postcode.exceptions;

public abstract class PostCodeException extends Exception {
	
	protected String postCode;

	public PostCodeException() {
		super();
	}

	public PostCodeException(String postCode) {
		super("");
		
		this.setPostCode(postCode);
	}
	
	public PostCodeException(String message, String postCode) {
		super(message);
		
		this.setPostCode(postCode);
	}

	public PostCodeException(Throwable cause, String postCode) {
		super(cause);
		
		this.setPostCode(postCode);
	}

	public PostCodeException(String message, Throwable cause, String postCode) {
		super(message, cause);
		
		this.setPostCode(postCode);
	}

	public PostCodeException(String message, String postCode, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		//super(message, cause, enableSuppression, writableStackTrace);
		super(message, cause);
		
		this.setPostCode(postCode);
	}
	
	protected void setPostCode(String postCode) {
		
		this.postCode = postCode;
	}
	
	protected String getPostCode( ) {
		
		return this.postCode;
	}
}