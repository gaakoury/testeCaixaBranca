package login;
//IMPORTANDO A FERRAMENTA DE CONEXÃO COM O BANDO DE DADOS.
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class user_Etapa3 {
	/**DECLARAÇÃO DO METODO DE CONEXÃO COM O BANCO DE DADOS.**/
	public Connection conectarBD(){
		Connection conn = null;
		//TRY PARA VALIDAR QUE A CONEXÃO COM O BANCO DEU CERTO
		try {
			Class.forName("com.mysql.Driver.Manager").newInstance();
			String url = "jdbc:mysql://127.0.0.1/test?user=lopes&password=123";
			conn = DriverManager.getConnection(url);
		//CASO NÃO, RETORNARÁ UM ERRO.
		}catch (Exception e) { }
		//RETORNO DO RESULTADO DO TRY
		return conn;}
	/**INDICAÇÃO DAS VARIAVEIS NOME E RESULT, E DO METODO VERIFICAR USUÁRIO**/
	public String nome="";
	public boolean result = false;
	public boolean verificarUsuario(String login, String senha) {
		String sql = "";
		/**PUXANDO O METODO DE CONEXÃO DO BANCO.**/
		Connection conn = conectarBD();
		//INSTRUÇÃO SQL
		/*VALIDADO A CONEXÃO COM O BANCO, ALGUMAS INSTRUÇÕES SERÃO EXECUTADAS, ASSIM
	    PUXANDO AS  INFORMÇÕES CONTIDAS NO MESMO.*/
		sql += "select nome from usuarios";
		sql += "where login = " + "'" + login + "'";
		sql += "and senha = " + "'" + senha + "';";
		// AGORA SERÁ FEITO UM TRY PARA A RELAÇÃO DO NOME AO LOGIN E SENHA.
		try{
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(sql);
			if(rs.next()) {
				result = true;
				nome = rs.getString("nome");}
		// CASO HAJA ALGUM PROBLEMA, RETORNARÁ UM ERRO.
		}catch (Exception e) { }
		// RETORNO DO RESULTADO DO TRY
		return result; }
}//FIM

