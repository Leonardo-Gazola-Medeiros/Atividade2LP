package leo.atividade2.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import org.w3c.dom.events.MouseEvent;

import java.net.URL;
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
    private void calculoIMC(ActionEvent event){
        //Tem q colocar isso no campo do SceneBuilder

        if(campoAltura.getText().isEmpty() || campoPeso.getText().isEmpty()) {
            campoIMC.setText("");
        }else {
            float imc;
            String resultado;

            imc = (Float.valueOf(campoPeso.getText())/(Float.valueOf(campoAltura.getText())*Float.valueOf(campoAltura.getText())));
            resultado = String.valueOf(imc);
            campoIMC.setText(resultado);
        }
    }





    @FXML
    private void salvar(MouseEvent event){
        String nome = campoNome.getText();
        String idade = campoIdade.getText();
        String nasc = campoNasc.getText();
        String cpf = campoCPF.getText();
        String peso = campoPeso.getText();
        String altura = campoAltura.getText();
        String imc = campoIMC.getText();

    }

}
