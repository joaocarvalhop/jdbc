package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class ExcluirPessoa {

	public static void main(String[] args) throws SQLException {
		
		Scanner entrada = new Scanner(System.in);
		Connection conexao = FabricaConexao.getConexao();
		String deleteSQL = "DELETE FROM pessoas WHERE codigo = ?";
		
		System.out.print("Informe o c�digo a ser exclu�do --->");
		int cod = entrada.nextInt();
		
		PreparedStatement stmt = conexao.prepareStatement(deleteSQL);
		stmt.setInt(1, cod);
		
		int contador = stmt.executeUpdate();
		
		// esse m�todo retorna a quantidade de linhas afetadas
		if (contador > 0) {
			System.out.println("Pessoa exclu�da com sucesso.");
		}else {
			System.out.println("Nada � feito...");
		}

		System.out.println("Linhas afetadas: " + contador);
		
		conexao.close();
		entrada.close();
	}
}
