package leo.atividade2.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import leo.atividade2.models.ConectorMySQL;


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
        ConectorMySQL conectorMySQL = new ConectorMySQL();
        conectorMySQL.Conectar();

        selecionarRegistro.setItems(listaDeRegistros);



    }




    @FXML
    public void addCadastro() {
        ConectorMySQL conectorMySQL = new ConectorMySQL();
        Connection con = conectorMySQL.Conectar();

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

        campoIMC.setText(Double.toString(imc));

    }

}
