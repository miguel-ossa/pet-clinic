package guru.springframework.petclinic.repositories;

import org.springframework.data.repository.CrudRepository;

import guru.springframework.petclinic.model.Specialty;

public interface SpecialtyRepository extends CrudRepository<Specialty, Long>{

}
