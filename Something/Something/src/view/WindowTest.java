package view;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import jdk.internal.org.objectweb.asm.Handle;
import launch.*;
import modele.Score;

public class WindowTest {

    @FXML
    private Label monLabel;

    @FXML
    private TextField maBox;

    @FXML
    private TextField maDeuxiemeBox;

    @FXML
    private Button monBoutton;

    @FXML
    private Label Pse;

    @FXML
    private Button mainMenuButton;

    @FXML
    private Label PtV;

    private Stage window;

    // Player p = new Player();

    public void initialize(){
        maBox.textProperty().bindBidirectional(maDeuxiemeBox.textProperty());


        monBoutton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
               // maBox.setText("L'action!!");
            }
        });
        mainMenuButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {

                Parent root2;
                try{
                    window = Launch.getMainStage();
                    root2 = FXMLLoader.load(getClass().getResource("../resource/fxml/Welcome.fxml"));
                    Scene scoreScene = new Scene(root2,1280,720);
                    window.setScene(scoreScene);
                }
                catch(Exception e){
                    e.printStackTrace();
                }

            }
        });
    }
}
