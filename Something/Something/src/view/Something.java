package view;

import javafx.animation.AnimationTimer;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import launch.Launch;
import modele.*;

import java.util.ArrayList;


public class Something {

    /**
     * Dimension de la fenetre
     * */
    private final int width= 1000;
    private final int height = 800;

    //Declaration des attributs
    @FXML
    private BorderPane myAnch;
    @FXML
    private Label posdex;
    @FXML
    private Label posdey;
    @FXML
    private Label life;
    @FXML
    private Label score;

    private Bousole myBousole = new Bousole();

    private Manager manager=new Manager(new StubILoader());

    private Stage myStage= Launch.getMainStage();
    private Canvas canevas =  new Canvas(width,height);

    private Image bakg = new Image("resource/image/finishedbigbackground.png");
    private GraphicsContext gc = canevas.getGraphicsContext2D();

    private ImageView myImageFront;
    private ImageView myImageBack;

    //les entrées claviers
    private ArrayList<String> input = new ArrayList<String>();

    private boolean isShooting = false;

    private ImageView currentImage;
    /**
     * Initialize la classe Something
     * @return
     */
    public void initialize(){
        intializeSprite();
        initializeManager();
        myAnch.setCenter(canevas);
        myTimer();
    }
    /**
     * Initialize les Sprites du jeu
     * @return
     */
    public void intializeSprite(){
        myImageFront =  new ImageView(manager.getMyPlayer().getImgFront());
        myImageBack = new ImageView(manager.getMyPlayer().getImgBack());
        currentImage = myImageFront;

        currentImage.xProperty().bindBidirectional(manager.getMyPlayer().xProperty());
        currentImage.yProperty().bindBidirectional(manager.getMyPlayer().yProperty());

       //a revoir??
       // Bindings.bindBidirectional(myPlayer.get().spProperty(),myPlayer.get().xProperty(),new NumberStringConverter());
        //posdex.textProperty().bind(myPlayer.get().xProperty().asString());
        posdex.textProperty().bind(manager.getMyPlayer().xProperty().asString());
        life.textProperty().bind(manager.getMyPlayer().hpProperty().asString());
        posdey.textProperty().bind(manager.getMyPlayer().yProperty().asString());
        score.textProperty().bind(Score.scoreProperty().asString());
    }
    public void initializeManager(){
        //manager.createEnemy(horde,width,height); //code this so it spawns enemies in waves
        //manager.generateWave(width,height);
    }
    /**
     * Recupere les actions lorsqu'on touche les boutons de notre clavier
     * @return
     */
    public void getKeyFromKeyboard(){
        myStage.addEventFilter(KeyEvent.KEY_PRESSED, event -> {
            String code = event.getCode().toString();
            if ( !input.contains(code) )
                input.add( code );
            switch (event.getCode()){
                case UP:
                    myBousole.positionUp();
                    break;
                case DOWN:
                    myBousole.positionDown();
                    break;
                case RIGHT:
                    myBousole.positionRight();
                    break;
                case LEFT:
                    myBousole.positionLeft();
                    break;
            }
        });

        myStage.addEventFilter(KeyEvent.KEY_RELEASED, event -> {
            switch (event.getCode()){
                case SPACE: isShooting = false; break;
            }
        });

        myStage.addEventFilter(KeyEvent.KEY_RELEASED,event -> {
            input.remove( event.getCode().toString());
        });
    }
    /**
     * Boucle de jeu qui gere le movement du joueur, l'action de tirer
     * Appel aussi les managers quand necessaire
     * @return
     */
    public void myTimer(){
        getKeyFromKeyboard();
        gc.clearRect(0,0,width,height);
        AnimationTimer timer =new AnimationTimer() {
            @Override
            public void handle(long now) {
                gc.drawImage(bakg, 0, 0);
                gc.drawImage(currentImage.getImage(), manager.getMyPlayer().getX(), manager.getMyPlayer().getY());

                if (input.contains("LEFT")) {       //si on appuie sur la touche gauche du clavier
                    if ( manager.getMyPlayer().getX() > 0)
                        manager.getMyPlayer().moveLeft();
                    manager.getMyPlayer().setDirection("LEFT");
                }
                if (input.contains("RIGHT")) { //si on appuie sur la touche doit du clavier
                    if ( manager.getMyPlayer().getX() < 1063)
                        manager.getMyPlayer().moveRight();
                    manager.getMyPlayer().setDirection("RIGHT");
                }
                if (input.contains("DOWN")) { //si on appuie sur la touche du bas du clavier
                    currentImage = myImageFront;
                    if (manager.getMyPlayer().getY() < 850)
                        manager.getMyPlayer().moveDown();
                    manager.getMyPlayer().setDirection("DOWN");
                }
                if (input.contains("UP")) { //si on appuie sur la touche du haut du clavier
                    currentImage = myImageBack;
                    if (manager.getMyPlayer().getY() > 0)
                        manager.getMyPlayer().moveUp();
                    manager.getMyPlayer().setDirection("UP");
                }
                if (input.contains("SPACE")) {//si on appuie sur la touche espace du clavier
                    if (!isShooting) {
                        ImageView newAttack = new ImageView(Projectile.getSrcImg());
                        newAttack.setY(manager.getMyPlayer().getY());
                        newAttack.setX(manager.getMyPlayer().getX());

                        manager.addProjectile(myBousole.getPosition());
                        isShooting = true;
                    }
                }
                manager.shootManager();
                manager.playerCollision();
                manager.enemyMove();
                for ( Composants e : manager.getCurrentHorde().getLesComposant() ) // on dessine tout les enemis
                {
                    if (e.getClass()==Enemy.class){
                        Enemy enemy = (Enemy) e;
                        gc.drawImage(new Image(enemy.getImgFront()), enemy.getX(), enemy.getY());
                    }
                }
                if (manager.getCurrentHorde().getLesComposant().size() == 0) {
                    manager.manageWave(width, height);
                }

                manager.collisionManager();
                for (Composants e : manager.getProjectile().getLesComposant()) {
                    if(e.getClass()==Projectile.class){
                        Projectile img = (Projectile) e;
                        gc.drawImage(new Image(img.getImgFront()), img.getX(), img.getY());  //on dessine chaque projectile
                    }

                }

                if(manager.getMyPlayer().isDead()){ //lorsque le joueur n'a plus de vie
                    try {
                        myStage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../resource/fxml/Welcome.fxml"))));
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }
            }
        };
        timer.start();
    }
}
