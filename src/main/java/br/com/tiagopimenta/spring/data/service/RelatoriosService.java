package br.com.tiagopimenta.spring.data.service;

import java.util.List;
import java.util.Scanner;

import org.springframework.stereotype.Service;

import br.com.tiagopimenta.spring.data.orm.Funcionario;
import br.com.tiagopimenta.spring.data.repository.FuncionarioRepository;

@Service
public class RelatoriosService {
	
	private Boolean system = true;
	
	private final FuncionarioRepository funcionarioRepository;
	
	public RelatoriosService (FuncionarioRepository funcionarioRepository) {
		
		this.funcionarioRepository = funcionarioRepository;
		
	}
	
	public void inicial(Scanner scanner) {
		
		while(system) {
			System.out.println("Qual ação de cargo que você quer executar ?");
			System.out.println("0 - Sair");
			System.out.println("1 - Busca Funcionario Nome");
			
			int action = scanner.nextInt();
			
			switch (action) {
			
			case 1: {
				
				buscaFuncionarioNome(scanner);
				break;
			}
			
			default:
				system = false;
				break;
			}
			
		}
		
	}
	
	private void buscaFuncionarioNome(Scanner scanner) {
		
		System.out.println("Qual nome deseja pesquisar");
		
		String nome = scanner.next();
		
		List<Funcionario> list = funcionarioRepository.findByNome(nome);
		
		list.forEach(System.out::println);
		
	}
	
}
