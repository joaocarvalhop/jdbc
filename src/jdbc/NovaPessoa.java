package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class NovaPessoa {

	public static void main(String[] args) throws SQLException {
		
		Scanner entrada = new Scanner(System.in);

		System.out.print("Informe o nome: ");
		String nome = entrada.next();
		
		Connection conexao = FabricaConexao.getConexao();
		
		String sql = "INSERT INTO pessoas (nome) VALUES (?)";
		
		// usando o preparedstatement ele vai considerar o 
		// nome como uma string em vez de um comando SQL
		// deixando assim a aplicação mais segura
		PreparedStatement stmt = conexao.prepareStatement(sql);
		// o nmr 1 significa o ? da String sql
		// caso eu queria inserir outro dado de outra 
		// coluna é só colocar o dois e um novo ? após a ,
		stmt.setString(1, nome);
		
		stmt.execute();
		
		System.out.println("Pessoa adicionada com sucesso!");
		entrada.close();
	}
}
