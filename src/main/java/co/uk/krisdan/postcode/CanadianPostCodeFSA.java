package co.uk.krisdan.postcode;

public class CanadianPostCodeFSA implements Comparable<CanadianPostCodeFSA>, PostCodeElement {

	private String code;
	
	private String description;

	protected CanadianPostCodeFSA(String code, String description) {
		
		this.setCode(code);
		
		this.setDescription(description);
	}
	
	/* (non-Javadoc)
	 * @see co.uk.krisdan.postcode.PostCodeElement#getCode()
	 */
	@Override
	public String getCode() {
		return code;
	}

	private void setCode(String code) {
		this.code = code;
	}

	/* (non-Javadoc)
	 * @see co.uk.krisdan.postcode.PostCodeElement#getDescription()
	 */
	@Override
	public String getDescription() {
		return description;
	}

	private void setDescription(String description) {
		this.description = description;
	}
	
	public int compareTo(CanadianPostCodeFSA fsa) {
		
		PostCodeElement canadianPostCodeFSA = (PostCodeElement) fsa;
		
		return this.getCode().compareTo(canadianPostCodeFSA.getCode());
	}
	
	public String toString() {
		
		StringBuilder out = new StringBuilder();
		
		out.append("\r");
		out.append("---------------------------");
		out.append("\r");
		out.append("FSA:");
		out.append("\r");
		out.append("code: " + this.getCode() + " ");
		out.append("description: " + this.getDescription());
		out.append("\r");
		out.append("---------------------------");
		out.append("\r");
		
		return out.toString();
	}
}
