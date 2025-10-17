module com.example.animacao_po {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires java.desktop;


    opens com.example.animacao_po to javafx.fxml;
    exports com.example.animacao_po;
}

