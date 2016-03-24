package co.uk.krisdan.postcode.validators;

import java.util.ArrayList;

public class PostCodeValidator {
	
	private PostCodeValidator() {
		
	}
	
	/** - Static Method
	 * 
	 * Receives a String of any length and tests to see if all of its characters are numeric.
	 * 
	 * If all characters are numeric returns true otherwise it returns false.
	 * 
	 * @param str String
	 * @return boolean
	 */
	public static boolean isNumeric(String str) {
		
		boolean isNumeric = false;
		
		String strStripped = str.replaceAll("\\s+", "").replaceAll("[-]+", "");

		if (strStripped.matches("^(?=.*\\d)[0-9]{1,10}$")) {
			isNumeric = true;
		}

		return isNumeric;
	}
	
	/** - Static Method
	 * 
	 * Receives a String of any length and tests to see if all of its characters are letters.
	 * 
	 * If all characters are letters returns true otherwise it returns false.
	 * 
	 * @param str String
	 * @return boolean
	 */
	public static boolean isAlpha(String str) {
		
		boolean isAlpha = false;
		
		String strNoSpaces = str.replaceAll("\\s+","");
		
		if (strNoSpaces.matches("^(?=.*[A-Za-z])[A-Za-z]{1,10}$")) {
			isAlpha = true;
		}
		
		return isAlpha;
	}
	
	/** - Static Method
	 * 
	 * Receives a String of any length and tests to see if all of its characters are a combination numbers and letters. .
	 * 
	 * If the characters are a combination of numbers and letters returns true otherwise it returns false.
	 * 
	 * @param str String
	 * @return boolean
	 */
	public static boolean isAlphaNumeric(String str) {
		
		boolean isAlphaNumeric = false;
		
		String strNoSpaces = str.replaceAll("\\s+","");
		
		if (strNoSpaces.matches("^(?=.*\\d)(?=.*[A-Za-z])[A-Za-z0-9]{1,10}$")) {
			isAlphaNumeric = true;
		}

		return isAlphaNumeric;
	}
	
	/** - Static Method
	 * 
	 * returns a list of forbidden characters as an ArreyList <Character>.
	 * 
	 * @return char
	 */
	public static ArrayList<Character> getForbidenCharsArray() {
		
		ArrayList<Character> forbidenChars = new ArrayList<Character>();
		
		forbidenChars.add('\u002d'); // -
		forbidenChars.add('\u0020'); // Space
		forbidenChars.add('\u0022'); // "
		forbidenChars.add('\u00A3'); // £
		forbidenChars.add('\u0024'); // $
		forbidenChars.add('\u0025'); // %
		forbidenChars.add('\u005E'); // ^
		forbidenChars.add('\u0026'); // &
		forbidenChars.add('\u002A'); // *
		forbidenChars.add('\u0028'); // (
		forbidenChars.add('\u0029'); // )
		forbidenChars.add('\u005F'); // _
		forbidenChars.add('\u0021'); // !
		forbidenChars.add('\u002B'); // +
		forbidenChars.add('\u003D'); // =
		forbidenChars.add('\u007B'); // {
		forbidenChars.add('\u007D'); // }
		forbidenChars.add('\u005B'); // [
		forbidenChars.add('\u005D'); // ]
		forbidenChars.add('\u003A'); // :
		forbidenChars.add('\u003B'); // ;
		forbidenChars.add('\u0040'); // @
		forbidenChars.add('\''); // \
		forbidenChars.add('\u007E'); // ~
		forbidenChars.add('\u0023'); // #
		forbidenChars.add('\u003C'); // <
		forbidenChars.add('\u003E'); // >
		forbidenChars.add('\u002C'); // ,
		forbidenChars.add('\u002E'); // .
		forbidenChars.add('\u003F'); // ?
		forbidenChars.add('\u002F'); // /
		forbidenChars.add('\u002B'); // +
		forbidenChars.add('\u002E'); // .
		
		return forbidenChars;
	}
	
	/** - Static Method
	 * 
	 * Receives a string representation of the name of the country 
	 * and then removes characters from the forbidenChars ArreyList 
	 * that can be used for that country's post code.
	 * 
	 * if the country is the united states remove character indexed as 0 
	 * or if the country is the united kingdom or Canada remove the character indexed as 1.
	 * 
	 * @param country String
	 * @return forbidenChars Character
	 */
	public static ArrayList<Character> getForbidenCharsByCountry(String country) {
		
		ArrayList<Character> forbidenChars = getForbidenCharsArray();
		
		if (country.toLowerCase().equals("united states")) {
			
			forbidenChars.remove(0);
		} 
		
		if (country.toLowerCase().equals("united kingdom") 
				|| country.toLowerCase().equals("canada")) {
			
			forbidenChars.remove(1);
		}
		
		return forbidenChars;
	}
	
	/** - Static Method
	 * 
	 * receives a String and checks to see if it contains forbidden characters.
	 * 
	 * if any of the characters in the String are forbidden then it returns true 
	 * otherwise it returns false.
	 * 
	 * @param postCode String
	 * @param country String
	 * @return boolean
	 */
	public static boolean hasForbidenChars(String postCode, String country) {
		
		boolean hasForbiden = false;
		
		ArrayList<Character> forbidenChars = getForbidenCharsByCountry(country);
		
		for (char postCodeCh : postCode.toCharArray()) {
			
			Character postCodeChObj = new Character(postCodeCh);
			
			for (Character ch : forbidenChars) {
				
				if (ch.equals(postCodeChObj)) {
					hasForbiden = true;
					break;
				}
			}
		}
		
		return hasForbiden;
	}
}