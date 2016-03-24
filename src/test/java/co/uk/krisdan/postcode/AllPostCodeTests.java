package co.uk.krisdan.postcode;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ CanadianPostCodeTest.class,
		CanadianPostCodeValidatorTest.class, FrenchPostCodeTest.class,
		FrenchPostCodeValidatorTest.class, PostCodeFormatTest.class, PostCodeValidatorTest.class,
		UkPostCodeTest.class, UkPostCodeValidatorTest.class,
		UsaPostCodeTest.class, UsaPostCodeValidatorTest.class })
public class AllPostCodeTests {

}