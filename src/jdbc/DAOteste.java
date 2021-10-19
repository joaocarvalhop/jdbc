package jdbc;

public class DAOteste {

	public static void main(String[] args) {

		DAO dao = new DAO();
		
		String sql = "INSERT INTO pessoas (nome) VALUES (?)";
		
		// mostra o c�digo
		System.out.println(dao.incluir(sql, "Julia Silva"));
		System.out.println(dao.incluir(sql, "Gabi Moura" ));
		System.out.println(dao.incluir(sql, "Jos� Cuervo"));
		
		dao.close();
	}

}
