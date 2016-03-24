package co.uk.krisdan.postcode;

public class PostCodeAPIInterface implements PostCodeAPI {

	private static PostCodeAPI instance = null;
	
	private PostCodeAPIInterface() {		
		
	}
	
	public static PostCodeAPI getPostCodeAPI() {
		
		if (instance == null) {
			instance = new PostCodeAPIInterface();
		}
		return instance;
	}

	@Override
	public PostCode getPostCodeObject(String postCode, String country) {
		
		PostCode postCodeObj = null;
		
		PostCodeCreatorAPI creator = PostCodeCreator.getInstance();
		
		postCodeObj = creator.getPostCodeObject(postCode, country);
		
		return postCodeObj;
	}

	@Override
	public PostCode getCanadianPostCodeObject(String postCode) {
		
		PostCode postCodeObj = null;
		
		PostCodeCreatorAPI creator = PostCodeCreator.getInstance();
		
		postCodeObj = creator.getCanadianPostCodeObject(postCode);
		
		return postCodeObj;
	}

	@Override
	public PostCode getFrenchPostCodeObject(String postCode) {
		
		PostCode postCodeObj = null;
		
		PostCodeCreatorAPI creator = PostCodeCreator.getInstance();
		
		postCodeObj = creator.getFrenchPostCodeObject(postCode);
		
		return postCodeObj;
	}

	@Override
	public PostCode getUkPostCodeObject(String postCode) {
		
		PostCode postCodeObj = null;
		
		PostCodeCreatorAPI creator = PostCodeCreator.getInstance();
		
		postCodeObj = creator.getUkPostCodeObject(postCode);
		
		return postCodeObj;
	}

	@Override
	public PostCode getUsaPostCodeObject(String postCode) {
		
		PostCode postCodeObj = null;
		
		PostCodeCreatorAPI creator = PostCodeCreator.getInstance();
		
		postCodeObj = creator.getUsaPostCodeObject(postCode);
		
		return postCodeObj;
	}

	@Override
	public PostCodeWrapper getPostCodeWrapper() {
		
		PostCodeWrapper wrapperObj = null;
		
		PostCodeCreatorAPI creator = PostCodeCreator.getInstance();
		
		wrapperObj = creator.getPostCodeWrapper();
		
		return wrapperObj;
	}

	@Override
	public boolean isValid(String postCode, String country) {
		
		boolean isValid = false;
		
		PostCodeValidatorAPI validator = PostCodeValidator.getInstance();
		
		isValid = validator.isValid(postCode, country);
		
		return isValid;
	}

	@Override
	public boolean isCanadianPostCode(String postCode) {
		
		boolean isValid = false;
		
		PostCodeValidatorAPI validator = PostCodeValidator.getInstance();
		
		isValid = validator.isCanadianPostCode(postCode);
		
		return isValid;
	}

	@Override
	public boolean isFrenchPostCode(String postCode) {
		
		boolean isValid = false;
		
		PostCodeValidatorAPI validator = PostCodeValidator.getInstance();
		
		isValid = validator.isFrenchPostCode(postCode);
		
		return isValid;
	}

	@Override
	public boolean isUkPostCode(String postCode) {
		
		boolean isValid = false;
		
		PostCodeValidatorAPI validator = PostCodeValidator.getInstance();
		
		isValid = validator.isUkPostCode(postCode);
		
		return isValid;
	}

	@Override
	public boolean isUsaPostCode(String postCode) {
		
		boolean isValid = false;
		
		PostCodeValidatorAPI validator = PostCodeValidator.getInstance();
		
		isValid = validator.isUsaPostCode(postCode);
		
		return isValid;
	}

}
