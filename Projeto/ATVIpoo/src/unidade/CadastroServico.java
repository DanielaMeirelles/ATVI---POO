package unidade;

import java.util.List;

import io.Entrada;
import modelo.Servico;


public class CadastroServico extends Cadastro {
	private List<Servico> servicos;
	private Entrada entrada;
	
	public CadastroServico(List<Servico> servicos) {
		this.servicos = servicos;
		entrada = new Entrada();
	}
	
	@Override
	public void cadastrar() {
		System.out.println("In�cio do cadastro de servi�o");
		System.out.println("Por favor informe o nome do servi�o:");
		String nome = entrada.receberTexto();
		
		System.out.println("Por favor informe o valor do servi�o:");
		double valor = entrada.receberNumeroDouble();
		
		System.out.println("Por favor informe o id do servi�o:");
		String id = new Entrada().receberTexto();
		
		Servico servico = new Servico(id, nome, valor);
		this.servicos.add(servico);
	}
}
