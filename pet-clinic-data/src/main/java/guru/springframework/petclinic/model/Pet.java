package guru.springframework.petclinic.model;

import java.time.LocalDate;
import java.time.Period;

public class Pet extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2220364868046453773L;
	
	private String name;
	private PetType petType;
	private Owner owner;
	private LocalDate birthDate;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public PetType getPetType() {
		return petType;
	}
	public void setPetType(PetType petType) {
		this.petType = petType;
	}
	public Owner getOwner() {
		return owner;
	}
	public void setOwner(Owner owner) {
		this.owner = owner;
	}
	public LocalDate getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}
	public int getAgeInYears() {
		LocalDate currentDate = LocalDate.now();
		Period diff = Period.between(birthDate, currentDate);
	    return diff.getYears(); 
	}
	
}
