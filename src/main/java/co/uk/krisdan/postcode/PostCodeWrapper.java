package co.uk.krisdan.postcode;

public class PostCodeWrapper {
	
	private PostCode postCode;
	
	private String message;
	
	public PostCodeWrapper() {
		
	}
	
	public String getMessage() {
		return message;
	}

	private boolean setMessage(String message) {
		
		boolean success = false;
		
		this.message = message;
		
		success = (this.getMessage().isEmpty());
		
		return success;
	}

	public PostCode getPostCode() {
		return postCode;
	}

	private boolean setPostCode(PostCode postCode) {
		
		boolean success = false;
		
		this.postCode = postCode;
		
		success = (!this.getPostCode().equals(null));
		
		return success;
	}
	
	public String getAsString() {
		return this.getPostCode().getAsString();
	}
	
	public char[] getAsCharArray() {
		return this.getPostCode().getAsCharArray();
	}
	
	private boolean clear() {
		
		boolean success = false;
		
		this.postCode = null;
		
		this.message = null;
		
		success = (this.getPostCode() == null);
		
		return success;
	}
	
	public boolean wrapPostCode(PostCode postCode) {
		
		boolean success = false;
		
		this.setPostCode(postCode);
		
		this.setMessage(postCode.getClass().getSimpleName() + 
				" Post code: " + postCode.getAsString());

		success = (!this.getPostCode().equals(null));
		
		return success;
	}
	
	public PostCode extractPostCode() {
		
		PostCode postCode = this.getPostCode();
		
		clear();
		
		return postCode;
	}
	
	public void finalize(){
		clear();
	}
}
