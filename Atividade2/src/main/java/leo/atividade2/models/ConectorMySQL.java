package leo.atividade2.models;

import javafx.collections.ObservableList;
import javafx.scene.control.TableView;

import java.sql.*;
import java.util.List;

public class ConectorMySQL {

    private String url = "jdbc:mysql://localhost/bancoIMC";
    private String user = "root";
    private String senha = "senha";



    public Connection Conectar() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conexao = DriverManager.getConnection(url,user,senha);
            System.out.println("Conexão bem sucedida! wuhuuul!1!!!!11!");
            return conexao;
        }catch (ClassNotFoundException ex) {
            System.out.println("Driver não encontrado");
            return null;
        }catch (SQLException ex) {
            System.out.println("Ocorreu um erro ao acessar o banco");
            return null;
        }

    }


}









