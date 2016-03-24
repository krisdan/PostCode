package co.uk.krisdan.postcode.gui;

//import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import co.uk.krisdan.postcode.PostCode;
import co.uk.krisdan.postcode.PostCodeAPI;
import co.uk.krisdan.postcode.PostCodeAPIInterface;

public class CheckPostCodeFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3665468904441707850L;
	private JPanel displayPanel;
	private JTextField textfield;
	private JLabel output;
	private JComboBox<String> countries;
	private JButton submit;
	
	
	public CheckPostCodeFrame() {
		
		setSize(350, 150);
		setTitle("Check Post Code");
		
		Container c = this.getContentPane();
		
		displayPanel = new JPanel();
		
		textfield = new JTextField(12);
		
		displayPanel.add(textfield, "East");
		
		countries = new JComboBox<String>();
        
        countries.addItem("Canada");
        countries.addItem("France");
        countries.addItem("United Kingdom");
        countries.addItem("United States of America");
        countries.setSelectedItem("United Kingdom");
		
		displayPanel.add(countries, "West");
		
		output = new JLabel();
		
		displayPanel.add(output, "Center");
		
		submit = new JButton("CHECK");
		
		submit.addActionListener(new CheckPostCodeActionListener());
		
		textfield.addActionListener(new CheckPostCodeActionListener());
		
		displayPanel.add(submit, "South");
		
		c.add(displayPanel);
	}
	
	private class CheckPostCodeActionListener implements ActionListener {
		
		PostCode postCodeObj;
		
		String message;

		@Override
		public void actionPerformed(ActionEvent e) {
			
			PostCodeAPI postCodeAPI = PostCodeAPIInterface.getPostCodeAPI();
			
			String countryType = "";
			boolean isValid = false;
			boolean isEmpty = true;
			
			switch (countries.getSelectedItem().toString().toLowerCase()) {
			
				case "canada" : countryType = "Canadian";
								isValid = postCodeAPI.isCanadianPostCode(textfield.getText());
								isEmpty = (textfield.getText().isEmpty()) ? true : false;
				break;
				
				case "france" : countryType = "French";
								isValid = postCodeAPI.isFrenchPostCode(textfield.getText());
								isEmpty = (textfield.getText().isEmpty()) ? true : false;
				break;
				
				case "united kingdom" : countryType = "UK";
										isValid = postCodeAPI.isUkPostCode(textfield.getText());
										isEmpty = (textfield.getText().isEmpty()) ? true : false;
				break;
				
				case "united states of america" : 	countryType = "USA";
													isValid = postCodeAPI.isUsaPostCode(textfield.getText());
													isEmpty = (textfield.getText().isEmpty()) ? true : false;
				break;
				
				default: 	countryType = "none";
							isValid = false;
							isEmpty = true;
				break;
			}
			
			String message = createMessage(isEmpty, isValid, countryType);
			
			PostCode postCodeObj = createPostCodeObj(isEmpty, isValid);
			
			this.setMessage(message);
			
			this.setPostCodeObj(postCodeObj);
			
			output.setText(this.getMessage());
			
			textfield.setText("");
			
			countries.setSelectedItem("United kingdom");
			
			this.setMessage("");
		}
		
		private boolean setPostCodeObj(PostCode p) {
			
			boolean success = false;
			
			this.postCodeObj = p;
			
			if(this.getPostCodeObj() != null) {
				success = true;
			}
			return success;
		}
		
		public PostCode getPostCodeObj() {
			
			return this.postCodeObj;
		}

		private boolean setMessage(String message) {
			
			boolean success = false;
			
			this.message = message;
			
			if(this.getMessage() != "") {
				success = true;
			}
			return success;
		}
		
		public String getMessage() {
			
			return this.message;
		}
		
		public String createMessage(boolean isEmpty, boolean isValid, String countryType) {
			
			String message = "";
			
			if (isEmpty) {
				message = "Sorry you must enter a post code! Please try again.";
			}
			
			if (!isEmpty && !isValid) {
				message = "'" + textfield.getText().toUpperCase() + "' is not a valid " + countryType + " post code.";
			}
			
			if (!isEmpty && isValid) {
				message = "'" + textfield.getText().toUpperCase() + "' is a valid " + countryType + " post code.";
			}
			
			return message;
		}
		
		public PostCode createPostCodeObj(boolean isEmpty, boolean isValid) {
			
			PostCode postCodeObj = null;
			
			if (!isEmpty && isValid) {
				
				switch (countries.getSelectedItem().toString().toLowerCase()) {
					case "canada" : postCodeObj = this.createCanadianPostCode(textfield.getText());
					break;
					
					case "france" : postCodeObj = this.createFrenchPostCode(textfield.getText());
					break;
					
					case "united kingdom" : postCodeObj = this.createUkPostCode(textfield.getText());
					break;
					
					case "united states of america" : postCodeObj =	this.createUsaPostCode(textfield.getText());
					break;
					
					default: postCodeObj = null;
					break;
				}
			}
			
			return postCodeObj;
		}
		
		public PostCode createCanadianPostCode(String postCode) {
			
			PostCodeAPI postCodeAPI = PostCodeAPIInterface.getPostCodeAPI();
			
			return postCodeAPI.getCanadianPostCodeObject(postCode);
		}
		
		public PostCode createFrenchPostCode(String postCode) {
			
			PostCodeAPI postCodeAPI = PostCodeAPIInterface.getPostCodeAPI();
			
			return postCodeAPI.getFrenchPostCodeObject(postCode);
		}
		
		public PostCode createUkPostCode(String postCode) {
			
			PostCodeAPI postCodeAPI = PostCodeAPIInterface.getPostCodeAPI();
			
			return postCodeAPI.getUkPostCodeObject(postCode);
		}
		
		public PostCode createUsaPostCode(String postCode) {
			
			PostCodeAPI postCodeAPI = PostCodeAPIInterface.getPostCodeAPI();
			
			return postCodeAPI.getUsaPostCodeObject(postCode);
		}
		
	}
}
