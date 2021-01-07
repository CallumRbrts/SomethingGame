package modele;

public class Bousole {
    private String position;

    public Bousole(){
        setPosition("DOWN");
    }

    public void setPosition(String position){
        this.position=position;
    }

    public String getPosition(){
        return position;
    }

    public void positionUp(){
        setPosition("UP");
    }

    public void positionDown(){
        setPosition("DOWN");
    }

    public void positionLeft(){
        setPosition("LEFT");
    }

    public void positionRight(){
        setPosition("RIGHT");
    }


    public boolean isPositionUp(){
        if(getPosition()=="UP") return true;
        return false;
    }

    public boolean isPositionDown(){
        if(getPosition()=="DOWN") return true;
        return false;    }

    public boolean isPositionLeft(){
        if(getPosition()=="LEFT") return true;
        return false;
    }

    public boolean isPositionRight(){
        if(getPosition()=="RIGHT") return true;
        return false;
    }

}
