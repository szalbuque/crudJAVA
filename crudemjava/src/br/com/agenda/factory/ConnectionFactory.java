package br.com.agenda.factory;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {

	// nome do usuário do mysql
	private static final String USERNAME = "root";
	
	// senha do database
	private static final String PASSWORD = "";
	
	// caminho do banco de dados, com a porta e o nome do database
	private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/agenda";
	
	/*
	 * Conexão com o banco de dados
	 */
	public static Connection createConnectionToMySQL() throws Exception {
		//A JVM carrega a classe
		Class.forName("com.mysql.cj.jdbc.Driver");
		//Cria a conexão com o banco de dados
		Connection connection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
		
		return connection;
	}
	
	/*
	 * Verifica se já existe uma conexão, antes de criar uma nova
	 */
	public static void main(String[] args) throws Exception {
		
		//Recupera uma conexão com o banco de dados
		Connection con = createConnectionToMySQL();
		
		//Testa se a conexão foi realizada
		if (con != null) {
			System.out.println("conexão com sucesso");
			con.close();
		}
		
	}
	
	
}
