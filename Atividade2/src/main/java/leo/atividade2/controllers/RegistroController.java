package leo.atividade2.controllers;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import leo.atividade2.models.ConectorMySQL;
import leo.atividade2.models.Pessoa;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;
import leo.atividade2.models.*;

public class RegistroController implements Initializable {

    @FXML
    private TableView<Pessoa> tabelaRegistros;
    @FXML
    private TableColumn<Pessoa, String> nome;
    @FXML
    private TableColumn<Pessoa, String> cpf;
    @FXML
    private TableColumn<Pessoa, Integer> idade;
    @FXML
    private TableColumn<Pessoa, String> nasc;
    @FXML
    private TableColumn<Pessoa, Float> peso;
    @FXML
    private TableColumn<Pessoa, Float> altura;
    @FXML
    private TableColumn<Pessoa, Float> imc;

    ObservableList<Pessoa> listaRegistros = FXCollections.observableArrayList();


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){



        nome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        cpf.setCellValueFactory(new PropertyValueFactory<>("cpf"));
        idade.setCellValueFactory(new PropertyValueFactory<>("idade"));
        nasc.setCellValueFactory(new PropertyValueFactory<>("nasc"));
        peso.setCellValueFactory(new PropertyValueFactory<>("peso"));
        altura.setCellValueFactory(new PropertyValueFactory<>("altura"));
        imc.setCellValueFactory(new PropertyValueFactory<>("imc"));


        try {
            ConectorMySQL conectorMySQL = new ConectorMySQL();
            Connection con = conectorMySQL.Conectar();

            String sql = "select * from pessoa";
            Statement statement = con.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while(resultSet.next()) {

                listaRegistros.add(new Pessoa(
                        resultSet.getString("nome"),
                        resultSet.getString("cpf"),
                        resultSet.getString("idade"),
                        resultSet.getString("nasc"),
                        resultSet.getDouble("peso"),
                        resultSet.getDouble("altura"),
                        resultSet.getDouble("imc")
                ));
            }}catch(Exception exception){

        }
            tabelaRegistros.setItems(listaRegistros);





    }

    }

