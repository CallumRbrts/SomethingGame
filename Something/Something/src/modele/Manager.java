package modele;
import javafx.beans.property.ObjectProperty;

import java.util.List;

public class Manager extends  Composite {

    private Score scorePlayer;
    private ILoader myILoader;

    //Declaration des autres managers
    private ShootManager shootMan = new ShootManager();
    private CollisionManager colliMan = new CollisionManager();
    private GameManager gameMan;


    public int getLifeCurrentPlayer(){
        return gameMan.getMyPlayer().getHp();
    }
    /**
     * Constructeur de Manager
     * @param newLoader
     * @return
     */
    public Manager(ILoader newLoader){
        myILoader = newLoader;
        gameMan= new GameManager(newLoader);
    }
    /**
     * Retourne une liste d'ennemis
     * @return Group
     */
    public Group getCurrentHorde(){
       return gameMan.getCurrentHorde();
    }

    /**
     * Appel la fonction qui retourne le joueur
     * @return
     */
    public Player createPlayer() {
        return gameMan.getMyPlayer();
    }
    /**
     * Creer un ennemi a partir de la Fabrique
     * @return
     */
    public Enemy createOneEnemy(){
        return FabriqueEntity.createEnemy(5,9,4,0, 360);
    }

   /*public Score createScore(){
        return new Score("jojo",0,1);
    }*/
    /**
     * Ajouter un Projectile a une liste de projectile
     * @param direction
     * @return
     */
    public void addProjectile( String direction){

        shootMan.addProjectile(gameMan.getMyPlayer().getX(),gameMan.getMyPlayer().getY(),direction);
    }
    /**
     * Appel le generateur d'une vague d'enemis
     * @param i
     * @param width
     * @param height
     * @return
     */
    public void generateWave(int i, int width, int height) { //nb of rounds
        gameMan.generateWave(i,width,height);
    }

    /**
     * Appel le gereur des vagues.
     * @param width
     * @param height
     * @return
     */
    public void manageWave( int width, int height) {
         gameMan.manageWave(gameMan.getCurrentHorde(),width,height);
    }
    /**
     * Appel le gereur des projectiles
     * @return
     */
    public void shootManager(){
        shootMan.shoot(shootMan.getAllProjectiles(),gameMan.getMyPlayer());
    }

    /**
     * Appel le gereur des collisions du joueur
     * @return
     */
    public void playerCollision(){
        colliMan.playerCollision(gameMan.getCurrentHorde(),gameMan.getMyPlayer());

    }

    public Group getProjectile(){
        return shootMan.getAllProjectiles();
    }
    /**
     * Appel le gereur des collisions entre enemis et Projectile
     * @return
     */
    public void collisionManager(){
        colliMan.detecteColision(gameMan.getCurrentHorde(),shootMan.getAllProjectiles(), scorePlayer);
    }

    /**
     * Crée des nouveaux managers
     * @return
     */
    public void newGame(){
        gameMan = new GameManager(myILoader);
        shootMan=new ShootManager();

    }

    /**
     * Appel la classe qui bouge les enemis
     * @return
     */
    public void enemyMove(){
        gameMan.enemyMove();
    }


    public Player getMyPlayer(){
        return gameMan.getMyPlayer();
    }


}

