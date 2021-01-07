package view;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.input.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import launch.Launch;

import static java.awt.Event.UP;

public class Welcome{

    @FXML
    private Button startButton;
    @FXML
    private Button scoreButton;
    @FXML
    private AnchorPane mainAnchor;

    private Stage myStage;


    @FXML
    public void startgame(){
        try {
            //Scene scene= new Scene(FXMLLoader.load(getClass().getResource("../resource/fxml/Something.fxml")));
            //scene.set
            myStage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../resource/fxml/Something.fxml"))));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @FXML
    public void startScore(){
        try {
            myStage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../resource/fxml/WindowTest.fxml"))));
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void initialize(){
        myStage=Launch.getMainStage();

    }


}
