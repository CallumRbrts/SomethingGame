package modele;

public class Group extends Composite{
    /**
     * Ajoute un Composants a la liste de Composants si sa class est Enemy
     * @param c
     * @return
     */
    @Override
    public void AddComponent(Composants c){

        if(Enemy.class == c.getClass() || Projectile.class == c.getClass()){
            LesComposants.add(c);
        }
    }



}
