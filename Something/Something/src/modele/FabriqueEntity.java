package modele;

public class FabriqueEntity {
    public static Player createPlayer(int hp,int speed,int x,int y){
        return new Player(hp,speed,x, y,"resource/image/spritefront.png","resource/image/spriteback.png");
    }

    public static Enemy createEnemy(int speed, int hp,int power, int x, int y){
        return new Enemy(speed, hp, power,x,y,"resource/image/spriteGHOSTa1.png");
    }
}
