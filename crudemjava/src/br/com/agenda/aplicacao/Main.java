package br.com.agenda.aplicacao;



import java.util.Date;

import br.com.agenda.dao.ContatoDAO;
import br.com.agenda.model.Contato;

public class Main {

	public static void main(String[] args) {
		
		// Cria novo contato CREATE
		//ContatoDAO contatoDAO = new ContatoDAO();
		//Contato contato = new Contato();
		//contato.setNome("Bruna");
		//contato.setIdade(25);
		//contato.setDataCadastro(new Date());

		//contatoDAO.save(contato);
		
		// UPDATE
		ContatoDAO contatoDAO = new ContatoDAO();
		Contato contato = new Contato();
		contato.setNome("Silvia Rocha");
		contato.setIdade(55);
		contato.setDataCadastro(new Date());
		contato.setId(1); // ID do registro que quero atualizar
		contatoDAO.update(contato);
		
		// Lista todos os contatos READ
		for (Contato c: contatoDAO.getContatos()) {
			System.out.println("Contato:"+c.getNome());
		}
	}

}
