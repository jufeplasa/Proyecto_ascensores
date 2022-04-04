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

	public String formarCola(int i) {
		String message="";
		int tp=building.get(i).getPersonsList().size();
		for(int j=tp-1;j>=0;j--) {
			personQueue.push(building.get(i).getPersonsList().get(j));
		}
		pickUpPerson(i);
		getOutPerson(i);
		message="Movimientos edificio "+building.get(i).getName()+"\n";
		message+=building.get(i).movimientos();
		message+="estado final edificio "+building.get(i).getName()+"\n";
		message+=building.get(i).finalState();
		personQueue.clear();
		transporte.getPila().clear();
		transporte.setCurrentFloor(0);
		return message;
	}

	public boolean maximoPiso() {
		for(int i=0;i<personQueue.size();i++) {
			if(personQueue.get(i).getcurrentFloor()>transporte.getCurrentFloor()) {
				return true;
			}
		}
		return false;
	}

	public boolean minimoPiso() {
		for(int i=0;i<personQueue.size();i++) {
			if(personQueue.get(i).getcurrentFloor()<transporte.getCurrentFloor()) {
				return true;
			}
		}
		return false;
	}
	public void pickUpPerson(int buildName) {
		if(transporte.getPila().size() < building.get(buildName).getPersonsList().size()) {
			Person aux = personQueue.lastElement();
			if(building.get(buildName).getPersonsList().size() == personQueue.size()){//|| ( building.get(buildName).getPersonsList().size()-1) == personQueue.size()){
				if(aux.getcurrentFloor()<=building.get(buildName).searchFloorOffice(aux.getDestination(),0)) {
					transporte.subir(aux.getcurrentFloor());
				}else {
					transporte.bajar(aux.getcurrentFloor());
				}
				personQueue.pop();
				transporte.entrarAscensor(aux);
				pickUpPerson(buildName);
			}
			else {
				if(transporte.isComingDown() && transporte.getCurrentFloor() >= aux.getcurrentFloor()||!maximoPiso()) {
					personQueue.pop();
					transporte.entrarAscensor(aux);
					if(transporte.getCurrentFloor() == 0 ) {
						transporte.subir(0);
					}
					pickUpPerson(buildName);
				}
				else if(!transporte.isComingDown() && transporte.getCurrentFloor() <= aux.getcurrentFloor()||!minimoPiso()) {
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
		if (transporte.getPila().size() != 0) {
			Person aux = transporte.getPila().lastElement();
			transporte.salirAscensor();
			int floorOffice=building.get(buildName).searchFloorOffice(aux.getDestination(),0);
			if(building.get(buildName).getOffices().get(floorOffice).get(aux.getDestination())==null && building.get(buildName).getOffices().get(floorOffice).containsKey(aux.getDestination()))  {
				building.get(buildName).getOffices().get(floorOffice).remove(aux.getDestination());
				building.get(buildName).getOffices().get(floorOffice).put(aux.getDestination(),aux);
				aux.setStatusWithOffice();
			}
			else {
				aux.setStatusWithOutOffice();
			}
			getOutPerson(buildName);
		}
	}

	public String showElevator() {
		return transporte.getPila().toString();
	}

	public List<Edificio> getBuildings() {
		return building;
	}

}

