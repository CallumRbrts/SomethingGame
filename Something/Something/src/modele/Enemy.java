package modele;

import java.net.MalformedURLException;
import java.net.URL;

public class Enemy extends Entity implements Composants{

    public static String enemyImg;
    /**
     * Get l'url de l'image de l'enemis
     * @return
     */
    public static String  getEnemyImage(){
        return enemyImg;
    }

    private int hp;
    /**
     * Get la valeur de hp
     * @return int
     */
    public int getHp() {
        return hp;
    }
    /**
     * Set la valeur de hp
     * @param hp
     * @return
     */
    public void setHp(int hp) {
        this.hp = hp;
    }

    private int power;
    /**
     * Get la valeur de power
     * @return int
     */
    public int getPower() {
        return power;
    }
    /**
     * Set la valeur de power
     * @param power
     * @return
     */
    public void setPower(int power) {
        this.power = power;
    }

    private boolean isDead = false;
    /**
     * Get la valeur de isDead
     * @return boolean
     */
    public boolean isDead() {
        return isDead;
    }
    /**
     * Set la valeur de isDead
     * @param dead
     * @return
     */
    public void setDead(boolean dead) {
        isDead = dead;
    }

    /**
     * Constructeur de Enemy
     * @param speed
     * @param hp
     * @param power
     * @param x
     * @param y
     * @param imgFront
     * @return
     */
    public Enemy(int speed, int hp,int power, int x, int y,String imgFront){
        super(speed,x,y,imgFront);
        enemyImg = imgFront;
        setHp(hp);
        setPower(power);
    }
}
