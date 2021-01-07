package modele;

import java.util.ArrayList;
import java.util.List;

public class CollisionManager {

    /**
     * Gere la collision des Enemy avec le Player
     * @param g
     * @param p
     * @return
     */
    public void playerCollision(Group g, Player p){
        List<Composants> listOfEnemies = new ArrayList<>();
        listOfEnemies.addAll(g.getLesComposant());
        for (Composants c : listOfEnemies)
            if(c.getClass()==Enemy.class){
                Enemy e = (Enemy) c;
                if(p.getX() >= e.getX() - 100 && p.getY() >= e.getY() - 100 && p.getX() <= e.getX() + 100 && p.getY() <= e.getY() + 100){
                    //seperate projectile collision with enemy collision because the collision is only taken into account when there is a projectile in a list
                    p.setHp(p.getHp()-1);
                    e.setHp(0);
                    if(p.getHp()==0){
                        p.setDead(true);
                    }
                    if(e.getHp()==0) {
                        g.getLesComposant().remove(e);
                    }
                }
            }
     }

    /**
     * Gere la collision des Projectiles avec la liste d'Enemy
     * @param allProjectiles
     * @param g
     * @return
     */
    public void detecteColision(Group g, Group allProjectiles, Score s){

        List<Composants> listOfEnemies = new ArrayList<>();
        listOfEnemies.addAll(g.getLesComposant());

        List<Composants> listOfProjectiles = new ArrayList<>();
        listOfProjectiles.addAll(allProjectiles.getLesComposant());
        for (Composants a : listOfProjectiles
        ) {
            if(a.getClass() == Projectile.class){
                Projectile pj = (Projectile) a;
                for (Composants c : listOfEnemies) {
                    if (c.getClass() == Enemy.class) {
                        Enemy e = (Enemy) c;
                        if (pj == null) {
                            return;
                        }
                        if (pj.getX() >= e.getX() - 100 && pj.getY() >= e.getY() - 100 && pj.getX() <= e.getX() + 100 && pj.getY() <= e.getY() + 100) {
                            e.setHp(e.getHp() - 1);
                            if (e.getHp() == 0) {
                                e.setDead(true);
                                g.getLesComposant().remove(e);
                                allProjectiles.DeleteComponent(pj);
                                s.setScore(s.getScore()+1);
                                //SCORE
                                //boolean? isDead? or add list directly?
                            }
                        }
                    }
                }
            }

        }

    }

}
