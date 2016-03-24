package co.uk.krisdan.postcode;

import static org.junit.Assert.*;

import org.junit.Test;

public class PostCodeAPIInterfaceTest {

	@Test
	public void testGetPostCodeAPI() {
		
		boolean isPostCodeAPI = false;
		
		PostCodeAPI api = PostCodeAPIInterface.getPostCodeAPI();
		
		if(api instanceof PostCodeAPI) {
			
			isPostCodeAPI = true;
		}
		
		assertEquals(true, isPostCodeAPI);
	}

	@Test
	public void testGetPostCodeObject() {
		
		boolean isPostCode = false;
		
		PostCodeAPI api = PostCodeAPIInterface.getPostCodeAPI();
		
		String code = "TF1 6QR";
		
		PostCode postCode = api.getPostCodeObject(code, "United Kingdom");
		
		if(postCode.getAsString().equals(code) && postCode instanceof PostCode) {
			isPostCode = true;
		}
		
		assertEquals(true, isPostCode);
	}

	@Test
	public void testGetCanadianPostCodeObject() {
		
		boolean isCanadian = false;
		
		PostCodeAPI api = PostCodeAPIInterface.getPostCodeAPI();
		
		String code = "H2J 1N3";
		
		PostCode postCode = api.getPostCodeObject(code, "Canada");
		
		if(postCode.getAsString().equals(code) && postCode instanceof CanadianPostCode) {
			isCanadian = true;
		}
		
		assertEquals(true, isCanadian);
	}

	@Test
	public void testGetFrenchPostCodeObject() {
		
		boolean isFrench = false;
		
		PostCodeAPI api = PostCodeAPIInterface.getPostCodeAPI();
		
		String code = "45000";
		
		PostCode postCode = api.getPostCodeObject(code, "France");
		
		if(postCode.getAsString().equals(code) && postCode instanceof FrenchPostCode) {
			isFrench = true;
		}
		
		assertEquals(true, isFrench);
	}

	@Test
	public void testGetUkPostCodeObject() {
		
		boolean isUk = false;
		
		PostCodeAPI api = PostCodeAPIInterface.getPostCodeAPI();
		
		String code = "ST1 4BY";
		
		PostCode postCode = api.getPostCodeObject(code, "United Kingdom");
		
		if(postCode.getAsString().equals(code) && postCode instanceof UkPostCode) {
			isUk = true;
		}
		
		assertEquals(true, isUk);
	}

	@Test
	public void testGetUsaPostCodeObject() {
		
		boolean isUsa = false;
		
		PostCodeAPI api = PostCodeAPIInterface.getPostCodeAPI();
		
		String code = "84150";
		
		PostCode postCode = api.getPostCodeObject(code, "United States of America");
		
		if(postCode.getAsString().equals(code) && postCode instanceof UsaPostCode) {
			isUsa = true;
		}
		
		assertEquals(true, isUsa);
	}

	@Test
	public void testGetPostCodeWrapper() {
		
		boolean isWrapper = false;
		
		PostCodeAPI api = PostCodeAPIInterface.getPostCodeAPI();
		
		PostCodeWrapper wrapper = api.getPostCodeWrapper();
		
		if(wrapper instanceof PostCodeWrapper) {
			isWrapper = true;
		}
		
		assertEquals(true, isWrapper);
	}

	@Test
	public void testIsValid() {
		
		boolean isValid = false;
		
		PostCodeAPI api = PostCodeAPIInterface.getPostCodeAPI();
		
		String code = "H2J 1N3";
		
		isValid = api.isValid(code, "Canada");
		
		assertEquals(true, isValid);
	}

	@Test
	public void testIsCanadianPostCode() {
		
		boolean isCanadian = false;
		
		PostCodeAPI api = PostCodeAPIInterface.getPostCodeAPI();
		
		String code = "H2J 1N3";
		
		isCanadian = api.isCanadianPostCode(code);
		
		assertEquals(true, isCanadian);
	}

	@Test
	public void testIsFrench() {
		
		boolean isFrench = false;
		
		PostCodeAPI api = PostCodeAPIInterface.getPostCodeAPI();
		
		String code = "45000";
		
		isFrench = api.isFrenchPostCode(code);
		
		assertEquals(true, isFrench);
	}

	@Test
	public void testIsUkPostCode() {
		
		boolean isUk = false;
		
		PostCodeAPI api = PostCodeAPIInterface.getPostCodeAPI();
		
		String code = "ST1 4BY";
		
		isUk = api.isUkPostCode(code);
		
		assertEquals(true, isUk);
	}

	@Test
	public void testIsUsaPostCode() {
		
		boolean isUsa = false;
		
		PostCodeAPI api = PostCodeAPIInterface.getPostCodeAPI();
		
		String code = "84150";
		
		isUsa = api.isUsaPostCode(code);
		
		assertEquals(true, isUsa);
	}

}
