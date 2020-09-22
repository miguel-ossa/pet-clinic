package guru.springframework.petclinic.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "specialties")
public class Specialty extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 43447860690223168L;

	@Column(name = "description")
	private String description;

}
