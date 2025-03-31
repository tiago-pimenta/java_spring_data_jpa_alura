package br.com.tiagopimenta.spring.data;

import java.util.Scanner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import br.com.tiagopimenta.spring.data.orm.Cargo;
import br.com.tiagopimenta.spring.data.repository.CargoRepository;
import br.com.tiagopimenta.spring.data.service.CrudCargoService;
import br.com.tiagopimenta.spring.data.service.CrudFuncionarioService;
import br.com.tiagopimenta.spring.data.service.CrudUnidadeTrabalhoService;
import br.com.tiagopimenta.spring.data.service.RelatorioFuncionarioDinamico;
import br.com.tiagopimenta.spring.data.service.RelatoriosService;
import br.com.tiagopimenta.spring.data.service.CrudCargoService;

@EnableJpaRepositories
@SpringBootApplication
public class SpringDataApplication implements CommandLineRunner {

	//private final CargoRepository repository;
	private final CrudCargoService cargoService;
	private final CrudFuncionarioService funcionarioService;
	private final CrudUnidadeTrabalhoService unidadeTrabalhoService;
	private final RelatoriosService relatorioService;
	private final RelatorioFuncionarioDinamico relatorioFuncionarioDinamico;
	
	private Boolean system = true;
	
//	public SpringDataApplication(CargoRepository repository) {
//		
//		this.repository = repository;
//		
//	}
	
	public SpringDataApplication(CrudCargoService cargoService,
								 CrudFuncionarioService funcionarioService,
								 CrudUnidadeTrabalhoService unidadeTrabalhoService,
								 RelatoriosService relatorioService,
								 RelatorioFuncionarioDinamico relatorioFuncionarioDinamico) {
		
		this.cargoService = cargoService;
		this.funcionarioService = funcionarioService;
		this.unidadeTrabalhoService = unidadeTrabalhoService;
		this.relatorioService = relatorioService;
		this.relatorioFuncionarioDinamico = relatorioFuncionarioDinamico;
		
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
			System.out.println("2 - Funcionario");
			System.out.println("3 - Unidade");
			System.out.println("4 - Relatorios");
			System.out.println("5 - Relatorios Dinamico");
			
			int action = scanner.nextInt();
			
//			if (action == 1) {
//				
//				cargoService.inicial(scanner);
//				
//			} else {
//				
//				system = false;
//				
//			}
			
			switch (action) {
			
			case 1: {
				
				cargoService.inicial(scanner);
				break;
			}
			
			case 2: {
				
				funcionarioService.inicial(scanner);
				break;
			}
			
			case 3: {
				
				unidadeTrabalhoService.inicial(scanner);
				break;
			}
			
			case 4: {
				
				relatorioService.inicial(scanner);
				break;
			}
			
			case 5: {
				
				relatorioFuncionarioDinamico.inicial(scanner);
				break;
			}
			
			default:
				System.out.println("Finalizando");
				system = false;
				break;
			}
			
		}
		
//		Cargo cargo = new Cargo();
//		cargo.setDescricao("Desenvolvedor de Software");
//		
//		repository.save(cargo);
		
	}

}
