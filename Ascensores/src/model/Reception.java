package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Reception {

	private List<Edificio> building;

	private IAscensor<Person> transporte;

	private Stack<Person> personQueue = new Stack<Person>();
	
	private Edificio edificio;
	public Reception() {
		building= new ArrayList<Edificio>();
		transporte=new Ascensor<Person>();
	}

	public void createBuilding(String buildName, int numFloors, int numOffices) {
		edificio = new Edificio(buildName, numFloors, numOffices);
		building.add(edificio);
	}

	public void createPerson(String perName, int start, int destiny, int buildName) {
		Person temp = new Person(perName, start, destiny);
		building.get(buildName).getPersonsList().add(temp);
	}

	public void formarCola() {
		for(int i=0;i<building.size();i++) {
			int tp=building.get(i).getPersonsList().size();
			for(int j=tp-1;j>=0;j--) {
				personQueue.push(building.get(i).getPersonsList().get(j));
			}
			pickUpPerson(i);
			System.out.println(transporte.getPila().toString());
		}
	}
	
	public boolean maximoPiso() {
		return false;
	}
	
	public boolean minimoPiso() {
		return false;
	}
	public void pickUpPerson(int buildName) {
		if(transporte.getPila().size() < building.get(buildName).getPersonsList().size()) {
			Person aux = personQueue.lastElement();
			
			if(building.get(buildName).getPersonsList().size() == personQueue.size() || (building.get(buildName).getPersonsList().size()-1) == personQueue.size()){
				if(transporte.getCurrentFloor() < aux.getcurrentFloor()) {
					transporte.subir(aux.getcurrentFloor());
				}else {
					transporte.bajar(aux.getcurrentFloor());
				}
				personQueue.pop();
				transporte.entrarAscensor(aux);
				pickUpPerson(buildName);
			}
			else {
				if(transporte.isComingDown() && transporte.getCurrentFloor() > aux.getcurrentFloor()) {
					transporte.bajar(aux.getcurrentFloor());
					personQueue.pop();
					transporte.entrarAscensor(aux);
					if(transporte.getCurrentFloor() == 0) {
						transporte.subir(0);
					}
					pickUpPerson(buildName);
				}
				else if(!transporte.isComingDown() && transporte.getCurrentFloor() < aux.getcurrentFloor()) {
					transporte.subir(aux.getcurrentFloor());
					personQueue.pop();
					transporte.entrarAscensor(aux);
					if(transporte.getCurrentFloor() == building.get(buildName).getOffices().size()-1) {
						transporte.bajar(building.get(buildName).getOffices().size()-1);
					}
					pickUpPerson(buildName);
				}else {
					personQueue.pop();
					personQueue.add(0, aux);
					pickUpPerson(buildName);
				}
			}
		}
	}

	public void getOutPerson(int buildName) {
		if (transporte.getPila().size() < building.get(buildName).getPersonsList().size()) {
			Person aux = transporte.getPila().firstElement();

			if (building.get(buildName).getPersonsList().size() == transporte.getPila().size()
					|| (building.get(buildName).getPersonsList().size() - 1) == transporte.getPila().size()) {
				if (transporte.getCurrentFloor() < edificio.searchFloorOffice(aux.getDestination(),
						aux.getcurrentFloor())) {
					transporte.subir(edificio.searchFloorOffice(aux.getDestination(), aux.getcurrentFloor()));
				} else {
					transporte.bajar(edificio.searchFloorOffice(aux.getDestination(), aux.getcurrentFloor()));
				}
				transporte.salirAscensor();
				getOutPerson(buildName);
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

