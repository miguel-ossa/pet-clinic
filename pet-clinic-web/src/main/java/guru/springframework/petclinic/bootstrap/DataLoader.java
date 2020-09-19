package guru.springframework.petclinic.bootstrap;

import java.time.LocalDate;
import java.util.Set;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import guru.springframework.petclinic.model.Owner;
import guru.springframework.petclinic.model.Pet;
import guru.springframework.petclinic.model.PetType;
import guru.springframework.petclinic.model.Specialty;
import guru.springframework.petclinic.model.Vet;
import guru.springframework.petclinic.model.Visit;
import guru.springframework.petclinic.services.OwnerService;
import guru.springframework.petclinic.services.PetTypeService;
import guru.springframework.petclinic.services.SpecialtyService;
import guru.springframework.petclinic.services.VetService;
import guru.springframework.petclinic.services.VisitService;

@Component
public class DataLoader implements CommandLineRunner {

	private final OwnerService ownerService;
	private final VetService vetService;
	private final PetTypeService petTypeService;
	private final SpecialtyService specialtyService;
	private final VisitService visitService;

	public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService,
			SpecialtyService specialtyService, VisitService visitService) {
		super();
		this.ownerService = ownerService;
		this.vetService = vetService;
		this.petTypeService = petTypeService;
		this.specialtyService = specialtyService;
		this.visitService = visitService;
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Running DataLoader...");

		int count = petTypeService.findAll().size();

		if (count == 0) {
			loadData();
		}

		System.out.println("Ending DataLoader...");
	}

	private void loadData() {

		PetType dog = new PetType();
		dog.setName("Dog");
		PetType savedDogPetType = petTypeService.save(dog);

		PetType cat = new PetType();
		cat.setName("Cat");
		PetType savedCatPetType = petTypeService.save(cat);

		Specialty radiology = new Specialty();
		radiology.setDescription("Radiology");
		Specialty savedRadiology = specialtyService.save(radiology);

		Specialty surgery = new Specialty();
		surgery.setDescription("Surgery");
		Specialty savedSurgery = specialtyService.save(surgery);

		Specialty dentistry = new Specialty();
		dentistry.setDescription("Dentistry");
		Specialty savedDentistry = specialtyService.save(dentistry);

		Owner owner1 = new Owner();
		owner1.setFirstName("Peter");
		owner1.setLastName("Parker");
		owner1.setAddress("123 Brick");
		owner1.setCity("California");
		owner1.setTelephone("555 55 55");

		Pet peterPet = new Pet();
		peterPet.setPetType(savedDogPetType);
		peterPet.setOwner(owner1);
		peterPet.setName("Dick");
		peterPet.setBirthDate(LocalDate.now());

		owner1.getPets().add(peterPet);

		ownerService.save(owner1);

		Owner owner2 = new Owner();
		owner2.setFirstName("Michael");
		owner2.setLastName("Flynn");
		owner2.setAddress("54 Picadilly");
		owner2.setCity("Texas");
		owner2.setTelephone("555 55 51");

		Pet michaelPet = new Pet();
		michaelPet.setPetType(savedCatPetType);
		michaelPet.setOwner(owner1);
		michaelPet.setName("Mosqui");
		michaelPet.setBirthDate(LocalDate.now());

		owner2.getPets().add(michaelPet);

		ownerService.save(owner2);

		Visit catVisit = new Visit();
		catVisit.setPet(michaelPet);
		catVisit.setDate(LocalDate.now());
		catVisit.setDescription("Sneezy kitty");

		visitService.save(catVisit);

		Vet vet1 = new Vet();
		vet1.setFirstName("Clark");
		vet1.setLastName("Kent");
		vet1.getSpecialties().add(savedRadiology);

		vetService.save(vet1);

		Vet vet2 = new Vet();
		vet2.setFirstName("Claudia");
		vet2.setLastName("O'Flynn");
		vet2.getSpecialties().add(savedSurgery);

		vetService.save(vet2);

		System.out.println("Number of owners: " + ownerService.getCount());


		// TODO pendiente de resolver orden de los println con Data JPA
		ownerService.findAll().forEach(owner -> {
			owner.getPets().forEach(pet -> {
				System.out.println("The owner " + owner.getFirstName() + " has a " + pet.getPetType().getName() + " named '" + pet.getName() + "'");
			});
		});
		System.out.println("Number of vets: " + vetService.getCount());
	}

}
