
package model;

import java.util.ArrayList;
import java.util.List;

public class Reception {
    
	private List<Edificio> building;
	private List<Person> person;
	
    public Reception() {
    	building= new ArrayList<Edificio>();
    	person= new ArrayList<Person>();
    }
    
    public void createBuilding(String buildName, int numFloors, int numoffices) {
    	Edificio temp=new Edificio(buildName, numFloors, numoffices);
    	building.add(temp);
    	
    }
    
    public void createPerson(String perName, int destiny) {
    	Person temp=new Person(perName, destiny);
    	person.add(temp);
    }
    
}
