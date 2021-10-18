package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TesteConexao {

	public static void main(String[] args) throws SQLException {
		
		// representa o local que acessa o banco de dados
		// mysql � o driver que vou acessar
		// como estou usando a porta padr�o 3306 n�o � necess�rio 
		// especificala ap�s descrever o local do servidor
		// fazendo isso ele n�o vai verificar se o servidor � verificado 
		// e vai usar uma conex�o segura entre a aplica��o e o SQL
		// ?verifyServerCertificate=false&useSSL=true
		final String url = "jdbc:mysql://localhost?verifyServerCertificate=false&useSSL=true"; 
		// pode ser usado s� assim tbm final String url = "jdbc:mysql://localhost"; 
		final String usuario = "root";
		final String senha = "0000";
		
		Connection conexao = DriverManager.getConnection(url, usuario, senha);
		
		System.out.println("Conex�o efetuada com sucesso!");
		conexao.close();
	}
}
