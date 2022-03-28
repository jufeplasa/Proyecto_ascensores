
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

	/**  public void searchPersonperfloor(int floor, int index) {
    	for (int i=0; i<building.get(index).getListPersons().size();i++) {
    		Person aux=building.get(index).getListPersons().get(i);
    		if(aux.getcurrentFloor()==floor) {
    			if(!transporte.isInElevator(aux)) {
        			transporte.entrarAscensor(aux);
    			}
    		}
    	}
    }**/


	public void addInElevator(int index) {
		for(int i=0;i<building.get(index).getListPersons().size();i++) {
			Person aux=building.get(index).getListPersons().get(i);
			transporte.entrarAscensor(aux);
		}

		/**if(transporte.isEmpty()) {
    		transporte.entrarAscensor(p);
    		transporte.setCurrentFloor(p.getcurrentFloor());
    		if(building.get(index).searchFloorOffice(p.getDestination(), 0)>transporte.getCurrentFloor()) {
    			transporte.subir();

    		}
    	}**/
	}
	
	public void proceso(int index) {
		Person top=transporte.getPila().lastElement();
		transporte.setCurrentFloor(top.getcurrentFloor());
		while(!transporte.isEmpty()) {
			
		}
	}
}
