
package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Edificio {

	private String name;
	private int officesPerFloor;
	private int floors;
	private List<HashMap<Integer,Person>> offices;
	private List <Person> personsList;

	//Constructor
	public Edificio(String name, int floors, int officesPerFloor) {
		this.name = name;
		this.floors = floors;
		this.officesPerFloor=officesPerFloor;
		offices =new ArrayList<HashMap<Integer,Person>>();
		personsList = new ArrayList<Person>();
		createOffices();
	}

	public String movimientos() {
		String message="";
		for(int i=0;i<personsList.size();i++) {
			message+=personsList.get(i).getStatus()+"\n";
		}
		return message;
	}

	public String finalState() {
		String message="[";
		int cont=0;
		int indexOffice=1;
		for(int i=offices.size()-1;i>=0;i--) {
			for(int j=0;j<offices.get(i).size();j++) {
				if(offices.get(i).get(indexOffice)!=null) {
					cont++;
					if(indexOffice==(officesPerFloor*floors)||cont==personsList.size()) {
						message+=offices.get(i).get(indexOffice).getName();
					}
					else {
						message+=offices.get(i).get(indexOffice).getName()+", ";
					}
				}
				indexOffice++;
			}
		}
		message+="]";
		return message;
	}

	public int searchFloorOffice(int IDOffice, int currentFloor) {
		int floor = currentFloor;
		if(floor<floors) {
			if(offices.get(floor).containsKey(IDOffice)) {
				return floor;
			}else{
				return searchFloorOffice(IDOffice, floor+1);
			}
		}
		else {
			return 0;
		}

	}

	public boolean isInOffice(Person p, int floor) {
		int index=floor-1;
		return offices.get(index).containsValue(p);

	}

	public List<HashMap<Integer, Person>> getOffices() {
		return offices;
	}
	public void createOffices() {
		int indexOffice=officesPerFloor*floors;
		for(int i=0;i<floors;i++) {
			offices.add(new HashMap<Integer,Person>());
			for(int j= 0; j<officesPerFloor;j++) {
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

	public int getOfficesPerFloor() {
		return officesPerFloor;
	}

	public void setOfficesPerFloor(int office) {
		this.officesPerFloor = office;
	}


	public List<Person> getPersonsList() {
		return personsList;
	}


	public void setPersonsList(List<Person> personsList) {
		this.personsList = personsList;
	}

}
