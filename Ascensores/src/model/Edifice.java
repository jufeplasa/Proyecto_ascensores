
package model;

public class Edifice {
    
    private String name;
    private int floors;
    
    //Constructor
    public Edifice(String name, int floors) {
        this.name = name;
        this.floors = floors;
    }
    
    //Getters and Setters
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getFloors() {
        return floors;
    }

    public void setFloors(int floors) {
        this.floors = floors;
    }
    
    
    
}
