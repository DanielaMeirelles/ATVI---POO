package unidade;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import io.Entrada;
import modelo.CPF;
import modelo.Cliente;
import modelo.RG;
import modelo.Telefone;

public class CadastroCliente extends Cadastro {
	private List<Cliente> clientes;
	private Entrada entrada;

	public CadastroCliente(List<Cliente> clientes) {
		this.clientes = clientes;
	}

	@Override
	public void cadastrar() {
		while(true) {
			entrada = new Entrada();
			System.out.println("In�cio do cadastro do cliente\n");
			
		
			System.out.println("Por favor informe o nome do cliente:");
			String nome = entrada.receberTexto();
			
			
			System.out.println("Por favor informe o nome social do cliente:");
			String nomeSocial = entrada.receberTexto();
			
	
			System.out.println("Por favor informe o g�nero do cliente (M ou F):");
			String genero = entrada.receberTexto();
			
		
			System.out.println("Por favor informe o n�mero do cpf:");
			String valor = entrada.receberTexto();
			
			System.out.println("Por favor informe a data de emiss�o do cpf, no padr�o dd/mm/yyyy:");
			String data = entrada.receberTexto();
			DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			LocalDate dataEmissao = LocalDate.parse(data, formato);
			
			CPF cpf = new CPF(dataEmissao, valor);
			
		
			List<RG> rgs = getRg();
			
		
			List<Telefone> tels = getTel();
			
			
			Cliente cliente = new Cliente(nome, nomeSocial, genero, cpf, rgs, tels);
			this.clientes.add(cliente);
			
			
		
			
			
			System.out.println("\nQuer cadastrar mais um cliente?");
			System.out.println("1 - Sim");
			System.out.println("0 - N�o");
			
			int maisUm = entrada.receberNumeroInteiro();
			if(maisUm == 1)
				System.out.println("--------------------------------------");
			
			else break;
		}
	}
	
	private List<RG> getRg(){
		int cadastrarRg;
		System.out.println("Quer cadastrar um RG?");
		System.out.println("1 - Sim");
		System.out.println("0 - N�o");
		
		cadastrarRg = entrada.receberNumeroInteiro();
		List<RG> rgs = new ArrayList<RG>();
		if(cadastrarRg == 1) {
			Entrada addRg = new Entrada();
			while(cadastrarRg == 1) {
				
				System.out.println("Por favor informe o n�mero do rg:");
				String valor = addRg.receberTexto();
				
				System.out.println("Por favor informe a data de emiss�o do rg, no padr�o dd/mm/yyyy:");
				String data = addRg.receberTexto();
				DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
				LocalDate dataEmissao = LocalDate.parse(data, formato);
				
				
				RG rg = new RG(dataEmissao, valor);
				rgs.add(rg);
				
				System.out.println("Quer cadastrar mais um RG?");
				System.out.println("1 - Sim");
				System.out.println("0 - N�o");
				
				cadastrarRg = entrada.receberNumeroInteiro();
				if(cadastrarRg == 1)
					System.out.println("\n");
			}
		}
		
		return rgs;
	}
	
	private List<Telefone> getTel(){
		int cadastrarTel;
		System.out.println("Quer cadastrar um telefone?");
		System.out.println("1 - Sim");
		System.out.println("0 - N�o");
		
		cadastrarTel = entrada.receberNumeroInteiro();
		List<Telefone> tels = new ArrayList<Telefone>();
		if(cadastrarTel == 1) {
			Entrada addTel = new Entrada();
			while(cadastrarTel == 1) {
				System.out.println("Por favor informe o n�mero do ddd:");
				String ddd = addTel.receberTexto();
				
				System.out.println("Por favor informe o n�mero de telefone:");
				String valorTel = addTel.receberTexto();
				
				Telefone tel = new Telefone(ddd, valorTel);
				tels.add(tel);
				
				System.out.println("Quer cadastrar mais um telefone?");
				System.out.println("1 - Sim");
				System.out.println("0 - N�o");
				
				cadastrarTel = entrada.receberNumeroInteiro();
				if(cadastrarTel == 1)
					System.out.println("\n");
			}
		}
		
		return tels;
	}
}
