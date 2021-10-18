package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class DesafioAtualizarRegistro {

	public static void main(String[] args) throws SQLException {

		Scanner entrada = new Scanner(System.in);
		
		System.out.print("Insira o código >>>>>>");
		int codigo = entrada.nextInt();
		
		Connection conexao = FabricaConexao.getConexao();
		
		String selectSQL = "SELECT codigo,nome FROM pessoas WHERE codigo = ?";
		String updateSQL = "UPDATE pessoas SET nome = ? WHERE codigo = ?";
		PreparedStatement stmt = conexao.prepareStatement(selectSQL);
		stmt.setInt(1, codigo);
		stmt.execute();
		
		ResultSet r = stmt.executeQuery();
		
		if (r.next()) {
			Pessoa p = new Pessoa(r.getInt(1), r.getString(2)); 
			
			System.out.println("O nome atual é " + p.getNome());
			entrada.nextLine();
			
			System.out.print("Insira o novo nome >>>");
			String newNome = entrada.nextLine();
			
			stmt.close();
			stmt = conexao.prepareStatement(updateSQL);
			stmt.setString(1, newNome);
			stmt.setInt(2, codigo);
			stmt.execute();
			
			System.out.println("Pessoa alterada com sucesso!");
		}else {
			System.out.println("Pessoa não encontrada...");
		}
		
		conexao.close();
		entrada.close();
	}

}
