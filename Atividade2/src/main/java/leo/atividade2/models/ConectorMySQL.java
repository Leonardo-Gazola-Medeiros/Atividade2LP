package leo.atividade2.models;

import java.sql.*;

public class ConectorMySQL {

    private Connection conexao;
    private PreparedStatement prepare;
    private ResultSet result;

    public static void Conexao() throws SQLException {
        Connection conexao = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conexao = DriverManager.getConnection("jdbc:mysql://localhost/bancoIMC","root","senha");
            System.out.println("Conexão bem sucedida! wuhuuul!1!!!!11!");
        }catch (ClassNotFoundException ex) {
            System.out.println("Driver não encontrado");
        }catch (SQLException ex) {
            System.out.println("Ocorreu um erro ao acessar o banco");

        }


    }






}


