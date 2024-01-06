package br.com.agenda.DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.PreparedStatement;
import br.com.agenda.factory.ConnectionFactory;
import br.com.agenda.model.Contato;

public class ContatoDAO {

	public void save (Contato contato) {
		
		//Criando a minha String para receber valores e preparar para inserir valores no banco
		String sql = "INSERT INTO contatos (nome, idade, dataCadastro) VALUES (?,?,?)";
		
		Connection conn = null;
		PreparedStatement psmt = null;
		
		try {
			//Criar uma conexão com o banco de dados
			conn = ConnectionFactory.createConnectionToMySQL();
			
			//Criamos um preparedstatement para executar uma Query
			psmt = (PreparedStatement) conn.prepareStatement(sql);
		
			// Adicionar os valores que são esperados pela Query
			psmt.setString(1, contato.getNome());
			psmt.setInt(2, contato.getIdade());
			psmt.setDate(3, new Date(contato.getDataCadastro().getTime()));
			
			psmt.execute();
			
			System.out.println("Contato salvo com sucesso!");
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			
			//Fechar as conexões
			try {
				if(psmt != null){
					psmt.close();
				}
				if(conn != null) {
					conn.close();
				}	
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
// ===================================
// 		       Fim SAVE
// ===================================
	
    public List<Contato> getContatos(){
		
    	//Criando a minha String para fazer a consulta no banco
    	String sql = "SELECT * FROM contatos";
    	
    	List<Contato> contatos = new ArrayList<Contato>();
    	
    	Connection conn = null;
		PreparedStatement psmt = null;
		
		// Classe que vai recupear dados do banco de dados. *Select
		ResultSet rst = null;
		
		try {
			
			conn = ConnectionFactory.createConnectionToMySQL();
			
			psmt = (PreparedStatement) conn.prepareStatement(sql);
			
			rst = psmt.executeQuery();
			
			// Enquanto eu tiver dados para percorrer, rodar While
			while (rst.next()) {
				Contato contato = new Contato();
				
				//Recuperar o ID
				contato.setId(rst.getInt("id"));
				
				//Recuperar o Nome
				contato.setNome(rst.getString("nome"));
				
				//Recuperar a idade
				contato.setIdade(rst.getInt("idade"));
				
				//Recuperar a data de cadastro
				contato.setDataCadastro(rst.getDate("dataCadastro"));
				
				contatos.add(contato);
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(rst != null) {
					rst.close();
				}
				if(psmt != null) {
					psmt.close();
				}
				if(conn != null) {
					conn.close();
				}
			}
			catch(Exception e){
				e.printStackTrace();
			}
		}
		return contatos;
	}
    
// ===================================
//		    Fim SELECT ALL
//===================================
    
    public List<Contato> getContatosByID(int contatoId){
    	
    	// Abrindo a String para consulta por ID
    	String sql = "SELECT * FROM contatos WHERE id = ?";
    	
    	// Preparando uma lista para retornar os contatos
    	List<Contato> contatos = new ArrayList<Contato>();
    	
    	Connection conn = null;
    	PreparedStatement psmt = null;
    	
    	// Classe que irá recuperar os dados do banco de dados
    	ResultSet rst = null;
    	
    	try {
    		
    		conn = ConnectionFactory.createConnectionToMySQL();
    		
    		psmt = (PreparedStatement) conn.prepareStatement(sql);
    		
    		psmt.setInt(1, contatoId);
    		
    		rst = psmt.executeQuery();
    		
    		while (rst.next()) {
				
    			Contato contato = new Contato();
    			
    			contato.setId(rst.getInt("id"));
    			contato.setNome(rst.getString("Nome"));
    		    contato.setIdade(rst.getInt("idade"));
    			contato.setDataCadastro(rst.getDate("dataCadastro"));
    			
    			contatos.add(contato);
			}
    	}
    	catch(Exception e) {
    		e.printStackTrace();
    	}
    	finally {
			try {				
				if(rst != null) {					
					rst.close();
				}				
				if(psmt != null) {
					psmt.close();
				}
				if(conn != null) {
					conn.close();
				}
			}
			catch(Exception e){
				e.printStackTrace();
			}
		}
		return contatos;
    }
    
// ===================================
//	       Fim SELECT BY ID
//===================================
    
	public void update (Contato contato) {
	
	// Abrindo a String para consulta por ID
	String sql = "UPDATE contatos SET nome = ?, idade = ?, dataCadastro = ?" +
	"WHERE id = ?";
	
	Connection conn = null;
	PreparedStatement psmt = null;
	
	try {
		// Criar conexão com o banco
		conn = ConnectionFactory.createConnectionToMySQL();
		
		// Criar classe para executar Query
		psmt = (PreparedStatement) conn.prepareStatement(sql);
		
		//Adicionar os valores para atualizar
		psmt.setString(1, contato.getNome());
		psmt.setInt(2, contato.getIdade());
		psmt.setDate(3, new Date(contato.getDataCadastro().getTime()));
		
		// Qual o ID do registro que deseja atualizar?
		psmt.setInt(4, contato.getId());
		
		//Executar a Query
		psmt.execute();
		
	}
	catch(Exception e)	{
		e.printStackTrace();
	}
	finally {
		try {				
			if(psmt != null) {
				psmt.close();
			}
			if(conn != null) {
				conn.close();
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
}
   
// ===================================
//            Fim UPDATE
//===================================
    
	public void delete (Contato contato) {
	
	// Abrindo a String para consulta e delete por ID
	String sql = "DELETE FROM contatos WHERE id = ?";

	Connection conn = null;
	PreparedStatement psmt = null;
	
	try {
		
		// Criar conexão com o banco
		conn = ConnectionFactory.createConnectionToMySQL();
		
		// Criar classe para executar Query
		psmt = (PreparedStatement) conn.prepareStatement(sql);
		
		// Receber Id do Main para realizar consulta no BD
		psmt.setInt(1, contato.getId());
		
		// Executar a Query
		psmt.execute();
		
	}
	catch(Exception e){
		e.printStackTrace();
	}
		finally {
			try {						
				if(psmt != null) {
					psmt.close();
				}
				if(conn != null) {
					conn.close();
				}
			}
			catch(Exception e){
				e.printStackTrace();
			}
		}

	} // Final


//===================================
//           Fim DELETE
//===================================
    

    
} // Fim ContatoDAO






