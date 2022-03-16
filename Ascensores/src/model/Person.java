
package model;

public class Person {
    private String name;
    private String location;
    private String destination;
    
    //Constructor
    public Person(String name, String location, String destination) {
        this.name = name;
        this.location = location;
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

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    
}
