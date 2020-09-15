package guru.springframework.petclinic.model;

import java.util.Set;

public class Vet extends Person {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4510798593311391277L;

	private Set<Specialty> specialties;

	public Set<Specialty> getSpecialties() {
		return specialties;
	}

	public void setSpecialties(Set<Specialty> specialties) {
		this.specialties = specialties;
	}
	
}
