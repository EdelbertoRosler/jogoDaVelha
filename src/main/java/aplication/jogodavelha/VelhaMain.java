package aplication.jogodavelha;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class VelhaMain extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(VelhaMain.class.getResource("velha-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Jogo da Velha!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}