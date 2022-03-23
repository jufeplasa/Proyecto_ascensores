
package model;

public class Person {
    private String name;
    private int location;
    private int destination;
    
    //Constructor
    public Person(String name, int location, int destination) {
        this.name = name;
        this.destination = destination;
        this.location = location;
    }

    public String getName() {
        return name;
    }
    
    //Getters and Setters
    
    public void setName(String name) {
        this.name = name;
    }

    public int getLocation() {
        return location;
    }

    public void setLocation(int location) {
        this.location = location;
    }

    public int getDestination() {
        return destination;
    }

    public void setDestination(int destination) {
        this.destination = destination;
    }

    
}
