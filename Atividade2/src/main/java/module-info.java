module leo.atividade2 {
    requires javafx.controls;
    requires javafx.fxml;
            
                            
    opens leo.atividade2 to javafx.fxml;
    exports leo.atividade2;
    exports leo.atividade2.controllers;
    opens leo.atividade2.controllers to javafx.fxml;
}