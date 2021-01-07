package modele;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class Score implements Composants {

    private String nom;


    private int wave;

    public int getWave() {
        return wave;
    }

    public void setWave(int wave) {
        this.wave = wave;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    private static final IntegerProperty score = new SimpleIntegerProperty();
    public static int getScore() {
        return score.get();
    }
    public static void setScore(int score) {
        Score.score.set(score);
    }
    public static IntegerProperty scoreProperty(){return score;}

    public Score(String nom, int score, int wave){
        this.nom = nom;
        setScore(score);
        this.wave = wave;
    }
}
