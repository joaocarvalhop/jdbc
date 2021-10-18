package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TesteConexao {

	public static void main(String[] args) throws SQLException {
		
		// representa o local que acessa o banco de dados
		// mysql é o driver que vou acessar
		// como estou usando a porta padrão 3306 não é necessário 
		// especificala após descrever o local do servidor
		// fazendo isso ele não vai verificar se o servidor é verificado 
		// e vai usar uma conexão segura entre a aplicação e o SQL
		// ?verifyServerCertificate=false&useSSL=true
		final String url = "jdbc:mysql://localhost?verifyServerCertificate=false&useSSL=true"; 
		// pode ser usado só assim tbm final String url = "jdbc:mysql://localhost"; 
		final String usuario = "root";
		final String senha = "0000";
		
		Connection conexao = DriverManager.getConnection(url, usuario, senha);
		
		System.out.println("Conexão efetuada com sucesso!");
		conexao.close();
	}
}
