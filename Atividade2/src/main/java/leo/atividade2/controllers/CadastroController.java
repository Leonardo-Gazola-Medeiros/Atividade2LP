package leo.atividade2.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import leo.atividade2.models.ConectorMySQL;
import leo.atividade2.models.Pessoa;


import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

public class CadastroController implements Initializable {

    @FXML
    private AnchorPane painelCadastro;
    @FXML
    private TextField campoNome;
    @FXML
    private TextField campoIdade;
    @FXML
    private TextField campoNasc;
    @FXML
    private TextField campoCPF;
    @FXML
    private TextField campoPeso;
    @FXML
    private TextField campoAltura;
    @FXML
    private Button enviarCadastro;
    @FXML
    private Button atualizarCadastro;
    @FXML
    private ComboBox selecionarRegistro;
    @FXML
    private Label campoIMC;

    ObservableList<String> listaDeRegistros = FXCollections.observableArrayList();



    @Override
    public void initialize(URL url, ResourceBundle resBund) {



        try {
            ConectorMySQL conectorMySQL = new ConectorMySQL();
            Connection con = conectorMySQL.Conectar();

            String sql = "select * from pessoa";

            Statement statement = con.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {

                listaDeRegistros.add(
                        resultSet.getString("nome")
                );
            }
        }catch (SQLException e){

            }

        selecionarRegistro.setItems(listaDeRegistros);



    }

    @FXML
    public void selectRegistro() {

        try {
            ConectorMySQL conectorMySQL = new ConectorMySQL();
            Connection con = conectorMySQL.Conectar();

            String sql = "select * from pessoa where nome = '" +  String.valueOf(selecionarRegistro.getValue()) + "'";

            Statement statement = con.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while(resultSet.next()){


                //SÓ PRA VER NO CONSOLE
                System.out.println(resultSet.getString("nome"));
                System.out.println(resultSet.getString("cpf"));
                System.out.println(resultSet.getString("idade"));
                System.out.println(resultSet.getString("nasc"));
                System.out.println(resultSet.getDouble("altura"));
                System.out.println(resultSet.getDouble("peso"));
                System.out.println(resultSet.getDouble("imc"));



                campoNome.setText(resultSet.getString("nome"));
                campoCPF.setText(resultSet.getString("cpf"));
                campoNasc.setText(resultSet.getString("nasc"));
                campoIdade.setText(resultSet.getString("idade"));
                campoPeso.setText(String.valueOf(resultSet.getDouble("peso")));
                campoAltura.setText(String.valueOf(resultSet.getDouble("altura")));
                campoIMC.setText(String.valueOf(resultSet.getDouble("imc")));
            }






        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void update() {

        System.out.println("teste");
        ConectorMySQL conectorMySQL = new ConectorMySQL();
        Connection con = conectorMySQL.Conectar();

        String sql = "UPDATE pessoa SET nome = ?, cpf = ?, idade = ?, nasc = ?, peso = ? , altura = ? , imc = ? WHERE nome = ?";

        try {
            PreparedStatement prepare = con.prepareStatement(sql);
            prepare.setString(1,campoNome.getText());
            prepare.setString(2,campoCPF.getText());
            prepare.setString(3,campoIdade.getText());
            prepare.setString(4,campoNasc.getText());
            prepare.setDouble(5,Double.valueOf(campoPeso.getText()));
            prepare.setDouble(6,Double.valueOf(campoAltura.getText()));
            prepare.setDouble(7,Double.valueOf(campoIMC.getText()));
            prepare.setString(8,String.valueOf(selecionarRegistro.getValue()));
            prepare.executeUpdate();
            System.out.println("Envio bem Sucedido!!!!11!11!!!!!!1");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @FXML
    public void deletar() {
        ConectorMySQL conectorMySQL = new ConectorMySQL();
        Connection con = conectorMySQL.Conectar();

        String sql = "DELETE FROM pessoa WHERE nome = ?";

        try {
            PreparedStatement prepare = con.prepareStatement(sql);
            prepare.setString(1,campoNome.getText());

            prepare.executeUpdate();
            System.out.println("Envio bem Sucedido!!!!11!11!!!!!!1");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }



    @FXML
    public void addCadastro() {
        ConectorMySQL conectorMySQL = new ConectorMySQL();
        Connection con = conectorMySQL.Conectar();

        double peso = Double.valueOf(campoPeso.getText());
        double altura = Double.valueOf(campoAltura.getText());
        double imc = peso / (altura * altura);

        String indice = String.format("%.2f",imc).replaceAll(",",".");


        campoIMC.setText(indice);

        String sql = ("insert into pessoa(nome,cpf,idade,nasc,peso,altura,imc) values(?,?,?,?,?,?,?)");
        try {


           PreparedStatement prepare = con.prepareStatement(sql);
           prepare.setString(1,campoNome.getText());
           prepare.setString(2,campoCPF.getText());
           prepare.setString(3,campoIdade.getText());
           prepare.setString(4,campoNasc.getText());
           prepare.setDouble(5,Double.valueOf(campoPeso.getText()));
           prepare.setDouble(6,Double.valueOf(campoAltura.getText()));
           prepare.setDouble(7,Double.valueOf(campoIMC.getText()));
           prepare.executeUpdate();
            System.out.println("Envio bem Sucedido!!!!11!11!!!!!!1");

        }catch (Exception ex){
            ex.printStackTrace();
        }
    }


    @FXML
    public void calcularIMC() {
        double peso = Double.valueOf(campoPeso.getText());
        double altura = Double.valueOf(campoAltura.getText());
        double imc = peso / (altura * altura);

        String indice = String.format("%.2f",imc).replaceAll(",",".");


        campoIMC.setText(indice);


    }

}
