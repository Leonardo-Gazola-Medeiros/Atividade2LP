module leo.atividade2 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
            
                            
    opens leo.atividade2 to javafx.fxml;
    exports leo.atividade2;
    exports leo.atividade2.controllers;
    exports  leo.atividade2.models;
    opens leo.atividade2.models to javafx.fxml;
    opens leo.atividade2.controllers to javafx.fxml;
}