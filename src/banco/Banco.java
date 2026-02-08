package banco;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Banco {

	private static final String URL_BANCO = "jdbc:sqlite:biblioteca.db";
	
	public static Connection conectar() {
		try {
			return DriverManager.getConnection(URL_BANCO);
		}catch(SQLException e) {
			throw new RuntimeException("Erro ao conectar com o banco de dados");
		}
	}
}
