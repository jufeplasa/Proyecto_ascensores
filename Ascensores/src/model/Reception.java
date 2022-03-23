
package model;

import java.util.ArrayList;
import java.util.List;

public class Reception {
    
	private List<Edificio> building;
	private List<Person> person;
	private IAscensor<Person> transporte;
	
    public Reception() {
    	building= new ArrayList<Edificio>();
    	person= new ArrayList<Person>();
    	transporte=new Ascensor<Person>();
    }
    
    public void createBuilding(String buildName, int numFloors, int numOffices) {
    	Edificio temp=new Edificio(buildName, numFloors, numOffices);
    	building.add(temp);
    	
    }
    
    public void createPerson(String perName, int start,int destiny) {
    	Person temp=new Person(perName, start,destiny);
    	person.add(temp);
    }
	
}
