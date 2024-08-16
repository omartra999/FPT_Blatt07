package Aufgabe01;

import java.io.Serializable;

public class Piston implements Serializable {
    private double thickness;

    public Piston(){}
    public Piston(double thickness){
        this.thickness = thickness;
    }

    public double getThickness() {
        return thickness;
    }

    public void setThickness(double thickness) {
        this.thickness = thickness;
    }
}
