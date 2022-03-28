
package model;

public class Person {
    private String name;
    private int currentFloor;
    private int destination;
    
    //Constructor
    public Person(String name, int currentFloor, int destination) {
        this.name = name;
        this.destination = destination;
        this.currentFloor = currentFloor;
    }

    public String getName() {
        return name;
    }
    
    //Getters and Setters
    
    public void setName(String name) {
        this.name = name;
    }

    public int getcurrentFloor() {
        return currentFloor;
    }

    public void setcurrentFloor(int location) {
        this.currentFloor = location;
    }

    public int getDestination() {
        return destination;
    }

    public void setDestination(int destination) {
        this.destination = destination;
    }

    
}
