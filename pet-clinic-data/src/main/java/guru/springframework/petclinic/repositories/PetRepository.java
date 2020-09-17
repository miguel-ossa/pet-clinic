package guru.springframework.petclinic.repositories;

import org.springframework.data.repository.CrudRepository;

import guru.springframework.petclinic.model.Pet;

public interface PetRepository extends CrudRepository<Pet, Long>{

}
