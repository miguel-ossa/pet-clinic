package guru.springframework.petclinic.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import guru.springframework.petclinic.model.Owner;
import guru.springframework.petclinic.model.Vet;
import guru.springframework.petclinic.services.OwnerService;
import guru.springframework.petclinic.services.VetService;
import guru.springframework.petclinic.services.map.OwnerServiceMap;
import guru.springframework.petclinic.services.map.VetServiceMap;

@Component
public class DataLoader implements CommandLineRunner {

	private final OwnerService ownerService;
	private final VetService vetService;
	
	public DataLoader() {
		this.ownerService = new OwnerServiceMap();
		this.vetService = new VetServiceMap();
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Running DataLoader...");
		
		Owner owner1 = new Owner();
		owner1.setId(1L);
		owner1.setFirstName("Peter");
		owner1.setLastName("Parker");
		
		ownerService.save(owner1);
		
		Owner owner2 = new Owner();
		owner2.setId(2L);
		owner2.setFirstName("Michael");
		owner2.setLastName("Flynn");
		
		ownerService.save(owner2);
		
		Vet vet1 = new Vet();
		vet1.setId(1L);
		vet1.setFirstName("Clark");
		vet1.setLastName("Kent");
		
		vetService.save(vet1);
		
		Vet vet2 = new Vet();
		vet2.setId(2L);
		vet2.setFirstName("Claudia");
		vet2.setLastName("O'Flynn");
		
		vetService.save(vet2);
		
		System.out.println("Ending DataLoader...");
		
	}

}
