package Aufgabe01Deserialize;
import Aufgabe01.*;

import java.beans.XMLDecoder;
import java.io.FileInputStream;
import java.io.ObjectInput;
import java.io.ObjectInputStream;

public class Main {
    public static void main(String[] args) {
        // Requirements to Deserialize:
        // -------------------------------------------------
        // must have the same objects in the deserialising device
        // in this case I didnt want to rewrite everything so I just imported everything from Aufgabe01 package
        // --------------------------------------------------

        // Steps to deserialize:
        // --------------------------------------------------------------------------
        // 1- Declare the object but dont make an instant of it
        // 2- the object class should implement the Serializable marker interface
        // 3- import java.io.Serializable(this step and the one before are already acomplished when imported Aufgabe01)
        // 4- FileInputStream to read our file from the given path
        // 5- ObjectInputStream to read the Object in the file
        // 6- Down Cast the object to desired class and read it
        // 7- close file and object input streams
        // --------------------------------------------------------------------------


        Car car;
        try{
            FileInputStream fileInputStream = new FileInputStream("Vehicle.ser");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            car = (Car) objectInputStream.readObject();
            objectInputStream.close();
            fileInputStream.close();
            System.out.println(car + "Binary");
        }catch (Exception e){
            System.out.println(e);
        }


        //Aufgabe c
        Car car1;
        try{
            FileInputStream fis = new FileInputStream("XMLSer.ser");
            XMLDecoder objectIn = new XMLDecoder(fis);
            car1 = (Car) objectIn.readObject();
            fis.close();
            objectIn.close();
            System.out.println();
            System.out.println(car1 + "XML");
        }catch (Exception e){
            System.out.println(e);
        }

    }
}
