package leo.atividade2.models;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;

import java.sql.*;
import java.util.List;

public class ConectorMySQL {

    private String url = "jdbc:mysql://localhost:3306/bancoIMC";
    private String user = "root";
    private String senha = "senha";



    public Connection Conectar() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conexao = DriverManager.getConnection(url,user,senha);

            Statement statement = conexao.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from pessoa");
            while(resultSet.next()) {
                System.out.println(resultSet.getString("nome"));
            }

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









