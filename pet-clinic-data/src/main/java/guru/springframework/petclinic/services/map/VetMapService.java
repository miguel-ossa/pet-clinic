package guru.springframework.petclinic.services.map;

import java.util.Set;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import guru.springframework.petclinic.model.Specialty;
import guru.springframework.petclinic.model.Vet;
import guru.springframework.petclinic.services.SpecialtyService;
import guru.springframework.petclinic.services.VetService;

@Service
@Profile({"default", "map"})
public class VetMapService extends AbstractMapService<Vet, Long> implements VetService {

	private SpecialtyService specialtyService;
	
	@Override
	public Vet save(Vet object) {
		if (object.getSpecialties().size() > 0) {
			object.getSpecialties().forEach(specialty -> {
				if (specialty.getId() == null) {
					Specialty specialtySaved = specialtyService.save(specialty);
					specialty.setId(specialtySaved.getId());
				}
			});
		}
		return super.save(object);
	}

	@Override
	public Set<Vet> findAll() {
		return super.findAll();
	}

	@Override
	public Vet findById(Long id) {
		return super.findById(id);
	}

	@Override
	public void deleteById(Long id) {
		super.deleteById(id);
	}

	@Override
	public void delete(Vet object) {
		super.delete(object);
	}

	@Override
	public int getCount() {
		return super.getCount();
	}

}
