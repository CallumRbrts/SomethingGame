package modele;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GameManager {

    private Player myPlayer;
    private int enemiesWave = 1;

    private ILoader myLoader;
    private Score scorePlayer;
    private Group currentHorde = new Group();

    /**
     * Constructeur de GameManager
     * @param newILoader
     * @return
     */
    public GameManager(ILoader newILoader){
        myLoader = newILoader;
        myPlayer=myLoader.getPlayer();
    }
    /**
     * Retourne le Player
     * @return Player
     */
    public Player getMyPlayer(){
      return myPlayer;
  }

    /**
     * Retourne un Group d'Enemy
     * @return Group
     */
    public Group getCurrentHorde(){
        return currentHorde;
    }

    /**
     * Cree un Joueur
     * @return Player
     */
    public Player createPlayer() {
        //myPlayer.set(myLoader.getPlayer());
        myPlayer=myLoader.getPlayer();
        return myLoader.getPlayer();
        //player.shoot(player);
    }
    /**
     * Cree un Group
     * @return Group
     */
    public Group generateHorde() {
        Group g = new Group();
        return g;
    }

    /**
     * Cree un Enemy
     * @return Enemy
     */
    public Enemy createOneEnemy(){
        return new Enemy(5,9,4,0, 360,"resource/image/spriteGHOSTa1.png");
    }

    /**
     * Crée un groupe d'ennemies de façon aléatoire sur la carte.
     * @param horde
     * @param width
     * @param height
     * @return
     */
    public Group createEnemy(Group horde, int width, int height) {
        Random r = new Random();
        Random r2 = new Random();
        double x = 0, y = 0;
        if(r.nextInt()%2 == 0){
            if(r2.nextInt()%2 ==1){
                x = r.nextInt(width-100);
                y=height-50;
            }else {
                x = r.nextInt(width-100);
                y = -100;
            }
        }
        else{
            if(r2.nextInt()%2 == 1){
                x =width-100;
                y = r.nextInt(height-100);
            }
            else{
                x=-100;
                y = r.nextInt(height-100);
            }
        }
        Enemy e = myLoader.getEnemy();
        e.updatePosition(x,y);
        horde.AddComponent(e);
        return horde;
    }

    /**
     * Genrere une vague (collection) d'ennemie avec un nombre définie d'ennemies.
     * @param i Nombre d'ennemies à generer.
     * @param width Largeur de la fenetre.
     * @param height Longueur de la fenetre.
     * @return Une liste d'ennemie.
     */
    public Group generateWave(int i, int width, int height) { //nb of rounds
        Group g = generateHorde();
        for (int x = 0; x < i; x++) {
            g = createEnemy(g, width, height);
        }
        currentHorde = g;
        return g;

    }

    /**
     * Genere une nouvelle vagues.
     * @param g Liste des ennemies.
     * @param width Largeur de la fenetre.
     * @param height Longueur de la fenetre.
     */
    public void manageWave(Group g, int width, int height) {

        if (g.getLesComposant().size() == 0){ //when we kill all the enemies, a new wave is created with one extra enemy
            g = generateWave(enemiesWave, width, height);
            enemiesWave++;
        }
        currentHorde = g;
    }

    /**
     * Gere le movement des ennemis
     * @return
     */
    public void enemyMove(){
        List<Composants> listOfEnemies = new ArrayList<>();
        listOfEnemies.addAll(currentHorde.getLesComposant());
        for (Composants c:listOfEnemies
        ) {
            if(c.getClass()==Enemy.class){
                Enemy e = (Enemy) c;
                if(e.getY() < myPlayer.getY()) {
                    e.setY(e.getY() + e.getSpeed());
                }
                if(e.getY() >myPlayer.getY()) {
                    e.setY(e.getY() - e.getSpeed());
                }
                if(e.getX() < myPlayer.getX()) {
                    e.setX(e.getX() + e.getSpeed());
                }
                if(e.getX() > myPlayer.getX()) {
                    e.setX(e.getX() - e.getSpeed());
                }
            }
        }
    }
}
