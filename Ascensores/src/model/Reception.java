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

	public void createPerson(String perName, int start, int destiny, int buildName) {
		Person temp = new Person(perName, start, destiny);
		building.get(buildName).getQueuePersons().add(0, temp);
		building.get(buildName).getPersonsList().add(temp);
	}

	public void pickUpPerson(int buildName) {
		for(int i =0;i< building.get(buildName).getPersonsList().size();i++) {
			Person aux = building.get(buildName).getQueuePersons().get(i);
			
			if(transporte.getPila().size() < building.get(buildName).getPersonsList().size()) {
				if(building.get(buildName).getPersonsList().size() == building.get(buildName).getQueuePersons().size() || (building.get(buildName).getPersonsList().size()-1) == (building.get(buildName).getQueuePersons().size())) {
					if(transporte.getCurrentFloor() < aux.getcurrentFloor()) {
						transporte.subir(aux.getcurrentFloor());
					}else {
						transporte.bajar(aux.getcurrentFloor());
					}

					building.get(buildName).getQueuePersons().pop();
					transporte.entrarAscensor(aux);
					//pickUpPerson(buildName);
				}
				else {
					if(transporte.isComingDown() && transporte.getCurrentFloor() > aux.getcurrentFloor()) {
						transporte.bajar(aux.getcurrentFloor());
						building.get(buildName).getQueuePersons().pop();
						transporte.entrarAscensor(aux);
						if(transporte.getCurrentFloor() == 0) {
							transporte.subir(0);
						}
						//pickUpPerson(buildName);
					}
					else if(!transporte.isComingDown() && transporte.getCurrentFloor() < aux.getcurrentFloor()) {
						transporte.subir(aux.getcurrentFloor());
						building.get(buildName).getQueuePersons().pop();
						transporte.entrarAscensor(aux);
						if(transporte.getCurrentFloor() == building.get(buildName).getOffices().size()-1) {
							transporte.bajar(building.get(buildName).getOffices().size()-1);
						}
						//pickUpPerson(buildName);
					}else {
						building.get(buildName).getQueuePersons().pop();
						building.get(buildName).getQueuePersons().add(0, aux);
					}
				}

			}
			
		}
		
	}
	
	public String showElevator() {
		return transporte.getPila().toString();
	}

	public List<Edificio> getBuildings() {
		return building;
	}
	
	
}

