package br.com.agenda.aplicacao;

import java.util.Date;

import br.com.agenda.DAO.ContatoDAO;
import br.com.agenda.model.Contato;

public class Main {

	public static void main(String[] args) {
		
		ContatoDAO contatoDao = new ContatoDAO();
		
//		Contato contato = new Contato();
//		contato.setNome("Monica da Silva");
//		contato.setIdade(19);
//		contato.setDataCadastro(new Date());
//		
//		contatoDao.save(contato);

//===================================
//              Fim SAVE
//===================================
		
//	Visualizando todos os registros
		
//		for(Contato c : contatoDao.getContatos())		{
//			System.out.println("Contato pesquisado: " + c.getNome());
//		}

//===================================
//           Fim SELECT ALL
//===================================			
		
// Visualizando os registros por ID
		
//		int x = 3;
//				
//		for(Contato c: contatoDao.getContatosByID(x)) {
//				System.out.println("Contato pesquisado por Id: " + c.getNome());
//		}

//===================================
//         Fim SELECT BY ID
//===================================	
		
// Realizando UPDATE de dados no banco de dados
		
//		Contato contato = new Contato();
//		contato.setNome("Yan Falcão");
//		contato.setIdade(30);
//		contato.setDataCadastro(new Date());
//		
//		// É o número que está no banco de dados
//		contato.setId(1);
//		
//		contatoDao.update(contato);
//		
//		for(Contato c : contatoDao.getContatos()){
//		System.out.println("Contato pesquisado: " + c.getNome());
//		}
		
//===================================
//            Fim UPDATE
//===================================
		
// Realizando DELETE de dados no banco de dados
		
		Contato contato = new Contato();
		contato.setId(5);
		
		//Chamando classe "ContatoDAO", e enviando o valor do ID por meio do objeto "contato" para executar método.
		contatoDao.delete(contato);

//===================================
//           Fim DELETE
//===================================		
		
		
	}
}
