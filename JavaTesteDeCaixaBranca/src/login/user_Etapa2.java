package login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class User {
	// 1- Tentativa de conexão ao Banco de dados.
	public Connection conectarBD(){
		Connection conn = null;
		try {
			Class.forName("com.mysql.Driver.Manager").newInstance();
			String url = "jdbc:mysql://127.0.0.1/test?user=lopes&password=123";
			conn = DriverManager.getConnection(url);
			// 2- Em caso de erro (FIM).
		}catch (Exception e) { }
		// 3- Caso conecte, retornar conexão e continuar.
		return conn;}
	public String nome="";
	public boolean result = false;
	// 4- Verificar validade do usuário.
	public boolean verificarUsuario(String login, String senha) {
		String sql = "";
		// 1- Tentativa de conexão com o Banco de dados.
		Connection conn = conectarBD();
		//INSTRUÇÃO SQL
		sql += "select nome from usuarios";
		sql += "where login = " + "'" + login + "'";
		sql += "and senha = " + "'" + senha + "';";
		try{
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(sql);
			if(rs.next()) {
				result = true;
				nome = rs.getString("nome");}
			// 2- Em caso de erro (FIM)
		}catch (Exception e) { }
		// 5- retornar resultado da verificação (FIM).
		return result; }
}//FIM DA CLASS

