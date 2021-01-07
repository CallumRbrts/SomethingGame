
package launch;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Launch extends Application {


    private static Stage myStage;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        myStage = primaryStage;
        //Parent root = FXMLLoader.load(getClass().getResource("../fxml/WindowTest.fxml");
        primaryStage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../resource/fxml/Welcome.fxml"))));

        //Parent root = FXMLLoader.load(getClass().getResource("../resource/fxml/Welcome.fxml"));
        //Scene mainScene = new Scene(root, 1280, 720);

        primaryStage.setMinWidth(200);
        primaryStage.setMinHeight(200);
        //primaryStage.setScene(mainScene);
        //primaryStage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../fxml/WindowTest.fxml"))));
        primaryStage.show();


    }


    public static Stage getMainStage() {
        return myStage;
    }
}
