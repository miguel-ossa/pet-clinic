package guru.springframework.petclinic.model;

public class PetType extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7458773405372253161L;
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
