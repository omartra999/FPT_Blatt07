package Aufgabe01;
import Aufgabe01.*;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Serialization = The process of converting an object into a byte stream.
        //                 persists(saves the state) the obejct after program exits
        //                 this byte stream can be saved as a file or sent over a network
        //                 => can be sent to a different machine
        //                 Byte Stream can be saved as a file (.ser) which is platform independent
        //                 (Think of it as if you're saving a file with the obeject's information)

        // Deserialization = The reverse process of converting a byte stream into an object
        //                   (Think of it as if you are loading a saved file)

        Wheel carWheel = new Wheel(15);
        Wheel carWheel2 = new Wheel(10);

        Seat carSeat1 = new Seat(Color.BLACK);
        Seat carSeat2 = new Seat(Color.BROWN);

        List<Wheel> wheels = new ArrayList<>();
        wheels.add(carWheel);
        wheels.add(carWheel2);

        List<Seat> seats = new ArrayList<>();
        seats.add(carSeat1);
        seats.add(carSeat2);

        Piston piston1 = new Piston(457D);
        Piston piston2 = new Piston(7789D);
        List<Piston> pistons = new ArrayList<>();
        pistons.add(piston1);
        pistons.add(piston2);

        Engine carEngine = new Engine(8D,pistons);

        Car car = new Car(1547, "OSP", carEngine, seats, wheels);
        try {
            car.serialise();
            System.out.println("car has been successflly serialized");
        }catch (Exception e){
            System.out.println(e);
        }

        Car car1 = new Car(4892, "mdl", carEngine, seats, wheels);
        // Aufgabe c
        try {
            car1.serializeXML();
            System.out.println("successfull");
        }catch (Exception e){
            System.out.println(e);
        }
    }
}

