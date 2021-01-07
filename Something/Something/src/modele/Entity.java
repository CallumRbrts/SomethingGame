package modele;


import javafx.beans.property.*;

public abstract class Entity implements Composants {


    private final SimpleDoubleProperty x = new SimpleDoubleProperty();
    public double getX(){
        return  x.get();
    }
    public void setX(double x){
        this.x.set(x);
    }
    public SimpleDoubleProperty xProperty(){return x;}

    public StringProperty sp = new SimpleStringProperty();
    public String getSp(){
        return  sp.get();
    }
    public void setSp(String value){
        sp.set(value);
    }

    public StringProperty spProperty(){
        return  sp;
    }

   // public StringConverter<Number> converter = new NumberStringConverter();

    private final SimpleDoubleProperty y = new SimpleDoubleProperty();
    public double getY() {
        return y.get();
    }
    public void setY(double y) {
        this.y.set(y);
    }
    public SimpleDoubleProperty yProperty(){return y;}

    private final IntegerProperty speed = new SimpleIntegerProperty();
    public int getSpeed() {
        return speed.get();
    }
    public void setSpeed(int speed) {
        this.speed.set(speed);
    }


    private final StringProperty imgFront = new SimpleStringProperty();
    public String getImgFront() {return imgFront.get();}
    public void setImgFront(String imagef) {this.imgFront.set(imagef);}
    public StringProperty imgFrontProperty(){return imgFront;}

    /**
     * Constructeur d'Entity
     * @param speed : vitesse.
     * @param x : position sur l'axe de x.
     * @param y : position sur l'axe des y.
     * @param imgFrontUrl : url de l'image de face.
     */
    public Entity(int speed, double x, double y, String imgFrontUrl) {
        setSpeed(speed);
        setX(x);
        setY(y);
        setImgFront(imgFrontUrl);
    }


    public void updatePosition(double x,double y){
        setX(x);
        setY(y);
    }

    public void updateX(double x){
        updatePosition(x,getY());
    }

    public void updateY(double y){
        updatePosition(getX(),y);
    }

    public void moveRight(){
        updateX(getX()+getSpeed());
    }

    public void moveLeft(){
        updateX(getX()-getSpeed());
    }

    public void moveUp(){
        updateY(getY()-getSpeed());
    }

    public void moveDown(){
        updateY(getY()+getSpeed());
    }

}
