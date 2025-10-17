package com.example.animacao_po;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Principal extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(
                Principal.class.getResource("/com/example/animacao_po/principal.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 600);
        stage.setTitle("Animação Pesquisa e Ordenação!");
        stage.setScene(scene);
        stage.show();
    }
    public void onRadixSort(ActionEvent actionEvent) {
        Radix radix = new Radix();
        radix.show();
    }
    public void onCountingSort(ActionEvent actionEvent) {
        Counting counting = new Counting();
        counting.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}
