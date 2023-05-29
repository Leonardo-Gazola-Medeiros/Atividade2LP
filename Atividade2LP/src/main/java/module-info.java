module prova.atividade2lp {
    requires javafx.controls;
    requires javafx.fxml;


    opens prova.atividade2lp to javafx.fxml;
    exports prova.atividade2lp;
}