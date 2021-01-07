package modele;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.net.MalformedURLException;
import java.net.URL;

/**
 *
 */
public class Player extends Entity implements  Composants{

    private final IntegerProperty hp = new SimpleIntegerProperty();
    public int getHp() {
        return hp.get();
    }
    public void setHp(int hp) {
        this.hp.set(hp);
    }
    public IntegerProperty hpProperty(){return hp;}

    private final StringProperty imgBack = new SimpleStringProperty();
    public String getImgBack() {return imgBack.get();}
    public void setImgBack(String imageb) {this.imgBack.set(imageb);}
    public StringProperty imgBackProperty(){return imgBack;}


    private boolean isDead = false;
    public boolean isDead() {
        return isDead;
    }
    public void setDead(boolean dead) {
        isDead = dead;
    }

    private String direction;
    public String getDirection() {
        return direction;
    }
    public void setDirection(String direction) {
        this.direction = direction;
    }

    /**
     *  Instancie un Player.
     * @param hp vie du Player.
     * @param speed Vitesse du Player.
     * @param x Position sur l'axe des x.
     * @param y Position sur l'axe des y.
     * @param imgFrontUrl Url de l'image de face.
     * @param imgBack Url de l'image de dos.
     */
    public Player(int hp,int speed, int x, int y, String imgFrontUrl,String imgBack){
        super(speed,x,y,imgFrontUrl);
        setHp(hp);
        setImgBack(imgBack);
        direction="DOWN";
    }

}