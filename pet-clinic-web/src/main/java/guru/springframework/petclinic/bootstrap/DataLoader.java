package guru.springframework.petclinic.bootstrap;

import java.time.LocalDate;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import guru.springframework.petclinic.model.Owner;
import guru.springframework.petclinic.model.Pet;
import guru.springframework.petclinic.model.PetType;
import guru.springframework.petclinic.model.Vet;
import guru.springframework.petclinic.services.OwnerService;
import guru.springframework.petclinic.services.PetTypeService;
import guru.springframework.petclinic.services.VetService;

@Component
public class DataLoader implements CommandLineRunner {

	private final OwnerService ownerService;
	private final VetService vetService;
	private final PetTypeService petTypeService;



	public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
		super();
		this.ownerService = ownerService;
		this.vetService = vetService;
		this.petTypeService = petTypeService;
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Running DataLoader...");
		
		PetType dog = new PetType();
		dog.setName("Dog");
		PetType savedDogPetType = petTypeService.save(dog);
		
		PetType cat = new PetType();
		cat.setName("Cat");
		PetType savedCatPetType = petTypeService.save(cat);
		
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
		
		Vet vet1 = new Vet();
		vet1.setFirstName("Clark");
		vet1.setLastName("Kent");
		
		vetService.save(vet1);
		
		Vet vet2 = new Vet();
		vet2.setFirstName("Claudia");
		vet2.setLastName("O'Flynn");
		
		vetService.save(vet2);
		
		System.out.println("Number of owners: " + ownerService.getCount());
		ownerService.findAll().forEach(owner -> {
			System.out.print("The owner " + owner.getFirstName() + " has the following pets: ");
			owner.getPets().forEach(pet -> {
				System.out.println(pet.getName() +  " and it is a " + pet.getPetType().getName());
			});
		});
		System.out.println("Number of vets: " + vetService.getCount());
		
		System.out.println("Ending DataLoader...");
		
	}

}
