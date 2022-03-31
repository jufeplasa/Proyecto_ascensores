
package model;

public class Person {
    private String name;
    private int currentFloor;
    private int destination;
    private String status;
    
    //Constructor
    public Person(String name, int currentFloor, int destination) {
        this.name = name;
        this.destination = destination;
        this.currentFloor = currentFloor;
        status=null;
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
    
    public String  getStatus() {
    	return status;
    }
    
    public void setStatusWithOffice(int office) {
    	status=name+" se mueve a la oficina "+office;
    }

    public void setStatusWithOutOffice() {
    	status=name+" se quedo sin oficina";
    }
    
}
