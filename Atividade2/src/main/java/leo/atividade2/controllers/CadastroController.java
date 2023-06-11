package leo.atividade2.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;



import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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



        selecionarRegistro.setItems(listaDeRegistros);


    }




    @FXML
    public void addCadastro() {


    }

    @FXML
    public void calcularIMC() {
        double peso = Double.valueOf(campoPeso.getText());
        double altura = Double.valueOf(campoAltura.getText());
        double imc = peso / (altura * altura);

        campoIMC.setText(Double.toString(imc));

    }

}
