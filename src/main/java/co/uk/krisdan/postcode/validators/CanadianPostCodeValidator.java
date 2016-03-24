package co.uk.krisdan.postcode.validators;

import java.util.ArrayList;
import java.util.Set;
import java.util.TreeMap;

import co.uk.krisdan.postcode.CanadianPostCodeFSA;
import co.uk.krisdan.postcode.CanadianPostCodeFsaList;
import co.uk.krisdan.postcode.PostCodeElement;
import co.uk.krisdan.postcode.PostCodeElementCollection;
import co.uk.krisdan.postcode.exceptions.CaAlphaNumericPostCodeException;
import co.uk.krisdan.postcode.exceptions.CaTooLongPostCodeException;
import co.uk.krisdan.postcode.exceptions.CaTooShortPostCodeException;
import co.uk.krisdan.postcode.exceptions.CaUnusedPostCodeException;
import co.uk.krisdan.postcode.exceptions.FrTooLongPostCodeException;
import co.uk.krisdan.postcode.exceptions.FrTooShortPostCodeException;
import co.uk.krisdan.postcode.exceptions.UkTooLongPostCodeException;
import co.uk.krisdan.postcode.exceptions.UkTooShortPostCodeException;
import co.uk.krisdan.postcode.exceptions.UsaTooLongPostCodeException;
import co.uk.krisdan.postcode.exceptions.UsaTooShortPostCodeException;
import co.uk.krisdan.postcode.json.JsonReader;

public class CanadianPostCodeValidator {

	private CanadianPostCodeValidator() {

	}

	protected static PostCodeElementCollection getPostCodeFSAsA() {
		
		PostCodeElementCollection pec = null;
		
		String file = "/FSAListA";
		
		JsonReader jr = new JsonReader();
		
		pec = jr.readCanadianPostCodeFSA(file);
		
		return pec;
	}

	protected static PostCodeElementCollection getPostCodeFSAsB() {
		
		String file = "/FSAListB";
		
		JsonReader jr = new JsonReader();
		
		return jr.readCanadianPostCodeFSA(file);
	}

	protected static PostCodeElementCollection getPostCodeFSAsC()  {
		
		String file = "/FSAListC";
		
		JsonReader jr = new JsonReader();
		
		return jr.readCanadianPostCodeFSA(file);
	}

	protected static PostCodeElementCollection getPostCodeFSAsE()  {
		
		String file = "/FSAListE";
		
		JsonReader jr = new JsonReader();
		
		return jr.readCanadianPostCodeFSA(file);
	}

	protected static PostCodeElementCollection getPostCodeFSAsG()  {
		
		String file = "/FSAListG";
		
		JsonReader jr = new JsonReader();
		
		return jr.readCanadianPostCodeFSA(file);
	}

	protected static PostCodeElementCollection getPostCodeFSAsH()  {
		
		String file = "/FSAListH";
		
		JsonReader jr = new JsonReader();
		
		return jr.readCanadianPostCodeFSA(file);
	}

	protected static PostCodeElementCollection getPostCodeFSAsJ()  {
		
		String file = "/FSAListJ";
		
		JsonReader jr = new JsonReader();
		
		return jr.readCanadianPostCodeFSA(file);
	}

	protected static PostCodeElementCollection getPostCodeFSAsK()  {
		
		String file = "/FSAListK";
		
		JsonReader jr = new JsonReader();
		
		return jr.readCanadianPostCodeFSA(file);
	}

	protected static PostCodeElementCollection getPostCodeFSAsL()  {
		
		String file = "/FSAListL";
		
		JsonReader jr = new JsonReader();
		
		return jr.readCanadianPostCodeFSA(file);
	}

	protected static PostCodeElementCollection getPostCodeFSAsM()  {
		
		String file = "/FSAListM";
		
		JsonReader jr = new JsonReader();
		
		return jr.readCanadianPostCodeFSA(file);
	}

	protected static PostCodeElementCollection getPostCodeFSAsN()  {
		
		String file = "/FSAListN";
		
		JsonReader jr = new JsonReader();
		
		return jr.readCanadianPostCodeFSA(file);
	}

	protected static PostCodeElementCollection getPostCodeFSAsP()  {
		
		String file = "/FSAListP";
		
		JsonReader jr = new JsonReader();
		
		return jr.readCanadianPostCodeFSA(file);
	}

	protected static PostCodeElementCollection getPostCodeFSAsR()  {
		
		String file = "/FSAListR";
		
		JsonReader jr = new JsonReader();
		
		return jr.readCanadianPostCodeFSA(file);
	}

	protected static PostCodeElementCollection getPostCodeFSAsS()  {
		
		String file = "/FSAListS";
		
		JsonReader jr = new JsonReader();
		
		return jr.readCanadianPostCodeFSA(file);
	}

	protected static PostCodeElementCollection getPostCodeFSAsT()  {
		
		String file = "/FSAListT";
		
		JsonReader jr = new JsonReader();
		
		return jr.readCanadianPostCodeFSA(file);
	}

	protected static PostCodeElementCollection getPostCodeFSAsV()  {
		
		String file = "/FSAListV";
		
		JsonReader jr = new JsonReader();
		
		return jr.readCanadianPostCodeFSA(file);
	}

	protected static PostCodeElementCollection getPostCodeFSAsX()  {
		
		String file = "/FSAListX";
		
		JsonReader jr = new JsonReader();
		
		return jr.readCanadianPostCodeFSA(file);
	}

	protected static PostCodeElementCollection getPostCodeFSAsY()  {
		
		String file = "/FSAListY";
		
		JsonReader jr = new JsonReader();
		
		return jr.readCanadianPostCodeFSA(file);
	}
	
	public static PostCodeElementCollection getGlobalFSAList()  {
		
		char[] fsaZones = {'A', 'B', 'C', 'E', 'G', 'H', 'J', 'K', 'L', 'M', 'N', 'P', 'R', 'S', 'T', 'V', 'X', 'Y'};
		
		JsonReader jr = new JsonReader();
		PostCodeElementCollection pec = new CanadianPostCodeFsaList("All Canadian FSAs");
		
		for(char zone : fsaZones) {
        	
        	pec.addAll( jr.readCanadianPostCodeFSA(zone).getCollection());
    	}
		return pec;
	}
	
	public static ArrayList<PostCodeElementCollection> getAllFSALists() {
		
		char[] fsaZones = {'A', 'B', 'C', 'E', 'G', 'H', 'J', 'K', 'L', 'M', 'N', 'P', 'R', 'S', 'T', 'V', 'X', 'Y'};
		
		JsonReader jr = new JsonReader();
		
		ArrayList<PostCodeElementCollection> pec = new ArrayList<PostCodeElementCollection>();
		
		for(char zone : fsaZones) {
        	
        	pec.add(jr.readCanadianPostCodeFSA(zone));
    	}
		return pec;
	}
	
	public static TreeMap<String, String> getFsaTreeMap(PostCodeElementCollection pceList) {
		
		TreeMap<String, String> fsaTM = new TreeMap<String, String>();
		
		for(PostCodeElement pce : pceList.getCollection()){
			
			CanadianPostCodeFSA fsa = (CanadianPostCodeFSA) pce;
			
			fsaTM.put(fsa.getCode(), fsa.getDescription());
		}
		return fsaTM;
	}
	
	public static Set<String> getAllFSACodes() {
		
		PostCodeElementCollection pec = getGlobalFSAList();
		
		Set<String> allFSACodes = getFsaTreeMap(pec).keySet();
		
		return allFSACodes;
	}

	/** - abstract Method
	 * 
	 * receives a String representation of the postCode 
	 * and checks its length to see if it is too long.
	 * 
	 * if the String is too long an exception is thrown.
	 * 
	 * @param postCode String
	 * @return boolean
	 * @throws CaTooLongPostCodeException
	 * @throws FrTooLongPostCodeException
	 * @throws UkTooLongPostCodeException
	 * @throws UsaTooLongPostCodeException
	 */
	public static boolean isTooLong(String postCode) {

		boolean tooLong = false;

		if (postCode.length() > 7) {

			tooLong = true;
		}

		return tooLong;
	}

	/** - abstract Method
	 * 
	 * receives a String representation of the postCode 
	 * and checks its length to see if it is too short.
	 * 
	 * if the String is too short an exception is thrown.
	 * 
	 * 
	 * @param postCode String
	 * @return boolean
	 * @throws CaTooShortPostCodeException
	 * @throws FrTooShortPostCodeException
	 * @throws UkTooShortPostCodeException
	 * @throws UsaTooShortPostCodeException
	 */
	public static boolean isTooShort(String postCode) {

		boolean tooShort = false;
		
		postCode = postCode.replaceAll("\\s+","");

		if (postCode.length() < 6) {

			tooShort = true;
		}

		return tooShort;
	}

	public static String getFSACode(String postCode) {

		int start = 0;

		int end = (postCode.length() - 3);

		String fsa = postCode.substring(start, end).replace(" ", "");

		return fsa;
	}

	public static String getLDUCode(String postCode) {

		int start = postCode.length() - 3;

		int end = postCode.length();

		String ldu = postCode.substring(start, end).replace(" ", "");

		return ldu;
	}
	
	public static boolean validFormat(String postCode) {
		
		boolean valid = (fsaValid(postCode) && lduValid(postCode));
		
		return valid;
	}

	/** - abstract Method
	 * 
	 * receives a String representation of the postCode 
	 * and checks to see if it is an actual post code.
	 * 
	 * if the String is not an actual post code an exception is thrown.
	 * 
	 * @param postCode String
	 * @return boolean
	 */
	public static boolean unused(String postCode) {

		boolean unused = false;

		boolean valid = validFormat(postCode);
		
		String fsa = getFSACode(postCode);
		
		Set<String> allFSAs = getAllFSACodes();
		
		boolean fsaExists = allFSAs.contains(fsa);

		if (valid && !fsaExists) {

			unused = true;
		}

		return unused;
	}

	public static boolean firstPositionValid(String postCode) {

		// String forbiden = "[DFIOQUWZdfioquwz]{1}";
		String permitted = "[ABCEGHJKLMNPRSTVXYabceghjklmnprstvxy]{1}";

		String fsa = getFSACode(postCode);

		String ch = "" + fsa.charAt(0);

		return ch.matches(permitted);
	}

	public static boolean secondPositionValid(String postCode) {

		// String forbiden = "[A-Za-z]{1}";
		String permitted = "[0-9]{1}";

		String fsa = getFSACode(postCode);

		String ch = "" + fsa.charAt(1);

		return ch.matches(permitted);
	}

	public static boolean thirdPositionValid(String postCode) {

		// String forbiden = "[DFIOQUdfioquv]{1}";
		String permitted = "[ABCEGHJKLMNPRSTVWXYZabceghjklmnprstvwxyz]{1}";

		String fsa = getFSACode(postCode);

		String ch = "" + fsa.charAt(2);

		return ch.matches(permitted);
	}

	public static boolean fourthPositionValid(String postCode) {

		// String forbiden = "[A-Za-z]{1}";
		String permitted = "[0-9]{1}";

		String ldu = getLDUCode(postCode);

		String ch = "" + ldu.charAt(0);

		return ch.matches(permitted);
	}

	public static boolean fithPositionValid(String postCode) {

		// String forbiden = "[DFIOQUdfioqu]{1}";
		String permitted = "[ABCEGHJKLMNPRSTVWXYZabceghjklmnprstvwxyz]{1}";

		String ldu = getLDUCode(postCode);

		String ch = "" + ldu.charAt(1);

		return ch.matches(permitted);
	}

	public static boolean sixthPositionValid(String postCode) {

		// String forbiden = "[A-Za-z]{1}";
		String permitted = "[0-9]{1}";

		String ldu = getLDUCode(postCode);

		String ch = "" + ldu.charAt(2);

		return ch.matches(permitted);
	}

	public static boolean fsaValid(String postCode) {

		boolean valid = false;

		boolean first, second, third;

		String fsa = getFSACode(postCode);

		first = firstPositionValid(postCode);

		second = secondPositionValid(postCode);

		third = thirdPositionValid(postCode);

		if (first && second && third && fsa.length() == 3) {

			valid = true;

		}

		return valid;
	}

	public static boolean lduValid(String postCode) {

		boolean valid = false;

		boolean fourth, fith, sixth;

		String ldu = getLDUCode(postCode);

		fourth = fourthPositionValid(postCode);

		fith = fithPositionValid(postCode);

		sixth = sixthPositionValid(postCode);

		if (fourth && fith && sixth && ldu.length() == 3) {

			valid = true;

		}

		return valid;
	}

	public static boolean validate(String postCode) throws CaUnusedPostCodeException,
			CaTooLongPostCodeException, CaTooShortPostCodeException,
			CaAlphaNumericPostCodeException {

		boolean valid = false;
		
		boolean isAlaphaNumeric = PostCodeValidator.isAlphaNumeric(postCode);
		
		if (!isAlaphaNumeric) { throw new CaAlphaNumericPostCodeException(postCode); };

		boolean tooLong = isTooLong(postCode);
		
		if (tooLong) { throw new CaTooLongPostCodeException(postCode); };

		boolean tooShort =  isTooShort(postCode);
		
		if (tooShort) { throw new CaTooShortPostCodeException(postCode); };

		boolean unused = unused(postCode);
		
		if (unused) { throw new CaUnusedPostCodeException(postCode); };

		boolean correct = (fsaValid(postCode) && lduValid(postCode) && isAlaphaNumeric);

		valid = (!tooLong && !tooShort && !unused && correct);

		return valid;
	}

}