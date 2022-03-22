
package model;

public class Person {
    private String name;
    private String location;
    private int destination;
    
    //Constructor
    public Person(String name,  int destination) {
        this.name = name;
        this.destination = destination;
    }

    public String getName() {
        return name;
    }
    
    //Getters and Setters
    
    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getDestination() {
        return destination;
    }

    public void setDestination(int destination) {
        this.destination = destination;
    }

    
}
