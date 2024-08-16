package Aufgabe01;

import java.io.Serializable;

public class Wheel implements Serializable {
    private int diameter;

    public Wheel(){}
    public Wheel(int diameter){
        this.diameter = diameter;
    }

    public int getDiameter() {
        return diameter;
    }
}
