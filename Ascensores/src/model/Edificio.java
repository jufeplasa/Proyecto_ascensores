
package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

public class Edificio {
    
    private String name;
    private int office;
    private int floors;
	private List<HashMap<Integer,Person>> offices;
	private Stack<Person> person;
	
    //Constructor
    public Edificio(String name, int floors, int office) {
        this.name = name;
        this.floors = floors;
        this.office=office;
        offices =new ArrayList<HashMap<Integer,Person>>();
        person = new Stack<Person>();
    }
    
    
    public int searchFloorOffice(int IDOffice, int currentFloor) {
    	int floor = currentFloor;
   	 	if(offices.get(floor).containsKey(IDOffice)) {
   			return floor;
   		}else{
   			return searchFloorOffice(IDOffice,floor+1);
   		}
   	 	
    }
    
    public boolean isInOffice(Person p, int floor) {
    	int index=floor-1;
    	return offices.get(index).containsValue(p);
    	
    }
   
    public List<HashMap<Integer, Person>> getOffices() {
		return offices;
	}

	public Stack<Person> getQueuePersons() {
		return person;
	}

	public void createOffices() {
    	int indexOffice=office*floors;
    	for(int i=0;i<floors;i++) {
    		offices.add(new HashMap<Integer,Person>());
    		for(int j= 0; j<office;j++) {
    			offices.get(i).put(indexOffice, null);
    			indexOffice--;
    		}
    	}
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
