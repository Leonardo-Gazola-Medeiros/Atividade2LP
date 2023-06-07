package leo.atividade2.controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import org.w3c.dom.Text;
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




    @Override
    public void initialize(URL url, ResourceBundle resBund) {

    }

    @FXML
    private void salvar(MouseEvent event){
        String nome = campoNome.getText();
        String idade = campoIdade.getText();
        String nasc = campoNasc.getText();

    }

}
