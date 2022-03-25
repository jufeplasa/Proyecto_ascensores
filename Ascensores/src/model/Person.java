
package model;

public class Person {
    private String name;
    private int origin;
    private int destination;
    
    //Constructor
    public Person(String name, int origin, int destination) {
        this.name = name;
        this.destination = destination;
        this.origin = origin;
    }

    public String getName() {
        return name;
    }
    
    //Getters and Setters
    
    public void setName(String name) {
        this.name = name;
    }

    public int getOrigin() {
        return origin;
    }

    public void setOrigin(int location) {
        this.origin = location;
    }

    public int getDestination() {
        return destination;
    }

    public void setDestination(int destination) {
        this.destination = destination;
    }

    
}
