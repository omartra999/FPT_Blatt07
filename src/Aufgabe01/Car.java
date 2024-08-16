package Aufgabe01;

import java.util.List;

public class Car extends Vehicle {
    private String model;
    private Engine engine;
    private List<Seat> seats;
    private List<Wheel> wheels;


    public Car(){}

    public Car(int id, String model, Engine engine, List<Seat> seats, List<Wheel> wheels){
        super(id);
        this.model = model;
        this.engine = engine;
        this.seats = seats;
        this.wheels = wheels;
    }

    public Engine getEngine() {
        return engine;
    }

    public List<Seat> getSeats() {
        return seats;
    }

    public List<Wheel> getWheels() {
        return wheels;
    }

    public String getModel() {
        return model;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setSeats(List<Seat> seats) {
        this.seats = seats;
    }

    public void setWheels(List<Wheel> wheels) {
        this.wheels = wheels;
    }

}
