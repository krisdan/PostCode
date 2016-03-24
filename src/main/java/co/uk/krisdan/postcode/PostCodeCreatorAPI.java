package co.uk.krisdan.postcode;

public interface PostCodeCreatorAPI {
	
	public PostCode getPostCodeObject(String postCode, String country);
	
	public PostCode getCanadianPostCodeObject(String postCode);
	
	public PostCode getFrenchPostCodeObject(String postCode);
	
	public PostCode getUkPostCodeObject(String postCode);
	
	public PostCode getUsaPostCodeObject(String postCode);
	
	public PostCodeWrapper getPostCodeWrapper();

}
