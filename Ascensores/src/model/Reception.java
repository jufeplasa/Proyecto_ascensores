

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
		building.get(index).getQueuePersons().add(0, temp);
	}
	
/**	
	public void firstCallElevator(int index) {
		Person aux =building.get(index).getListPersons().get(0);
		transporte.setCurrentFloor(aux.getcurrentFloor());
		recorrido(index);
	}
	
	public void recorrido(int index) {
		addInElevator(index, transporte.getCurrentFloor()) ;
		exitInElevator(index, transporte.getCurrentFloor()) ;
	}
	

	public void addInElevator(int index, int floor) {
		for(int i=0;i<building.get(index).getListPersons().size();i++) {
			Person aux=building.get(index).getListPersons().get(i);
			if(aux.getcurrentFloor()==floor) {
				transporte.entrarAscensor(aux);
			}
		}
	}
	
	public void exitInElevator(int index, int floor) {
		
	}
	**/
}
