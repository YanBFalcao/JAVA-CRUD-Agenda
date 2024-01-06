package br.com.agenda.factory;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {

	//NOME DO USUÁRIO DO MYSQL
	private static final String USERNAME = "root";
	
	//SENHA DO USUÁRIO DO MYSQL
	private static final String PASSWORD = "";
	
	//CAMINHO DO BANCO DE DADOS, PORTA, NOME DO BANCO DE DADOS
	private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/agenda";
	
	/*
	 Conexão com o Banco de Dados
	*/
	
	public static Connection createConnectionToMySQL() throws Exception{
		// Faz com que a classe seja carregada pela JVM (JAVA VIRTUAL MACHINE)
		Class.forName("com.mysql.jdbc.Driver");
		
		// Cria a conexão com o Banco de Dados
		Connection connection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
		
	    return connection;
	}
	
	public static void main(String[] args) throws Exception {
		
		// Recuperar uma conexão com o banco de dados
		Connection con = createConnectionToMySQL();
		
		// Testar se a conexão é nula
		if(con != null)		{
			System.out.println("Conexão obtida com sucesso!");
			con.close();
		}
		
	}
	
	
	
	
	
	
	
	
	
}
