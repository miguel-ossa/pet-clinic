package guru.springframework.petclinic.services.springdatajpa;

import java.util.HashSet;
import java.util.Set;

import guru.springframework.petclinic.model.Pet;
import guru.springframework.petclinic.repositories.PetRepository;
import guru.springframework.petclinic.services.PetService;

public class PetSDJpaService implements PetService {

	private final PetRepository petRepository;

	public PetSDJpaService(PetRepository petRepository) {
		super();
		this.petRepository = petRepository;
	}

	@Override
	public Set<Pet> findAll() {

		Set<Pet> pets = new HashSet<>();

		petRepository.findAll().forEach(pets::add);

		return pets;
	}

	@Override
	public Pet findById(Long id) {
		return petRepository.findById(id).orElse(null);
	}

	@Override
	public Pet save(Pet object) {
		return petRepository.save(object);
	}

	@Override
	public void delete(Pet object) {
		petRepository.delete(object);
	}

	@Override
	public void deleteById(Long id) {
		petRepository.deleteById(id);
	}

	@Override
	public int getCount() {
		return (int)petRepository.count();
	}

}
