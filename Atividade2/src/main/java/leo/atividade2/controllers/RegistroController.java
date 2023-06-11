package leo.atividade2.controllers;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import leo.atividade2.models.Pessoa;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;

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


        nome.setCellValueFactory(new PropertyValueFactory<>("NOME"));
        cpf.setCellValueFactory(new PropertyValueFactory<>("CPF"));
        idade.setCellValueFactory(new PropertyValueFactory<>("IDADE"));
        nasc.setCellValueFactory(new PropertyValueFactory<>("NASC"));
        peso.setCellValueFactory(new PropertyValueFactory<>("PESO"));
        altura.setCellValueFactory(new PropertyValueFactory<>("ALTURA"));
        imc.setCellValueFactory(new PropertyValueFactory<>("IMC"));




        try{
            ConectorH2 conH2 = new ConectorH2();
            Connection con = DriverManager.getConnection("jdbc:h2:./test","sa","");

            String sql = "SELECT * FROM PESSOAS";
            Statement statement = con.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while(resultSet.next()) {

                listaRegistros.add(new Pessoa(
                        resultSet.getString("NOME"),
                        resultSet.getString("CPF"),
                        resultSet.getInt("IDADE"),
                        resultSet.getString("NASC"),
                        resultSet.getFloat("PESO"),
                        resultSet.getFloat("ALTURA"),
                        resultSet.getFloat("IMC")
                ));
            }
            tabelaRegistros.setItems(listaRegistros);


        }catch(Exception exception){

        }

    }

    }

