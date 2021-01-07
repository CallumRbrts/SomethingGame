package modele;

public class StubILoader implements ILoader {
    public Player getPlayer(){
        //return new Player(3,9,640, 360,"resource/image/spritefront.png","resource/image/spriteback.png");
        return FabriqueEntity.createPlayer(3,10,640, 360);
    }
    public Enemy getEnemy(){
        //return  new Enemy(1, 1, 1,200,200,"resource/image/spriteGHOSTa1.png");
        return FabriqueEntity.createEnemy(1, 1, 1,200,200);
    }
}
