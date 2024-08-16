package Aufgabe01;

import java.beans.XMLEncoder;
import java.io.*;

public abstract class Vehicle implements Serializable {
    private static final long SerialVersionUID = 1;
    private int id;

    public Vehicle(){}
    public Vehicle(int id){
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public void serialise() throws IOException {
        // Steps to serialize binary:
        // ---------------------------------------------------------------------------
        // 1- Object should implement the Serializable Marker Interface
        // 2- import java.io.Serializable;
        // 3- FileOutputStream which indicates the path where the object is saved
        // 4- ObjectOutputStream takes a FileOutputStream as a parameter
        // 5- objectOut.writeObject(objectName)
        // 6- close object and file output streams
        // ----------------------------------------------------------------------------
        FileOutputStream fileOutputStream = new FileOutputStream("Vehicle.ser");
        ObjectOutput objectOutput = new ObjectOutputStream(fileOutputStream);
        objectOutput.writeObject(this);
        objectOutput.close();
        fileOutputStream.close();
    }

    public void serializeXML() throws IOException{
        //Same as binary but use XMLEncoder instead of ObjectOutputStream
        // make sure javaBeans contract:
        // ------------------------------
        // 1- objects to serialize must have a standard no argument constructor
        // 2- all attributes are private
        // 3- public getters and setters
        // 4- implements serializable

        FileOutputStream fos = new FileOutputStream("XMLSer.ser");
        XMLEncoder objectOut = new XMLEncoder(fos);
        objectOut.writeObject(this);
        objectOut.close();
        fos.close();
        System.out.println("Serialized successfully");
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "id=" + id +
                '}';
    }
}
