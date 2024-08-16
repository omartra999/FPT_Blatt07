package Aufgabe01;

import java.io.Serializable;
import java.util.List;

public class Engine implements Serializable {
    private double size;
    private List<Piston> pistons;

    public Engine(){}

    public Engine(double size, List<Piston> pistons){
        this.pistons = pistons;
        this.size = size;

    }

    public double getSize() {
        return size;
    }

    public void setPistons(List<Piston> pistons) {
        this.pistons = pistons;
    }

    public List<Piston> getPistons() {
        return pistons;
    }

    public void setSize(double size) {
        this.size = size;
    }
}
