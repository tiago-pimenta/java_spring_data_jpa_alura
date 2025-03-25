package br.com.tiagopimenta.spring.data;

import java.util.Scanner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.tiagopimenta.spring.data.orm.Cargo;
import br.com.tiagopimenta.spring.data.repository.CargoRepository;
import br.com.tiagopimenta.spring.data.service.CrudCargoService;
import br.com.tiagopimenta.spring.data.service.CrudCargoService;

@SpringBootApplication
public class SpringDataApplication implements CommandLineRunner {

	//private final CargoRepository repository;
	private final CrudCargoService cargoService;
	
	private Boolean system = true;
	
//	public SpringDataApplication(CargoRepository repository) {
//		
//		this.repository = repository;
//		
//	}
	
	public SpringDataApplication(CrudCargoService cargoService) {
		
		this.cargoService = cargoService;
		
	}
	
	public static void main(String[] args) {
		SpringApplication.run(SpringDataApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
				
		Scanner scanner = new Scanner(System.in);
		
		while(system) {
			System.out.println("Qual ação que você quer executar ?");
			System.out.println("0 - Sair");
			System.out.println("1 - Cargo");
			
			int action = scanner.nextInt();
			
			if (action == 1) {
				
				cargoService.inicial(scanner);
				
			} else {
				
				system = false;
				
			}
		}
		
//		Cargo cargo = new Cargo();
//		cargo.setDescricao("Desenvolvedor de Software");
//		
//		repository.save(cargo);
		
	}

}
