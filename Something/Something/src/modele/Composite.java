package modele;

import java.util.ArrayList;
import java.util.List;

public abstract class Composite implements Composants {

    public List<Composants> LesComposants = new ArrayList<Composants>();

    public List<Composants> getLesComposant() {
        return LesComposants;
    }

    public void AddComponent(Composants c){
        LesComposants.add(c);
    }

    public void DeleteComponent(Composants c){
        LesComposants.remove(c);
    }
}
