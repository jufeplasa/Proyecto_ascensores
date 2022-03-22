
package model;

public class Edificio {
    
    private String name;
    private int office;
    private int floors;
    
    //Constructor
    public Edificio(String name, int floors, int office) {
        this.name = name;
        this.floors = floors;
        this.office=office;
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

	public int getOffice() {
		return office;
	}

	public void setOffice(int office) {
		this.office = office;
	}
    
    
    
}
