package guru.springframework.petclinic.model;

public class Specialty extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 43447860690223168L;

	private String description;

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
}
