package co.uk.krisdan.postcode.exceptions;

public class InvalidTargetPostCodeTypeException extends PostCodeException {
	
	private String expectedType;
	
	private Object ob;
	
	public InvalidTargetPostCodeTypeException(Object ob, String expectedType) {
		
		this.setOb(ob);
		
		this.setType(expectedType);
	}

	public InvalidTargetPostCodeTypeException(String message, Object ob, String expectedType) {
		super(message);
		
		this.setOb(ob);
		
		this.setType(expectedType);
	}

	public InvalidTargetPostCodeTypeException(String message, String postCode, Object ob, String expectedType) {
		super(message, postCode);
		
		this.setOb(ob);
		
		this.setType(expectedType);
	}

	public InvalidTargetPostCodeTypeException(Throwable cause, String postCode, Object ob, String expectedType) {
		super(cause, postCode);
		
		this.setOb(ob);
		
		this.setType(expectedType);
	}

	public InvalidTargetPostCodeTypeException(String message, Throwable cause,
			String postCode, Object ob, String expectedType) {
		super(message, cause, postCode);
		
		this.setOb(ob);
		
		this.setType(expectedType);
	}

	public InvalidTargetPostCodeTypeException(String message, String postCode,
			Throwable cause, boolean enableSuppression,
			boolean writableStackTrace, Object ob) {
		super(message, postCode, cause, enableSuppression, writableStackTrace);
		
		this.setOb(ob);
		
		this.setType(expectedType);
	}
	
	@Override
	public String getLocalizedMessage() {
		
		String message = "An Object of type " + this.getExpectedType() 
				+ "is expected but an Object of type " 
				+ this.getOb().getClass().getSimpleName() + " was suplied";
		
		return message;
	}

	private void setOb(Object ob) {
		this.ob = ob;
	}

	private void setType(String type) {
		this.expectedType = type;
	}
	
	protected Object getOb() {
		return this.ob;
	}

	protected String getExpectedType() {
		return this.expectedType;
	}
}