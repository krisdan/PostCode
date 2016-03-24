package co.uk.krisdan.postcode;

public interface PostCodeValidatorAPI {
	
	public boolean isValid(String postCode, String country);

	public boolean isCanadianPostCode(String postCode);
	
	public boolean isFrenchPostCode(String postCode);
	
	public boolean isUkPostCode(String postCode);
	
	public boolean isUsaPostCode(String postCode);
}
