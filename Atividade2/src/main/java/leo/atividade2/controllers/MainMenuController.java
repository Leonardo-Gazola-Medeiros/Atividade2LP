package leo.atividade2.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import leo.atividade2.App;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class MainMenuController implements Initializable {

    @FXML
    private BorderPane mainPane;

    @FXML
    private Button cadastro;

    @FXML
    private Button registros;

    @Override
    public void initialize(URL url, ResourceBundle resBund) {

    }

    @FXML
    private void entrarCadastro(ActionEvent event) throws IOException {
        AnchorPane view = FXMLLoader.load(Objects.requireNonNull(App.class.getResource("cadastro.fxml")));
        mainPane.setCenter(view);
    }

    @FXML
    private void entrarRegistros(ActionEvent event) throws IOException {
        AnchorPane view = FXMLLoader.load(Objects.requireNonNull(App.class.getResource("registros.fxml")));
        mainPane.setCenter(view);

    }

}
