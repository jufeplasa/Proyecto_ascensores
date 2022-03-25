
package model;

import java.util.ArrayList;
import java.util.List;

public class Reception {
    
	private List<Edificio> building;
	
	private IAscensor<Person> transporte;
	
    public Reception() {
    	building= new ArrayList<Edificio>();
    	transporte=new Ascensor<Person>();
    }
    
    public void createBuilding(String buildName, int numFloors, int numOffices) {
    	Edificio temp=new Edificio(buildName, numFloors, numOffices);
    	building.add(temp);
    	
    }
    
    
    public void createPerson(String perName, int start,int destiny, int index) {
    	Person temp=new Person(perName, start,destiny);
    	building.get(index).getListPersons().add(temp);
    }
	
    
    public void genericMethod() {
    	for(int i=0;i<building.size();i++) {
    		for(int j=0;j<building.get(i).getListPersons().size();j++) {
    			
    			//transporte.entrarAscensor();
    		}
    	}
    }
}
