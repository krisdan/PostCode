package co.uk.krisdan.postcode;

import java.io.IOException;

import javax.swing.WindowConstants;

import co.uk.krisdan.postcode.gui.CheckPostCodeFrame;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException
    {
    	CheckPostCodeFrame checkPostCode = new CheckPostCodeFrame();
        
        checkPostCode.setVisible(true);
        
        checkPostCode.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		
    }
}
