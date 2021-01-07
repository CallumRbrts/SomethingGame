package modele;

public class Leaderboard extends Composite{
    @Override
    public void AddComponent(Composants c){

        if(c.getClass() == Score.class){
            LesComposants.add(c);
        }
    }

}
