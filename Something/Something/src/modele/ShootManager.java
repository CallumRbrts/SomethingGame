package modele;

import java.util.ArrayList;
import java.util.List;

public class ShootManager {

    private Group allProjectiles = new Group();

    /**
     * Ajoute un nouveau projectile.
     * @param x Position x de départ du projectile.
     * @param y Position y de départ du projectile.
     * @param direction Direction ou part par le projectile.
     */
    public void addProjectile(double x, double y, String direction){
        String imgurl = "";
        switch (direction){
            case "UP":
                imgurl ="resource/image/spritemagicattackup.png";
                break;
            case "DOWN":
                imgurl ="resource/image/spritemagicattackdown.png";
                break;
            case "RIGHT":
                imgurl ="resource/image/spritemagicattacknormalcroped.png";
                break;
            case "LEFT":
                imgurl ="resource/image/spritemagicattackleft.png";
                break;
            default:
                imgurl ="resource/image/spritemagicattackdown.png";
        }
        allProjectiles.AddComponent(new Projectile(10, 1, x,y, 500, 5,imgurl, direction));
    }

    /**
     * Donc accès à la liste de projectile.
     * @return la liste de tous les projectiles.
     */
    public Group getAllProjectiles(){
        return allProjectiles;
    }

    /**
     * Le Player tir un projectile.
     * @param allProjectiles La liste de tous les projectiles.
     * @param p Le Player.
     */
    public void shoot(Group allProjectiles, Player p) { //Maybe try using the list to delete it here
        List<Composants> Oof = new ArrayList<Composants>();
        Oof.addAll(allProjectiles.getLesComposant()); //this is to prevent a concurrentModificationException
        for (Composants e : Oof) {
            if(e.getClass() == Projectile.class){
                Projectile pj =(Projectile) e;
                if (pj.getDirection() == "LEFT") {
                    pj.setX(pj.getX() - pj.getSpeed());
                }
                if (pj.getDirection() == "RIGHT") {
                    pj.setX(pj.getX() + pj.getSpeed());
                }
                if (pj.getDirection() == "UP") {
                    pj.setY(pj.getY() - pj.getSpeed());
                }
                if (pj.getDirection() == "DOWN") {
                    pj.setY(pj.getY() + pj.getSpeed());
                }
                if ((pj.getX() - p.getX()) >= pj.getLength() || (pj.getX() - p.getX()) <= -pj.getLength()) {
                    allProjectiles.DeleteComponent(pj); //this deletes all the projectiles from the list once your finger is removed
                    //concurrentModificationException
                }
                if ((pj.getY() - p.getY()) >= pj.getLength() || (pj.getY() - p.getY()) <= -pj.getLength()) {
                    allProjectiles.DeleteComponent(pj); //this deletes all the projectiles from the list once your finger is removed
                    //concurrentModificationException
                }
            }

        }
    }
}
