package guru.springframework.petclinic.services.springdatajpa;

import java.util.HashSet;
import java.util.Set;

import guru.springframework.petclinic.model.PetType;
import guru.springframework.petclinic.repositories.PetTypeRepository;
import guru.springframework.petclinic.services.PetTypeService;

public class PetTypeSDJpaService implements PetTypeService {

	private final PetTypeRepository petTypeRepository;


	public PetTypeSDJpaService(PetTypeRepository petTypeRepository) {
		super();
		this.petTypeRepository = petTypeRepository;
	}

	@Override
	public Set<PetType> findAll() {
		
		Set<PetType> petTypes = new HashSet<>();
		
		petTypeRepository.findAll().forEach(petTypes::add);
		
		return petTypes;
	}

	@Override
	public PetType findById(Long id) {
		return petTypeRepository.findById(id).orElse(null);	}

	@Override
	public PetType save(PetType object) {
		return petTypeRepository.save(object);
	}

	@Override
	public void delete(PetType object) {
		petTypeRepository.delete(object);
	}

	@Override
	public void deleteById(Long id) {
		petTypeRepository.deleteById(id);
	}

	@Override
	public int getCount() {
		return (int)petTypeRepository.count();
	}

}